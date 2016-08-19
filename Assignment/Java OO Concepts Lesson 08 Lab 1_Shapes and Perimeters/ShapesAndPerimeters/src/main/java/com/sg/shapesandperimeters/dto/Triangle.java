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
public class Triangle extends Shape {

    private double height;
    private double base;
    private double side;

    public Triangle(double height, double base, double side, String color) {
        super(color);
        this.height = height;
        this.base = base;
        this.side = side;
    }

    @Override
    double area() {
        return height * base / 2;
    }

    @Override
    double perimeter() {
        return (side + Math.sqrt((((base - (Math.sqrt((side * side - height * height)))) * (base - (Math.sqrt((side * side - height * height))))) + height * height)) + base);
    }
}
