/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.dao;

import com.sg.fmp.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class FMPImplementationTest {

    private ApplicationContext context;
    private FMPImplementation fmpImpl;
    private PrintWriter writer;

    @Before
    public void setUp() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.fmpImpl = (FMPImplementation) context.getBean("implementation");
    }

    @After
    public void cleanUp() {
        try {
            this.writer = new PrintWriter(new FileWriter(fmpImpl.getFilePathTo_database_orderSet() + "Orders_TestDate.txt"));
            writer.println("1,true,Xin Li,PA,6.75,Tile,200.0,3.5,4.15,700.0,830.0000000000001,103.275,1633.275");
            writer.println("2,true,Clarice Li,OH,6.25,Carpet,200.0,2.25,2.1,450.0,420.0,54.375,924.375");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Whoops");
        }
    }

    // ********************************************************************************************** keyEncoder()
    @Test
    public void keyEncoderTest_1() {
        // Arrange
        setUp();
        String date = "03051990";
        String orderNumber = "100";
        String expected = "03051990::100";
        // Act
        String actual = fmpImpl.keyEncoder(date, orderNumber);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void keyDecoder_getDateTest_1() {
        // Arrange
        setUp();
        String encodedString = "03051990::100";
        String expected = "03051990";
        // Act
        String actual = fmpImpl.keyDecoder_getDate(encodedString);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void keyDecoder_getOrderNumberTest_1() {
        // Arrange
        setUp();
        String encodedString = "03051990::100";
        String expected = "100";
        // Act
        String actual = fmpImpl.keyDecoder_getOrderNumber(encodedString);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void fileName_GeneratorTest_1() {
        // Arrange
        setUp();
        String givenDate = "03051990";
        String expected = "Orders_03051990.txt";
        // Act
        String actual = fmpImpl.fileName_Generator(givenDate);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void retrieveDataFromDatabaseTest_1() {
        // Arrange
        setUp();
        String givenDate = "TestDateBlablabla";
        int expected = 1;
        // Act
        int actual = fmpImpl.retrieveDataFromDatabase(givenDate);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void retrieveDataFromDatabaseTest_2() {
        // Arrange
        setUp();
        String givenDate = "TestDate";
        int expected_index = 3;
//        ArrayList<String> expected_data = new ArrayList<>();
//        // Can't test the details of this method individually, since I will use this method to initialize my database,
//        // So if I have previous data on today, it will fail my test
//        // This can only be tested when no data exist for the current day
//        expected_data.add("1,true,Xin Li,PA,6.75,Tile,200.0,3.5,4.15,700.0,830.0000000000001,103.275,1633.275");
//        expected_data.add("2,false,Clarice Li,OH,6.25,Carpet,200.0,2.25,2.1,450.0,420.0,54.375,924.375");
        // Act
        int actual_index = fmpImpl.retrieveDataFromDatabase(givenDate);
//        ArrayList<String> actual_data = new ArrayList<>();
//        fmpImpl.getOrders().keySet()
//                .stream()
//                .forEach(key -> {
//                    actual_data.add(fmpImpl.getOrders().get(key).encodedAttributes());
//                });
        // Assert
        // Check returned index
        org.junit.Assert.assertEquals(expected_index, actual_index);
//        // Check retrieved data count
//        org.junit.Assert.assertEquals(expected_data.size(), actual_data.size());
//        // Check retrived data details
//        IntStream
//                .range(0, expected_data.size())
//                .forEach(index -> {
//                    org.junit.Assert.assertEquals(expected_data.get(index), actual_data.get(index));
//                });
    }

    // ********************************************************************************************** ()
    @Test
    public void checkDatabaseExistenceTest_1() {
        // Arrange
        setUp();
        String givenDate = "TestDateBlablabla";
        boolean expected = false;
        // Act
        boolean actual = fmpImpl.checkDatabaseExistence(givenDate);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDatabaseExistenceTest_2() {
        // Arrange
        setUp();
        String givenDate = "TestDate";
        boolean expected = true;
        // Act
        boolean actual = fmpImpl.checkDatabaseExistence(givenDate);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void checkImportedListExistenceTest_1() {
        // Arrange
        setUp();
        String givenDate = "TestDate";
        boolean expected = false;
        // Act
        boolean actual = fmpImpl.checkImportedListExistence(givenDate);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkImportedListExistenceTest_2() {
        // Arrange
        setUp();
        String givenDate = "TestDate";
        fmpImpl.retrieveDataFromDatabase(givenDate);
        boolean expected = true;
        // Act
        boolean actual = fmpImpl.checkImportedListExistence(givenDate);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void decodeDateTest_1() {
        // Arrange
        setUp();
        String givenDate_1 = "03051990";
        String expected_1 = "03051990";
        String givenDate_2 = "03/05/1990";
        String expected_2 = "03051990";
        // Act
        String actual_1 = fmpImpl.decodeDate(givenDate_1);
        String actual_2 = fmpImpl.decodeDate(givenDate_2);
        // Assert
        org.junit.Assert.assertEquals(expected_1, actual_1);
        org.junit.Assert.assertEquals(expected_2, actual_2);
    }

    // ********************************************************************************************** ()
    @Test
    public void listOrdersTest_1() {
        // Arrange
        setUp();
        String givenDate = "TestDateBlablabla";
        List<Order> expected = null;
        // Act
        List<Order> actual = fmpImpl.listOrders(givenDate);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void listOrdersTest_2() {
        // Arrange
        setUp();
        String givenDate = "TestDate";
        List<String> expected_data = new ArrayList<>();
        expected_data.add("1,true,Xin Li,PA,6.75,Tile,200.0,3.5,4.15,700.0,830.0000000000001,103.275,1633.275");
        expected_data.add("2,true,Clarice Li,OH,6.25,Carpet,200.0,2.25,2.1,450.0,420.0,54.375,924.375");
        // Act
        List<Order> actual_data = fmpImpl.listOrders(givenDate)
                .stream()
                .collect(Collectors.toList());
        // Assert
        // Check retrived data details
        IntStream
                .range(0, expected_data.size())
                .forEach(index -> {
                    org.junit.Assert.assertEquals(expected_data.get(index), actual_data.get(index).encodedAttributes());
                });
    }

    // ********************************************************************************************** ()
    @Test
    public void addOrderTest_1() {
        // Arrange
        setUp();
        Order newOrder = new Order(99, true, "CustomerName", "State", 5.0, "ProductType", 9, 9, 9, 9, 9, 9, 9);
        int expected_DatabaseSize = fmpImpl.getOrders().size() + 1;
        int expected_CurrentOrderNumber = fmpImpl.getCurrentOrderNumber() + 1;
        // Act
        fmpImpl.addOrder(newOrder);
        int actual_DatabaseSize = fmpImpl.getOrders().size();
        int actual_CurrentOrderNumber = fmpImpl.getCurrentOrderNumber();
        // Assert
        org.junit.Assert.assertEquals(expected_DatabaseSize, actual_DatabaseSize);
        org.junit.Assert.assertEquals(expected_CurrentOrderNumber, actual_CurrentOrderNumber);
    }

    // ********************************************************************************************** ()
    @Test
    public void editOrderTest_1() {
        // Arrange
        setUp();
        // Populate a test order into the database first
        Order editedOrder = new Order(99, true, "CustomerName", "State", 10, "ProductType", 1, 1, 1, 1, 1, 1, 1);
        fmpImpl.addOrder(editedOrder);
        String keyToEdit = fmpImpl.getOrders().keySet()
                .stream()
                .filter(key -> key.contains("99"))
                .collect(Collectors.toList())
                .get(0);
        // Prepare the basic informatio modification
        editedOrder.setCustomerName("ChangedName");
        editedOrder.setState("OH");
        editedOrder.setProductType("Carpet");
        editedOrder.setArea(100);
        String expected = new Order(99, true, "ChangedName", "OH", 6.25, "Carpet", 100, 2.25, 2.10, 225.0, 210.0, 27.1875, 462.1875).encodedAttributes();
        // Act
        fmpImpl.editOrder(keyToEdit, fmpImpl.preEditOrder(editedOrder));
        String actual = fmpImpl.getOrders().get(keyToEdit).encodedAttributes();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void removeOrderTest_1() {
        // Arrange
        setUp();
        String givenDate = "TestDate";
        String orderNumber = "1";
        String expected = "" + !(fmpImpl.listOrders(givenDate).get(0).isOrderStatus());
        // Act
        // populate data into memory first
        fmpImpl.retrieveDataFromDatabase(givenDate);
        // All remove action is done during memory
        fmpImpl.removeOrder(givenDate, orderNumber);
        String actual = fmpImpl.getOrders().get(fmpImpl.keyEncoder(givenDate, orderNumber)).getOrderStatus();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ********************************************************************************************** ()
    @Test
    public void saveCurrentWorkTest_1() {
        // Arrange
        setUp();
        String givenDate = "TestDate";
        String orderNumber = "2";
        int index = Integer.parseInt(orderNumber) - 1;
        String expected = "2,true,Changed,PA,6.75,Tile,1000.0,3.5,4.15,3500.0,4150.0,516.375,8166.375";
        int expected_Size = 2;

        // Act
        fmpImpl.retrieveDataFromDatabase(givenDate);
        Order order = fmpImpl.listOrders(givenDate).get(index);
        order.setCustomerName("Changed");
        order.setProductType("Tile");
        order.setState("PA");
        order.setArea(1000);
        String key = fmpImpl.keyEncoder(givenDate, orderNumber);
        fmpImpl.editOrder(key, fmpImpl.preEditOrder(order));
        List<Order> actual_OrderList = fmpImpl.listOrders(givenDate);
        String actual = fmpImpl.getOrders().get(key).encodedAttributes();
        int actual_Size = actual_OrderList.size();
        fmpImpl.saveCurrentWork();
        // Assert
        org.junit.Assert.assertEquals(expected_Size, actual_Size);
        org.junit.Assert.assertEquals(expected, actual);

        cleanUp();
    }
    
    
    // ********************************************************************************************** ()
    
    @Test
    public void preEditOrderTest_1(){
        // Arrange
        Order order = new Order(1, true, "Test", "OH", -1, "Carpet", 100, 0, 0, 0, 0, 0, 0);
        String expected = "1,true,Test,OH,6.25,Carpet,100.0,2.25,2.1,225.0,210.0,27.1875,462.1875";
        // Act
        String actual = fmpImpl.preEditOrder(order).encodedAttributes();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
