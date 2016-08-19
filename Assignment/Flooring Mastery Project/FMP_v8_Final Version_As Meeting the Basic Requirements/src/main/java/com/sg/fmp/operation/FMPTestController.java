/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.operation;

import com.sg.fmp.dao.FMPImplementation;
import com.sg.fmp.dto.Order;
import com.sg.fmp.ui.FMPUi;
import java.io.File;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class FMPTestController implements FMPController {

    protected ApplicationContext context;
    protected FMPImplementation fMPImplementation;
    protected FMPUi ui;
    protected boolean globalQuit;
    protected boolean switchMode;

    public FMPTestController() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.fMPImplementation = (FMPImplementation) context.getBean("implementation");
        this.ui = (FMPUi) context.getBean("ui");
        this.globalQuit = false;
        this.switchMode = true;
    }

    @Override
    public void execute() {

        String operation = "";

        while (!globalQuit) {
//            ui.nextPage();
            ui.message_NextSection();
            ui.testMenu();
            operation = ui.promptForOperation();
            ui.nextPage();

            switch (operation) {
                case "1":
                    // List
                    list();
                    break;
                case "2":
                    // Add
                    add();
                    break;
                case "3":
                    // Edit
                    edit();
                    break;
                case "4":
                    // Remove
                    remove();
                    break;
                case "!":
                    // Settings
                    settings();
                    break;
                case "0":
                    // Show menu
                    ui.nextPage();
                    break;
                case "-1":
                    // Quit
                    this.globalQuit = true;
                    this.switchMode = true;
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }

        if (!switchMode) {
            FMPLauncher switcher = new FMPLauncher();
            switcher.execute();
        }
    }

    public void list() {
        ui.header_ListAll();
        ui.message_DateFormat();
        String date = fMPImplementation.decodeDate(ui.promptForDate());
        List<Order> orders = fMPImplementation.listOrders(date);

        ui.nextPage();
        ui.displayRecords(orders);
    }

    public void add() {
        boolean quit = false;
        String operation = "";

        Order order = ui.promptForAddNewOrder(fMPImplementation.getCurrentOrderNumber(), fMPImplementation.getProducts(), fMPImplementation.getTaxes());
        ui.nextPage();
        ui.header_Add();
        ui.displayRecordSummary(order);
        ui.displayYesOrNo();

        while (!quit) {
            operation = ui.promptForOperation();
            switch (operation) {
                case "Y":
                case "y":
                    fMPImplementation.addOrder(order);
                    ui.message_ConfirmAdd();
                    quit = true;
                    break;
                case "N":
                case "n":
                    ui.message_DiscardAdd();
                    quit = true;
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void edit() {
        ui.header_Edit();
        ui.message_DateFormat();
        String date = fMPImplementation.decodeDate(ui.promptForDate());
        boolean memoryExistence = fMPImplementation.checkMemoryExistence(date);
        boolean databaseExistence = fMPImplementation.checkDatabaseExistence(date);

        if (!memoryExistence && !databaseExistence) {
            ui.nextPage();
            ui.message_RecordNotFound();
        } else {
            ui.displayRecords(fMPImplementation.listOrders(date));
            if (!memoryExistence) {
                fMPImplementation.retrieveDataFromDatabase(date);
            }

            String orderNumber = ui.promptForOrderNumber();
            String key = fMPImplementation.keyEncoder(date, orderNumber);
            Order order = new Order(0, memoryExistence, orderNumber, date, 0, date, 0, 0, 0, 0, 0, 0, 0);
            String confirmEdition = "";

            if (fMPImplementation.getOrders().containsKey(key) && fMPImplementation.getOrders().get(key).isOrderStatus()) {
                //1. encoded of date & orderNumber 2. Pass it to the map to get order 3. pass the order to the editor
                order = ui.promptForEditOrder(fMPImplementation.getOrders().get(key), fMPImplementation.getProducts(), fMPImplementation.getTaxes());
                order = fMPImplementation.preEditOrder(order);
                ui.nextPage();
                ui.header_Edit();
                ui.displayRecordSummary(order);
                ui.displayYesOrNo();
                confirmEdition = ui.promptForOperation();
            } else {
                ui.nextPage();
                ui.message_RecordNotFound();
            }

            if (confirmEdition.equals("Y") || confirmEdition.equals("y")) {
                fMPImplementation.editOrder(key, order);
                ui.message_EditDone();
            } else if (confirmEdition.equals("N") || confirmEdition.equals("n")) {
                ui.message_NothingIsDone();
            }
        }
    }

    public void remove() {
        ui.header_Remove();
        ui.message_DateFormat();
        String date = fMPImplementation.decodeDate(ui.promptForDate());
        boolean memoryExistence = fMPImplementation.checkMemoryExistence(date);
        boolean databaseExistence = fMPImplementation.checkDatabaseExistence(date);

        if (!memoryExistence && !databaseExistence) {
            ui.nextPage();
            ui.message_RecordNotFound();
        } else {
            ui.displayRecords(fMPImplementation.listOrders(date));
            if (!memoryExistence) {
                fMPImplementation.retrieveDataFromDatabase(date);
            }

            String orderNumber = ui.promptForOrderNumber();
            String key = fMPImplementation.keyEncoder(date, orderNumber);
            Order order;
            String confirmRemoval = "";

            if (fMPImplementation.getOrders().containsKey(key) && fMPImplementation.getOrders().get(key).isOrderStatus()) {
                ui.displayYesOrNo();
                confirmRemoval = ui.promptForOperation();
            } else {
                ui.nextPage();
                ui.message_RecordNotFound();
            }

            if (confirmRemoval.equals("Y") || confirmRemoval.equals("y")) {
                fMPImplementation.removeOrder(date, orderNumber);
                ui.message_RemoveDone();
            } else if (confirmRemoval.equals("N") || confirmRemoval.equals("n")) {
                ui.message_NothingIsDone();
            }
        }

        /*
        ui.header_Remove();
        ui.message_DateFormat();
        String date = fMPImplementation.decodeDate(ui.promptForDate());
        List<Order> orders = fMPImplementation.listOrders(date);

        if (orders.isEmpty()) {
            ui.nextPage();
            ui.message_RecordNotFound();
        } else {
            ui.displayRecords(orders);

            String orderNumber = ui.promptForOrderNumber();
            String key = fMPImplementation.keyEncoder(date, orderNumber);
            String confirmRemoval = "";

            if (fMPImplementation.checkDatabaseExistence(date) || fMPImplementation.getOrders().containsKey(key)) {
                if (!fMPImplementation.checkImportedListExistence(date)) {
                    fMPImplementation.retrieveDataFromDatabase(date);
                }

                if (fMPImplementation.getOrders().containsKey(key) && fMPImplementation.getOrders().get(key).isOrderStatus()) {
                    ui.displayYesOrNo();
                    confirmRemoval = ui.promptForOperation();
                } else {
                    ui.nextPage();
                    ui.message_RecordNotFound();
                }
            } else {
                ui.nextPage();
                ui.message_RecordNotFound();
            }

            if (confirmRemoval.equals("Y") || confirmRemoval.equals("y")) {
                fMPImplementation.removeOrder(date, orderNumber);
                ui.message_RemoveDone();
            } else if (confirmRemoval.equals("N") || confirmRemoval.equals("n")) {
                ui.message_NothingIsDone();
            }
        }
         */
    }

    public void menu() {
        ui.testMenu();
    }

    public void settings() {
        boolean subQuit = false;
        String operation = "";

        while (!subQuit) {
            ui.nextPage();
            ui.settingMenu();
            operation = ui.promptForOperation();
            ui.nextPage();

            switch (operation) {
                case "1":
                    this.globalQuit = true;
                    this.switchMode = false;
                    subQuit = true;
                    break;
                case "2":
                    snapshot();
                    break;
                case "3":

                    break;
                case "4":

                    break;

                case "0":
                    // Show menu
                    ui.settingMenu();
                    break;
                case "-1":
                    // Quit
                    subQuit = true;
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void snapshot() {
        boolean subQuit = false;
        String operation = "";

        while (!subQuit) {
            ui.nextPage();
            ui.snapshotMenu();
            operation = ui.promptForOperation();
            ui.nextPage();

            switch (operation) {
                case "1":
                    // Browse snapshot
                    listSnapshots_ToUser();
                    browseSnapshot_ToUser(true);
                    break;
                case "2":
                    // create snapshot
                    fMPImplementation.createSnapshot();
                    break;
                case "3":
                    // ?????????????????????????????????????????
                    // restore snapshot
                    listSnapshots_ToUser();
                    fMPImplementation.restoreSnapshot(browseSnapshot_ToUser(false));
                    ui.message_SnapshotApplied();
                    break;
                case "0":
                    // Show menu
                    ui.snapshotMenu();
                    break;
                case "-1":
                    // Quit
                    subQuit = true;
                    break;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void listSnapshots_ToUser() {
        ui.displaySnapshots(fMPImplementation.listSnapshots());

    }

    public String browseSnapshot_ToUser(boolean showOrNot) {
        // Read the total # of snapshot,
        // pass it to the prompt to valid the user input
        // if snapshot exist, then display it
        // return the selection for later use

        File folder_snapshot = new File(fMPImplementation.getFilePathTo_database_snapshot());
        int snapshotCount = folder_snapshot.listFiles().length;
        String selection = ui.promptForSnapshot(snapshotCount);

        if (showOrNot) {
            ui.nextPage();
            ui.displaySnapshotDetails(fMPImplementation.browseSnapshot(selection));
        }

        return selection;
    }
}
