/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author warde
 */
public interface DvdLibraryDao {
    
    public void add(Dvd dvd);
    public void remove(int id);
    public List<Dvd> listAll();
    public Dvd getById(int id);
    public List<Dvd> getByTitle(String title);
    public List<Dvd> getByRating(String rating);
    public List<Dvd> getByStudio(String studio);
}
