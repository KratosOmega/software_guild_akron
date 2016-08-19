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
public class SoAloneTest {
    int a, b;
    boolean expected, actual;

    @Test
    public void soAloneTest_1(){
        // Arrange
        a = 13;
        b = 99;
        expected = true;

        // Act
        ConditionalsJUnitDrills soAloneTest = new ConditionalsJUnitDrills();
        actual = soAloneTest.soAlone(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void soAloneTest_2(){
        // Arrange
        a = 21;
        b = 19;
        expected = true;

        // Act
        ConditionalsJUnitDrills soAloneTest = new ConditionalsJUnitDrills();
        actual = soAloneTest.soAlone(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void soAloneTest_3(){
        // Arrange
        a = 13;
        b = 13;
        expected = false;

        // Act
        ConditionalsJUnitDrills soAloneTest = new ConditionalsJUnitDrills();
        actual = soAloneTest.soAlone(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
