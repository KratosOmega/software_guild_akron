/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Kratos
 */
public class DvdLibraryImplementation implements DvdLibraryApi {

    private List<Dvd> dvdLibrary;

    public static int id;

    public DvdLibraryImplementation() {
        this.dvdLibrary = new ArrayList<>();
        id = 0;
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
        dvd.setId(id);
        dvdLibrary.add(dvd);
        this.id++;
    }

    public void edit(Dvd dvd) {
        int editIndex = 0;

        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getId() == dvd.getId()) {
                editIndex = i;
            }
        }
        dvdLibrary.set(editIndex, dvd);
    }

    @Override
    public void remove(int id) {
        int deleteIndex = 0;

        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getId() == id) {
                deleteIndex = i;
            }
        }
        dvdLibrary.remove(deleteIndex);
    }

    @Override
    public List<Dvd> listAll() {
        return dvdLibrary;
    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
        // Get criteria terms
//        String idCriteria = criteria.get(SearchTerm.ID);
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String mpaaRatingCriteria = criteria.get(SearchTerm.MPAA_RATING);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String noteCriteria = criteria.get(SearchTerm.NOTE);

        // Setup predicate
        Predicate<Dvd> titleMatches;
        Predicate<Dvd> releaseDateMatches;
        Predicate<Dvd> mpaaRatingMatches;
        Predicate<Dvd> directorMatches;
        Predicate<Dvd> studioMatches;
        Predicate<Dvd> noteMatches;

        Predicate<Dvd> truePredicate = (dvd) -> {
            return true;
        };

        // Get maches
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate
                : (dvd) -> dvd.getTitle().equals(titleCriteria);
        releaseDateMatches = (releaseDateCriteria == null)
                ? truePredicate
                : (dvd) -> (dvd.getReleaseDate() + "").equals(releaseDateCriteria);
                
//                ? truePredicate
//                : (dvd) -> {
//                    return (dvd.getReleaseDate() + "").equals(releaseDateCriteria);
//                };

        mpaaRatingMatches = (mpaaRatingCriteria == null || mpaaRatingCriteria.isEmpty())
                ? truePredicate
                : (dvd) -> dvd.getMpaaRating().equals(mpaaRatingCriteria);
        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate
                : (dvd) -> dvd.getDirector().equals(directorCriteria);
        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (dvd) -> dvd.getStudio().equals(studioCriteria);
        noteMatches = (noteCriteria == null || noteCriteria.isEmpty())
                ? truePredicate
                : (dvd) -> dvd.getNote().equals(noteCriteria);

        return dvdLibrary
                .stream()
                .filter(
                        titleMatches
                        .and(releaseDateMatches)
                        .and(mpaaRatingMatches)
                        .and(directorMatches)
                        .and(studioMatches)
                        .and(noteMatches)
                ).collect(Collectors.toList());
    }

    // used for initialize the in-memory data from json file
    public void setDvdLibrary(List<Dvd> dvdLibrary) {
        this.dvdLibrary = dvdLibrary;
    }

}
