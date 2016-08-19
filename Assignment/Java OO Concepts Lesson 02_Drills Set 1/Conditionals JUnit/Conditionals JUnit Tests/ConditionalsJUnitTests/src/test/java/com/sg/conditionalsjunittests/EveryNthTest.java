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
public class EveryNthTest {
    String str, expected, actual;
    int n;

    @Test
    public void everyNthTest_1(){
        // Arrange
        str = "Miracle";
        expected = "Mrce";
        n = 2;

        // Act
        ConditionalsJUnitDrills everyNthTest = new ConditionalsJUnitDrills();
        actual = everyNthTest.everyNth(str, n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void everyNthTest_2(){
        // Arrange
        str = "abcdefg";
        expected = "aceg";
        n = 2;

        // Act
        ConditionalsJUnitDrills everyNthTest = new ConditionalsJUnitDrills();
        actual = everyNthTest.everyNth(str, n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void everyNthTest_3(){
        // Arrange
        str = "abcdefg";
        expected = "adg";
        n = 3;

        // Act
        ConditionalsJUnitDrills everyNthTest = new ConditionalsJUnitDrills();
        actual = everyNthTest.everyNth(str, n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
