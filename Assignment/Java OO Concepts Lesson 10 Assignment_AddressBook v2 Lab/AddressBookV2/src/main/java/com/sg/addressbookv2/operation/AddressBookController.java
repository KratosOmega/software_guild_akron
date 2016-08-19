/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.operation;

import com.sg.addressbookv2.dao.AddressBookImplementation;
import com.sg.addressbookv2.dto.Address;
import com.sg.addressbookv2.ui.AddressBookUi;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class AddressBookController {

    private final ApplicationContext context;
    private final AddressBookImplementation dao;
    private final AddressBookUi ui;

    public AddressBookController() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dao = (AddressBookImplementation) context.getBean("addressBook");
        this.ui = (AddressBookUi) context.getBean("ui");
    }

    public void execute() {
        boolean quit = false;
        boolean repeatExecution = false;
        String operation = "";

        ui.mainMenu();

        while (!quit) {
            if (!repeatExecution) {
                operation = ui.promptOperation();
            }

            switch (operation) {
                case "1":
                    add();
                    break;
                case "2":
                    remove();
                    break;
                case "3":
                    edit();
                    break;
                case "4":
                    count();
                    break;
                case "5":
                    listAll();
                    break;
                case "6":
                    applyFilter();
                    break;
                case "7":
                    importData();
                    break;
                case "8":
                    exportData();
                    break;
                case "0":
                    ui.mainMenu();
                    break;
                case "-1":
                    quit = true;
                    ui.quit();
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void applyFilter() {
        boolean quit = false;
        boolean repeatExecution = false;
        String operation = "";

        ui.subMenu();

        while (!quit) {
            if (!repeatExecution) {
                operation = ui.promptOperation();
            }

            switch (operation) {
                case "1":
                    lastNameFilter();
                    break;
                case "2":
                    cityFilter();
                    break;
                case "3":
                    stateFilter();
                    break;
                case "4":
                    zipCodeFilter();
                    break;
                case "0":
                    ui.subMenu();
                    break;
                case "-1":
                    quit = true;
                    ui.quitToMainMenu();
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void add() {
        Address address = ui.promptToAddNewRecord();
        dao.addRecord(address);
        ui.message_RecordAdded();
    }

    public void remove() {
        String encodedFLName = ui.promptFLName();
        int indexToRemove = dao.findIndexByFLName(encodedFLName);
        if (indexToRemove < 0) {
            ui.message_NoRecordFound();
        } else {
            dao.removeRecord(indexToRemove);
            ui.message_RecordRemoved();
        }
    }

    public void edit() {
        String encodedFLName = ui.promptFLName();
        int indexToEdit = dao.findIndexByFLName(encodedFLName);
        if (dao.findIndexByFLName(encodedFLName) == -1) {
            ui.message_NoRecordFound();
        } else {
            dao.editRecord(indexToEdit, ui.promptCompleteEditing(dao.decoding(encodedFLName)[0], dao.decoding(encodedFLName)[1]));
        }
    }

    public void count() {
        ui.displayCount(dao.countRecord());
    }

    public void listAll() {
        dao.listAll()
                .stream()
                .forEach(address -> {
                    ui.displayLine("\n -------------------  # " + (dao.findIndexByFullRecordData(address.encodedRecord()) + 1) + "  ------------------- ");
                    ui.displayLine(address.addressRecord());
                });
    }

    public void importData() {
        String fileName = ui.promptFileName();
        dao.importRecord(fileName);
    }

    public void exportData() {
        String fileName = ui.promptFileName();
        dao.exportRecord(fileName);
    }

    public void lastNameFilter() {
        String lastName = ui.promptLastName();
        List<Address> result = dao.filterLastName(lastName);
        if (result.isEmpty()) {
            ui.message_NoRecordFound();
        } else {
            ui.displayRecord(result);
        }
    }

    public void cityFilter() {
        String city = ui.promptCity();
        List<Address> result = dao.filterCity(city);
        if (result.isEmpty()) {
            ui.message_NoRecordFound();
        } else {
            ui.displayRecord(result);
        }
    }

    public void stateFilter() {
        String state = ui.promptState();
        List<Address> result = dao.filterState(state);
        if (result.isEmpty()) {
            ui.message_NoRecordFound();
        } else {
            ui.displayRecord(result);
        }
    }

    public void zipCodeFilter() {
        String zipCode = ui.promptZipCode();
        List<Address> result = dao.filterZipCode(zipCode);
        if (result.isEmpty()) {
            ui.message_NoRecordFound();
        } else {
            ui.displayRecord(result);
        }
    }
}
