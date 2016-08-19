/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookApi;
import com.sg.addressbook.model.Address;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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

    private AddressBookApi dao;

    @Inject
    public HomeController(AddressBookApi dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        return "search";
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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Address addAddress(@Valid @RequestBody Address address) {
        dao.addAddress(address);
        return address;
    }

//- Delete a address (DELETE)
//        - address/{id}
//        - Note: No RequestBody, no ResponseBody
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAddress(@PathVariable("id") String id) {
        dao.deleteAddress(Integer.parseInt(id));
    }

//- Update a address (PUT)
//        - address/{id}
//        - RequestBody: JSON object of address, with the id
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editAddress(@PathVariable("id") int id, @Valid @RequestBody Address address) {
        dao.updateAddress(address);

    }

//- Retrieve ALL Address (GET)
//        - /Contacts
//        -ResponseBody: Array of Contacts, in JSON form
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllAddresses() {
        return dao.getAllAddress();
    }
    
//- Search Address
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Address> searchAddress(@Valid @RequestBody Address address) {
        return dao.getAddressBySearch(address);
    }

}
