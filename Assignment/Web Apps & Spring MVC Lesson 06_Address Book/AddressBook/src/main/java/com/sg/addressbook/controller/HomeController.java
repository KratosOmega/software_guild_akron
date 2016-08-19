/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookImpl;
import com.sg.addressbook.dao.SearchTerm;
import com.sg.addressbook.dto.Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Kratos
 */
@Controller
public class HomeController {

    private AddressBookImpl dao;

    @Inject
    public HomeController(AddressBookImpl dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        if (dao.listAll().isEmpty()) {
            loadTestData();
        }
        return "home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        return "search";
    }

    public void loadTestData() {
        Address address = new Address();

        address.setFirstName("Kratos");
        address.setLastName("Omega");
        address.setHouseNumber("123");
        address.setStreet("God of War St.");
        address.setCity("GW");
        address.setState("Sparta");
        address.setZipCode(99999);
        address.setCountry("Greek");

        dao.addRecord(address);

        address = new Address();
        address.setFirstName("Xin");
        address.setLastName("Li");
        address.setHouseNumber("712");
        address.setStreet("Clifftop Dr.");
        address.setCity("Gaithersburg");
        address.setState("MD");
        address.setZipCode(20878);
        address.setCountry("USA");

        dao.addRecord(address);

        address = new Address();
        address.setFirstName("Clarice");
        address.setLastName("Li");
        address.setHouseNumber("4706");
        address.setStreet("Blackfoot Rd.");
        address.setCity("College Park");
        address.setState("MD");
        address.setZipCode(20740);
        address.setCountry("USA");

        dao.addRecord(address);
    }

// - Retrieve a address (GET)
//        - /address/{contactId}
//        - Response Body: Address in JSON  
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Address getAddress(@PathVariable("id") int id) {
        return dao.getAddressById(id);
    }

//- Add (create) a Address (POST)
//      - /address
//       - RequestBody - JSON object of Address
    // - ResponseBody - JSON object of Address
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Address addAddress(@Valid @RequestBody Address address) {
        dao.addRecord(address);
        return address;
    }

//- Delete a address (DELETE)
//        - address/{id}
//        - Note: No RequestBody, no ResponseBody
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAddress(@PathVariable("id") int id) {
        dao.removeRecord(id);
    }

//- Update a address (PUT)
//        - address/{id}
//        - RequestBody: JSON object of address, with the id
    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editAddress(@PathVariable("id") int id, @Valid @RequestBody Address address) {
        address.setId(id);
        dao.editRecord(id, address);

    }

//- Retrieve ALL Address (GET)
//        - /Contacts
//        -ResponseBody: Array of Contacts, in JSON form
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllAddresses() {
        return dao.listAll();
    }
    
    
    // - search Contacts
    // - taking in the search criteria
    // - search/contacts, POST
    @RequestMapping(value="/address/search",method=RequestMethod.POST)
    @ResponseBody
    public List<Address> search(@RequestBody Map<String, String> searchMap) {
        Map<SearchTerm, String> criteriaMap = new HashMap<>();

        String currentTerm = searchMap.get("firstName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.FIRST_NAME, currentTerm);
        }

        currentTerm = searchMap.get("lastName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.LAST_NAME, currentTerm);
        }
        
        currentTerm = searchMap.get("houseNumber");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.HOUSE_NUMBER, currentTerm);
        }
        
        currentTerm = searchMap.get("street");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STREET, currentTerm);
        }
        
        currentTerm = searchMap.get("city");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.CITY, currentTerm);
        }
        
        currentTerm = searchMap.get("state");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STATE, currentTerm);
        }
        
        currentTerm = searchMap.get("zipCode");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.ZIPCODE, currentTerm);
        }
        
        currentTerm = searchMap.get("country");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.COUNTRY, currentTerm);
        }
        

        return dao.searchRecord(criteriaMap);
    }

}
