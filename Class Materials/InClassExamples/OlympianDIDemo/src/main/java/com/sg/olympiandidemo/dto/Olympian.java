/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.olympiandidemo.dto;

/**
 *
 * @author softwareguild
 */
public class Olympian {
    private Event event;
    private String country = "USA";
    
    public Olympian(Event event){
        this.event = event;
    }

    public String competeInEvent(){
        System.out.println("Now competing for " + country + ":");
        return event.compete();
    }
    
    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
