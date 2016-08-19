/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kratos
 */
public class DVDLibraryAccessor implements DvdLibraryDao {

    private ArrayList<Dvd> dvdLibrary;

    public DVDLibraryAccessor() {
        this.dvdLibrary = new ArrayList<>();
    }

    @Override
    public void add(Dvd dvd) {
        dvdLibrary.add(dvd);
    }

    @Override
    public void remove(int id) {
        boolean founded = false;
        Dvd dvdToRemove = new Dvd();

        for (Dvd dvd : dvdLibrary) {
            if (dvd.getId() == id) {
                dvdToRemove = dvd;
                founded = true;
            }
        }
        if (founded) {
            dvdLibrary.remove(dvdToRemove);
        }
    }

    @Override
    public List<Dvd> listAll() {
        return dvdLibrary;
    }

    @Override
    public Dvd getById(int id) {
        for (Dvd dvd : dvdLibrary) {
            if (dvd.getId() == id) {
                return dvd;
            }
        }
        return null;
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        ArrayList<Dvd> filteredDvds = new ArrayList<>();

        for (Dvd dvd : dvdLibrary) {
            if (dvd.getTitle().equals(title)) {
                filteredDvds.add(dvd);
            }
        }
        return filteredDvds;
    }

    @Override
    public List<Dvd> getByRating(String rating) {
        ArrayList<Dvd> filteredDvds = new ArrayList<>();

        for (Dvd dvd : dvdLibrary) {
            if (dvd.getMpaaRating().equals(rating)) {
                filteredDvds.add(dvd);
            }
        }
        return filteredDvds;
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        ArrayList<Dvd> filteredDvds = new ArrayList<>();

        for (Dvd dvd : dvdLibrary) {
            if (dvd.getStudio().equals(studio)) {
                filteredDvds.add(dvd);
            }
        }
        return filteredDvds;
    }

    public ArrayList<Dvd> getDvdLibrary() {
        return dvdLibrary;
    }
}
