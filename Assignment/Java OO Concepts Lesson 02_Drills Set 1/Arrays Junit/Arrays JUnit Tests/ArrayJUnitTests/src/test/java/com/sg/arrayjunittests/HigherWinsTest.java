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
public class HigherWinsTest {
    int[] numbers, expected, actual;
    
    @Test
    public void passTest_HigherWins_1(){
        // Arrange
        numbers = new int[] {1, 2, 3};
        expected = new int[] {3, 3, 3};
        
        // Act
        ArraysJUnitDrills higherWinsTest = new ArraysJUnitDrills();
        actual = higherWinsTest.higherWins(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void passTest_HigherWins_2(){
        // Arrange
        numbers = new int[] {11, 5, 9};
        expected = new int[] {11, 11, 11};
        
        // Act
        ArraysJUnitDrills higherWinsTest = new ArraysJUnitDrills();
        actual = higherWinsTest.higherWins(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void passTest_HigherWins_3(){
        // Arrange
        numbers = new int[] {2, 11, 3};
        expected = new int[] {3, 3, 3};
        
        // Act
        ArraysJUnitDrills higherWinsTest = new ArraysJUnitDrills();
        actual = higherWinsTest.higherWins(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
}
