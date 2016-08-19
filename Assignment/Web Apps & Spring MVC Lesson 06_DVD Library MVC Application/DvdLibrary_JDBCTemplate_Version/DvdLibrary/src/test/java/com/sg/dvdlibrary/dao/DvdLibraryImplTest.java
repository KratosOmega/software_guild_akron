/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class DvdLibraryImplTest {

    private DvdLibraryApi dao;

    public DvdLibraryImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-spring-persistence.xml");
        dao = (DvdLibraryApi) ctx.getBean("DvdLibraryApi");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void add_select_edit_remove_Test() {
        Dvd dvd = new Dvd();
        dvd.setTitle("test");
        dvd.setReleaseDate("test");
        dvd.setMmpaRating("578");
        dvd.setDirector("test");
        dvd.setStudio("test");
        dvd.setNote("test");

        Dvd expectedAdd = dao.addDvd(dvd);
        Dvd actualAdd = dao.getDvdById(expectedAdd.getId());

        org.junit.Assert.assertEquals(expectedAdd.getId(), actualAdd.getId());
        org.junit.Assert.assertEquals(expectedAdd.getTitle(), actualAdd.getTitle());
        org.junit.Assert.assertEquals(expectedAdd.getReleaseDate(), actualAdd.getReleaseDate());
        org.junit.Assert.assertEquals(expectedAdd.getMmpaRating(), actualAdd.getMmpaRating());
        org.junit.Assert.assertEquals(expectedAdd.getDirector(), actualAdd.getDirector());
        org.junit.Assert.assertEquals(expectedAdd.getStudio(), actualAdd.getStudio());
        org.junit.Assert.assertEquals(expectedAdd.getNote(), actualAdd.getNote());
        
        Dvd editedDvd = dvd;
        editedDvd.setTitle("edited");
        editedDvd.setReleaseDate("edited");
        editedDvd.setMmpaRating("123");
        editedDvd.setDirector("edited");
        editedDvd.setStudio("edited");
        editedDvd.setNote("edited");
        
        dao.editDvd(editedDvd);
        Dvd expectedEdit = editedDvd;
        Dvd actualEdit = dao.getDvdById(expectedEdit.getId());
        
        org.junit.Assert.assertEquals(expectedEdit.getId(), actualEdit.getId());
        org.junit.Assert.assertEquals(expectedEdit.getTitle(), actualEdit.getTitle());
        org.junit.Assert.assertEquals(expectedEdit.getReleaseDate(), actualEdit.getReleaseDate());
        org.junit.Assert.assertEquals(expectedEdit.getMmpaRating(), actualEdit.getMmpaRating());
        org.junit.Assert.assertEquals(expectedEdit.getDirector(), actualEdit.getDirector());
        org.junit.Assert.assertEquals(expectedEdit.getStudio(), actualEdit.getStudio());
        org.junit.Assert.assertEquals(expectedEdit.getNote(), actualEdit.getNote());
        
        dao.deleteDvd(dvd.getId());
        org.junit.Assert.assertNull(dao.getDvdById(dvd.getId()));
    }

}
