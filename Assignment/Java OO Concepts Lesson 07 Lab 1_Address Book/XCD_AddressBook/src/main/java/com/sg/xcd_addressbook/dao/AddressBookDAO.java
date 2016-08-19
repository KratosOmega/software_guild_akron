/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_addressbook.dao;

import com.sg.xcd_addressbook.dto.Address;
import com.sg.xcd_addressbook.dto.AddressBook;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class AddressBookDAO {

    // ****************************************************************************** 
    private Scanner scanner;
    private PrintWriter writer;

    // ****************************************************************************** 1
    public void addRecord(AddressBook addressBook, Address record) {
        addressBook.getAddressBook().add(record);
    }

    // ****************************************************************************** 2
    public void removeRecord(AddressBook addressBook, int index) {
        addressBook.getAddressBook().remove(index);
    }

    // ****************************************************************************** 3
    public ArrayList<Address> searchByLastName(AddressBook addressBook, String lastName) {

        ArrayList<Address> foundedAddresses = new ArrayList<>();
        boolean founded = false;

        for (Address record : addressBook.getAddressBook()) {
            if (record.getLastName().equals(lastName)) {
                founded = true;
                foundedAddresses.add(record);
            }
        }

        if (founded) {
            return foundedAddresses;
        } else {
            return null;
        }
    }

    // ****************************************************************************** 4
    public int countRecords(AddressBook addressBook) {
        return addressBook.getAddressBook().size();
    }

    // ****************************************************************************** 5
    public boolean isAllAddressRecordsEmpty(AddressBook addressBook) {
        return addressBook.getAddressBook().isEmpty();
    }

    // ****************************************************************************** 6
    public Address editRecordWithFLNameDone(String encodedName) {
        String firstName = encodedName.split("::")[0];
        String lastName = encodedName.split("::")[1];

        return new Address(firstName, lastName, null, null, null, null, null, null);
    }

    // ****************************************************************************** 7
    public AddressBook editRecordWithRestDone(int indexToEdit, Address address, AddressBook addressBook) {
        addressBook.getAddressBook().set(indexToEdit, address);
        return addressBook;
    }

    // ****************************************************************************** 8
    public boolean importData(String fileName, AddressBook addressBook) {
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (scanner.hasNext()) {
                String[] recordComponent = scanner.nextLine().split("\t");
                addressBook.getAddressBook().add(new Address(
                        recordComponent[0], recordComponent[1],
                        recordComponent[2], recordComponent[3],
                        recordComponent[4], recordComponent[5],
                        recordComponent[6], recordComponent[7]));
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    // ****************************************************************************** 9
    public boolean exportData(String fileName, AddressBook addressBook) {

        try {
            writer = new PrintWriter(new FileWriter(fileName));
            for (Address record : addressBook.getAddressBook()) {
                writer.println(
                        record.getFirsName() + "\t" + record.getLastName() + "\t"
                        + record.getHouseNumber() + "\t" + record.getStreet() + "\t"
                        + record.getCity() + "\t" + record.getState() + "\t"
                        + record.getZipCode() + "\t" + record.getCountry()
                );
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // ---------------------------------------------- Utilities
    // ****************************************************************************** 10
    public ArrayList<Integer> searchByFullName(String encodedName, AddressBook addressBook) {
        ArrayList<Integer> indexs = new ArrayList<>();

        for (int i = 0; i < addressBook.getAddressBook().size(); i++) {
            if (encodedName.equals((addressBook.getAddressBook().get(i).encodingName()))) {
                indexs.add(i);
            }
        }
        return indexs;
    }

    // ****************************************************************************** 11
    public String encodingFLName(String firstName, String lastName) {
        return firstName + "::" + lastName;
    }
}
