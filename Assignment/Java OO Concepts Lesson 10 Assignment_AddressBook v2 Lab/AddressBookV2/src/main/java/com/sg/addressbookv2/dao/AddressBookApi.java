/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookv2.dao;

import com.sg.addressbookv2.dto.Address;
import java.util.List;

/**
 *
 * @author Kratos
 */
public interface AddressBookApi {

    // *************************************************** v2 API
    public List<Address> filterLastName(String lastName);

    public List<Address> filterCity(String city);

    public List<Address> filterState(String state);

    public List<Address> filterZipCode(String zipCode);

    // *************************************************** v2 API
    public void addRecord(Address record);
    
    public void removeRecord(int indexToRemove);
    
    public void editRecord(int indexToEdit, Address record);
    
    public long countRecord();
    
    public List<Address> listAll();
    
    public boolean importRecord(String fileName);
    
    public boolean exportRecord(String fileName);
}
