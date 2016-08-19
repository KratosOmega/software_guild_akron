/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_dvdlibrary.dao;

import com.sg.xcd_dvdlibrary.dto.DVD;
import com.sg.xcd_dvdlibrary.dto.DVDLibrary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kratos
 */
public class DVDLibraryDAOTest {

    DVDLibraryDAO dao;

    // ************************************************************************************* addDVD()
    @Test
    public void addDVDTest_1() throws FileNotFoundException {
        // Arrange
        DVD dvd = new DVD("Test", "Test", "Test", "Test", "Test", new ArrayList<>());
        DVDLibrary dvdLibrary = new DVDLibrary();
        int expected = 4;
        // Act
        dao = new DVDLibraryDAO();
        dao.addDVD(dvd, dvdLibrary);
        int actual = dvdLibrary.getDvdLibrary().size();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* addNotesToExistedDVD()
    @Test
    public void addNotesToExistedDVDTest_1() throws FileNotFoundException {
        // Arrange
        int indexToAdd = 0;
        String additonalNote = "Additional Note";
        DVDLibrary dvdLibrary = new DVDLibrary();
        int expected_NoteCount = dvdLibrary.getDvdLibrary().get(indexToAdd).getUserNote().size() + 1;
        String expected_NewNote = "Additional Note";
        // Act
        dao = new DVDLibraryDAO();
        dao.addNotesToExistedDVD(indexToAdd, additonalNote, dvdLibrary);
        int actual_NoteCount = dvdLibrary.getDvdLibrary().get(indexToAdd).getUserNote().size();
        int lastNoteIndex = dvdLibrary.getDvdLibrary().get(indexToAdd).getUserNote().size() - 1;
        String actual_NewNote = dvdLibrary.getDvdLibrary().get(indexToAdd).getUserNote().get(lastNoteIndex);
        // Assert
        org.junit.Assert.assertEquals(expected_NewNote, actual_NewNote);
        org.junit.Assert.assertEquals(expected_NoteCount, actual_NoteCount);
    }

    // ************************************************************************************* editDVD()
    @Test
    public void editDVDTest_1() throws FileNotFoundException {
        // Arrange
        int indexToEdit = 0;
        DVD dvd = new DVD("Test", "Test", "Test", "Test", "Test", new ArrayList<String>());
        DVDLibrary dvdLibrary = new DVDLibrary();
        String expected = new DVD("Test", "Test", "Test", "Test", "Test", new ArrayList<String>()).toString();
        // Act
        dao = new DVDLibraryDAO();
        dao.editDVD(indexToEdit, dvd, dvdLibrary);
        String actual = dvdLibrary.getDvdLibrary().get(indexToEdit).toString();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* removeDVD()
    @Test
    public void removeDVDTest_1() throws FileNotFoundException {
        // Arrange
        int indexToRemove = 0;
        DVDLibrary dvdLibrary = new DVDLibrary();
        String expected = dvdLibrary.getDvdLibrary().get(indexToRemove + 1).toString();
        // Act
        dao = new DVDLibraryDAO();
        dao.removeDVD(indexToRemove, dvdLibrary);
        String actual = dvdLibrary.getDvdLibrary().get(indexToRemove).toString();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* isLibraryEmpty()
    @Test
    public void isLibraryEmptyTest_1() throws FileNotFoundException {
        // Arrange
        DVDLibrary dvdLibrary = new DVDLibrary();
        boolean expected = false;
        // Act
        dao = new DVDLibraryDAO();
        boolean actual = dao.isLibraryEmpty(dvdLibrary);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* searchByTitle()
    @Test
    public void searchByTitleTest_1() throws FileNotFoundException {
        // Arrange
        String title = "Kratos";
        DVDLibrary dvdlibrary = new DVDLibrary();
        String expected = dvdlibrary.getDvdLibrary().get(1).toString();
        // Act
        dao = new DVDLibraryDAO();
        String actual = dao.searchByTitle(title, dvdlibrary).toString();
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* exportData()
    @Test
    public void exportDataTest_1() throws FileNotFoundException {
        // Arrange
        String fileName = "export_test.txt";
        DVDLibrary dvdLibrary = new DVDLibrary();
        String expected = "";
        ArrayList<DVD> dvds = dvdLibrary.getDvdLibrary();
        for (DVD dvd : dvds) {
            expected += dvd.toString();
        }
        // Act
        dao = new DVDLibraryDAO();
        dao.exportData(fileName, dvdLibrary);
        String actual = "";
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        while (fileScanner.hasNext()) {
            actual += fileScanner.nextLine();
        }
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* importData()
    @Test
    public void importDataTest_1() throws FileNotFoundException {
        // Arrange
        String fileName = "import_test.txt";
        DVDLibrary dvdLibrary = new DVDLibrary();
        String expected = "";
        ArrayList<DVD> expectedDVDs = dvdLibrary.getDvdLibrary();
        for (DVD dvd : expectedDVDs) {
            expected += dvd.toString();
        }
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        while (fileScanner.hasNext()) {
            expected += fileScanner.nextLine();
        }
        // Act
        dao = new DVDLibraryDAO();
        dao.importData(fileName, dvdLibrary);
        String actual = "";
        ArrayList<DVD> actualDVDs = dvdLibrary.getDvdLibrary();
        for (DVD dvd : actualDVDs) {
            actual += dvd.toString();
        }
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* searchRecordIndex()
    @Test
    public void searchRecordIndexTest_1() throws FileNotFoundException {
        // Arrange
        String recordTitle = "Kratos";
        DVDLibrary dvdLibrary = new DVDLibrary();
        int expected = 1;
        // Act
        dao = new DVDLibraryDAO();
        int actual = dao.searchRecordIndex(recordTitle, dvdLibrary);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchRecordIndexTest_2() throws FileNotFoundException {
        // Arrange
        String recordTitle = "Blablabla";
        DVDLibrary dvdLibrary = new DVDLibrary();
        int expected = -1;
        // Act
        dao = new DVDLibraryDAO();
        int actual = dao.searchRecordIndex(recordTitle, dvdLibrary);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************************************************* decoding() Test
    @Test
    public void decodingTest_1() {
        // Arrange
        String encodedString = "One::Two::Three";
        ArrayList<String> expected = new ArrayList<>();
        expected.add("One");
        expected.add("Two");
        expected.add("Three");
        // Act
        dao = new DVDLibraryDAO();
        ArrayList<String> actual = dao.decoding(encodedString);
        // Assert
        org.junit.Assert.assertEquals(expected.get(0), actual.get(0));
        org.junit.Assert.assertEquals(expected.get(1), actual.get(1));
        org.junit.Assert.assertEquals(expected.get(2), actual.get(2));
    }
}
