/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.model.Address;
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
public class AddressBookImpl implements AddressBookApi {

    private JdbcTemplate jdbcTemplate;

    // DI by using setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SQL Statements
    // Last inserted ID
    private static final String SQL_SELECT_LAST_INSERTED_ID = "SELECT LAST_INSERT_ID()";
    // Address
    private static final String SQL_INSERT_ADDRESS = "INSERT INTO ab_address(first_name, last_name, house_number, street, city, state, zipcode, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_ADDRESS = "DELETE FROM ab_address WHERE address_id = ?";
    private static final String SQL_UPDATE_ADDRESS = "UPDATE ab_address SET first_name = ?, last_name = ?, house_number = ?, street = ?, city = ?, state = ?, zipcode = ?, country = ? WHERE address_id = ?";
    private static final String SQL_SELECT_ADDRESS = "SELECT * FROM ab_address ";
    private static final String SQL_SELECT_ADDRESS_BY_ADDRESS_ID = "SELECT * FROM ab_address WHERE address_id = ?";

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
    // Address Method
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Address addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getCountry());
        address.setAddressId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        
        return address;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteAddress(int addressId) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getHouseNumber(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getCountry(),
                address.getAddressId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Address getAddressById(int addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS_BY_ADDRESS_ID, new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Address> getAllAddress() {
        return jdbcTemplate.query(SQL_SELECT_ADDRESS, new AddressMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)    
    public List<Address> getAddressBySearch(Address address) {
        String SQL_SELECT_ADDRESS_BY_SEARCH = SQL_SELECT_ADDRESS;
        List<String> tempList = new ArrayList<>();

        boolean amTheFirstOne = true;

        if (!address.getFirstName().equals("")) {
            tempList.add(address.getFirstName());
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE first_name = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND first_name = ? ";
            }
        }
        
        if (!address.getLastName().equals("")) {
            tempList.add(address.getLastName());            
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE last_name = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND last_name = ? ";
            }
        }
        
        if (!address.getHouseNumber().equals("")) {
            tempList.add(address.getHouseNumber());            
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE house_number = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND house_number = ? ";
            }
        }
        
        if (!address.getStreet().equals("")) {
            tempList.add(address.getStreet());            
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE street = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND street = ? ";
            }
        }
        
        if (!address.getCity().equals("")) {
            tempList.add(address.getCity());            
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE city = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND city = ? ";
            }
        }
        
        if (!address.getState().equals("")) {
            tempList.add(address.getState());            
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE state = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND state = ? ";
            }
        }
        
        if (!address.getZipCode().equals("")) {
            tempList.add(address.getZipCode());            
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE zipcode = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND zipcode = ? ";
            }
        }
        
        if (!address.getCountry().equals("")) {
            tempList.add(address.getCountry());            
            if (amTheFirstOne) {
                SQL_SELECT_ADDRESS_BY_SEARCH += "WHERE country = ? ";
                amTheFirstOne = false;
            } else {
                SQL_SELECT_ADDRESS_BY_SEARCH += "AND country = ? ";
            }
        }
        
        String[] searchList = new String[tempList.size()];
        
        for(int i = 0; i < tempList.size(); i++){
            searchList[i] = tempList.get(i);
        }
        
        return jdbcTemplate.query(SQL_SELECT_ADDRESS_BY_SEARCH, searchList, new AddressMapper());
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
    private static final class AddressMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {
            Address address = new Address();
            address.setAddressId(rs.getInt("address_id"));
            address.setFirstName(rs.getString("first_name"));
            address.setLastName(rs.getString("last_name"));
            address.setHouseNumber(rs.getString("house_number"));
            address.setStreet(rs.getString("street"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZipCode(rs.getString("zipcode"));
            address.setCountry(rs.getString("country"));

            return address;
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
