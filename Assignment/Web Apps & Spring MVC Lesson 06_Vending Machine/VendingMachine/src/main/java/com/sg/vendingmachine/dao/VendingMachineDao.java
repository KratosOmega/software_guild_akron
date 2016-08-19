/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.model.Change;
import com.sg.vendingmachine.model.Item;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.core.io.FileSystemResource;

/**
 *
 * @author Kratos
 */
public class VendingMachineDao implements VendingMachineApi {

    private ArrayList<Item> inventory;
    private FileSystemResource resource;
    private int currentMoneyPool;

    public VendingMachineDao() throws FileNotFoundException {
        this.inventory = new ArrayList<>();
        currentMoneyPool = 0;
        InputStream is = getClass().getResourceAsStream("/inventory.txt");
        String line;

        try {
            Reader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("::");
                this.inventory.add(new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2])));
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean updateVM() {
        try {
            PrintWriter vmUpdater = new PrintWriter(new FileWriter("inventory.txt"));

            for (Item item : inventory) {
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

    @Override
    public int isMoneyEnought(int selection, int insertedMoney) {
        currentMoneyPool += insertedMoney;
        int diff = currentMoneyPool - (int) (inventory.get(selection).getItemPrice() * 100);
        return diff;
    }

    @Override
    public Change makeChange(int diff) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int cents = 0;

        do {
            if (diff >= 25) {
                quarters = ((diff - (diff % 25))) / 25;
                diff = diff % 25;
            } else if (diff >= 10) {
                dimes = ((diff - (diff % 10))) / 10;
                diff = diff % 10;
            } else if (diff >= 5) {
                nickels = ((diff - (diff % 5))) / 5;
                diff = diff % 5;
            } else {
                cents = diff;
                diff = 0;
            }
        } while (diff != 0);

        Change change = new Change(quarters, dimes, nickels, cents);

        return change;
    }
    
    public void updateVMAfterSale(int selection) {
        Item item = inventory.get(selection);
        item.setItemQty(item.getItemQty() - 1);

        // update vm item position on the list
        if (item.getItemQty() == 0) {
            item.setAvailable(false);
        }
    }

    public void setCurrentMoneyPool(int currentMoneyPool) {
        this.currentMoneyPool = currentMoneyPool;
    }

    public List<Item> getInventory() {
        List<Item> availableInventory = new ArrayList<>();
        
        for(Item item : inventory){
            if(item.isAvailable()){
                availableInventory.add(item);
            }
        }
        return availableInventory;
    }
}
