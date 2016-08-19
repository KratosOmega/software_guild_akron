/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.dao;

import com.sg.addressbookv2.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Kratos
 */
public class AddressBookImplementation implements AddressBookApi {

    private List<Address> addressBook;

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose
    public Scanner scanner;
    public PrintWriter writer;
    public String[] data;
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose

    public AddressBookImplementation() {
        this.addressBook = new ArrayList<>();

        // +++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose
        try {
            this.scanner = new Scanner(new BufferedReader(new FileReader("loadDataForTest.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Can not load file!");
        }

        while (scanner.hasNext()) {
            data = scanner.nextLine().split("::");
            Address address = new Address(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
            this.addressBook.add(address);
        }
        // +++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose
    }

    // *********************************************************************************** v2 API
    @Override
    public List<Address> filterLastName(String lastName) {
        return addressBook
                .stream()
                .filter(address -> address.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> filterCity(String city) {
        return addressBook
                .stream()
                .filter(address -> address.getCity().equals(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> filterState(String state) {
        return addressBook
                .stream()
                .filter(address -> address.getState().equals(state))
                .sorted((add1, add2) -> add1.getCity().compareTo(add2.getCity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> filterZipCode(String zipCode) {
        return addressBook
                .stream()
                .filter(address -> address.getZipCode().equals(zipCode))
                .collect(Collectors.toList());
    }

    // *********************************************************************************** v1 API
    @Override
    public void addRecord(Address record) {
        addressBook.add(record);
    }

    @Override
    public void removeRecord(int indexToRemove) {
        addressBook.remove(indexToRemove);
    }

    @Override
    public void editRecord(int indexToEdit, Address record) {
        addressBook.set(indexToEdit, record);
    }

    @Override
    public long countRecord() {
        return addressBook
                .stream()
                .count();
    }

    @Override
    public List<Address> listAll() {
        return this.addressBook;
    }

    @Override
    public boolean importRecord(String fileName) {
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (scanner.hasNext()) {
                String[] recordComponent = scanner.nextLine().split("::");
                addressBook.add(new Address(
                        recordComponent[0],
                        recordComponent[1],
                        recordComponent[2],
                        recordComponent[3],
                        recordComponent[4],
                        recordComponent[5],
                        recordComponent[6],
                        recordComponent[7]));
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean exportRecord(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName));

            addressBook
                    .stream()
                    .forEach(address -> writer.println(
                            address.getFirsName() + "::"
                            + address.getLastName() + "::"
                            + address.getHouseNumber() + "::"
                            + address.getStreet() + "::"
                            + address.getCity() + "::"
                            + address.getState() + "::"
                            + address.getZipCode() + "::"
                            + address.getCountry()));
//            for (Address record : addressBook) {
//                writer.println(
//                        record.getFirsName() + "\t" + record.getLastName() + "\t"
//                        + record.getHouseNumber() + "\t" + record.getStreet() + "\t"
//                        + record.getCity() + "\t" + record.getState() + "\t"
//                        + record.getZipCode() + "\t" + record.getCountry()
//                );
//            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // *********************************************************************************** Customized Methods
    public int findIndexByFLName(String encodedFLName) {
        if (addressBook
                .stream()
                .filter(address -> address.encodeName().equals(encodedFLName))
                .toArray().length == 0) {
            return -1;
        } else {
            return IntStream
                    .range(0, addressBook.size())
                    .filter((int n) -> addressBook.get(n).encodeName().equals(encodedFLName)) // Should I "int n"?
                    .min()
                    .getAsInt();
        }
    }

    public int findIndexByFullRecordData(String encodedRecord) {
        if (addressBook
                .stream()
                .filter(address -> address.encodedRecord().equals(encodedRecord))
                .toArray().length == 0) {
            return -1;
        } else {
            return IntStream
                    .range(0, addressBook.size())
                    .filter(n -> addressBook.get(n).encodedRecord().equals(encodedRecord)) // Or leave it just simply "n" ?
                    .min()
                    .getAsInt();
        }
    }

    public String[] decoding(String encodedString) {
        return encodedString.split("::");
    }

    public List<Address> getAddressBook() {
        return addressBook;
    }
}
