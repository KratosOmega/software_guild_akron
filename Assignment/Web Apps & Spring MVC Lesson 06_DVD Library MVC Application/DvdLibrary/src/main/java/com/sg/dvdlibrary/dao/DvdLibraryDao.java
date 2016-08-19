/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import java.util.List;

/**
 *
 * @author warde
 */
public interface DvdLibraryDao {
    public void add(Dvd dvd);
    public void remove(int id);
    public List<Dvd> listAll();
}
