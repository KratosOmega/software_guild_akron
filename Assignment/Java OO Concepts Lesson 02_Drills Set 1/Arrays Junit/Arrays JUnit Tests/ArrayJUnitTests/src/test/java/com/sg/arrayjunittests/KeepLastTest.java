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
public class KeepLastTest {

    int[] numbers, expected, actual;

    @Test
    public void passTest_KeepPast_1() {
        // Arrange
        numbers = new int[]{4, 5, 6};
        expected = new int[]{0, 0, 0, 0, 0, 6};

        // Act
        ArraysJUnitDrills keepLastTest = new ArraysJUnitDrills();
        actual = keepLastTest.keepLast(numbers);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void passTest_KeepPast_2() {
        // Arrange
        numbers = new int[]{1, 2};
        expected = new int[]{0, 0, 0, 2};

        // Act
        ArraysJUnitDrills keepLastTest = new ArraysJUnitDrills();
        actual = keepLastTest.keepLast(numbers);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void passTest_KeepPast_3() {
        // Arrange
        numbers = new int[]{3};
        expected = new int[]{0, 3};

        // Act
        ArraysJUnitDrills keepLastTest = new ArraysJUnitDrills();
        actual = keepLastTest.keepLast(numbers);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
}
