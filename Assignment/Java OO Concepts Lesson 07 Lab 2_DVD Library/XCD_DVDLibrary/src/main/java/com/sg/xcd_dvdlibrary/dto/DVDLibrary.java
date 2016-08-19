/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_dvdlibrary.dto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import com.sg.xcd_dvdlibrary.dao.DVDLibraryDAO;
import com.sg.xcd_dvdlibrary.ui.DVDLibraryUI;

/**
 *
 * @author Kratos
 */
public class DVDLibrary {

    private DVDLibraryDAO dao;
    private DVDLibraryUI ui;
    private ArrayList<DVD> dvdLibrary;

    public DVDLibrary() throws FileNotFoundException {
        dvdLibrary = new ArrayList<>();
        this.dao = new DVDLibraryDAO();
        this.ui = new DVDLibraryUI();

        Scanner initializationScanner = new Scanner(new BufferedReader(new FileReader("dvdLibarayInitialization.tsv")));
        while (initializationScanner.hasNext()) {
            String[] recordComponent = initializationScanner.nextLine().split("\t");
            dvdLibrary.add(new DVD(
                    recordComponent[0],
                    recordComponent[1],
                    recordComponent[2],
                    recordComponent[3],
                    recordComponent[4],
                    dao.decoding(recordComponent[5])));
        }
    }

    public ArrayList<DVD> getDvdLibrary() {
        return dvdLibrary;
    }

    public void setDvdLibrary(ArrayList<DVD> dvdLibrary) {
        this.dvdLibrary = dvdLibrary;
    }
}
