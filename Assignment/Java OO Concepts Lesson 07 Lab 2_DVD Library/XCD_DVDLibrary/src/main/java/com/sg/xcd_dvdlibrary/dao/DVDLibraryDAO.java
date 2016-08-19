/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_dvdlibrary.dao;

import com.sg.xcd_dvdlibrary.dto.DVD;
import com.sg.xcd_dvdlibrary.dto.DVDLibrary;
import com.sg.xcd_dvdlibrary.ui.DVDLibraryUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class DVDLibraryDAO {

    private DVDLibraryUI ui;

    public DVDLibraryDAO() {
        this.ui = new DVDLibraryUI();
    }

    // ********************************************************************** Add DVD
    public void addDVD(DVD dvd, DVDLibrary dvdLibrary) {
        dvdLibrary.getDvdLibrary().add(dvd);
    }

    // ********************************************************************** Add Notes
    public void addNotesToExistedDVD(int indexToAdd, String addtionalNote, DVDLibrary dvdLibrary) {
        dvdLibrary.getDvdLibrary().get(indexToAdd).getUserNote().add(addtionalNote);
    }

    // ********************************************************************** Edit Record
    public void editDVD(int indexToEdit, DVD dvd, DVDLibrary dvdLibrary) {
        dvdLibrary.getDvdLibrary().set(indexToEdit, dvd);
    }

    // ********************************************************************** Remove DVD
    public void removeDVD(int indexToRemove, DVDLibrary dvdLibrary) {
        dvdLibrary.getDvdLibrary().remove(indexToRemove);
    }

    // ********************************************************************** check empty library DVDs
    public boolean isLibraryEmpty(DVDLibrary dvdLibrary) {
        return dvdLibrary.getDvdLibrary().isEmpty();
    }

    // ********************************************************************** Search DVD by title
    public DVD searchByTitle(String title, DVDLibrary dvdLibrary) {
        for (DVD record : dvdLibrary.getDvdLibrary()) {
            if (record.getTitle().equals(title)) {
                return record;
            }
        }
        return null;
    }

    // ********************************************************************** Save Data to txt file
    public boolean exportData(String fileName, DVDLibrary dvdLibrary) {

        try {
            int noteIndex;
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (DVD record : dvdLibrary.getDvdLibrary()) {
                noteIndex = 0;

                writer.print(
                        record.getTitle() + "\t"
                        + record.getReleaseDate() + "\t"
                        + record.getMpaaRating() + "\t"
                        + record.getDirectorName() + "\t"
                        + record.getStudio() + "\t");

                for (String note : record.getUserNote()) {
                    noteIndex++;
                    if (noteIndex < record.getUserNote().size()) {
                        writer.print(note + "::");
                    } else {
                        writer.println(note);
                    }
                }
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // ********************************************************************** Import Data from txt file
    public boolean importData(String fileName, DVDLibrary dvdLibrary) {

        try {
            Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (fileScanner.hasNext()) {
                String[] record = fileScanner.nextLine().split("\t");
                ArrayList<String> notes = new ArrayList<>();

                for (String note : record[5].split("::")) {
                    notes.add(note);
                }

                dvdLibrary.getDvdLibrary().add(new DVD(
                        record[0],
                        record[1],
                        record[2],
                        record[3],
                        record[4],
                        notes));
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    // ********************************************************************** Utilities
    public int searchRecordIndex(String recordTitle, DVDLibrary dvdLibrary) {
        for (int i = 0; i < dvdLibrary.getDvdLibrary().size(); i++) {
            if (recordTitle.equals((dvdLibrary.getDvdLibrary().get(i).getTitle()))) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<String> decoding(String encodedString) {
        ArrayList<String> decodedList = new ArrayList<>();

        String[] dataList = encodedString.split("::");

        for (int i = 0; i < dataList.length; i++) {
            decodedList.add(dataList[i]);
        }
        return decodedList;
    }
}
