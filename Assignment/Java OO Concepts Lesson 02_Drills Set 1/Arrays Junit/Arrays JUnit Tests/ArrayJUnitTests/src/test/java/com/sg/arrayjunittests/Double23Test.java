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
public class Double23Test {

    int[] numbers;
    boolean expected, actual;

    @Test
    public void passTest_Double23Test_1() {
        // Arrange
        numbers = new int[]{2, 2, 3};
        expected = true;

        // Act
        ArraysJUnitDrills double23Test = new ArraysJUnitDrills();
        actual = double23Test.double23(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_Double23Test_2() {
        // Arrange
        numbers = new int[]{3, 4, 5, 3};
        expected = true;

        // Act
        ArraysJUnitDrills double23Test = new ArraysJUnitDrills();
        actual = double23Test.double23(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void failTest_Double23Test_1() {
        // Arrange
        numbers = new int[]{2, 3, 2, 2};
        expected = false;

        // Act
        ArraysJUnitDrills double23Test = new ArraysJUnitDrills();
        actual = double23Test.double23(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
