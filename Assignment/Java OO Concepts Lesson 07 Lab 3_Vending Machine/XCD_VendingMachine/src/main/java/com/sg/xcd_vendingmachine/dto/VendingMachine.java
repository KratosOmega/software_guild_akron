/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_vendingmachine.dto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class VendingMachine {

    private ArrayList<Item> vendingMachine;
    private Scanner invScanner;

    public VendingMachine() throws FileNotFoundException {
        this.invScanner = new Scanner(new BufferedReader(new FileReader("inventory.txt")));
        this.vendingMachine = new ArrayList<>();

        while (invScanner.hasNext()) {
            String[] data = invScanner.nextLine().split("::");
            this.vendingMachine.add(new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2])));
        }
    }

    public ArrayList<Item> getVendingMachine() {
        return vendingMachine;
    }
}
