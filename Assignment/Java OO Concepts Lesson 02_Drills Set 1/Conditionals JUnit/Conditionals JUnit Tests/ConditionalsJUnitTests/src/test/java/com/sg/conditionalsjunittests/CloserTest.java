package com.sg.conditionalsjunittests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class CloserTest {
    int a, b, expected, actual;

    @Test
    public void closerTest_1(){
        // Arrange
        a = 8;
        b = 13;
        expected = 8;

        // Act
        ConditionalsJUnitDrills closerTest = new ConditionalsJUnitDrills();
        actual = closerTest.closer(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void closerTest_2(){
        // Arrange
        a = 13;
        b = 8;
        expected = 8;

        // Act
        ConditionalsJUnitDrills closerTest = new ConditionalsJUnitDrills();
        actual = closerTest.closer(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void closerTest_3(){
        // Arrange
        a = 13;
        b = 7;
        expected = 0;

        // Act
        ConditionalsJUnitDrills closerTest = new ConditionalsJUnitDrills();
        actual = closerTest.closer(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
