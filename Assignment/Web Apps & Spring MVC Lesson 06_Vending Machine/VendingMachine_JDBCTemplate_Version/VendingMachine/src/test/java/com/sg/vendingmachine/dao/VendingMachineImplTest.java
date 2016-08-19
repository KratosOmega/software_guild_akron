/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Change;
import com.sg.vendingmachine.model.Item;
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
public class VendingMachineImplTest {

    private VendingMachineApi dao;

    public VendingMachineImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-spring-persistence.xml");
        dao = (VendingMachineApi) ctx.getBean("VendingMachineApi");
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
    public void edit_select_Test() {
        Item expectedEdit = dao.listItemById(1);
        expectedEdit.setItem_name("Test");
        expectedEdit.setItem_price(5);
        expectedEdit.setItem_quantity(11);
        dao.editItem(expectedEdit);
        Item actualEdit = dao.listItemById(expectedEdit.getItem_id());

        org.junit.Assert.assertEquals(expectedEdit.getItem_id(), actualEdit.getItem_id());
        org.junit.Assert.assertEquals(expectedEdit.getItem_name(), actualEdit.getItem_name());
        org.junit.Assert.assertEquals(expectedEdit.getItem_price(), actualEdit.getItem_price(),0.0);
        org.junit.Assert.assertEquals(expectedEdit.getItem_quantity(), actualEdit.getItem_quantity());
    }

    @Test
    public void change_Test() {
        Change expectedChange = new Change(1, 1, 1, 1);
        Change actualChange = dao.makeChange(41);

        org.junit.Assert.assertEquals(expectedChange.getQuarters(), actualChange.getQuarters());
        org.junit.Assert.assertEquals(expectedChange.getDimes(), actualChange.getDimes());
        org.junit.Assert.assertEquals(expectedChange.getNickels(), actualChange.getNickels());
        org.junit.Assert.assertEquals(expectedChange.getCents(), actualChange.getCents());
    }
}
