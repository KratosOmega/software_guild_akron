/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_vendingmachine.ui;

import com.sg.xcd_vendingmachine.dto.Change;
import com.sg.xcd_vendingmachine.dto.Item;
import com.sg.xcd_vendingmachine.dto.VendingMachine;

/**
 *
 * @author Kratos
 */
public class VendingMachineUI {

    private ConsoleIO io;
    private GUIUtilities guiUtilities;

    public VendingMachineUI() {
        this.io = new ConsoleIO();
        this.guiUtilities = new GUIUtilities();
    }

    public void vmMenu(VendingMachine vm) {
        int index = 0;

        io.display("\n******************************************\n");
        io.display("************* Vending Machine ************\n");
        io.display("******************************************\n");

        for (Item item : vm.getVendingMachine()) {
            index++;

            if (item.getItemQty() != 0) {
                io.display("**  <" + index + "> ");
                io.displayFormated(item.getItemName(), "" + item.getItemPrice(), "" + item.getItemQty());
            }
        }

        io.display("******************************************\n");
    }

    public void message_NotEnoughMoney(String money, String difference) {
        io.display("\n------------------------------------------\n");
        io.display("Not enought money!!!\n");
        io.display("Current Balance : $ " + money + "\n");
        io.display("Still need      : $ " + difference + "\n");
    }

    public String promtGetMoney() {
        io.display("------------------------------------------\n\n");
        return io.promptForString("Please insert money to purchase:  ");
    }

    public String getSelection() {
        return io.promptForString("Make your selction:  ");
    }

    public void displayChange(Change change) {
        io.display("\n------------------------------------------\n");
        io.display(
                "Your change is returned: \n"
                + " * Quarters : " + change.getQuarters()
                + "\n * Dimes:   : " + change.getDimes()
                + "\n * Nickels  : " + change.getNickels()
                + "\n * Cents    : " + change.getCents()
                + "\n"
        );
    }

    public void killtheGodDamnNewLine() {
        io.killNewLine();
    }

    public void message_exitThankYou() {
        io.display("\n******************************************\n");
        io.display("**          Stock is updated!           **\n");
        io.display("**              Thank You!              **\n");
        io.display("******************************************\n");
    }

    public void message_ReUpdateVMWarning() {
        io.display("\n******************************************\n");
        io.display("**       Stock failed to updated!       **\n");
        io.display("**          Please re-update!           **\n");
        io.display("******************************************\n");
    }

    public void message_Error_InitializaitonFailed() {
        io.display("\n******************************************\n");
        io.display("**        Initialization Failed!        **\n");
        io.display("******************************************\n");
    }

    public void message_InvalidSelection() {
        io.display(guiUtilities.os_Quick_Notification_Builder("/", "Invalid Selection/Please select again."));
    }
}
