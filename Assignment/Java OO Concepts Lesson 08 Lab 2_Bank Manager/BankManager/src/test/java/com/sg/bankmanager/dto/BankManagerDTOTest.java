/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.dto;

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
public class BankManagerDTOTest {

    Account account;
    CheckingAccount checkingAccount;
    SavingAccount savingAccount;

    // ****************************************** Account
    @Test
    public void accountDepositTest_1() {
        // Arrange
        double cash = 200;
        boolean expected_result = true;
        double expected_balance = 1200;
        // Act
        account = new Account();
        boolean actual_result = account.deposit(cash);
        double actual_balance = account.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void accountDepositTest_2() {
        // Arrange
        double cash = 20000;
        boolean expected_result = false;
        double expected_balance = 1000;
        // Act
        account = new Account();
        boolean actual_result = account.deposit(cash);
        double actual_balance = account.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void accountWithdrawTest_1() {
        // Arrange
        double cash = 500;
        boolean expected_result = true;
        double expected_balance = 500;
        // Act
        account = new Account();
        boolean actual_result = account.withdraw(cash);
        double actual_balance = account.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void accountWithdrawTest_2() {
        // Arrange
        double cash = 5000;
        boolean expected_result = false;
        double expected_balance = 1000;
        // Act
        account = new Account();
        boolean actual_result = account.withdraw(cash);
        double actual_balance = account.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    // ****************************************** CheckingAccount
    @Test
    public void checkingAccountDepositTest_1() {
        // Arrange
        double cash = 5000;
        boolean expected_result = true;
        double expected_balance = 6000;
        // Act
        checkingAccount = new CheckingAccount();
        boolean actual_result = checkingAccount.deposit(cash);
        double actual_balance = checkingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void checkingAccountDepositTest_2() {
        // Arrange
        double cash = 20000;
        boolean expected_result = false;
        double expected_balance = 1000;
        // Act
        checkingAccount = new CheckingAccount();
        boolean actual_result = checkingAccount.deposit(cash);
        double actual_balance = checkingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void checkingAccountWithdrawTest_1() {
        // Arrange
        double cash = 100;
        boolean expected_result = true;
        double expected_balance = 900;
        // Act
        checkingAccount = new CheckingAccount();
        boolean actual_result = checkingAccount.withdraw(cash);
        double actual_balance = checkingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void checkingAccountWithdrawTest_2() {
        // Arrange
        double cash = 500;
        boolean expected_result = true;
        double expected_balance = 500;
        // Act
        checkingAccount = new CheckingAccount();
        boolean actual_result = checkingAccount.withdraw(cash);
        double actual_balance = checkingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void checkingAccountWithdrawTest_3() {
        // Arrange
        double cash = 1010;
        boolean expected_result = true;
        double expected_balance = -20;
        // Act
        checkingAccount = new CheckingAccount();
        boolean actual_result = checkingAccount.withdraw(cash);
        double actual_balance = checkingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void checkingAccountWithdrawTest_4() {
        // Arrange
        double cash = 1500;
        boolean expected_result = false;
        double expected_balance = 1000;
        // Act
        checkingAccount = new CheckingAccount();
        boolean actual_result = checkingAccount.withdraw(cash);
        double actual_balance = checkingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

   
    // ****************************************** SavingAccount
    @Test
    public void savingAccountWithdrawTest_1() {
        // Arrange
        double cash = 500;
        boolean expected_result = true;
        double expected_balance = 4450;
        // Act
        savingAccount = new SavingAccount(10);
        boolean actual_result = savingAccount.withdraw(cash);
        double actual_balance = savingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }

    @Test
    public void savingAccountWithdrawTest_2() {
        // Arrange
        double cash = 6000;
        boolean expected_result = false;
        double expected_balance = 5000;
        // Act
        savingAccount = new SavingAccount(10);
        boolean actual_result = savingAccount.withdraw(cash);
        double actual_balance = savingAccount.balance;
        // Assert
        org.junit.Assert.assertEquals(expected_result, actual_result);
        org.junit.Assert.assertEquals(expected_balance, actual_balance, 0.0);
    }
}
