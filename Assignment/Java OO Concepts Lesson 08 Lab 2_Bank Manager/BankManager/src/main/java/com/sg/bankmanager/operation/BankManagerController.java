/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.operation;

import com.sg.bankmanager.dao.BankManagerDAO;
import com.sg.bankmanager.dto.CheckingAccount;
import com.sg.bankmanager.dto.SavingAccount;
import com.sg.bankmanager.ui.BankManagerUI;

/**
 *
 * @author Kratos
 */
public class BankManagerController {

    private BankManagerDAO dao;
    private BankManagerUI ui;
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;

    public BankManagerController() {
        this.dao = new BankManagerDAO();
        this.ui = new BankManagerUI();
        this.checkingAccount = new CheckingAccount();
        this.savingAccount = new SavingAccount(10);
    }

    public void run() {
        int pwTry = 3;
        boolean quit = false;
        String operation = "";

        while (!quit) {
            String password = ui.prompt_PassWord();
            if (!password.equals(checkingAccount.getPassword())) {
                pwTry--;
                if (pwTry == 0) {
                    ui.message_SafetyProtction();
                    quit = true;
                } else {
                    ui.message_Wrong_PassWord();
                }

            } else {
                break;
            }
        }

        // ******************************************* Accounts Section
        while (!quit) {
            ui.message_NextSection();
            ui.menu_Accounts();
            operation = ui.prompt_Operation();

            switch (operation) {
                case "1":
                    checkingAccount();
                    break;
                case "2":
                    savingAccount();
                    break;
                case "3":
                    // Show Balance
                    ui.message_NextSection();
                    ui.message_CurrentBalance_AllAccounts(checkingAccount.getBalance() + savingAccount.getBalance());
                    break;
                case "quit":
                    quit = true;
                    ui.message_NextSection();
                    ui.message_QuitThankYou();
                    break;
                default:
                    ui.message_NextSection();
                    ui.message_InvalidInput();
            }
        }
    }

    // ******************************************* Checking Account Section
    public void checkingAccount() {
        boolean quit = false;
        String operation = "";
        double cash = 0;

        while (!quit) {
            ui.message_NextSection();
            ui.menu_CheckingAccount();

            operation = ui.prompt_Operation();

            switch (operation) {
                case "1":
                    // deposit
                    cash = ui.prompt_Deposit();
                    ui.message_NextSection();
                    if (checkingAccount.deposit(cash)) {
                        ui.message_Deposit_CheckingAccount_Done(cash);
                        ui.message_CurrentBalance_CheckingAccount(checkingAccount.getBalance());
                    } else {
                        ui.message_Deposit_MoreThan10K_Warning();
                        ui.message_CurrentBalance_CheckingAccount(checkingAccount.getBalance());
                    }
                    break;
                case "2":
                    // withdraw
                    cash = ui.prompt_Withdraw();
                    ui.message_NextSection();
                    if (checkingAccount.withdraw(cash)) {
                        ui.message_Withdraw_CheckingAccount_Done(cash);
                        ui.message_CurrentBalance_CheckingAccount(checkingAccount.getBalance());
                    } else {
                        ui.message_Withdraw_Overdraft_Warning();
                        ui.message_CurrentBalance_CheckingAccount(checkingAccount.getBalance());
                    }
                    break;
                case "3":
                    // Show Balance
                    ui.message_CurrentBalance_CheckingAccount(checkingAccount.getBalance());
                    break;
                case "quit":
                    quit = true;
                    ui.message_NextSection();
                    ui.message_BackToAccountsMenu();
                    break;
                default:
                    ui.message_NextSection();
                    ui.message_InvalidInput();
            }
        }
    }

    // ******************************************* Saving Account Section
    public void savingAccount() {
        boolean quit = false;
        String operation = "";
        double cash = 0;

        while (!quit) {
            ui.message_NextSection();
            ui.menu_SavingAccount();
            operation = ui.prompt_Operation();

            switch (operation) {
                case "1":
                    // deposit
                    cash = ui.prompt_Deposit();
                    ui.message_NextSection();
                    if (savingAccount.deposit(cash)) {
                        ui.message_Deposit_SavingAccount_Done(cash);
                        ui.message_CurrentBalance_SavingAccount(savingAccount.getBalance());
                    } else {
                        ui.message_Deposit_MoreThan10K_Warning();
                        ui.message_CurrentBalance_SavingAccount(savingAccount.getBalance());
                    }
                    break;
                case "2":
                    // withdraw
                    cash = ui.prompt_Withdraw();
                    ui.message_NextSection();
                    if (savingAccount.withdraw(cash)) {
                        ui.message_Withdraw_SavingAccount_Done(cash);
                        ui.message_CurrentBalance_SavingAccount(savingAccount.getBalance());
                    } else {
                        ui.message_Withdraw_Overdraft_Warning();
                        ui.message_CurrentBalance_SavingAccount(savingAccount.getBalance());
                    }
                    break;
                case "3":
                    // Show Balance
                    ui.message_CurrentBalance_CheckingAccount(savingAccount.getBalance());
                    break;
                case "quit":
                    quit = true;
                    ui.message_NextSection();
                    ui.message_BackToAccountsMenu();
                    break;
                default:
                    ui.message_NextSection();
                    ui.message_InvalidInput();
            }
        }
    }
}
