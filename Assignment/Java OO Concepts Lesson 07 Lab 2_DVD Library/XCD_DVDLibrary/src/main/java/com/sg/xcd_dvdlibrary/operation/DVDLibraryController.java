/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_dvdlibrary.operation;

import com.sg.xcd_dvdlibrary.dao.DVDLibraryDAO;
import com.sg.xcd_dvdlibrary.dto.DVD;
import com.sg.xcd_dvdlibrary.dto.DVDLibrary;
import com.sg.xcd_dvdlibrary.ui.DVDLibraryUI;
import java.io.FileNotFoundException;

/**
 *
 * @author Kratos
 */
public class DVDLibraryController {

    private DVDLibraryDAO dao;
    private DVDLibraryUI ui;
    private DVDLibrary dvdLibrary;
    private boolean quit;
    private String operation;
    private boolean repeatExecution;
    private String multiSelection;

    public DVDLibraryController() {
        this.dao = new DVDLibraryDAO();
        this.ui = new DVDLibraryUI();

        this.quit = false;
        this.repeatExecution = false;
        this.operation = "";
        this.multiSelection = "";
        try {
            this.dvdLibrary = new DVDLibrary();
            ui.message_InitializationDone();
        } catch (FileNotFoundException e) {
            ui.message_InitializationFalied();
        }
    }

    public void run() {
        ui.menu();

        while (!quit) {
            if (!repeatExecution) {
                operation = ui.promptOperation(); 
            }

            switch (operation) {
                case "0":
                    ui.menu();
                    break;
                case "1":
                    // Add
                    addDVD();
                    break;
                case "2":
                    // Remove
                    removeDVD();
                    break;
                case "3":
                    // Edit
                    editDVD();
                    break;
                case "4":
                    // List
                    listDVDs();
                    break;
                case "5":
                    // Search by title
                    searchDVDs();
                    break;
                case "6":
                    repeatAddRemoveEdit();
                    break;
                case "7":
                    importDVDs();
                    break;
                case "8":
                    exportDVDs();
                    break;
                case "-1":
                    autoSaving();
                    quit = true;
                default:
                    ui.message_InvalidIput();
            }
        }
    }

    public void addDVD() {
        if (repeatExecution) {
            operation = "6";
        }

        String titleToAdd = ui.promptGetTitleToAdd();
        int indexToAdd = dao.searchRecordIndex(titleToAdd, dvdLibrary);

        if (indexToAdd == -1) {
            DVD dvd = ui.promptFinishAddingOrEditingRecord(titleToAdd);
            dao.addDVD(dvd, dvdLibrary);
            ui.message_Add_RecordAdded();
        } else if (ui.promptConfirmationToAddNotes()) {
            dao.addNotesToExistedDVD(indexToAdd, ui.promptAddNotes(), dvdLibrary);
            ui.message_Add_NotesAdded();
        } else {
            ui.message_Add_RecordExists();
        }
    }

    public void removeDVD() {
        if (repeatExecution) {
            operation = "6";
        }

        String titleToRemove = ui.promptGetTitleToRemove();
        int indexToRemove = dao.searchRecordIndex(titleToRemove, dvdLibrary);

        if (indexToRemove == -1) {
            ui.message_Remove_RecordNotExists();
        } else {
            dao.removeDVD(indexToRemove, dvdLibrary);
            ui.message_Remove_RecordRemoved();
        }
    }

    public void editDVD() {
        if (repeatExecution) {
            operation = "6";
        }

        String titleToEdit = ui.promptGetTitleToEdit();
        int indexToEdit = dao.searchRecordIndex(titleToEdit, dvdLibrary);

        if (indexToEdit != -1) {
            DVD dvd = ui.promptFinishAddingOrEditingRecord(titleToEdit);
            dao.editDVD(indexToEdit, dvd, dvdLibrary);
            ui.message_Edit_RecordEdited();
        } else {
            ui.message_Edit_RecordNotExists();
        }
    }

    public void listDVDs() {
        if (dao.isLibraryEmpty(dvdLibrary)) {
            ui.message_NoRecordToDisplay();
        } else {
            ui.displayDVDLibraryRecords(dvdLibrary);
        }
    }

    public void searchDVDs() {
        DVD record = dao.searchByTitle(ui.promptTitleToSearch(), dvdLibrary);
        if (record != null) {
            ui.displaySearchedResult(record);
        } else {
            ui.message_Search_NoRecordFounded();
        }
    }

    public void repeatAddRemoveEdit() {
        repeatExecution = true;
        multiSelection = ui.promptMultiOperation();
        switch (multiSelection) {
            case "add":
                operation = "1";
                break;
            case "remove":
                operation = "2";
                break;
            case "edit":
                operation = "3";
                break;
            case "quit":
                // quit
                repeatExecution = false;
                break;
            default:
                ui.message_Error_InvalidOption();
        }
    }

    // Need implement importDVDs()
    public void importDVDs(){
        if(dao.importData(ui.promptForFileNameToImport(), dvdLibrary)){
            ui.message_ImportDone();
        }else{
            ui.message_ImportFailed();
        }
    }
    // Need implement exportDVDs()
    public void exportDVDs(){
        if(dao.exportData(ui.promptForFileNameToExport(), dvdLibrary)){
            ui.message_ExportDone();
        }else{
            ui.message_ExportFalied();
        }
    }
    
    
    public void autoSaving() {
        if (dao.exportData(ui.promptForFileNameToSaveData(), dvdLibrary)) {
            ui.message_SaveData_Done();
            ui.message_exitThankYou();
        } else {
            ui.message_SaveData_IOException();
        }
    }

}
