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
public class RotateLeftTest {
    int[] numbers, expected, actual;
    
    @Test
    public void passTest_RotateLeft_1(){
        // Arrange
        numbers = new int[]{1, 2, 3};
        expected = new int[] {2, 3, 1};
        
        // Act
        ArraysJUnitDrills rotateLeft = new ArraysJUnitDrills();
        actual = rotateLeft.rotateLeft(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void passTest_RotateLeft_2(){
        // Arrange
        numbers = new int[]{5, 11, 9};
        expected = new int[] {11, 9, 5};
        
        // Act
        ArraysJUnitDrills rotateLeft = new ArraysJUnitDrills();
        actual = rotateLeft.rotateLeft(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void passTest_RotateLeft_3(){
        // Arrange
        numbers = new int[]{7, 0, 0};
        expected = new int[] {0, 0, 7};
        
        // Act
        ArraysJUnitDrills rotateLeft = new ArraysJUnitDrills();
        actual = rotateLeft.rotateLeft(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
}
