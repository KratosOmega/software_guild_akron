/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_vendingmachine.operation;

import com.sg.xcd_vendingmachine.dao.VendingMachineDAO;
import com.sg.xcd_vendingmachine.dto.VendingMachine;
import com.sg.xcd_vendingmachine.ui.VendingMachineUI;
import java.io.FileNotFoundException;

/**
 *
 * @author Kratos
 */
public class VendingMachineController {

    private VendingMachineDAO dao;
    private VendingMachineUI ui;
    private VendingMachine vm;
    private DataFormatConverter dataFormater;

    public VendingMachineController() {
        this.dao = new VendingMachineDAO();
        this.ui = new VendingMachineUI();
        this.dataFormater = new DataFormatConverter();
        try {
            this.vm = new VendingMachine();
        } catch (FileNotFoundException e) {
            ui.message_Error_InitializaitonFailed();
        }
    }

    public void run() {
        int selection;
        int money = 0;
        boolean quit = false;
        int difference = 0;
        int itemPrice = 0;

        while (!quit) {
            ui.vmMenu(vm);
            money = dataFormater.numberFormater_2Decimal_StringToInteger(ui.promtGetMoney());
            // ----!!!!
//            ui.killtheGodDamnNewLine();

            if (money >= 0) {
                selection = Integer.parseInt(ui.getSelection());

                // Check selection
                while (!dao.isSelectionValid(selection, vm)) {
                    ui.message_InvalidSelection();
                    selection = Integer.parseInt(ui.getSelection());
                }

                // After made correct selction
                // Check money inserted, compare with item price
                do {
                    itemPrice = dataFormater.numberFormater_2Decimal_StringToInteger(vm.getVendingMachine().get(selection - 1).priceToString());
                    difference = dao.isMoneyEnought(selection, money, itemPrice);
                    if (difference < 0) {
                        ui.message_NotEnoughMoney(dataFormater.numberFormater_2Decimal_IntegerToString(money), dataFormater.numberFormater_2Decimal_IntegerToString(-difference));
                        money += dataFormater.numberFormater_2Decimal_StringToInteger(ui.promtGetMoney());
                    }
                } while (difference < 0);

                // After money inserted > item price ==> purchase done
                // update vm item qty & move stock 0 item to the end of list
                dao.updateVMAfterSale(selection, vm);

                // Call the change method
                // displayChange(Change change);
                ui.displayChange(dao.makeChange(difference));

            } else {
                quit = dao.updateVM(vm);
                if (quit) {
                    ui.message_exitThankYou(); // let user know vm is updated and thank you
                } else {
                    ui.message_ReUpdateVMWarning(); // Ask user to enter -1 to re-update vm
                }
            }
        }
    }
}
