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
public class FirstLast6Test {

    int[] array;
    boolean actual, expected;

    @Test
    public void passTest_FirstLast6_First6() {
        // Arrange
        array = new int[]{1, 2, 6};
        expected = true;

        // Act
        ArraysJUnitDrills firstLast6Test = new ArraysJUnitDrills();
        actual = firstLast6Test.firstLast6(array);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_FirstLast6_Last6() {
        // Arrange
        array = new int[]{6, 1, 2, 3};
        expected = true;

        // Act
        ArraysJUnitDrills firstLast6Test = new ArraysJUnitDrills();
        actual = firstLast6Test.firstLast6(array);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void failTest_FirstLast6_NeitherFirstLast6() {
        // Arrange
        array = new int[]{13, 6, 1, 2, 3};
        expected = false;

        // Act
        ArraysJUnitDrills firstLast6Test = new ArraysJUnitDrills();
        actual = firstLast6Test.firstLast6(array);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
