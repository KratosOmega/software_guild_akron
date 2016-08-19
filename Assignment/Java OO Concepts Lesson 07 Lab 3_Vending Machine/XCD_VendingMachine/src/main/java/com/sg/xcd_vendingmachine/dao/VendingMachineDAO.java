/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_vendingmachine.dao;

import com.sg.xcd_vendingmachine.dto.Change;
import com.sg.xcd_vendingmachine.dto.Item;
import com.sg.xcd_vendingmachine.dto.VendingMachine;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Kratos
 */
public class VendingMachineDAO {

    // ----------------------------------------------------------------------------- Check if money is enought
    public int isMoneyEnought(int selection, int money, int itemPrice) {
        return money - itemPrice;
    }

//    public boolean isSelectionOutOfStock(int selection, VendingMachine vm){
//        return vm.getVendingMachine().get(selection).getItemQty() == 0;
//    }
    
    // ----------------------------------------------------------------------------- Check selection if it is valid input    
    public boolean isSelectionValid(int selection, VendingMachine vm) {
        return selection <= vm.getVendingMachine().size();
    }    

    // ----------------------------------------------------------------------------- Update the current inventory stock in virtual database
    public void updateVMAfterSale(int selection, VendingMachine vm) {
        Item item = vm.getVendingMachine().get(selection - 1);
        item.setItemQty(item.getItemQty() - 1);

        // update vm item position on the list
        if (item.getItemQty() == 0) {
            Item updatedItem = new Item(item.getItemName(), item.getItemPrice(), item.getItemQty());
            vm.getVendingMachine().add(updatedItem);
            vm.getVendingMachine().remove(selection - 1);
        }
    }

    // ----------------------------------------------------------------------------- calculation for combination of q, d, n, c
    public Change makeChange(int difference) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int cents = 0;

        do {
            if (difference >= 25) {
                quarters = ((difference - (difference % 25))) / 25;
                difference = difference % 25;
            } else if (difference >= 10) {
                dimes = ((difference - (difference % 10))) / 10;
                difference = difference % 10;
            } else if (difference >= 5) {
                nickels = ((difference - (difference % 5))) / 5;
                difference = difference % 5;
            } else {
                cents = difference;
                difference = 0;
            }
        } while (difference != 0);

        Change change = new Change(quarters, dimes, nickels, cents);

        return change;
    }

    // ----------------------------------------------------------------------------- Update the inventory stock in local database (txt file)
    public boolean updateVM(VendingMachine vm) {
        try {
            PrintWriter vmUpdater = new PrintWriter(new FileWriter("inventory.txt"));

            for (Item item : vm.getVendingMachine()) {
                vmUpdater.println(
                        item.getItemName()
                        + "::" + item.getItemPrice()
                        + "::" + item.getItemQty()
                );
            }
            vmUpdater.flush();
            vmUpdater.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
