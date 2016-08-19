/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_addressbook.dto;

/**
 *
 * @author Kratos
 */
public class Address {

    private String firstName;
    private String lastName;
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address(String firstName, String lastName, String houseNumber, String street, String city, String state, String zipCode, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getFirsName() {
        return firstName;
    }

    public void setFirsName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // -------------------------- Customized
    public String[] toArray() {
        String[] recordInArray = new String[8];

        recordInArray[0] = this.firstName;
        recordInArray[1] = this.lastName;
        recordInArray[2] = this.houseNumber;
        recordInArray[3] = this.street;
        recordInArray[4] = this.city;
        recordInArray[5] = this.state;
        recordInArray[6] = this.zipCode;
        recordInArray[7] = this.country;

        return recordInArray;
    }

    public String encodingName() {
        String name
                = this.firstName + "::"
                + this.lastName;
        return name;
    }

    public String encodingAddress() {
        String address
                = this.houseNumber + "::"
                + this.street + "::"
                + this.city + "::"
                + this.state + "::"
                + this.zipCode + "::"
                + this.country;
        return address;
    }

    @Override
    public String toString() {
        return this.firstName + "::"
                + this.lastName + "::"
                + this.houseNumber + "::"
                + this.street + "::"
                + this.city + "::"
                + this.state + "::"
                + this.zipCode + "::"
                + this.country;
    }
}
