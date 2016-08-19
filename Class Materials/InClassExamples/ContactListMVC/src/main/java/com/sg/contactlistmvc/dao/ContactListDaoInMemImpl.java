/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.dao;

import com.sg.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author softwareguild
 */
public class ContactListDaoInMemImpl implements ContactListDao {

    // simulated database
    private Map<Integer, Contact> contactMap = new HashMap<>();

    // keep track of the contactID
    private static int contactIdCounter = 0;

    @Override
    public Contact addContact(Contact contact) {
        // set the contact Id that is used behind the scenes
        contact.setContactId(contactIdCounter);
        // increment the id counter
        // Note: This will get handled by a database automatically
        // We need to simulate this in our in-memory implementation
        contactIdCounter++;
        // add the passed-in contact to our database
        contactMap.put(contact.getContactId(), contact);
        // return the contact that was added
        return contact;
    }

    @Override
    public void removeContact(int contactId) {
        // remove this contact from our database
        contactMap.remove(contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        Collection<Contact> c = contactMap.values();
        return new ArrayList(c);
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactMap.get(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        // Get all the search terms from the criteria map
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String companyCriteria = criteria.get(SearchTerm.COMPANY);
        String phoneCriteria = criteria.get(SearchTerm.PHONE);
        String emailCriteria = criteria.get(SearchTerm.EMAIL);

        // Declare our predicates
        Predicate<Contact> firstNameMatches;
        Predicate<Contact> lastNameMatches;
        Predicate<Contact> companyMatches;
        Predicate<Contact> phoneMatches;
        Predicate<Contact> emailMatches;

        // Placeholder predicate - always returns true and is used for
        // empty search terms
        Predicate<Contact> truePredicate = (c) -> {
            return true;
        };

        //Assign values to predicates
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getFirstName().equals(firstNameCriteria);
        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getLastName().equals(lastNameCriteria);
        companyMatches = (companyCriteria == null || companyCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getCompany().equals(companyCriteria);
        phoneMatches = (phoneCriteria == null || phoneCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getPhone().equals(phoneCriteria);
        emailMatches = (emailCriteria == null || emailCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getLastName().equals(emailCriteria);
        
        // return the list of Contacts based on criteria
        // Meet AND
        return contactMap.values().stream()
                .filter(firstNameMatches
                        .and(lastNameMatches)
                        .and(companyMatches)
                        .and(phoneMatches)
                        .and(emailMatches))
                .collect(Collectors.toList());

    }
}