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
public class GetMiddleTest {

    int[] a, b, expected, actual;

    @Test
    public void passTest_GetMiddle_1() {
        // Arrange
        a = new int[]{1, 2, 3};
        b = new int[]{4, 5, 6};
        expected = new int[]{2, 5};

        // Act
        ArraysJUnitDrills getMiddleTest = new ArraysJUnitDrills();
        actual = getMiddleTest.getMiddle(a, b);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void passTest_GetMiddle_2() {
        // Arrange
        a = new int[]{7, 7, 7};
        b = new int[]{3, 8, 0};
        expected = new int[]{7, 8};

        // Act
        ArraysJUnitDrills getMiddleTest = new ArraysJUnitDrills();
        actual = getMiddleTest.getMiddle(a, b);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void passTest_GetMiddle_3() {
        // Arrange
        a = new int[]{5, 2, 9};
        b = new int[]{1, 4, 5};
        expected = new int[]{2, 4};

        // Act
        ArraysJUnitDrills getMiddleTest = new ArraysJUnitDrills();
        actual = getMiddleTest.getMiddle(a, b);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
}
