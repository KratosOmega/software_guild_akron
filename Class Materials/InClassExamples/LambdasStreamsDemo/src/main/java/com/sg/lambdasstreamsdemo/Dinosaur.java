/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.lambdasstreamsdemo;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author softwareguild
 */
public class Dinosaur {
    private String name;
    private LocalDate birthdate;
    
    public long getDinoAge(){
        Period p = getBirthdate().until(LocalDate.now());
        return p.getYears();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
