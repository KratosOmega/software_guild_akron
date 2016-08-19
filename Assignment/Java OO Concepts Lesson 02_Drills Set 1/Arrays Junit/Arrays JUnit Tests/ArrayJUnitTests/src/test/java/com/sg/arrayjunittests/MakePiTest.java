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
public class MakePiTest {
    int n;
    int[] expected, actual;
    
    @Test
    public void passTest_MakePi_0() {
        // Arrange
        n = 0;
        expected = new int[]{0};

        // Act
        ArraysJUnitDrills makePiTest = new ArraysJUnitDrills();
        actual = makePiTest.makePi(n);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void passTest_MakePi_1() {
        // Arrange
        n = 1;
        expected = new int[]{3};

        // Act
        ArraysJUnitDrills makePiTest = new ArraysJUnitDrills();
        actual = makePiTest.makePi(n);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
    
    @Test
    public void passTest_MakePi_3() {
        // Arrange
        n = 3;
        expected = new int[]{3, 1, 4};

        // Act
        ArraysJUnitDrills makePiTest = new ArraysJUnitDrills();
        actual = makePiTest.makePi(n);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
}
