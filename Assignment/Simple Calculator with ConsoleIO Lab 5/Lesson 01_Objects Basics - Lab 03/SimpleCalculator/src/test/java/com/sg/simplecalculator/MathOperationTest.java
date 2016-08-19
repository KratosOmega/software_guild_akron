/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

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
public class MathOperationTest {
    double num1, num2, actual, expected;
    Exception failureExpected;
    
    @Test
    public void MathOperationAddSuccessTest(){
        // Arrange
        num1 = 10.0;
        num2 = 20.0;
        expected = 30.0;
        // Act
        MathOperation mathOperation = new MathOperation();
        actual = mathOperation.add(num1, num2);
        // Assert
        org.junit.Assert.assertEquals(expected, actual,0.0);
    }
    
    @Test
    public void MathOperationSubtractSuccessTest(){
        // Arrange
        num1 = 10.0;
        num2 = 20.0;
        expected = -10.0;
        // Act
        MathOperation mathOperation = new MathOperation();
        actual = mathOperation.subtract(num1, num2);
        // Assert
        org.junit.Assert.assertEquals(expected, actual,0.0);
    }
    
    @Test
    public void MathOperationMultiplySuccessTest(){
        // Arrange
        num1 = 10.0;
        num2 = 20.0;
        expected = 200.0;
        // Act
        MathOperation mathOperation = new MathOperation();
        actual = mathOperation.multiply(num1, num2);
        // Assert
        org.junit.Assert.assertEquals(expected, actual,0.0);
    }
    
    @Test
    public void MathOperationDivideSuccessTest(){
        // Arrange
        num1 = 10.0;
        num2 = 20.0;
        expected = 0.50;
        // Act
        MathOperation mathOperation = new MathOperation();
        actual = mathOperation.divide(num1, num2);
        // Assert
        org.junit.Assert.assertEquals(expected, actual,0.0);
    }

    
//    
}
