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
public class SameFirstLastTest {

    int[] array;
    boolean actual, expected;

    @Test
    public void passTest_SameFirstLast_1() {
        // Arrange
        array = new int[]{1, 2, 1};
        expected = true;

        // Act
        ArraysJUnitDrills sameFirstLastTest = new ArraysJUnitDrills();
        actual = sameFirstLastTest.sameFirstLast(array);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_SameFirstLast_2() {
        // Arrange
        array = new int[]{1, 2, 3, 1};
        expected = true;

        // Act
        ArraysJUnitDrills sameFirstLastTest = new ArraysJUnitDrills();
        actual = sameFirstLastTest.sameFirstLast(array);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void failTest_SameFirstLast_1() {
        // Arrange
        array = new int[]{1, 2, 3};
        expected = false;

        // Act
        ArraysJUnitDrills sameFirstLastTest = new ArraysJUnitDrills();
        actual = sameFirstLastTest.sameFirstLast(array);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
