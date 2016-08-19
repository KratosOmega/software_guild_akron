/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kratos
 */
public interface DvdLibraryApi extends DvdLibraryDao{
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria);
    public double fitlerAvgAge();
    public Dvd fitlerNewestMovie();
    public Dvd fitlerOldestMovie();
    public double calculateAvgNotes();
}
