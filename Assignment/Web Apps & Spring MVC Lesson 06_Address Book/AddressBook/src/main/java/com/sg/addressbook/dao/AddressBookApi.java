/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kratos
 */
public interface AddressBookApi {



    public void addRecord(Address record);
    
    public void removeRecord(int indexToRemove);
    
    public void editRecord(int indexToEdit, Address record);
    
    public List<Address> searchRecord(Map<SearchTerm, String> criteria);
    
    public long countRecord();
    
    public List<Address> listAll();
    
    public boolean importRecord(String fileName);
    
    public boolean exportRecord(String fileName);
}