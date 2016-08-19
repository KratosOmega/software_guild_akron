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
public class Canvas implements Paintable {
    private String color;
    private String canvasArea;
    
    @Override
    public void applyColor(String color) {
        // Paint our canvas the color
        this.canvasArea = color;
        this.canvasArea += BACKGROUND_COLOR;
    }

    @Override
    public void setColor(String color) {
        // We picked a color to use
        this.color = color;
    }

    @Override
    public String getColor() {
        // What color did we pick?
        return this.color;
    }
    
}
