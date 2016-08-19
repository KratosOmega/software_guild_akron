/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.model;

import java.util.List;

/**
 *
 * @author Kratos
 */
public class Developer {
    // Developer Fields

    private Object aboutMe;
    private Object education;
    private Object skills;
    private Object specialities;
    private Object hobbyAndInterest;

    public Object getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(Object aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Object getEducation() {
        return education;
    }

    public void setEducation(Object education) {
        this.education = education;
    }

    public Object getSkills() {
        return skills;
    }

    public void setSkills(Object skills) {
        this.skills = skills;
    }

    public Object getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Object specialities) {
        this.specialities = specialities;
    }

    public Object getHobbyAndInterest() {
        return hobbyAndInterest;
    }

    // Developer Getters & Setters
    public void setHobbyAndInterest(Object hobbyAndInterest) {
        this.hobbyAndInterest = hobbyAndInterest;
    }

    // Developer Methods
    public Object showMyProjects() {
        Object projects = new Object();
        return projects;
    }
    
    public Object showMyTestimonials(){
        Object testimonials = new Object();
        return testimonials;
    }
    
    public Object showMyPosts(){
        Object posts = new Object();
        return posts;
    }
    
    public Object contact(){
        Object contact = new Object();
        return contact;
    }

    // Create Object for Xin
    public static void main(String[] args) {
        Developer xin = new Developer();

        // Xin's General Information
        xin.getAboutMe();
        xin.getEducation();
        xin.getSkills();
        xin.getSpecialities();
        xin.getHobbyAndInterest();
        
        // What Xin did
        xin.showMyProjects();
        xin.showMyTestimonials();
        xin.showMyPosts();
        
        // Contact Xin
        xin.contact();
    }
}
