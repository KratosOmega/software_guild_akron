/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Kratos
 */
public class DvdLibraryImplementation implements DvdLibraryApi {

    private List<Dvd> dvdLibrary;
    public static int id;

    // +++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose
    public Scanner scanner;
    public String[] data;
    // +++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose

    public DvdLibraryImplementation() {
        this.dvdLibrary = new ArrayList<>();
        id = 0;

        // +++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose
        try {
            this.scanner = new Scanner(new BufferedReader(new FileReader("loadDataForTest.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Can not load file!");
        }

        while (scanner.hasNext()) {
            data = scanner.nextLine().split("::");
            Dvd dvd = new Dvd();

            dvd.setId(id);
            dvd.setTitle(data[1]);
            dvd.setReleaseDate(Integer.parseInt(data[2]));
            dvd.setMpaaRating(data[3]);
            dvd.setDirector(data[4]);
            dvd.setStudio(data[5]);
            if (data.length < 7) {
                dvd.setNote(null);
            } else {
                dvd.setNote(data[6]);
            }
            dvdLibrary.add(dvd);
            id++;
        }
        // +++++++++++++++++++++++++++++++++++++++++++++ Quick Data Lodaer, for testing purpose

    }

    @Override
    public List<Dvd> filterNYears(int years) {
        // Find all movies released in the last N years
        return dvdLibrary
                .stream()
                .filter(dvds -> dvds.getReleaseDate() > (Calendar.getInstance().get(Calendar.YEAR) - years))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> filterRating(String mpaa) {
        // Find all the movies with a given MPAA rating
        return dvdLibrary
                .stream()
                .filter(dvds -> dvds.getMpaaRating().equals(mpaa))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> filterDirector(String director) {
        // Find all the movies by a given director
        // When searching by director, the movies should be sorted into separate data structures by MPAA rating
        return dvdLibrary
                .stream()
                .filter(dvds -> dvds.getDirector().equals(director))
                .sorted((dvd1, dvd2) -> dvd1.getMpaaRating().compareTo(dvd2.getMpaaRating()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> fitlerStudio(String studio) {
        // Find all the movies released by a particular studio
        return dvdLibrary
                .stream()
                .filter(dvds -> dvds.getStudio().equals(studio))
                .collect(Collectors.toList());
    }

    @Override
    public double fitlerAvgAge() {
        // Find all the average age of the movies in the collection
        return dvdLibrary
                .stream()
                .mapToInt(dvds -> (Calendar.getInstance().get(Calendar.YEAR) - dvds.getReleaseDate()))
                .average()
                .getAsDouble();
    }

    @Override
    public Dvd fitlerNewestMovie() {
        // Find the newest movie in your collection
        Dvd newestMovie = dvdLibrary
                .stream()
                .max((dvd1, dvd2) -> Integer.compare(dvd1.getReleaseDate(), dvd2.getReleaseDate()))
                .get();
        return newestMovie;
    }

    @Override
    public Dvd fitlerOldestMovie() {
        // Find the oldest movie in your collection
        Dvd oldestMovie = dvdLibrary
                .stream()
                .min((dvd1, dvd2) -> Integer.compare(dvd1.getReleaseDate(), dvd2.getReleaseDate()))
                .get();
        return oldestMovie;
    }

    @Override
    public double calculateAvgNotes() {
        // Find the average number of notes associated with movies in your collection

        double emptyNotesCount = dvdLibrary
                .stream()
                .filter(dvds -> dvds.getNote() == null)
                .count();

        double recordsCount = dvdLibrary
                .stream()
                .count();

        return (recordsCount - emptyNotesCount) / recordsCount;
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
}
