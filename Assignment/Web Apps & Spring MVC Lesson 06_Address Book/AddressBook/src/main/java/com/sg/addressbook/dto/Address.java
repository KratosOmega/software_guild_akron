/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dto;

import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Kratos
 */
public class Address {

    private int id;
    private boolean isArchived;

    @NotEmpty(message = "First name must not be empty!")
    @Length(max = 15, message = "First name must be no more than 15 characters!")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    @Length(max = 15, message = "Last name must be no more than 15 characters!")
    private String lastName;

    @NotEmpty(message = "House number must not be empty!")
    @Length(max = 5, message = "House number must be no more than 5 character!")
    private String houseNumber;

    @NotEmpty(message = "Street must not be empty!")
    @Length(max = 50, message = "Street must be no more than 50 characters!")
    private String street;

    @NotEmpty(message = "City must not be empty!")
    @Length(max = 15, message = "City must be no more than 15 characters!")
    private String city;

    @NotEmpty(message = "State must not be empty!")
    @Length(max = 2, min = 2, message = "State must be 2 charaters!")
    private String state;

    @NotNull(message = "Zipcode must not be empty!")
    private Integer zipCode;

    @NotEmpty(message = "Country must not be empty!")
    @Length(max = 15, message = "State must be no more than 15 charaters!")
    private String country;

    public Address() {
        this.isArchived = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
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

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isIsArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.houseNumber);
        hash = 37 * hash + Objects.hashCode(this.street);
        hash = 37 * hash + Objects.hashCode(this.city);
        hash = 37 * hash + Objects.hashCode(this.state);
        hash = 37 * hash + Objects.hashCode(this.zipCode);
        hash = 37 * hash + Objects.hashCode(this.country);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if(this.isArchived){
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Address other = (Address) obj;

        if (this.id != other.id) {
            return false;
        }

        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }

        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }

        if (!Objects.equals(this.houseNumber, other.houseNumber)) {
            return false;
        }

        if (!Objects.equals(this.street, other.street)) {
            return false;
        }

        if (!Objects.equals(this.city, other.city)) {
            return false;
        }

        if (!Objects.equals(this.state, other.state)) {
            return false;
        }

        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }

        if (!Objects.equals(this.country, other.country)) {
            return false;
        }

        return true;
    }
}
