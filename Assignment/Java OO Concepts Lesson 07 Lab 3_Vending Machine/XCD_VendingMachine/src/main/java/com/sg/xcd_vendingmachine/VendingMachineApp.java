/*
 * Team XCD: 
 * - Xin
 * - Casey
 * - Darian
 */
package com.sg.xcd_vendingmachine;

import com.sg.xcd_vendingmachine.operation.VendingMachineController;

/**
 *
 * @author Kratos
 */
public class VendingMachineApp {

    public static void main(String[] args) {
        VendingMachineController controller = new VendingMachineController();
        controller.run();
    }
}
