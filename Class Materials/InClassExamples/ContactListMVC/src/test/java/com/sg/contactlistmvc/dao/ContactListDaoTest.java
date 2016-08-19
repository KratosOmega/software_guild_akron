/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.dao;

import com.sg.contactlistmvc.model.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author softwareguild
 */
public class ContactListDaoTest {
    
    private ContactListDao dao;
    
    public ContactListDaoTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("contactListDao", ContactListDao.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteContact(){
        Contact nc = new Contact();
        nc.setFirstName("Xin");
        nc.setLastName("Li");
        nc.setCompany("TSG");
        nc.setEmail("xin.li@thesoftwareguild.com");
        nc.setPhone("1238675309");
        // add the contact to our mock database
        dao.addContact(nc);
        // get the contact
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb,nc);
        
        // test removing
        dao.removeContact(nc.getContactId());
        assertNull(dao.getContactById(nc.getContactId()));
    }
    
    @Test
    public void addUpdateContact(){
        Contact nc = new Contact();
        nc.setFirstName("Brian");
        nc.setLastName("Brossmann");
        nc.setCompany("TSG");
        nc.setEmail("brian.brossmann@thesoftwareguild.com");
        nc.setPhone("1238675309");
        
        dao.addContact(nc);
        
        nc.setPhone("9999999999");
        
        dao.updateContact(nc);
        
        Contact fromDb = dao.getContactById(nc.getContactId());
        assertEquals(fromDb, nc);
    }
    
    @Test
    public void getAllContacts(){
        addContacts();
        List<Contact> cList = dao.getAllContacts();
        assertEquals(cList.size(),4);
    }
    
    @Test
    public void searchContacts(){
        addContacts();
        
        // Create search criteria
        Map<SearchTerm,String> criteria = new HashMap<>();
        criteria.put(SearchTerm.COMPANY,"GK Rocks");
        
        List<Contact> cList = dao.searchContacts(criteria);
        assertEquals(2,cList.size());
        
        criteria.put(SearchTerm.COMPANY,"SL Rocks");
        
        cList = dao.searchContacts(criteria);
        assertEquals(2,cList.size());
        
        criteria.put(SearchTerm.COMPANY,"SD Rocks");
        
        cList = dao.searchContacts(criteria);
        assertEquals(0,cList.size());
        
    }
    
    private void addContacts(){
        Contact nc = new Contact();
        nc.setFirstName("Gordon");
        nc.setLastName("Kilarsky");
        nc.setCompany("GK Rocks");
        nc.setEmail("gk@us.info");
        nc.setPhone("1238675309");
        
        dao.addContact(nc);
        
        Contact nc2 = new Contact();
        nc2.setFirstName("Sean");
        nc2.setLastName("LeRoy");
        nc2.setCompany("SL Rocks");
        nc2.setEmail("sl@us.info");
        nc2.setPhone("1238675309");
        
        dao.addContact(nc2);
        
        Contact nc3 = new Contact();
        nc3.setFirstName("Shoshanna");
        nc3.setLastName("Barnett");
        nc3.setCompany("GK Rocks");
        nc3.setEmail("sb@us.info");
        nc3.setPhone("1238675309");
        
        dao.addContact(nc3);
        
        Contact nc4 = new Contact();
        nc4.setFirstName("Alex");
        nc4.setLastName("Bagrintsev");
        nc4.setCompany("SL Rocks");
        nc4.setEmail("ab@us.info");
        nc4.setPhone("1238675309");
        
        dao.addContact(nc4);
    }

}
