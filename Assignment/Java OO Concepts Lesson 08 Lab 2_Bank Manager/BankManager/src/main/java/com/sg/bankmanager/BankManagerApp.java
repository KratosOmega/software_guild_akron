/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager;

import com.sg.bankmanager.operation.BankManagerController;

/**
 *
 * @author Kratos
 */
public class BankManagerApp {

    public static void main(String[] args) {
        BankManagerController controller = new BankManagerController();
        controller.run();
    }

}
