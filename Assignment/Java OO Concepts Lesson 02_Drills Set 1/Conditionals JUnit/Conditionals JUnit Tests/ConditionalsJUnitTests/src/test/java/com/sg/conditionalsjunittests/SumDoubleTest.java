/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.conditionalsjunittests;

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
public class SumDoubleTest {
    int a, b, expected, actual;

    @Test
    public void sumDoubleTest_1(){
        // Arrange
        a = 1;
        b = 2;
        expected = 3;

        // Act
        ConditionalsJUnitDrills sumDoubleTest = new ConditionalsJUnitDrills();
        actual = sumDoubleTest.sumDouble(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumDoubleTest_2(){
        // Arrange
        a = 3;
        b = 2;
        expected = 5;

        // Act
        ConditionalsJUnitDrills sumDoubleTest = new ConditionalsJUnitDrills();
        actual = sumDoubleTest.sumDouble(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void sumDoubleTest_3(){
        // Arrange
        a = 2;
        b = 2;
        expected = 8;

        // Act
        ConditionalsJUnitDrills sumDoubleTest = new ConditionalsJUnitDrills();
        actual = sumDoubleTest.sumDouble(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
