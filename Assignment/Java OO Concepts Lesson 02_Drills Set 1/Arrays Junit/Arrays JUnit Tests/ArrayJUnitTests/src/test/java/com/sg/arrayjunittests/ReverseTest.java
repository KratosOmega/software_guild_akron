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
public class ReverseTest {

    int[] numbers, expected, actual;

    @Test
    public void passTest_Reverse_1() {
        // Arrange
        numbers = new int[]{1, 2, 3};
        expected = new int[]{3, 2, 1};
        
        // Act
        ArraysJUnitDrills reverseTest = new ArraysJUnitDrills();
        actual = reverseTest.reverse(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
    
    
    @Test
    public void passTest_Reverse_2() {
        // Arrange
        numbers = new int[]{1, 2, 3, 4};
        expected = new int[]{4, 3, 2, 1};
        
        // Act
        ArraysJUnitDrills reverseTest = new ArraysJUnitDrills();
        actual = reverseTest.reverse(numbers);
        
        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

}
