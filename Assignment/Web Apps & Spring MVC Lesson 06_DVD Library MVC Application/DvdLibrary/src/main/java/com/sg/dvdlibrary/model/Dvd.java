package com.sg.dvdlibrary.model;

import java.util.Objects;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author warde
 */
public class Dvd {

    private int id;

    @NotEmpty(message = "Title can not be empty!")
    @Length(max = 50, message = "Title must be no more than 50 characters in length!")
    private String title;

    @NotNull(message = "Release Year can not be empty!")
    @Max(2016)
    @Min(1965)
    private Integer releaseDate;

    @NotEmpty(message = "MPAA Rating can not be empty!")
    @Length(max = 5, message = "MPAA Rating must be no more than 5 characters in length!")
    private String mpaaRating;

    @NotEmpty(message = "Director can not be empty!")
    @Length(max = 50, message = "Director must be no more than 50 characters in length")
    private String director;

    @NotEmpty(message = "Studio can not be empty!")
    @Length(max = 50, message = "Studio must be no more than 50 characters in length")
    private String studio;

    @NotEmpty(message = "Note can not be empty")
    @Length(min = 5, message = "Note must be at least 5 characters in length")
    private String note;

    public Dvd() {
        this.releaseDate = null;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.releaseDate);
        hash = 37 * hash + Objects.hashCode(this.mpaaRating);
        hash = 37 * hash + Objects.hashCode(this.director);
        hash = 37 * hash + Objects.hashCode(this.studio);
        hash = 37 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Dvd other = (Dvd) obj;

        if (this.id != other.id) {
            return false;
        }

        if (!Objects.equals(this.title, other.title)) {
            return false;
        }

        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }

        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }

        if (!Objects.equals(this.director, other.director)) {
            return false;
        }

        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }

        if (!Objects.equals(this.note, other.note)) {
            return false;
        }

        return true;
    }
}
