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
public class Fix23Test {

    int[] numbers, expected, actual;

    @Test
    public void passTest_Fix23_1() {
        // Arrange
        numbers = new int[]{1, 2, 3};
        expected = new int[]{1, 2, 0};

        // Act
        ArraysJUnitDrills fix23Test = new ArraysJUnitDrills();
        actual = fix23Test.fix23(numbers);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void passTest_Fix23_2() {
        // Arrange
        numbers = new int[]{2, 3, 5};
        expected = new int[]{2, 0, 5};

        // Act
        ArraysJUnitDrills fix23Test = new ArraysJUnitDrills();
        actual = fix23Test.fix23(numbers);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void failtest_Fix23_1() {
        // Arrange
        numbers = new int[]{1, 2, 1};
        expected = new int[]{1, 2, 1};

        // Act
        ArraysJUnitDrills fix23Test = new ArraysJUnitDrills();
        actual = fix23Test.fix23(numbers);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
}
