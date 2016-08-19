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
public interface DvdLibraryApi extends DvdLibraryDao{
    public List<Dvd> filterNYears(int years);
    public List<Dvd> filterRating(String mpaa);
    public List<Dvd> filterDirector(String director); // When searching by director, the movies should be sorted into separate data structures by MPAA rating.
    public List<Dvd> fitlerStudio(String studio);
    public double fitlerAvgAge();
    public Dvd fitlerNewestMovie();
    public Dvd fitlerOldestMovie();
    public double calculateAvgNotes();
}
