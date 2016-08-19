/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters.dto;

/**
 *
 * @author Kratos
 */
public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle(double width, double length, String color) {
        super(color);
        this.width = width;
        this.length = length;
    }

    @Override
    double area() {
        return width * length;
    }

    @Override
    double perimeter() {
        return (width + length) * 2;
    }
}
