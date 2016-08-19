/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_addressbook.dto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class AddressBook {

    private ArrayList<Address> addressBook;

    public AddressBook() throws FileNotFoundException {
        this.addressBook = new ArrayList<>();

        Scanner initializationScanner = new Scanner(new BufferedReader(new FileReader("addressbookInitialization.tsv")));
        while (initializationScanner.hasNext()) {
            String[] recordComponent = initializationScanner.nextLine().split("\t");
            addressBook.add(new Address(
                    recordComponent[0], recordComponent[1],
                    recordComponent[2], recordComponent[3],
                    recordComponent[4], recordComponent[5],
                    recordComponent[6], recordComponent[7]));
        }
    }

    public ArrayList<Address> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(ArrayList<Address> addressBook) {
        this.addressBook = addressBook;
    }
    
    @Override
    public String toString(){
        String encodedString = "";
        for(Address address : addressBook){
            encodedString += address.toString();
        }
        return encodedString;
    }
}
