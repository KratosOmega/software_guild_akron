/*

import java.util.ArrayList;

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_dvdlibrary.dto;

import java.util.ArrayList;

/**
 *
 * @author Kratos
 */
public class DVD {

    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private ArrayList<String> userNote;

    public DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio, String userNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.userNote = new ArrayList<>();
        this.userNote.add(userNote);
    }

    public DVD(String title, String releaseDate, String mpaaRating, String directorName, String studio, ArrayList<String> moreUserNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.userNote = new ArrayList<>();
        for (String note : moreUserNote) {
            userNote.add(note);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public ArrayList<String> getUserNote() {
        return userNote;
    }

    public void setUserNote(ArrayList<String> userNote) {
        this.userNote = userNote;
    }

    @Override
    public String toString() {
        String toString = "";
        toString += this.title + "\t" + this.releaseDate + "\t" + this.mpaaRating + "\t" + this.directorName + "\t" + this.studio + "\t";
        int index = 0;
        if (!this.userNote.isEmpty()) {
            for (String note : this.userNote) {
                index++;
                if (index == this.userNote.size()) {
                    toString += note;
                } else {
                    toString += note + "::";
                }
            }
        }
        return toString;
    }
}
