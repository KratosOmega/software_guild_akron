/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.model;

import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author softwareguild
 */
public class Contact {

    private int contactId;
    @NotEmpty(message="You must supply a value for First Name.")
    @Length(max=50, message="First Name must be no more than 50 characters in length.")
    private String firstName;
    @NotEmpty(message="You must supply a value for Last Name.")
    @Length(max=50, message="Last Name must be no more than 50 characters in length.")
    private String lastName;
    @NotEmpty(message="You must supply a value for Company.")
    @Length(max=50, message="Company must be no more than 50 characters in length.")
    private String company;
    @Email(message="Please enter a valid email address.")
    @Length(max=50, message="Email mst be no more than 50 characters in length.")
    private String email;
    @NotEmpty(message="You must supply a value for Phone.")
    @Length(max=10,message="Phone must be no more than 10 characters in length.")
    private String phone;

    /**
     * @return the contactId
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * @param contactId the contactId to set
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.contactId;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.company);
        hash = 37 * hash + Objects.hashCode(this.phone);
        hash = 37 * hash + Objects.hashCode(this.email);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        
        final Contact other = (Contact) obj;
        
        if (this.contactId != other.contactId) {
            return false;
        }
        
        if (!Objects.equals(this.firstName, other.firstName)){
            return false;
        }
        
        if (!Objects.equals(this.lastName, other.lastName)){
            return false;
        }
        
        if (!Objects.equals(this.company, other.company)){
            return false;
        }
        
        if (!Objects.equals(this.email, other.email)){
            return false;
        }
        
        if (!Objects.equals(this.phone, other.phone)){
            return false;
        }
        return true;
    }
    
}
