/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

/**
 *
 * @author Kratos
 */
public class Capital {

    private String capitalName;
    private long population;
    private double sqrtMileage;

    public Capital(String capitalName, long population, double sqrtMileage) {
        this.capitalName = capitalName;
        this.population = population;
        this.sqrtMileage = sqrtMileage;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getSqrtMileage() {
        return sqrtMileage;
    }

    public void setSqrtMileage(double sqrtMileage) {
        this.sqrtMileage = sqrtMileage;
    }
}
