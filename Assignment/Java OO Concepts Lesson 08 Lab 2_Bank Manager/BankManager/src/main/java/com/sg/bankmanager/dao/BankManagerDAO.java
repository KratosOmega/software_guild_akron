/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.dao;

import com.sg.bankmanager.dto.Account;

/**
 *
 * @author Kratos
 */
public class BankManagerDAO {
    
    private Account account;

    public BankManagerDAO() {
        this.account = new Account();
    }
    
    public boolean checkPassWord(String password){
        return password.equals(account.getPassword());
    }
}
