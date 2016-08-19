/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.dao;

import com.sg.addressbookv2.dto.Address;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class AddressBookImplementationTest {

    private ApplicationContext context;
    private AddressBookImplementation dao;
    private Address address;

    @Before
    public void setUp() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dao = (AddressBookImplementation) context.getBean("addressBook");
        this.address = (Address) context.getBean("address");
    }

    // *********************************************************************************** v2 API Test
    @Test
    public void filterLastNameTest_1() {
        // Arrange
        String lastName = "blablabla";
        int expected = 0;
        // Act
        int actual = dao.filterLastName(lastName).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterLastNameTest_2() {
        // Arrange
        String lastName = "Li";
        int expected = 4;
        // Act
        int actual = dao.filterLastName(lastName).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterCityTest_1() {
        // Arrange
        String city = "City1";
        int expected = 2;
        // Act
        int actual = dao.filterCity(city).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterCityTest_2() {
        // Arrange
        String city = "CityBlablabla";
        int expected = 0;
        // Act
        int actual = dao.filterCity(city).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterStateTest_1() {
        // Arrange
        String state = "State2";
        int expected_1 = 4;
        List<String> temp = new ArrayList<>();
        temp.add("City1");
        temp.add("City1");
        temp.add("City2");
        temp.add("City2");
        String expected_2 = temp.toString();
        // Act
        int actual_1 = dao.filterState(state).size();
        String actual_2 = dao.filterState(state)
                .stream()
                .map(record -> record.getCity())
                .collect(Collectors.toList()).toString();

        // Assert
        org.junit.Assert.assertEquals(expected_1, actual_1);
        org.junit.Assert.assertEquals(expected_2, actual_2);
    }

    @Test
    public void filterStateTest_2() {
        // Arrange
        String state = "StateBlablabla";
        int expected = 0;
        // Act
        int actual = dao.filterState(state).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterZipCodeTest_1() {
        // Arrange
        String zipCode = "ZipCode1";
        int expected = 3;
        // Act
        int actual = dao.filterZipCode(zipCode).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterZipCodeTest_2() {
        // Arrange
        String zipCode = "ZipCodeblablabla";
        int expected = 0;
        // Act
        int actual = dao.filterZipCode(zipCode).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // *********************************************************************************** v1 API Test
    @Test
    public void addRecordTest_1() {
        // Arrange
        Address address = this.address;
        int expected = dao.getAddressBook().size() + 1;
        // Act
        dao.addRecord(address);
        int actual = dao.getAddressBook().size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeRecordTest_1() {
        // Arrange
        int indexToRemove = 1;
        int expected = dao.getAddressBook().size() - 1;
        // Act
        dao.removeRecord(indexToRemove);
        int actual = dao.getAddressBook().size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void editRecordTest_1() {
        // Arrange
        int indexToEdit = 1;
        Address address = this.address;
        String expected = address.encodedRecord();
        // Act
        dao.editRecord(indexToEdit, address);
        String actual = dao.getAddressBook().get(indexToEdit).encodedRecord();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void countRecordTest_1() {
        // Arrange
        long expected = 5;
        // Act
        long actual = dao.countRecord();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void listAllTest_1() {
        // Arrange
        List<Address> expected = dao.getAddressBook();
        // Act
        List<Address> actual = dao.listAll();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ importData() Test 
    @Test
    public void importDataTest_1() throws FileNotFoundException {
        // Arrange
        String fileName = "importTest.txt";
        boolean expected = true;
        // Act
        boolean actual = dao.importRecord(fileName);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void importDataTest_2() throws FileNotFoundException {
        // Arrange
        String fileName = "blablabla.txt";
        boolean expected = false;
        // Act
        boolean actual = dao.importRecord(fileName);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************ exportData() Test 
    @Test
    public void exportDataTest_1() throws FileNotFoundException {
        // Arrange
        String fileName = "blablabla.txt";
        boolean expected = true;
        // Act
        boolean actual = dao.exportRecord(fileName);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // *********************************************************************************** Utilities Test
    @Test
    public void findIndexByFLNameTest_1() {
        // Arrange
        String encodedFLName = "Xin::Li";
        int expected = 1;
        // Act
        int actual = dao.findIndexByFLName(encodedFLName);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void findIndexByFLNameTest_2() {
        // Arrange
        String encodedFLName = "XXX::OOO";
        int expected = -1;
        // Act
        int actual = dao.findIndexByFLName(encodedFLName);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void findIndexByFullRecordData_1() {
        // Arrange
        String encodedRecord = "Kratos::Omega::123::Street1::City1::State2::ZipCode1::Country1";
        int expected = 0;
        // Act
        int actual = dao.findIndexByFullRecordData(encodedRecord);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void findIndexByFullRecordData_2() {
        // Arrange
        String encodedRecord = "XXXXX::XXXXX::XXXXX::XXXXX::XXXXX::XXXXX::XXXXX::XXXXX";
        int expected = -1;
        // Act
        int actual = dao.findIndexByFullRecordData(encodedRecord);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void decoding_1() {
        // Arrange
        String encodedString = "XXXXX::OOOOO";
        String[] expected = {"XXXXX", "OOOOO"};
        // Act
        String[] actual = dao.decoding(encodedString);
        // Assert
        org.junit.Assert.assertEquals(expected[0], actual[0]);
        org.junit.Assert.assertEquals(expected[1], actual[1]);
    }
}
