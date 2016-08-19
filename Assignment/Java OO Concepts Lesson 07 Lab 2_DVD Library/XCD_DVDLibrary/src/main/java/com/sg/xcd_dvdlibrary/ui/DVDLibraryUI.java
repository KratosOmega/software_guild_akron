/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_dvdlibrary.ui;

import com.sg.xcd_dvdlibrary.dto.DVD;
import com.sg.xcd_dvdlibrary.dto.DVDLibrary;

/**
 *
 * @author Kratos
 */
public class DVDLibraryUI {

    private ConsoleIO io;
    private GUIUtilities guiUtilities;

    public DVDLibraryUI() {
        this.io = new ConsoleIO();
        this.guiUtilities = new GUIUtilities();
    }

    // ********************************************************************** Initialization
    // ********************************************************************** Dispaly Menu
    public void menu() {
        io.display(guiUtilities.os_Quick_Menu_Builder("DVD Library System", "/",
                "1. Add DVD record to Libaray/"
                + "2. Remove DVD record from Library/"
                + "3. Edit DVD record in the Library/"
                + "4. List DVD records in the Library/"
                + "5. Search DVD record Information/"
                + "6. Multiple execution/"
                + "7. Import DVD data into Library/"
                + "8. Export DVD data into local drive/"
                + "0. Display Operation Menu") + "\n");
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");

    }

    // ********************************************************************** Controller Related UI
//    public void killTheDamnNewLine() {
//        io.killNewLine();
//    }

    // ********************************************************************** Displays
    public void displaySearchedResult(DVD foundedDVD) {
        int noteIndex = 0;
        io.display(guiUtilities.os_Quick_Header_Builder("DVD Found"));
        io.display("\n> DVD Title       : " + foundedDVD.getTitle() + "\n");
        io.display("> Release Date    : " + foundedDVD.getReleaseDate() + "\n");
        io.display("> MPAA Rating     : " + foundedDVD.getMpaaRating() + "\n");
        io.display("> Director's Name : " + foundedDVD.getDirectorName() + "\n");
        io.display("> Studio          : " + foundedDVD.getStudio() + "\n");
        io.display("> User Note       : ");

        for (String note : foundedDVD.getUserNote()) {
            noteIndex++;
            if (noteIndex == 1) {
                io.display(noteIndex + ". " + note + "\n");
            } else {
                io.display("                    " + noteIndex + ". " + note + "\n");
            }
        }
    }

    public void displayDVDLibraryRecords(DVDLibrary dvdlibrary) {
        int index = 0;
        int noteIndex;

        io.display(guiUtilities.os_Quick_Header_Builder("List Records"));

        for (DVD record : dvdlibrary.getDvdLibrary()) {
            index++;
            noteIndex = 0;

            io.display("\n" + guiUtilities.os_Quick_Header_Builder("# " + index + "") + "\n");
            io.display("> DVD Title           : " + record.getTitle() + "\n");
            io.display("> Release Date        : " + record.getReleaseDate() + "\n");
            io.display("> MPAA Rating         : " + record.getMpaaRating() + "\n");
            io.display("> Director's Name     : " + record.getDirectorName() + "\n");
            io.display("> Studio              : " + record.getStudio() + "\n");
            io.display("> User Note           : ");

            for (String note : record.getUserNote()) {
                noteIndex++;
                if (noteIndex == 1) {
                    io.display(noteIndex + ". " + note + "\n");
                } else {
                    io.display("                        " + noteIndex + ". " + note + "\n");
                }
            }
        }
    }

    // ********************************************************************** Prompts
    public String promptForFileNameToSaveData() {
        io.display(guiUtilities.os_Quick_Header_Builder("Save Records") + "\n");
        return io.promptForString("DVD Library wants to save your data."
                + "\nPlease enter a file name to save: ");
    }

    public String promptGetTitleToEdit() {
        io.display(guiUtilities.os_Quick_Header_Builder("Edit Record") + "\n");
        return io.promptForString("Please enter the DVD title: ");
    }

