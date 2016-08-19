/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_addressbook.operation;

import com.sg.xcd_addressbook.dao.AddressBookDAO;
import com.sg.xcd_addressbook.dto.Address;
import com.sg.xcd_addressbook.dto.AddressBook;
import com.sg.xcd_addressbook.ui.AddressBookUI;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Kratos
 */
public class AddressBookController {

    private AddressBookUI ui;
    private AddressBookDAO dao;
    private AddressBook addressBook;
    private boolean quit;
    private int operation;

    public AddressBookController() {
        this.ui = new AddressBookUI();
        this.dao = new AddressBookDAO();
        try {
            this.addressBook = new AddressBook();
        } catch (FileNotFoundException e) {
            ui.message_Import_FileNotFoundException();
        }

        this.quit = false;
        this.operation = 0;
    }

    // ****************************************************************************** run()
    public void run() {
        ui.menu();

        while (!quit) {
            operation = ui.promptOperation();
            ui.killTheGodDamnNewLine();
            switch (operation) {
                case 0:
                    // ****************************************************************************** Display Menu
                    ui.menu();
                    break;
                case 1:
                    // ****************************************************************************** Add
                    addRecord();
                    break;
                case 2:
                    // ****************************************************************************** Remove
                    removeRecord();
                    break;
                case 3:
                    // ****************************************************************************** Search
                    searchRecords();
                    break;
                case 4:
                    // ****************************************************************************** Count
                    countRecords();
                    break;
                case 5:
                    // ****************************************************************************** List All
                    listRecords();
                    break;
                case 6:
                    // ****************************************************************************** Edit
                    editRecord();
                    break;
                // -------- Safe Above
                case 7:
                    // ****************************************************************************** Import
                    importRecords();
                    break;
                case 8:
                    // ****************************************************************************** Export
                    exportRecords();
                    break;
                default:
                    // ****************************************************************************** Quit
                    quitSys();
            }
        }
    }

    public void addRecord() {
        dao.addRecord(addressBook, ui.promptAddRecord());
        ui.message_Add_RecordAdded();
    }

    public void removeRecord() {
        ArrayList<Integer> indexs = dao.searchByFullName(ui.promptRemoveRecord_GetFLName(), addressBook);
        if (indexs.size() <= 0) {
            ui.message_Remove_RecordNotExists();
        } else if (indexs.size() == 1) {
            dao.removeRecord(addressBook, indexs.get(0));
        } else {
            ui.message_DuplicatedRecord();
            ui.displayDuplicatedRecord(addressBook, indexs);
            dao.removeRecord(addressBook, ui.getIndexForRemoveOrEdit(indexs));
        }
    }

    public void searchRecords() {
        ArrayList<Address> foundedAddresses = dao.searchByLastName(addressBook, ui.promptLastNameToSearch());
        if (foundedAddresses != null) {
            ui.displaySearchedResult(foundedAddresses);
        } else {
            ui.message_Search_NoRecordFounded();
        }
    }

    public void countRecords() {
        ui.displayRecordCount(dao.countRecords(addressBook));
    }

    public void listRecords() {
        if (dao.isAllAddressRecordsEmpty(addressBook)) {
            ui.message_Search_NoRecordFounded();
        } else {
            ui.displayAddressRecord(addressBook);
        }
    }

    public void editRecord() {
        String encodedName = ui.promptEditRecord_GetFLName_Encoded();
        ArrayList<Integer> indexs = dao.searchByFullName(encodedName, addressBook);
        if (indexs.size() <= 0) {
            ui.message_Edit_RecordNotExists();
        } else if (indexs.size() == 1) {
            int index = indexs.get(0);
            Address address = ui.promptFinshEditRecord(dao.editRecordWithFLNameDone(encodedName));
            addressBook = dao.editRecordWithRestDone(index, address, addressBook);
            ui.message_Edit_RecordEdited();
        } else {
            ui.message_DuplicatedRecord();
            ui.displayDuplicatedRecord(addressBook, indexs);
            int index = ui.getIndexForRemoveOrEdit(indexs);
            ui.killTheGodDamnNewLine();
            Address address = ui.promptFinshEditRecord(dao.editRecordWithFLNameDone(encodedName));
            addressBook = dao.editRecordWithRestDone(index, address, addressBook);
        }

    }

    public void importRecords() {
        if (dao.importData(ui.promptForFileNameToImport(), addressBook)) {
            ui.message_Import_Done();
        } else {
            ui.message_Import_FileNotFoundException();
        }
    }

    public void exportRecords() {
        if (dao.exportData(ui.promptForFileNameToExport(), addressBook)) {
            ui.message_Export_Done();
        } else {
            ui.message_Export_IOException();
        }
    }

    public void quitSys() {
        ui.message_exitThankYou();
        quit = true;
    }
}
