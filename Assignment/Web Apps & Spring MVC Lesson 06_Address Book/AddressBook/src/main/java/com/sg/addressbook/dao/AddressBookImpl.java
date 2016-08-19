/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Kratos
 */
public class AddressBookImpl implements AddressBookApi {

    private List<Address> addressBook;
    private int id;


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose

    public AddressBookImpl() {
        this.addressBook = new ArrayList<>();
        this.id = 0;
    }

    // *********************************************************************************** v1 API
    @Override
    public void addRecord(Address record) {
        record.setId(id);
        addressBook.add(record);
        this.id++;
    }

    @Override
    public void removeRecord(int indexToRemove) {
        addressBook.get(indexToRemove).setIsArchived(true);
    }

    @Override
    public void editRecord(int indexToEdit, Address record) {
        addressBook.set(indexToEdit, record);
    }
    
    @Override
    public List<Address> searchRecord(Map<SearchTerm, String> criteria) {
        // Get all the search terms from the criteria map
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String houseNumberCriteria = criteria.get(SearchTerm.HOUSE_NUMBER);
        String streetCriteria = criteria.get(SearchTerm.STREET);
        String cityCriteria = criteria.get(SearchTerm.CITY);
        String stateCriteria = criteria.get(SearchTerm.STATE);
        String zipCodeCriteria = criteria.get(SearchTerm.ZIPCODE);
        String countryCriteria = criteria.get(SearchTerm.COUNTRY);

        // Declare our predicates
        Predicate<Address> firstNameMatches;
        Predicate<Address> lastNameMatches;
        Predicate<Address> houseNumberMatches;
        Predicate<Address> streetMatches;
        Predicate<Address> cityMatches;
        Predicate<Address> stateMatches;
        Predicate<Address> zipCodeMatches;
        Predicate<Address> countryMatches;

        // Placeholder predicate - always returns true and is used for
        // empty search terms
        Predicate<Address> truePredicate = (c) -> {
            return true;
        };

        //Assign values to predicates
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getFirstName().equals(firstNameCriteria);
        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getLastName().equals(lastNameCriteria);
        houseNumberMatches = (houseNumberCriteria == null || houseNumberCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getHouseNumber().equals(houseNumberCriteria);
        streetMatches = (streetCriteria == null || streetCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getStreet().equals(streetCriteria);
        cityMatches = (cityCriteria == null || cityCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getCity().equals(cityCriteria);
        stateMatches = (stateCriteria == null || stateCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getState().equals(stateCriteria);
        zipCodeMatches = (zipCodeCriteria == null || zipCodeCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getZipCode() == Integer.parseInt(zipCodeCriteria);
        countryMatches = (countryCriteria == null || countryCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getCountry().equals(countryCriteria);
        
        // return the list of addresses based on criteria
        // Meet AND
        return addressBook.stream()
                .filter(firstNameMatches
                        .and(lastNameMatches)
                        .and(houseNumberMatches)
                        .and(streetMatches)
                        .and(cityMatches)
                        .and(stateMatches)
                        .and(zipCodeMatches)
                        .and(countryMatches))
                .collect(Collectors.toList());
    }

    @Override
    public long countRecord() {
        return addressBook
                .stream()
                .count();
    }

    @Override
    public List<Address> listAll() {
        List<Address> activeAddressList = new ArrayList<>();
        
        for(Address address : this.addressBook){
            if(!address.isIsArchived()){
                activeAddressList.add(address);
            }
        }
        return activeAddressList;
    }

    @Override
    public boolean importRecord(String fileName) {
        return true;
    }

    @Override
    public boolean exportRecord(String fileName) {
            return true;
    }

    public List<Address> getAddressBook() {
        return addressBook;
    }
    
    // ------------------------------------------------------------ additional method for js
    public Address getAddressById(int id){
        return this.addressBook.get(id);
    }
}