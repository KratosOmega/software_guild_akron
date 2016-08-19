/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_vendingmachine.dao;

import com.sg.xcd_vendingmachine.dto.Change;
import com.sg.xcd_vendingmachine.dto.Item;
import com.sg.xcd_vendingmachine.dto.VendingMachine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kratos
 */
public class VendingMachineDAOTest {

    VendingMachineDAO dao;

    // ----------------------------------------------------------------------------- isMoneyEnought() Test
    @Test
    public void isMoneyEnoughtTest_1() {
        // Arrange
        int selection = 1;
        int money = 100;
        int itemPrice = 125;
        int expected = -25;
        // Act
        dao = new VendingMachineDAO();
        int actual = dao.isMoneyEnought(selection, money, itemPrice);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void isMoneyEnoughtTest_2() {
        // Arrange
        int selection = 1;
        int money = 125;
        int itemPrice = 100;
        int expected = 25;
        // Act
        dao = new VendingMachineDAO();
        int actual = dao.isMoneyEnought(selection, money, itemPrice);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ----------------------------------------------------------------------------- isSelectionValid() Test
    @Test
    public void isSelectionValidTest_1() throws FileNotFoundException {
        // Arrange
        int selection = 1;
        VendingMachine vm = new VendingMachine();
        boolean expected = true;
        // Act
        dao = new VendingMachineDAO();
        boolean actual = dao.isSelectionValid(selection, vm);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void isSelectionValidTest_2() throws FileNotFoundException {
        // Arrange
        int selection = 9;
        VendingMachine vm = new VendingMachine();
        boolean expected = false;
        // Act
        dao = new VendingMachineDAO();
        boolean actual = dao.isSelectionValid(selection, vm);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ----------------------------------------------------------------------------- updateVMAfterSale() Test
    @Test
    public void updateVMAfterSaleTest_1() throws FileNotFoundException {
        // Arrange
        int selection = 1;
        VendingMachine vm = new VendingMachine();
        String expected_name = "Chocolate";
        // Act
        dao = new VendingMachineDAO();
        dao.updateVMAfterSale(selection, vm);
        String actual_name = vm.getVendingMachine().get(vm.getVendingMachine().size() - 1).getItemName();
        // Assert
        org.junit.Assert.assertEquals(expected_name, actual_name);
    }

    // ----------------------------------------------------------------------------- makeChange() Test
    @Test
    public void makeChangeTest_1() {
        // Arrange
        int difference = 74;
        Change expected = new Change(2, 2, 0, 4);
        // Act
        dao = new VendingMachineDAO();
        Change actual = dao.makeChange(difference);
        // Assert
        org.junit.Assert.assertEquals(expected.getQuarters(), actual.getQuarters());
        org.junit.Assert.assertEquals(expected.getDimes(), actual.getDimes());
        org.junit.Assert.assertEquals(expected.getNickels(), actual.getNickels());
        org.junit.Assert.assertEquals(expected.getCents(), actual.getCents());
    }

    // ----------------------------------------------------------------------------- updateVM()
    @Test
    public void updateVMTest_1() throws FileNotFoundException {
        // Arrange
        VendingMachine vm = new VendingMachine();
        vm.getVendingMachine().get(1).setItemQty(2);
        String expected = "";
        for (Item item : vm.getVendingMachine()) {
            expected += item.toString();
        }
        // Act
        dao = new VendingMachineDAO();
        dao.updateVM(vm);
        String actual = "";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("inventory.txt")));
        while (scanner.hasNext()) {
            actual += scanner.nextLine();
        }
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
