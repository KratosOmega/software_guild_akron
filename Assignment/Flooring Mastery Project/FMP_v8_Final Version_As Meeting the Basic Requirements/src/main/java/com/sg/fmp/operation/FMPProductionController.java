/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.operation;

/**
 *
 * @author Kratos
 */
public class FMPProductionController extends FMPTestController {

    @Override
    public void execute() {
        String operation = "";

        while (!globalQuit) {
//            ui.nextPage();
            ui.message_NextSection();
            ui.prodMenu();
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
                case "5":
                    // Save
                    save();
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

    public void save() {
        ui.header_Save();
        ui.message_DataSaved();
        fMPImplementation.saveCurrentWork();
    }

    @Override
    public void menu() {
        ui.prodMenu();
    }
}
