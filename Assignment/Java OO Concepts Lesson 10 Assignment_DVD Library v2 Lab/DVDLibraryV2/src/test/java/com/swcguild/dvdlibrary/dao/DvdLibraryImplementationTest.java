/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.List;
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
public class DvdLibraryImplementationTest {

    private ApplicationContext context;
    private DvdLibraryApi implementation;

    @Before
    public void setUp() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.implementation = (DvdLibraryApi) context.getBean("dvdLibraryApiImplementation");
    }

    @Test
    public void filterNYearsTest_1() {
        // Arrange
        int years = 5;
        int expected = 3;
        // Act
        int actual = implementation.filterNYears(years).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterNYearsTest_2() {
        // Arrange
        int years = 1;
        int expected = 0;
        // Act
        int actual = implementation.filterNYears(years).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterRatingTest_1() {
        // Arrange
        String mpaa = "PG-13";
        int expected = 2;
        // Act
        int actual = implementation.filterRating(mpaa).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test

    public void filterRatingTest_2() {
        // Arrange
        String mpaa = "PG-xxx";
        int expected = 0;
        // Act
        int actual = implementation.filterRating(mpaa).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterDirectorTest_1() {
        // Arrange
        String director = "DirectorA";
        int expected = 7;
        // Act
        int actual = implementation.filterDirector(director).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void filterDirectorTest_2() {
        // Arrange
        String director = "DirectorBlablabla";
        int expected = 0;
        // Act
        int actual = implementation.filterDirector(director).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void fitlerStudioTest_1() {
        // Arrange
        String studio = "StudioA";
        int expected = 6;
        // Act
        int actual = implementation.fitlerStudio(studio).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void fitlerStudioTest_2() {
        // Arrange
        String studio = "StudioBlablabla";
        int expected = 0;
        // Act
        int actual = implementation.fitlerStudio(studio).size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void fitlerAvgAgeTest_1() {
        // Arrange
        double expected = 8.7;
        // Act
        double actual = implementation.fitlerAvgAge();
        // Assert
        org.junit.Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void fitlerNewestMovieTest_1() {
        // Arrange
        Dvd expected = new Dvd();
        expected.setId(9);
        expected.setTitle("Test9");
        expected.setReleaseDate(2015);
        expected.setMpaaRating("PG-11");
        expected.setDirector("DirectorA");
        expected.setStudio("StudioD");
        expected.setNote(null);
        // Act
        Dvd actual = implementation.fitlerNewestMovie();
        // Assert
        org.junit.Assert.assertEquals(expected.getId(), actual.getId());
        org.junit.Assert.assertEquals(expected.getTitle(), actual.getTitle());
        org.junit.Assert.assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
        org.junit.Assert.assertEquals(expected.getMpaaRating(), actual.getMpaaRating());
        org.junit.Assert.assertEquals(expected.getDirector(), actual.getDirector());
        org.junit.Assert.assertEquals(expected.getStudio(), actual.getStudio());
        org.junit.Assert.assertEquals(expected.getNote(), actual.getNote());
    }

    @Test
    public void fitlerOldestMovieTest_1() {
        // Arrange
        Dvd expected = new Dvd();
        expected.setId(0);
        expected.setTitle("Test0");
        expected.setReleaseDate(1991);
        expected.setMpaaRating("PG-13");
        expected.setDirector("DirectorA");
        expected.setStudio("StudioA");
        expected.setNote("Note1");
        // Act
        Dvd actual = implementation.fitlerOldestMovie();
        // Assert
        org.junit.Assert.assertEquals(expected.getId(), actual.getId());
        org.junit.Assert.assertEquals(expected.getTitle(), actual.getTitle());
        org.junit.Assert.assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
        org.junit.Assert.assertEquals(expected.getMpaaRating(), actual.getMpaaRating());
        org.junit.Assert.assertEquals(expected.getDirector(), actual.getDirector());
        org.junit.Assert.assertEquals(expected.getStudio(), actual.getStudio());
        org.junit.Assert.assertEquals(expected.getNote(), actual.getNote());
    }

    @Test
    public void calculateAvgNotesTest_1() {
        // Arrange
        double expected = 0.6;
        // Act
        double actual = implementation.calculateAvgNotes();
        // Assert
        org.junit.Assert.assertEquals(expected, actual, 0.0);
    }
}
