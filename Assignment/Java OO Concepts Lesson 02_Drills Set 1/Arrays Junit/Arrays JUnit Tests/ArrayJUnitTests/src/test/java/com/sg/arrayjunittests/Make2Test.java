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
public class Make2Test {

    int[] a, b, expected, actual;

    @Test
    public void passTest_Make2_1() {
        // Arrange
        a = new int[]{4, 5};
        b = new int[]{1, 2, 3};
        expected = new int[]{4, 5};

        // Act
        ArraysJUnitDrills make2Test = new ArraysJUnitDrills();
        actual = make2Test.make2(a, b);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void passTest_Make2_2() {
        //Arrange
        a = new int[]{4};
        b = new int[]{1, 2, 3};
        expected = new int[]{4, 1};

        // Act
        ArraysJUnitDrills make2Test = new ArraysJUnitDrills();
        actual = make2Test.make2(a, b);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void passTest_Make2_3() {
        //Arrange
        a = new int[]{};
        b = new int[]{1, 2};
        expected = new int[]{1, 2};

        // Act
        ArraysJUnitDrills make2Test = new ArraysJUnitDrills();
        actual = make2Test.make2(a, b);

        // Assert
        org.junit.Assert.assertArrayEquals(expected, actual);
    }
}
