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
 * @author Kratos
 */
public interface DvdLibraryApi {
    // Dvd
    public Dvd addDvd(Dvd dvd);
    public void deleteDvd(int dvd_id);
    public void editDvd(Dvd dvd);
    public Dvd getDvdById(int dvd_id);
    public List<Dvd> getAllDvds();
    public List<Dvd> getDvdBySearch(Dvd dvd);

//    // Zip Code
//    public void addZipCode(ZipCode zipCode);
//    public void deleteZipCode(int zipCodeId);
//    public void updateZipCode(ZipCode zipCode);
//    public ZipCode getZipCodeById(int zipCodeId);
//    public List<ZipCode> getAllZipCodes();
//    
//    // State
//    public void addState(State state);
//    public void deleteState(int stateId);
//    public void updateState(State state);
//    public State getStateById(int stateId);
//    public List<State> getAllStates();
//    
//    // Country
//    public void addCountry(Country country);
//    public void deleteCountry(int countryId);
//    public void updateCountry(Country country);
//    public Country getCountryById(int countryId);
//    public List<Country> getAllCountries();
}