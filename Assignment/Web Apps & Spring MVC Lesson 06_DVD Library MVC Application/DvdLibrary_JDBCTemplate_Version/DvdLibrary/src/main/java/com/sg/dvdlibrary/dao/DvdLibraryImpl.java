/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kratos
 */
public class DvdLibraryImpl implements DvdLibraryApi {

    private JdbcTemplate jdbcTemplate;

    // DI by using setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SQL Statements
    // Last inserted ID
    private static final String SQL_SELECT_LAST_INSERTED_ID = "SELECT LAST_INSERT_ID()";
    // Dvd
    private static final String SQL_INSERT_DVD 
            = "INSERT INTO dvd(dvd_title, dvd_releaseDate, dvd_mmpaRating, dvd_director, dvd_studio, dvd_note) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD = "DELETE FROM dvd WHERE dvd_id = ?";
    private static final String SQL_UPDATE_DVD 
            = "UPDATE dvd "
            + "SET dvd_title = ?, dvd_releaseDate = ?, dvd_mmpaRating = ?, dvd_director = ?, dvd_studio = ?, dvd_note = ? "
            + "WHERE dvd_id = ?";
    private static final String SQL_SELECT_DVD = "SELECT * FROM dvd ";
    private static final String SQL_SELECT_DVD_BY_DVD_ID = "SELECT * FROM dvd WHERE dvd_id = ?";

//    // State
//    private static final String SQL_INSERT_STATE = "INSERT INTO ab_state(state_name) VALUES (?)";
//    private static final String SQL_DELETE_STATE = "DELETE FROM ab_state WHERE state_id = ?";
//    private static final String SQL_UPDATE_STATE = "UPDATE ab_state SET state_name = ?";
//    private static final String SQL_SELECT_STATE = "SELECT * FROM ab_state";
//    private static final String SQL_SELECT_STATE_BY_STATE_ID = "SELECT state_name FROM ab_state WHERE state_id = ?";
//
//    // ZipCode
//    private static final String SQL_INSERT_ZIPCODE = "INSERT INTO ab_zipcode(area_name) VALUES (?)";
//    private static final String SQL_DELETE_ZIPCODE = "DELETE FROM ab_zipcode WHERE zipcode_id = ?";
//    private static final String SQL_UPDATE_ZIPCODE = "UPDATE ab_zipcode SET area_name = ?";
//    private static final String SQL_SELECT_ZIPCODE = "SELECT * FROM ab_zipcode";
//    private static final String SQL_SELECT_ZIPCODE_BY_ZIPCODE_ID = "SELECT area_name FROM ab_zipcode WHERE zipcode_id = ?";
//
//    // Country
//    private static final String SQL_INSERT_COUNTRY = "INSERT INTO ab_country(country_name) VALUES (?)";
//    private static final String SQL_DELETE_COUNTRY = "DELETE FROM ab_country WHERE country_id = ?";
//    private static final String SQL_UPDATE_COUNTRY = "UPDATE ab_country SET country_name = ?";
//    private static final String SQL_SELECT_COUNTRY = "SELECT * FROM ab_country";
//    private static final String SQL_SELECT_COUNTRY_BY_COUNTRY_ID = "SELECT country_name FROM ab_country WHERE country_id = ?";
    // Dvd Method
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMmpaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote());
        dvd.setId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        
        return dvd;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteDvd(int dvd_id) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvd_id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editDvd(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD, 
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMmpaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote(),
                dvd.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd getDvdById(int dvd_id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD_BY_DVD_ID, new DvdMapper(), dvd_id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_SELECT_DVD, new DvdMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Dvd> getDvdBySearch(Dvd dvd) {
        String SQL_SELECT_DVD_BY_SEARCH = SQL_SELECT_DVD;
        List<String> tempList = new ArrayList<>();

        boolean amTheFirstOne = true;

        if (!dvd.getTitle().equals("")) {
            tempList.add(dvd.getTitle());
            if (amTheFirstOne) {
                SQL_SELECT_DVD_BY_SEARCH += "WHERE dvd_title = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_DVD_BY_SEARCH += "AND dvd_title = ? ";
            }
        }
        
        if (!dvd.getReleaseDate().equals("")) {
            tempList.add(dvd.getReleaseDate());
            if (amTheFirstOne) {
                SQL_SELECT_DVD_BY_SEARCH += "WHERE dvd_releaseDate = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_DVD_BY_SEARCH += "AND dvd_releaseDate = ? ";
            }
        }
        
        if (!dvd.getMmpaRating().equals("")) {
            tempList.add(dvd.getMmpaRating());
            if (amTheFirstOne) {
                SQL_SELECT_DVD_BY_SEARCH += "WHERE dvd_mmpaRating = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_DVD_BY_SEARCH += "AND dvd_mmpaRating = ? ";
            }
        }
        
        if (!dvd.getDirector().equals("")) {
            tempList.add(dvd.getDirector());
            if (amTheFirstOne) {
                SQL_SELECT_DVD_BY_SEARCH += "WHERE dvd_director = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_DVD_BY_SEARCH += "AND dvd_director = ? ";
            }
        }
        
        if (!dvd.getStudio().equals("")) {
            tempList.add(dvd.getStudio());
            if (amTheFirstOne) {
                SQL_SELECT_DVD_BY_SEARCH += "WHERE dvd_studio = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_DVD_BY_SEARCH += "AND dvd_studio = ? ";
            }
        }
        
        if (!dvd.getNote().equals("")) {
            tempList.add(dvd.getNote());
            if (amTheFirstOne) {
                SQL_SELECT_DVD_BY_SEARCH += "WHERE dvd_note = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_DVD_BY_SEARCH += "AND dvd_note = ? ";
            }
        }

        String[] searchList = new String[tempList.size()];

        for (int i = 0; i < tempList.size(); i++) {
            searchList[i] = tempList.get(i);
        }

        return jdbcTemplate.query(SQL_SELECT_DVD_BY_SEARCH, searchList, new DvdMapper());
    }

//    // Zip Code
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void addZipCode(ZipCode zipCode) {
//        jdbcTemplate.update(SQL_INSERT_ZIPCODE,
//                zipCode.getAreaName());
//        zipCode.setZipCodeId(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void deleteZipCode(int zipCodeId) {
//        jdbcTemplate.update(SQL_DELETE_ZIPCODE, zipCodeId);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void updateZipCode(ZipCode zipCode) {
//        jdbcTemplate.update(SQL_UPDATE_ZIPCODE,
//                zipCode.getAreaName());
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public ZipCode getZipCodeById(int zipCodeId) {
//        try {
//            return jdbcTemplate.queryForObject(SQL_SELECT_ZIPCODE_BY_ZIPCODE_ID, new ZipCodeMapper(), zipCodeId);
//        } catch (EmptyResultDataAccessException ex) {
//            return null;
//        }
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public List<ZipCode> getAllZipCodes() {
//        return jdbcTemplate.query(SQL_SELECT_ZIPCODE, new ZipCodeMapper());
//    }
//
//    // State
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void addState(State state) {
//        jdbcTemplate.update(SQL_INSERT_STATE,
//                state.getStateName());
//        state.setStateId(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void deleteState(int stateId) {
//        jdbcTemplate.update(SQL_DELETE_STATE, stateId);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void updateState(State state) {
//        jdbcTemplate.update(SQL_UPDATE_STATE,
//                state.getStateName());
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public State getStateById(int stateId) {
//        try {
//            return jdbcTemplate.queryForObject(SQL_SELECT_STATE_BY_STATE_ID, new StateMapper(), stateId);
//        } catch (EmptyResultDataAccessException ex) {
//            return null;
//        }
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public List<State> getAllStates() {
//        return jdbcTemplate.query(SQL_SELECT_STATE, new StateMapper());
//    }
//
//    // Country
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void addCountry(Country country) {
//        jdbcTemplate.update(SQL_INSERT_COUNTRY,
//                country.getCountryName());
//        country.setCountryId(jdbcTemplate.queryForObject(SQL_SELECT_LAST_INSERTED_ID, Integer.class));
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void deleteCountry(int countryId) {
//        jdbcTemplate.update(SQL_DELETE_COUNTRY, countryId);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public void updateCountry(Country country) {
//        jdbcTemplate.update(SQL_UPDATE_COUNTRY,
//                country.getCountryName());
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public Country getCountryById(int countryId) {
//        try {
//            return jdbcTemplate.queryForObject(SQL_SELECT_COUNTRY_BY_COUNTRY_ID, new CountryMapper(), countryId);
//        } catch (EmptyResultDataAccessException ex) {
//            return null;
//        }
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//    public List<Country> getAllCountries() {
//        return jdbcTemplate.query(SQL_SELECT_COUNTRY, new CountryMapper());
//    }
    // Mappers
    private static final class DvdMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setId(rs.getInt("dvd_id"));
            dvd.setTitle(rs.getString("dvd_title"));
            dvd.setReleaseDate(rs.getString("dvd_releaseDate"));
            dvd.setMmpaRating(rs.getString("dvd_mmpaRating"));
            dvd.setDirector(rs.getString("dvd_director"));
            dvd.setStudio(rs.getString("dvd_studio"));
            dvd.setNote(rs.getString("dvd_note"));

            return dvd;
        }

    }

//    private static final class StateMapper implements RowMapper<State> {
//
//        @Override
//        public State mapRow(ResultSet rs, int i) throws SQLException {
//            State state = new State();
//            state.setStateId(rs.getInt("state_id"));
//            state.setStateName(rs.getString("state_name"));
//
//            return state;
//        }
//    }
//
//    private static final class ZipCodeMapper implements RowMapper<ZipCode> {
//
//        @Override
//        public ZipCode mapRow(ResultSet rs, int i) throws SQLException {
//            ZipCode zipCode = new ZipCode();
//            zipCode.setZipCodeId(rs.getInt("zipcode_id"));
//            zipCode.setAreaName(rs.getString("area_name"));
//
//            return zipCode;
//        }
//    }
//    
//    private static final class CountryMapper implements RowMapper<Country> {
//
//        @Override
//        public Country mapRow(ResultSet rs, int i) throws SQLException {
//            Country country = new Country();
//            country.setCountryId(rs.getInt("country_id"));
//            country.setCountryName(rs.getString("country_name"));
//
//            return country;
//        }
//    }
}
