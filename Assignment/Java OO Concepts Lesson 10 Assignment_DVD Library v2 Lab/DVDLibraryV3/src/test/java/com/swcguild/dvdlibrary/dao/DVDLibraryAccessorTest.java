/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kratos
 */
public class DVDLibraryAccessorTest {

    private ApplicationContext context;
    private DvdLibraryDao dVDLibraryAccessor;
    private Dvd dvd;

    @Before
    public void setUp() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dVDLibraryAccessor = (DvdLibraryDao) context.getBean("dvdLibraryDao");
        this.dvd = (Dvd) context.getBean("dvd");
    }

    @Test
    public void addTest() {
        // Arrange
        setUp();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("1231231");
        dvd.setDirector("123");
        dvd.setStudio("123");
        dvd.setNote("123");
        int expected = dVDLibraryAccessor.listAll().size() + 1;
        // Act
        dVDLibraryAccessor.add(dvd);
        int actual = dVDLibraryAccessor.listAll().size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest_1() {
        // Arrange
        setUp();
        dVDLibraryAccessor = new DVDLibraryAccessor();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("1231231");
        dvd.setDirector("123");
        dvd.setStudio("123");
        dvd.setNote("123");
        dVDLibraryAccessor.add(dvd);
        int expected = dVDLibraryAccessor.listAll().size();
        // Act
        dVDLibraryAccessor.remove(10);
        int actual = dVDLibraryAccessor.listAll().size();
        // Asset
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest_2() {
        // Arrange
        setUp();
        dVDLibraryAccessor = new DVDLibraryAccessor();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("1231231");
        dvd.setDirector("123");
        dvd.setStudio("123");
        dvd.setNote("123");
        dVDLibraryAccessor.add(dvd);
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("1231231");
        dvd.setDirector("123");
        dvd.setStudio("123");
        dvd.setNote("123");
        dVDLibraryAccessor.add(dvd);
        int expected = dVDLibraryAccessor.listAll().size() - 1;
        // Act
        dVDLibraryAccessor.remove(0);
        int actual = dVDLibraryAccessor.listAll().size();
        // Asset
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void listAllTest_1() {
        // Arrange
        setUp();
        dVDLibraryAccessor = new DVDLibraryAccessor();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("1231231");
        dvd.setDirector("123");
        dvd.setStudio("123");
        dvd.setNote("123");
        dVDLibraryAccessor.add(dvd);
        String expected = dVDLibraryAccessor.listAll().getClass().toString();
        // Act
        String actual = dVDLibraryAccessor.listAll().getClass().toString();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getById() {
        // Arrange
        setUp();
        int id = 0;
        dVDLibraryAccessor = new DVDLibraryAccessor();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("1231231");
        dvd.setDirector("123");
        dvd.setStudio("123");
        dvd.setNote("123");
        dVDLibraryAccessor.add(dvd);
        Dvd expected = dvd;
        // Act
        Dvd actual = dVDLibraryAccessor.getById(id);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void getByTitleTest() {
        // Arrange
        setUp();
        String title = "test";
        dVDLibraryAccessor = new DVDLibraryAccessor();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Kratos");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("Kratos");
        dvd.setDirector("Kratos");
        dvd.setStudio("Kratos");
        dvd.setNote("Kratos");
        dVDLibraryAccessor.add(dvd);

        dvd = new Dvd();
        dvd.setId(1);
        dvd.setTitle("test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("test");
        dvd.setDirector("test");
        dvd.setStudio("test");
        dvd.setNote("test");
        dVDLibraryAccessor.add(dvd);

        Dvd expected = dvd;
        // Act
        List<Dvd> actual = dVDLibraryAccessor.getByTitle(title);
        // Assert
        org.junit.Assert.assertEquals(expected.getId(), actual.get(0).getId());
        org.junit.Assert.assertEquals(expected.getTitle(), actual.get(0).getTitle());
        org.junit.Assert.assertEquals(expected.getReleaseDate(), actual.get(0).getReleaseDate());
        org.junit.Assert.assertEquals(expected.getMpaaRating(), actual.get(0).getMpaaRating());
        org.junit.Assert.assertEquals(expected.getDirector(), actual.get(0).getDirector());
        org.junit.Assert.assertEquals(expected.getStudio(), actual.get(0).getStudio());
        org.junit.Assert.assertEquals(expected.getNote(), actual.get(0).getNote());
    }

    @Test
    public void getByRatingTest() {
        // Arrange
        setUp();
        String rating = "XXXXXX";
        dVDLibraryAccessor = new DVDLibraryAccessor();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Kratos");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("XXXXXX");
        dvd.setDirector("Kratos");
        dvd.setStudio("Kratos");
        dvd.setNote("Kratos");
        dVDLibraryAccessor.add(dvd);
        Dvd expected = dvd;

        dvd = new Dvd();
        dvd.setId(1);
        dvd.setTitle("test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("OOOOO");
        dvd.setDirector("test");
        dvd.setStudio("test");
        dvd.setNote("test");
        dVDLibraryAccessor.add(dvd);

        // Act
        List<Dvd> actual = dVDLibraryAccessor.getByRating(rating);
        // Assert
        org.junit.Assert.assertEquals(expected.getId(), actual.get(0).getId());
        org.junit.Assert.assertEquals(expected.getTitle(), actual.get(0).getTitle());
        org.junit.Assert.assertEquals(expected.getReleaseDate(), actual.get(0).getReleaseDate());
        org.junit.Assert.assertEquals(expected.getMpaaRating(), actual.get(0).getMpaaRating());
        org.junit.Assert.assertEquals(expected.getDirector(), actual.get(0).getDirector());
        org.junit.Assert.assertEquals(expected.getStudio(), actual.get(0).getStudio());
        org.junit.Assert.assertEquals(expected.getNote(), actual.get(0).getNote());
    }

    @Test
    public void getByStudioTest() {
        // Arrange
        setUp();
        String studio = "test";
        dVDLibraryAccessor = new DVDLibraryAccessor();
        dvd = new Dvd();
        dvd.setId(0);
        dvd.setTitle("Kratos");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("Kratos");
        dvd.setDirector("Kratos");
        dvd.setStudio("Kratos");
        dvd.setNote("Kratos");
        dVDLibraryAccessor.add(dvd);

        dvd = new Dvd();
        dvd.setId(1);
        dvd.setTitle("test");
        dvd.setReleaseDate(123);
        dvd.setMpaaRating("test");
        dvd.setDirector("test");
        dvd.setStudio("test");
        dvd.setNote("test");
        dVDLibraryAccessor.add(dvd);

        Dvd expected = dvd;
        // Act
        List<Dvd> actual = dVDLibraryAccessor.getByStudio(studio);
        // Assert
        org.junit.Assert.assertEquals(expected.getId(), actual.get(0).getId());
        org.junit.Assert.assertEquals(expected.getTitle(), actual.get(0).getTitle());
        org.junit.Assert.assertEquals(expected.getReleaseDate(), actual.get(0).getReleaseDate());
        org.junit.Assert.assertEquals(expected.getMpaaRating(), actual.get(0).getMpaaRating());
        org.junit.Assert.assertEquals(expected.getDirector(), actual.get(0).getDirector());
        org.junit.Assert.assertEquals(expected.getStudio(), actual.get(0).getStudio());
        org.junit.Assert.assertEquals(expected.getNote(), actual.get(0).getNote());
    }
}
