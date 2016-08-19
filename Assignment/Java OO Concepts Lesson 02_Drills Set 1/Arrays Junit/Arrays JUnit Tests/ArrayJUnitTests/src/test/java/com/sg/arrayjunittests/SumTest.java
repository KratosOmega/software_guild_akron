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
public class SumTest {

    int[] numbers;
    int actual, expected;

    @Test
    public void passTest_Sum_1() {
        // Arrange
        numbers = new int[]{1, 2, 3};
        expected = 6;

        // Act
        ArraysJUnitDrills sumTest = new ArraysJUnitDrills();
        actual = sumTest.sum(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_Sum_2() {
        // Arrange
        numbers = new int[]{5, 11, 2};
        expected = 18;

        // Act
        ArraysJUnitDrills sumTest = new ArraysJUnitDrills();
        actual = sumTest.sum(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_Sum_3() {
// Arrange
        numbers = new int[]{7, 0, 0};
        expected = 7;

        // Act
        ArraysJUnitDrills sumTest = new ArraysJUnitDrills();
        actual = sumTest.sum(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

}
