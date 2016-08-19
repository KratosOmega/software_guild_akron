/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_addressbook.ui;

import com.sg.xcd_addressbook.dto.Address;
import com.sg.xcd_addressbook.dto.AddressBook;
import java.util.ArrayList;

/**
 *
 * @author Kratos
 */
public class AddressBookUI {

    private ConsoleIO io;
    private GUIUtilities guiUtilities;

    public AddressBookUI() {
        this.io = new ConsoleIO();
        this.guiUtilities = new GUIUtilities();
    }

    public void menu() {
        io.display(guiUtilities.os_Menu_Builder(50, 2, "#", 2, ";",
                "Address Book System",
                "1. Add an address record;"
                + "2. Remove an address record;"
                + "3. Find address record by lastname;"
                + "4. Show total # of address records;"
                + "5. Show all address records;"
                + "6. Edit address records;"
                + "7. Import data into address book;"
                + "8. Export data into local file;"
                + "0. Display Operation Menu;"));
        io.display("\n");
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "<Enter \"-1\" to Quit>"));
    }

    // ********************************************************************** Controller Related UI
    public int promptOperation() {
        io.display("\n" + guiUtilities.os_Component_Builder("=", 50));
        return io.promptForIntWithinRange("\nPlease choose operation: ", -1, 8);
    }

    public void message_exitThankYou() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Thank you for using Electric Address Book!"));
    }

    // ********************************************************************** Add Record Related UI
    public Address promptAddRecord() {
        io.display(guiUtilities.os_Quick_Header_Builder("Add New Record") + "\n");

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

    public void message_Add_RecordAdded() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Record is successfully added!"));
    }

    // ********************************************************************** Remove Record Related UI
    public String promptRemoveRecord_GetFLName() {
        io.display(guiUtilities.os_Quick_Header_Builder("Remove Record") + "\n");
        return (io.promptForString("> First Name: ") + "::" + io.promptForString("> Last Name : "));
    }

    public void message_Remove_RecordRemoved() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Record is successfully removed!"));
    }

    public void message_Remove_RecordNotExists() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "No such record, action is denied!"));
    }

    public void message_DuplicatedRecord() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "You have duplicated records!") + "\n");
    }

    public void displayDuplicatedRecord(AddressBook addressBook, ArrayList<Integer> indexs) {
        int count = 0;

        for (int index : indexs) {
            count++;
            io.display(guiUtilities.os_Quick_Header_Builder("# " + count));
            io.display("\n"
                    + addressBook.getAddressBook().get(index).getFirsName() + " "
                    + addressBook.getAddressBook().get(index).getLastName() + "\n"
                    + addressBook.getAddressBook().get(index).getHouseNumber() + " "
                    + addressBook.getAddressBook().get(index).getStreet() + "\n"
                    + addressBook.getAddressBook().get(index).getCity() + ", "
                    + addressBook.getAddressBook().get(index).getState() + " "
                    + addressBook.getAddressBook().get(index).getZipCode() + "\n"
                    + addressBook.getAddressBook().get(index).getCountry() + "\n");
        }
    }

    public int getIndexForRemoveOrEdit(ArrayList<Integer> indexs) {
        io.display("\n" + guiUtilities.os_Component_Builder("=", 50));
        return indexs.get(io.promptForInt("\nMake your selection: ") - 1);
    }

    // ********************************************************************** Search Records by last name Related UI
    public String promptLastNameToSearch() {
        io.display(guiUtilities.os_Quick_Header_Builder("Search Record") + "\n");
        return io.promptForString("Please enter the last name: ");
    }

    public void displaySearchedResult(ArrayList<Address> foundedAddresses) {
        int index = 0;

        for (Address record : foundedAddresses) {
            index++;
            io.display(guiUtilities.os_Quick_Header_Builder("# " + index));
            io.display("\n"
                    + record.getFirsName() + " " + record.getLastName() + "\n"
                    + record.getHouseNumber() + " " + record.getStreet() + "\n"
                    + record.getCity() + ", " + record.getState() + " " + record.getZipCode() + "\n"
                    + record.getCountry() + "\n");
        }
    }

    public void message_Search_NoRecordFounded() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "No such record!"));
    }

    // ********************************************************************** Count Records Related UI
    public void displayRecordCount(int count) {
        io.display(guiUtilities.os_Quick_Header_Builder("Count Records") + "\n");
        io.display("There are " + count + " records in the address book.");
    }

    // ********************************************************************** List All Records Related UI
    public void displayAddressRecord(AddressBook addressBook) {
        int index = 0;
        io.display(guiUtilities.os_Quick_Header_Builder("List Records") + "\n");

        for (Address record : addressBook.getAddressBook()) {
            index++;
            io.display(guiUtilities.os_Quick_Header_Builder("# " + index));
            io.display("\n"
                    + record.getFirsName() + " " + record.getLastName() + "\n"
                    + record.getHouseNumber() + " " + record.getStreet() + "\n"
                    + record.getCity() + ", " + record.getState() + " " + record.getZipCode() + "\n"
                    + record.getCountry() + "\n");
        }
    }

    public void message_NoRecordToDisplay() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Database has not record to display!"));
    }

    // ********************************************************************** Edit Record Related UI
    public void message_Edit_RecordNotExists() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "No such record, action is denied!"));
    }

    public void message_Edit_RecordEdited() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Record is sucessfully edited"));
    }

    public String promptEditRecord_GetFLName_Encoded() {
        io.display(guiUtilities.os_Quick_Header_Builder("Edit Record") + "\n");
        return (io.promptForString("> First Name: ") + "::" + io.promptForString("> Last Name : "));
    }

    public Address promptFinshEditRecord(Address recordNeedEditing) {
        recordNeedEditing.setHouseNumber(io.promptForString("> House #   : "));
        recordNeedEditing.setStreet(io.promptForString("> Street    : "));
        recordNeedEditing.setCity(io.promptForString("> City      : "));
        recordNeedEditing.setState(io.promptForString("> State     : "));
        recordNeedEditing.setZipCode(io.promptForString("> Zip Code  : "));
        recordNeedEditing.setCountry(io.promptForString("> Country   : "));

        return recordNeedEditing;
    }

    // ********************************************************************** Import Related UI
    public String promptForFileNameToImport() {
        io.display(guiUtilities.os_Quick_Header_Builder("Import Record") + "\n");
        return io.promptForString("Enter the file name: ");
    }

    public void message_Import_FileNotFoundException() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Import Failed"));
    }

    public void message_Import_Done() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Import is finished!"));
    }

    // ********************************************************************** Export Related UI
    public String promptForFileNameToExport() {
        io.display(guiUtilities.os_Quick_Header_Builder("Export Record") + "\n");
        return io.promptForString("Enter the file name: ");
    }

    public void message_Export_IOException() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "IOException!"));
    }

    public void message_Export_Done() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Export is finished!"));
    }

    // ******************************************************************** Utilities
    public void killTheGodDamnNewLine() {
        io.killNewLine();
    }
}
