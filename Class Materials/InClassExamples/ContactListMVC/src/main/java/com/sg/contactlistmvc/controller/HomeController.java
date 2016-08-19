/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.controller;

import com.sg.contactlistmvc.dao.ContactListDao;
import com.sg.contactlistmvc.model.Contact;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author softwareguild
 */
@Controller
public class HomeController {

    // Our DAO for the controller - will be wired up for dependency injection
    private ContactListDao dao;

    @Inject
    public HomeController(ContactListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

// - Retrieve a contact (GET)
//        - /contact/{contactId}
//        - Response Body: Contact in JSON  
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Contact getContact(@PathVariable("id") int id) {
        return dao.getContactById(id);
    }

//- Create a contact (POST)
//      - /contact
//       - RequestBody - JSON object of our Contact
    // - ResponseBody - JSON object of our Contact
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Contact createContact(@Valid @RequestBody Contact contact) {
        dao.addContact(contact);
        return contact;
    }

//- Delete a contact (DELETE)
//        - contact/{contactId}
//        - Note: No RequestBody, no ResponseBody
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") int id) {
        dao.removeContact(id);
    }

//- Update a contact (PUT)
//        - contact/{contactId}
//        - RequestBody: JSON object of our Contact, with the contactId
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putContact(@PathVariable("id") int id, @Valid @RequestBody Contact contact) {
        contact.setContactId(id);
        dao.updateContact(contact);
    }
    
//- Retrieve ALL contacts (GET)
//        - /Contacts
//        -ResponseBody: Array of Contacts, in JSON form
    @RequestMapping(value="/contacts", method=RequestMethod.GET)
    @ResponseBody public List<Contact> getAllContacts(){
        return dao.getAllContacts();
    }
    
}
