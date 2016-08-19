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
public class CheckingAccount extends Account {

    private boolean overdraft;

    public CheckingAccount() {
        this.overdraft = false;
        this.balance = 1000;
    }
    
    
    @Override
    public boolean deposit(double cash) {
        if (cash > 10000) {
            return false;
        } else {
            this.balance += cash;
            this.overdraft = false;
            return true;
        }
    }

    
    @Override
    public boolean withdraw(double cash) {
        if (this.overdraft) {
            return false;
        } else if (cash > this.balance && cash <= this.balance + 100) {
            this.balance -= (cash + 10);
            this.overdraft = true;
            return true;
        } else if (cash > this.balance + 100) {
            return false;
        } else {
            this.balance -= cash;
            return true;
        }
    }
    
    public double getBalance(){
        return this.balance;
    }

}
