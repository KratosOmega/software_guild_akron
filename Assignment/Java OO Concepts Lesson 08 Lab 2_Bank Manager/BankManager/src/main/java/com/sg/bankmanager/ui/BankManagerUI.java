/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager.ui;

import com.sg.bankmanager.dto.CheckingAccount;
import com.sg.bankmanager.dto.SavingAccount;

/**
 *
 * @author Kratos
 */
public class BankManagerUI {

    private ConsoleIO io;
    private GUIUtilities gui;

    public BankManagerUI() {
        this.io = new ConsoleIO();
        this.gui = new GUIUtilities();
    }

    // ***************************************************** menu
    public void menu_Accounts() {
        io.display(gui.os_Quick_Menu_Builder("Bank Account Manager", "/", " /1. Manage Checking Account/2. Manage Saving Account/3. All Account Total Balance") + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"quit\" to Quit>") + "\n");
    }

    public void menu_CheckingAccount() {
        io.display(gui.os_Menu_Builder(50, 3, "X", 2, "/", "Checking Account", "1. Deposit Money to Checking Account/2. Withdraw Money from Checking Account/3. Current Balance")+"\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"quit\" to Quit>") + "\n");
    }

    public void menu_SavingAccount() {
        io.display(gui.os_Menu_Builder(50, 3, "O", 2, "/", "Saving Account", "1. Deposit Money to Saving Account/2. Withdraw Money from Saving Account/3. Current Balance")+"\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"quit\" to Quit>") + "\n");
    }

    public void splitter() {
        io.display(gui.os_Component_Builder("$", 50));
    }

    // ***************************************************** Prompt
    public String prompt_PassWord() {
        return io.promptForString("Please enter password: ");
    }

    public double prompt_Deposit() {
        return io.promptForDouble("Please insert money to deposit... ");
    }

    public double prompt_Withdraw() {
        return io.promptForDouble("Please enter amount to withdraw... ");
    }

    public String prompt_Operation() {
        return io.promptForString("Please choose your operation: ");
    }

    // ***************************************************** Notification
    public void message_Deposit_CheckingAccount_Done(double cash) {
        io.display(gui.os_Quick_Notification_Builder("/", "$ " + cash + " is deposited/to your checking account"));
    }

    public void message_Deposit_SavingAccount_Done(double cash) {
        io.display(gui.os_Quick_Notification_Builder("/", "$ " + cash + " is deposited/to your saving account"));
    }

    public void message_Withdraw_SavingAccount_Done(double cash) {
        io.display(gui.os_Quick_Notification_Builder("/", "$ " + cash + " is withdrawn/from your saving account!"));
    }

    public void message_Withdraw_CheckingAccount_Done(double cash) {
        io.display(gui.os_Quick_Notification_Builder("/", "$ " + cash + " is withdrawn/from your checking account!"));
    }

    public void message_CurrentBalance_CheckingAccount(double balance) {
        io.display(gui.os_Quick_Notification_Builder("/", ">>> Checking Account <<</Current Balance: " + balance));
    }

    public void message_CurrentBalance_SavingAccount(double balance) {
        io.display(gui.os_Quick_Notification_Builder("/", ">>> Saving Account <<</Current Balance: " + balance));
    }

    public void message_CurrentBalance_AllAccounts(double balance){
        io.display(gui.os_Quick_Notification_Builder("/", ">>> All Accounts <<</Current Balance: " + balance));
    }
    
    public void message_Deposit_MoreThan10K_Warning() {
        io.display(gui.os_Quick_Notification_Builder("/", "For your account safety/Our bank manger will clear the large deposit/ And it can not be withdrawn temporarily ."));
    }

    public void message_Withdraw_Overdraft_Warning() {
        io.display(gui.os_Quick_Notification_Builder("/", "Due to our overdraft policy"
                + "/You either reached the overdraft limitation"
                + "/Or you had made your overdraft today"
                + "/Thus, you can not withdraw money temporarily."));
    }

    public void message_InvalidInput() {
        io.display(gui.os_Quick_Notification_Builder("/", "Invalid Selection!/Please select again..."));
    }

    public void message_BackToAccountsMenu() {
        io.display(gui.os_Quick_Notification_Builder(";", "Quiting current account...;Nagivate you to the main menu."));
    }
    
    public void message_Wrong_PassWord() {
        io.display(gui.os_Quick_Notification_Builder("/", "Wrong Password, access denied./Please enter you password again!"));
    }

    public void message_QuitThankYou() {
        io.display(gui.os_Quick_Notification_Builder("/", "Thank you for using our system!"));
    }

    public void message_SafetyProtction() {
        io.display(gui.os_Quick_Notification_Builder("/", "You tried 3 times of wrong Password/"
                + "In order to secure your Accounts/"
                + "You will be forced to quit system."));
    }
    
    public void message_NextSection(){
        io.display(gui.os_Quick_Notification_Builder(";", "|  |;|  |;_|  |_;\\    /;\\  /;\\/;"));
    }
    // ***************************************************** 
}
