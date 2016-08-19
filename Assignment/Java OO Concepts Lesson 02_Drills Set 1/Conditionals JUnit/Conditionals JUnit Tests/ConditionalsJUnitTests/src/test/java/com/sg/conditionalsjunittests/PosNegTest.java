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
public class PosNegTest {

    int a, b;
    boolean negative, expected, actual;

    @Test
    public void posNegTest_1(){
        // Arrange
        a = 1;
        b = -1;
        negative = false;
        expected = true;

        // Act
        ConditionalsJUnitDrills posNegTest = new ConditionalsJUnitDrills();
        actual = posNegTest.posNeg(a, b, negative);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void posNegTest_2(){
        // Arrange
        a = -1;
        b = 1;
        negative = false;
        expected = true;

        // Act
        ConditionalsJUnitDrills posNegTest = new ConditionalsJUnitDrills();
        actual = posNegTest.posNeg(a, b, negative);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void posNegTest_3(){
        // Arrange
        a = -4;
        b = -5;
        negative = true;
        expected = true;

        // Act
        ConditionalsJUnitDrills posNegTest = new ConditionalsJUnitDrills();
        actual = posNegTest.posNeg(a, b, negative);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
