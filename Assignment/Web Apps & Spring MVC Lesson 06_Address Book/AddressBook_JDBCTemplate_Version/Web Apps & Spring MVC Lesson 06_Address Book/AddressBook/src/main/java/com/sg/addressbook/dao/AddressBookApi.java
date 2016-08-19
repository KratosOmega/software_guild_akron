/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.model.Address;
import java.util.List;

/**
 *
 * @author Kratos
 */
public interface AddressBookApi {
    // Address
    public Address addAddress(Address address);
    public void deleteAddress(int addressId);
    public void updateAddress(Address address);
    public Address getAddressById(int addressId);
    public List<Address> getAllAddress();
    public List<Address> getAddressBySearch(Address address);

//    // Zip Code
//    public void addZipCode(ZipCode zipCode);
//    public void deleteZipCode(int zipCodeId);
//    public void updateZipCode(ZipCode zipCode);
//    public ZipCode getZipCodeById(int zipCodeId);
//    public List<ZipCode> getAllZipCodes();
//    
//    // State
//    public void addState(State state);
//    public void deleteState(int stateId);
//    public void updateState(State state);
//    public State getStateById(int stateId);
//    public List<State> getAllStates();
//    
//    // Country
//    public void addCountry(Country country);
//    public void deleteCountry(int countryId);
//    public void updateCountry(Country country);
//    public Country getCountryById(int countryId);
//    public List<Country> getAllCountries();
}