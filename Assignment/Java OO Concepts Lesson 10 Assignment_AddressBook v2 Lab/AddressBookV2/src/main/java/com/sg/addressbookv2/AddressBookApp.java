/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2;

import com.sg.addressbookv2.operation.AddressBookController;

/**
 *
 * @author Kratos
 */
public class AddressBookApp {
    public static void main(String[] args) {
        AddressBookController controller = new AddressBookController();
        controller.execute();
    }
}
