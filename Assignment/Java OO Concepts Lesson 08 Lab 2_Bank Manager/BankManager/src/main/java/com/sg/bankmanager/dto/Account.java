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
public class Account {

    protected double balance;
    private String password;

    public Account() {
        this.balance = 1000.00;
        this.password = "Kratos";
    }

    public boolean deposit(double cash) {
        if (cash > 10000) {
            return false;
        } else {
            this.balance += cash;
            return true;
        }
    }

    protected boolean withdraw(double cash) {
        if (cash < this.balance) {
            this.balance -= cash;
            return true;
        } else {
            return false;
        }
    }

    public String getPassword() {
        return password;
    }
}
