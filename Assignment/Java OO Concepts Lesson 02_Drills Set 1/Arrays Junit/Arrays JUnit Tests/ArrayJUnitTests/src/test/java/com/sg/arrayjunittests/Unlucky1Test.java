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
public class Unlucky1Test {

    int[] numbers;
    boolean expected, actual;

    @Test
    public void passTest_Unlucky1_1() {
        // Arrange
        numbers = new int[]{1, 3, 4, 5};
        expected = true;

        // Act
        ArraysJUnitDrills unlucky1Test = new ArraysJUnitDrills();
        actual = unlucky1Test.unlucky1(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_Unlucky1_2() {
        // Arrange
        numbers = new int[]{2, 1, 3, 4, 5};
        expected = true;

        // Act
        ArraysJUnitDrills unlucky1Test = new ArraysJUnitDrills();
        actual = unlucky1Test.unlucky1(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void failTest_Unlucky1Test_1() {
        // Arrange
        numbers = new int[]{1, 1, 1};
        expected = false;

        // Act
        ArraysJUnitDrills unlucky1Test = new ArraysJUnitDrills();
        actual = unlucky1Test.unlucky1(numbers);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

}
