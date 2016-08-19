/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.dao;

import com.sg.contactlistmvc.model.Contact;
import java.util.List;
import java.util.Map;

/**
 *
 * @author softwareguild
 */
public interface ContactListDao {
    // add a contact
    public Contact addContact(Contact contact);
    // remove a contact
    public void removeContact(int contactId);
    // update a contact
    public void updateContact(Contact contact);
    // get all contacts
    public List<Contact> getAllContacts();
    // get a contact by Id
    public Contact getContactById(int contactId);
    // search for Contacts given certain criteria
    public List<Contact> searchContacts(Map<SearchTerm,String> criteria);
}
