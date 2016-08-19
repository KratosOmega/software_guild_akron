/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.dto;

/**
 *
 * @author Kratos
 */
public class SavingAccount extends Account {

    private int withdrawPercentageRate;

    public SavingAccount(int withdrawPercentageRate) {
        this.withdrawPercentageRate = withdrawPercentageRate;
        this.balance = 5000;
    }

    @Override
    public boolean withdraw(double cash) {
        if (cash < this.balance) {
            this.balance -= (cash * (1 + (this.withdrawPercentageRate / 100.0))); // !!! Needs to use "100.0" instead of "100"

            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return this.balance;
    }
}
