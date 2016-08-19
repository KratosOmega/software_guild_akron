/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.model;

/**
 *
 * @author Kratos
 */
public class Item {

    private String itemName;
    private double itemPrice;
    private int itemQty;
    private boolean available;

    public Item(String itemName, double itemPrice, int itemQty) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
        this.available = true;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public String priceToString() {
        return this.itemPrice + "";
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return this.itemName + "::" + this.itemPrice + "::" + this.itemQty;
    }
}
