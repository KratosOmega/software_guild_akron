/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrayjunittests;

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
public class HasEvenTest {
    int[] numbers;
    boolean expected, actual;
    
    @Test
    public void passTest_HasEven_1(){
        // Arrange
        numbers = new int[] {2, 5};
        expected = true;
        
        // Act
        ArraysJUnitDrills hasEvenTest = new ArraysJUnitDrills();
        actual = hasEvenTest.hasEven(numbers);
        
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void passTest_HasEven_2(){
        // Arrange
        numbers = new int[] {4, 3};
        expected = true;
        
        // Act
        ArraysJUnitDrills hasEvenTest = new ArraysJUnitDrills();
        actual = hasEvenTest.hasEven(numbers);
        
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void failTest_HasEven_1(){
        // Arrange
        numbers = new int[] {7, 5};
        expected = false;
        
        // Act
        ArraysJUnitDrills hasEvenTest = new ArraysJUnitDrills();
        actual = hasEvenTest.hasEven(numbers);
        
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
