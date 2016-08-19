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
public class CommonEndTest {

    int[] a, b;
    boolean actual, expected;

    @Test
    public void passTest_commonEnd_1() {
        // Arrange
        a = new int[]{1, 2, 3};
        b = new int[]{7, 3};
        expected = true;

        // Act
        ArraysJUnitDrills commonEndTest = new ArraysJUnitDrills();
        actual = commonEndTest.commonEnd(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_commonEnd_2() {
        // Arrange
        a = new int[]{1, 2, 3};
        b = new int[]{1, 3};
        expected = true;

        // Act
        ArraysJUnitDrills commonEndTest = new ArraysJUnitDrills();
        actual = commonEndTest.commonEnd(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void failTest_commonEnd_1() {
        // Arrange
        a = new int[]{1, 2, 3};
        b = new int[]{7, 3, 2};
        expected = false;

        // Act
        ArraysJUnitDrills commonEndTest = new ArraysJUnitDrills();
        actual = commonEndTest.commonEnd(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
