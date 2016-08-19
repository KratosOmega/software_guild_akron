/*
 * Team XCD: 
 * - Xin
 * - Casey
 * - Darian
 */
package com.sg.xcd_addressbook;

import com.sg.xcd_addressbook.operation.AddressBookController;


/**
 *
 * @author Kratos
 */
public class AddressBookApp {

    public static void main(String[] args) {
        AddressBookController controller = new AddressBookController();
        controller.run();
    }
}
