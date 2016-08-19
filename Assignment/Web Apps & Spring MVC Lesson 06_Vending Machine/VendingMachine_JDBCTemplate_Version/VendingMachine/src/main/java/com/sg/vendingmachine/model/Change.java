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
public class Change {

    private int quarters;
    private int dimes;
    private int nickels;
    private int cents;

    public Change(int quarters, int dimes, int nickels, int cents) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.cents = cents;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }
}
