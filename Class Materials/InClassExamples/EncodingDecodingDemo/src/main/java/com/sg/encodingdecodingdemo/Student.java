/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.encodingdecodingdemo;

/**
 *
 * @author softwareguild
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort;

    public Student(String studentId){
        this.studentId = studentId;
    }
    
    // overloaded constructor
    public Student (String studentId, String firstName, String lastName, String cohort){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cohort = cohort;
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
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the cohort
     */
    public String getCohort() {
        return cohort;
    }

    /**
     * @param cohort the cohort to set
     */
    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    
    // By overriding the toString() output, we have control of what to display
    // Otherwise, object.toString() tends to return the object type and hashcode
    @Override
    public String toString(){
       return this.firstName + " " + this.lastName + " ("
                    + this.studentId + ") - " + this.cohort;
    }
    
    
}
