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
public class HasTeenTest {
    int a, b, c;
    boolean expected, actual;

    @Test
    public void hasTeenTest_1(){
        // Arrange
        a = 13;
        b = 20;
        c = 10;
        expected = true;

        // Act
        ConditionalsJUnitDrills hasTeenTest = new ConditionalsJUnitDrills();
        actual = hasTeenTest.hasTeen(a, b, c);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasTeenTest_2(){
        // Arrange
        a = 20;
        b = 19;
        c = 10;
        expected = true;

        // Act
        ConditionalsJUnitDrills hasTeenTest = new ConditionalsJUnitDrills();
        actual = hasTeenTest.hasTeen(a, b, c);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasTeenTest_3(){
        // Arrange
        a = 20;
        b = 10;
        c = 12;
        expected = false;

        // Act
        ConditionalsJUnitDrills hasTeenTest = new ConditionalsJUnitDrills();
        actual = hasTeenTest.hasTeen(a, b, c);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