    public DVD promptEditRecord() {
        io.display(guiUtilities.os_Quick_Header_Builder("Edit Record") + "\n");
        DVD newRecord = new DVD(
                io.promptForString("> DVD Title       : "),
                io.promptForString("> Release Date    : "),
                io.promptForString("> MPAA Rating     : "),
                io.promptForString("> Director's Name : "),
                io.promptForString("> Studio          : "),
                io.promptForString("> User Note       : ")
        );
        return newRecord;
    }

    public String promptTitleToSearch() {
        io.display(guiUtilities.os_Quick_Header_Builder("Search Record") + "\n");
        return io.promptForString("Please enter the DVD title: ");
    }

    public String promptGetTitleToRemove() {
        io.display(guiUtilities.os_Quick_Header_Builder("Remove Record") + "\n");
        return io.promptForString("> DVD Title       : ");
    }

    public String promptGetTitleToAdd() {
        io.display(guiUtilities.os_Quick_Header_Builder("Add New Record") + "\n");
        return io.promptForString("> DVD Title       : "); ///---???
    }

    public DVD promptFinishAddingOrEditingRecord(String title) {
        DVD newRecord = new DVD(
                title,
                io.promptForString("> Release Date    : "),
                io.promptForString("> MPAA Rating     : "),
                io.promptForString("> Director's Name : "),
                io.promptForString("> Studio          : "),
                io.promptForString("> User Note       : ")
        );
        return newRecord;
    }

    public boolean promptConfirmationToAddNotes() {
        if (io.promptForString(
                guiUtilities.os_Quick_Notification_Builder("/", "Record already exists!/Enter \"note\" for adding more notes/Enter \"quit\" to quit this session")
                + "\nPlease choose operation: "
        ).equals("note")) {
            return true;
        } else {
            return false;
        }
    }

    public String promptAddNotes() {
        return io.promptForString("> User Note       : ");
    }

    public String promptOperation() {
        io.display("\n" + guiUtilities.os_Component_Builder("=", 50) + "\n");
        return io.promptForString("Please choose operation: ");
    }

    public String promptMultiOperation() {
        io.display(guiUtilities.os_Component_Builder("=", 50));
        return io.promptForString("\nPlease select add/edit/remove/quit: ");
    }

    public String promptForFileNameToImport() {
        return io.promptForString("\nPlease enter a file name to import: ");
    }

    public String promptForFileNameToExport() {
        return io.promptForString("\nPlease enter a file name to export: ");
    }

    // ********************************************************************** Message
    public void message_Error_InvalidOption() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Invalid Option!"));
    }

    public void message_Search_NoRecordFounded() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "No such record!"));
    }

    public void message_InitializationDone() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Initializaiton Done") + "\n\n\n");
    }

    public void message_InitializationFalied() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Initializaiton Failed"));
    }

    public void message_Add_RecordExists() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Record exists, action is denied!"));
    }

    public void message_Add_RecordAdded() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Record is successfully added!"));
    }

    public void message_Add_NotesAdded() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Note is successfully added!"));
    }

    public void message_Remove_RecordRemoved() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Record is successfully removed!"));
    }

    public void message_Remove_RecordNotExists() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "No such record, action is denied!"));
    }

    public void message_NoRecordToDisplay() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Database has not record to display!"));
    }

    public void message_Edit_RecordNotExists() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "No such record, action is denied!"));
    }

    public void message_Edit_RecordEdited() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Record is sucessfully edited"));
    }

    public void message_SaveData_IOException() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "IOException!"));
    }

    public void message_SaveData_Done() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Data is saved!"));
    }

    public void message_ImportDone() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Importing is completed!"));
    }

    public void message_ImportFailed() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Importing is failed!"));
    }

    public void message_ExportDone() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Exporting is completed!"));
    }

    public void message_ExportFalied() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Exporting is failed!"));
    }

    public void message_InvalidIput(){
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Invalid Input!!!/Please enter again..."));
    }
    
    public void message_exitThankYou() {
        io.display("\nThank you for using DVD Libaray System!");
    }

}
