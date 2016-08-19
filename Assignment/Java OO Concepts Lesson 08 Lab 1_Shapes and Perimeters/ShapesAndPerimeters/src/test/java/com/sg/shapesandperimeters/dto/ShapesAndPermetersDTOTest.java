/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters.dto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kratos
 */
public class ShapesAndPermetersDTOTest {

    double expected_Area, actual_Area;
    double expected_Perimeter, actual_Perimeter;

    // ************************************************************* Square
    @Test
    public void square_AreaAndPerimeterTest() {
        // Arrange
        Square square = new Square(2.5, "Red");
        expected_Area = 6.25;
        expected_Perimeter = 10;
        // Act
        actual_Area = square.area();
        actual_Perimeter = square.perimeter();
        // Assert
        org.junit.Assert.assertEquals(expected_Area, actual_Area, 0.0);
        org.junit.Assert.assertEquals(expected_Perimeter, actual_Perimeter, 0.0);
    }

    // ************************************************************* Rectangle
    @Test
    public void rectangle_AreaAndPerimeterTest() {
        // Arrange
        Rectangle rectangle = new Rectangle(5, 8, "Black");
        expected_Area = 40;
        expected_Perimeter = 26;
        // Act
        actual_Area = rectangle.area();
        actual_Perimeter = rectangle.perimeter();
        // Assert
        org.junit.Assert.assertEquals(expected_Area, actual_Area, 0.0);
        org.junit.Assert.assertEquals(expected_Perimeter, actual_Perimeter, 0.0);
    }

    // ************************************************************* Triangle
    @Test
    public void triangle_AreaAndPerimeterTest() {
        // Arrange
        Triangle triangle = new Triangle(4, 6, 5, "Green");
        expected_Area = 12;
        expected_Perimeter = 16;
        // Act
        actual_Area = triangle.area();
        actual_Perimeter = triangle.perimeter();
        // Assert
        org.junit.Assert.assertEquals(expected_Area, actual_Area, 0.0);
        org.junit.Assert.assertEquals(expected_Perimeter, actual_Perimeter, 0.0);
    }

    // ************************************************************* Circle
    @Test
    public void circle_AreaAndPerimeterTest() {
        // Arrange
        Circle circle = new Circle(4, "Blue");
        expected_Area = Math.PI * 4 * 4;
        expected_Perimeter = 2 * Math.PI * 4;
        // Act
        actual_Area = circle.area();
        actual_Perimeter = circle.perimeter();
        // Assert
        org.junit.Assert.assertEquals(expected_Area, actual_Area, 0.0);
        org.junit.Assert.assertEquals(expected_Perimeter, actual_Perimeter, 0.0);
    }
}
