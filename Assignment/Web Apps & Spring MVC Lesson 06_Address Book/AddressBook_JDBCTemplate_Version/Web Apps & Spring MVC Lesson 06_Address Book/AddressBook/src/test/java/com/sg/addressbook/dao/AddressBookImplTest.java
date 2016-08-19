/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.model.Address;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class AddressBookImplTest {

    private AddressBookApi dao;

    public AddressBookImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-spring-persistence.xml");
        dao = (AddressBookApi) ctx.getBean("AddressBookApi");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void add_select_edit_remove_Test() {
        Address address = new Address();
        address.setFirstName("testFN");
        address.setLastName("testLN");
        address.setHouseNumber("123");
        address.setStreet("test Street");
        address.setCity("test City");
        address.setZipCode("12345");
        address.setState("CA");
        address.setCountry("test Country");

        Address expectedAdd = dao.addAddress(address);
        Address actualAdd = dao.getAddressById(expectedAdd.getAddressId());

        org.junit.Assert.assertEquals(expectedAdd.getAddressId(), actualAdd.getAddressId());
        org.junit.Assert.assertEquals(expectedAdd.getFirstName(), actualAdd.getFirstName());
        org.junit.Assert.assertEquals(expectedAdd.getLastName(), actualAdd.getLastName());
        org.junit.Assert.assertEquals(expectedAdd.getHouseNumber(), actualAdd.getHouseNumber());
        org.junit.Assert.assertEquals(expectedAdd.getStreet(), actualAdd.getStreet());
        org.junit.Assert.assertEquals(expectedAdd.getCity(), actualAdd.getCity());
        org.junit.Assert.assertEquals(expectedAdd.getZipCode(), actualAdd.getZipCode());
        org.junit.Assert.assertEquals(expectedAdd.getState(), actualAdd.getState());
        org.junit.Assert.assertEquals(expectedAdd.getCountry(), actualAdd.getCountry());
        
        Address editedAddress = address;
        editedAddress.setFirstName("testFN");
        editedAddress.setLastName("testLN");
        editedAddress.setHouseNumber("123");
        editedAddress.setStreet("test Street");
        editedAddress.setCity("test City");
        editedAddress.setZipCode("12345");
        editedAddress.setState("MD");
        editedAddress.setCountry("test Country");
        
        dao.updateAddress(editedAddress);
        
        Address expectedEdit = editedAddress;
        Address actualEdit = dao.getAddressById(expectedEdit.getAddressId());
        
        org.junit.Assert.assertEquals(expectedEdit.getAddressId(), actualEdit.getAddressId());
        org.junit.Assert.assertEquals(expectedEdit.getFirstName(), actualEdit.getFirstName());
        org.junit.Assert.assertEquals(expectedEdit.getLastName(), actualEdit.getLastName());
        org.junit.Assert.assertEquals(expectedEdit.getHouseNumber(), actualEdit.getHouseNumber());
        org.junit.Assert.assertEquals(expectedEdit.getStreet(), actualEdit.getStreet());
        org.junit.Assert.assertEquals(expectedEdit.getCity(), actualEdit.getCity());
        org.junit.Assert.assertEquals(expectedEdit.getZipCode(), actualEdit.getZipCode());
        org.junit.Assert.assertEquals(expectedEdit.getState(), actualEdit.getState());
        org.junit.Assert.assertEquals(expectedEdit.getCountry(), actualEdit.getCountry());
        
        dao.deleteAddress(address.getAddressId());
        
        org.junit.Assert.assertNull(dao.getAddressById(address.getAddressId()));
    }
}
