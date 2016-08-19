/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interfacedemo.dto;

/**
 *
 * @author softwareguild
 */
public class Ball extends Shape implements Colorable  {
    private String ballColor;
    
    @Override
    public void setColor(String ballColor) {
        //set my color
        this.ballColor = ballColor;
    }

    @Override
    public String getColor() {
        // return my color
        return this.ballColor;
    }

    @Override
    public double area() {
        return 5.0;
    }
    
}
