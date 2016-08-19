/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_addressbook.dao;

import com.sg.xcd_addressbook.dto.Address;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sg.xcd_addressbook.dto.AddressBook;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 *
 * @author Kratos
 */
public class AddressBookDAOTest {

    // ********************* 0
    AddressBookDAO dao;

    // ************************************************************************************ addRecord() Test
    @Test
    public void addRecordTest_1() throws FileNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        Address record = new Address("Xin", "Li", "111", "222", "333", "444", "555", "666");

        int expected = 4;
        // Act
        dao = new AddressBookDAO();
        dao.addRecord(addressBook, record);
        int actual = addressBook.getAddressBook().size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ removeRecord() Test
    @Test
    public void removeRecordTest_1() throws FileNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        int index = 0;
        int expected = 2;
        // Act
        dao = new AddressBookDAO();
        dao.removeRecord(addressBook, index);
        int actual = addressBook.getAddressBook().size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ searchByLastName() Test
    @Test
    public void searchByLastNameTest_1() throws FileNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        String lastName = "Li";
        int expected = 1;
        // Act
        dao = new AddressBookDAO();
        int actual = dao.searchByLastName(addressBook, "Li").size();
        // Assert

        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ countRecords() Test 
    @Test
    public void countRecords_1() throws FileNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        int expected = 3;
        // Act
        dao = new AddressBookDAO();
        int actual = dao.countRecords(addressBook);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ isAllAddressRecordsEmpty() Test 
    @Test
    public void isAllAddressRecordsEmpty_1() throws FileNotFoundException {
        // Arrange
        AddressBook addressBook = new AddressBook();
        boolean expected = false;
        // Act
        dao = new AddressBookDAO();
        boolean actual = dao.isAllAddressRecordsEmpty(addressBook);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ editRecordWithFLNameDone() Test 
    @Test
    public void editRecordWithFLNameDoneTest_1() {
        // Arrange
        String encodeName = "Xin::Li";
        Address expected = new Address("Xin", "Li", null, null, null, null, null, null);
        // Act
        dao = new AddressBookDAO();
        Address actual = dao.editRecordWithFLNameDone(encodeName);
        // Assert
        org.junit.Assert.assertEquals(expected.getFirsName(), actual.getFirsName());
        org.junit.Assert.assertEquals(expected.getLastName(), actual.getLastName());
        org.junit.Assert.assertEquals(expected.getHouseNumber(), actual.getHouseNumber());
        org.junit.Assert.assertEquals(expected.getStreet(), actual.getStreet());
        org.junit.Assert.assertEquals(expected.getCity(), actual.getCity());
        org.junit.Assert.assertEquals(expected.getState(), actual.getState());
        org.junit.Assert.assertEquals(expected.getZipCode(), actual.getZipCode());
        org.junit.Assert.assertEquals(expected.getCountry(), actual.getCountry());
    }

    // ************************************************************************************ editRecordWithRestDone() Test ----------------- ??? How to Assert ArrayList 
    // ************************************************************************************ (Is expected & actual has to be the same type as Return type??
    @Test
    public void editRecordWithRestDoneTest_1() throws FileNotFoundException {
        // Arrange
        int indexToEdit = 0;
        Address address = new Address("NewFN", "NewLN", "NewHouse#", "NewStreet", "NewCity", "NewState", "NewZipCode", "NewCountry");
        AddressBook addressBook = new AddressBook();
        String expected = "NewFN::NewLN::NewHouse#::NewStreet::NewCity::NewState::NewZipCode::NewCountry"
                + "Xin::Li::123::Clifftop Dr.::Gaithersburg::Maryland::54321::USA"
                + "Michael::Jackson::321::Billie Jean St.::Beverly Hills::California::54321::USA";
        // Act
        dao = new AddressBookDAO();
        String actual = dao.editRecordWithRestDone(0, address, addressBook).toString();
        System.out.println(expected);
        System.out.println(actual);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);

    }

    // ************************************************************************************ importData() Test 
    @Test
    public void importDataTest_1() throws FileNotFoundException {
        // Arrange
        String fileName = "addressbookInitialization.tsv";
        AddressBook addressBook = new AddressBook();
        boolean expected = true;
        // Act
        dao = new AddressBookDAO();
        boolean actual = dao.importData(fileName, addressBook);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void importDataTest_2() throws FileNotFoundException {
        // Arrange
        String fileName = "blablabla.tsv";
        AddressBook addressBook = new AddressBook();
        boolean expected = false;
        // Act
        dao = new AddressBookDAO();
        boolean actual = dao.importData(fileName, addressBook);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ exportData() Test 
    @Test
    public void exportDataTest_1() throws FileNotFoundException {
        // Arrange
        String fileName = "blablabla.txt";
        AddressBook addressBook = new AddressBook();
        boolean expected = true;
        // Act
        dao = new AddressBookDAO();
        boolean actual = dao.exportData(fileName, addressBook);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ searchByFullName() Test 
    @Test
    public void searchByFullNameTest_1() throws FileNotFoundException {
        // Arrange
        String encodedName = "Xin::Li";
        AddressBook addressBook = new AddressBook();
        addressBook.getAddressBook().add(new Address("Xin", "Li", "blabla", "blabla", "blabla", "blabla", "blabla", "blabla"));
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        // Act
        dao = new AddressBookDAO();
        ArrayList<Integer> actual = dao.searchByFullName(encodedName, addressBook);
        // Assert
        org.junit.Assert.assertEquals(expected.get(0), actual.get(0));
        org.junit.Assert.assertEquals(expected.get(1), actual.get(1));
        org.junit.Assert.assertEquals(expected.size(), actual.size());
    }

    // ************************************************************************************ encodingFLName() Test 
    @Test
    public void encodingFLNameTest_1() {
        // Arrange
        String firstName = "Xin";
        String lastName = "Li";
        String expected = "Xin::Li";
        // Act
        dao = new AddressBookDAO();
        String actual = dao.encodingFLName(firstName, lastName);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
