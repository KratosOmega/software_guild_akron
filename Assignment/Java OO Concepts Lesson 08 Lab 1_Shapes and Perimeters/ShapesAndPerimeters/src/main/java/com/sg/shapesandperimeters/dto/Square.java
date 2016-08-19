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
public class Square extends Shape{
    private double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    double area() {
        return this.side * this.side;
    }

    @Override
    double perimeter() {
        return this.side * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
