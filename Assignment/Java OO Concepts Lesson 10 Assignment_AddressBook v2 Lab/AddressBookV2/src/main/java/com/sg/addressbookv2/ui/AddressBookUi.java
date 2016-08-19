/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.ui;

import com.sg.addressbookv2.dto.Address;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kratos
 */
public class AddressBookUi {

    private ConsoleIO io;
    private GUIUtilities gui;

    public AddressBookUi() {
        this.io = new ConsoleIO();
        this.gui = new GUIUtilities();
    }

    // *************************************************************************************************************** General UI
    public void mainMenu() {
        io.display(gui.os_Quick_Menu_Builder("DVD Library System", "/",
                "1. Add Address record/"
                + "2. Remove address record/"
                + "3. Edit address Record/"
                + "4. Count total records in System/"
                + "5. Display all records/"
                + "6. Apply filter to records/"
                + "7. Import data into System/"
                + "8. Export data out of System/"
                + "0. Display main menu") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");
    }

    public void subMenu() {
        io.display(gui.os_Quick_Menu_Builder("Filter System", "/",
                "1. Apply filter on Last Name/"
                + "2. Apply filter on City/"
                + "3. Apply filter on State/"
                + "4. Apply filter on Zip Code/"
                + "0. Display sub menu") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>") + "\n");
    }

    public String promptOperation() {
        io.display("\n" + gui.os_Component_Builder("=", 100) + "\n");
        return io.promptForString("Please choose operation: ");

    }

    public void quit() {
        io.display(gui.os_Quick_Notification_Builder("/", "Thank you!"));
    }
    
    public void quitToMainMenu(){
        io.display(gui.os_Quick_Notification_Builder("/", "Back to the main menu!"));
    }

    public void displayCount(long count) {
        io.display("" + count);
    }

    public void displayRecord(List<Address> result) {
        int index = 0;

        for (Address record : result) {
            index++;
            io.display(gui.os_Quick_Header_Builder("# " + index));
            io.display("\n"
                    + record.getFirsName() + " " + record.getLastName() + "\n"
                    + record.getHouseNumber() + " " + record.getStreet() + "\n"
                    + record.getCity() + ", " + record.getState() + " " + record.getZipCode() + "\n"
                    + record.getCountry() + "\n");
        }
    }
    
    public void displayLine(String line){
        io.displayLn(line);
    }

    // *************************************************************************************************************** Prompt UI
    public Address promptToAddNewRecord() {
        io.display(gui.os_Quick_Header_Builder("Add New Record") + "\n");

        Address newRecord = new Address(
                io.promptForString("> First Name: "),
                io.promptForString("> Last Name : "),
                io.promptForString("> House #   : "),
                io.promptForString("> Street    : "),
                io.promptForString("> City      : "),
                io.promptForString("> State     : "),
                io.promptForString("> Zip Code  : "),
                io.promptForString("> Country   : ")
        );
        return newRecord;
    }

    public String promptFLName() {
        return io.promptForString("> First Name: ") + "::" + io.promptForString("> Last Name : ");
    }

    public Address promptCompleteEditing(String firstName, String lastName) {
        io.display(gui.os_Quick_Header_Builder("Edit Record") + "\n");

        Address editedRecord = new Address(
                firstName,
                lastName,
                io.promptForString("> House #   : "),
                io.promptForString("> Street    : "),
                io.promptForString("> City      : "),
                io.promptForString("> State     : "),
                io.promptForString("> Zip Code  : "),
                io.promptForString("> Country   : ")
        );
        return editedRecord;
    }

    public String promptFileName() {
        return io.promptForString("> Enter the file name: ");
    }

    public String promptLastName() {
        return io.promptForString("> Enter you last name: ");
    }

    public String promptCity() {
        return io.promptForString("> Enter city to apply filter: ");
    }

    public String promptState() {
        return io.promptForString("> Enter state to apply filter: ");
    }

    public String promptZipCode() {
        return io.promptForString("> Enter zipcode to apply filter: ");
    }

    // *************************************************************************************************************** Message UI
    public void message_RecordAdded() {
        io.display(gui.os_Quick_Notification_Builder("/", "New Record is added!"));
    }

    public void message_RecordRemoved() {
        io.display(gui.os_Quick_Notification_Builder("/", "Record is removed!"));
    }

    public void message_NoRecordFound() {
        io.display(gui.os_Quick_Notification_Builder("/", "No record is founded!"));
    }

    public void message_InvalidIput() {
        io.display(gui.os_Quick_Notification_Builder("/", "Invalid Input!!!/Please enter again..."));
    }
}
