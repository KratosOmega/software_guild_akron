/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.controller;

import com.sg.contactlistmvc.dao.ContactListDao;
import com.sg.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author softwareguild
 */
@Controller
public class HomeControllerNoAjax {

    // We need a DAO
    private ContactListDao dao;

    // Annotation-driven constructor injection
    @Inject
    public HomeControllerNoAjax(ContactListDao dao) {
        this.dao = dao;
    }

    // This method takes a Model object as a parameter.  This is
    // because this method gets a list of all the Contact objects from the DAO.
    // We need to place this list on the Model so that Spring MVC can pass the list to the view
    // We'll use JSTL to iterate through the list and print the Contact information.
    @RequestMapping(value = "displayContactListNoAjax", method = RequestMethod.GET)
    public String displayContactListNoAjax(Model model) {
        // Get all contacts
        List<Contact> contactList = dao.getAllContacts();
        // add the contactList to our model to be used by the view
        model.addAttribute("contactList", contactList);
        // return the view
        return "displayContactListNoAjax";
    }

    @RequestMapping(value = "displayNewContactFormNoAjax", method = RequestMethod.GET)
    public String displayNewContactFormNoAjax() {
        return "newContactFormNoAjax";
    }

    @RequestMapping(value = "displayNewContactFormNoAjaxValidation", method = RequestMethod.GET)
    public String displayNewContactFormNoAjaxValidation(Model model) {
        model.addAttribute("contact", new Contact());
        return "newContactFormNoAjaxValidation";
    }
    
    @RequestMapping(value = "/addNewContactNoAjax", method = RequestMethod.POST)
    public String addNewContactNoAjax(HttpServletRequest req) {
        // Get all the data from the request
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String company = req.getParameter("company");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        // Create a new Contact and set its fields
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setCompany(company);
        contact.setEmail(email);
        contact.setPhone(phone);

        // Add the contact to the DAO
        dao.addContact(contact);

        // redirect to displayContactListNoAjax
        // Now we should see our new contact in the contact list
        // We redirect so that we use the controller endpoint
        return "redirect:displayContactListNoAjax";
    }

    @RequestMapping(value = "/addNewContactNoAjaxValidation", method = RequestMethod.POST)
    public String addNewContactNoAjaxValidation(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "newContactFormNoAjaxValidation";
        }
        // Add the contact to the DAO
        dao.addContact(contact);

        // redirect to displayContactListNoAjax
        // Now we should see our new contact in the contact list
        // We redirect so that we use the controller endpoint
        return "redirect:displayContactListNoAjax";
    }

    @RequestMapping(value = "/deleteContactNoAjax", method = RequestMethod.GET)
    public String deleteContactNoAjax(HttpServletRequest req) {
        // Get the contact Id
        int contactId = Integer.parseInt(req.getParameter("contactId"));
        // Have the DAO remove the contact
        dao.removeContact(contactId);

        // Refresh our contact list by redirecting to the controller endpoint
        return "redirect:displayContactListNoAjax";
    }

    @RequestMapping(value = "/displayEditContactFormNoAjax", method = RequestMethod.GET)
    public String displayEditContactFormNoAjax(HttpServletRequest req, Model model) {
        // get the id
        int contactId = Integer.parseInt(req.getParameter("contactId"));
        // get the contact from our DAO
        Contact contact = dao.getContactById(contactId);
        // put the contact on the model
        model.addAttribute("contact", contact);
        // show the Edit form
        return "editContactFormNoAjax";
    }

    @RequestMapping(value = "/editContactNoAjax", method = RequestMethod.POST)
    public String editContactNoAjax(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
        // If there are any validation errors
        // Display the Edit form again
        if (result.hasErrors()) {
            return "editContactFormNoAjax";
        }

        dao.updateContact(contact);
        return "redirect:displayContactListNoAjax";
    }

    // Purely for testing purposes
    @RequestMapping(value = "loadContacts", method = RequestMethod.POST)
    public String loadContacts() {
        Contact c2 = new Contact();
        c2.setFirstName("Eric");
        c2.setLastName("Ward");
        c2.setCompany("The Software Guild");
        c2.setEmail("eward@thesoftwareguild.com");

        dao.addContact(c2);

        Contact c1 = new Contact();
        c1.setFirstName("Eric");
        c1.setLastName("Wise");
        c1.setCompany("The Software Guild");
        c1.setEmail("ewise@thesoftwareguild.com");

        dao.addContact(c1);

        Contact c3 = new Contact();
        c3.setFirstName("Sarah");
        c3.setLastName("Dutkiewicz");
        c3.setCompany("The Software Guild");
        c3.setEmail("sdutkiewicz@thesoftwareguild.com");

        dao.addContact(c3);
        return "redirect:displayContactListNoAjax";
    }

}
