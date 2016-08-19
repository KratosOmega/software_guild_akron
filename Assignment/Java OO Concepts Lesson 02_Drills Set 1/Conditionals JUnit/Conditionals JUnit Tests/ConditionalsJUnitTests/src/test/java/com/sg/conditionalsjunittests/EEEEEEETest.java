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
public class EEEEEEETest {
    String str;
    boolean expected, actual;

    @Test
    public void eEEEEEETest_1(){
        // Arrange
        str = "Hello";
        expected = true;

        // Act
        ConditionalsJUnitDrills eEEEEEETest = new ConditionalsJUnitDrills();
        actual = eEEEEEETest.gotE(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void eEEEEEETest_2(){
        // Arrange
        str = "Heelle";
        expected = true;

        // Act
        ConditionalsJUnitDrills eEEEEEETest = new ConditionalsJUnitDrills();
        actual = eEEEEEETest.gotE(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void eEEEEEETest_3(){
        // Arrange
        str = "Heelele";
        expected = false;

        // Act
        ConditionalsJUnitDrills eEEEEEETest = new ConditionalsJUnitDrills();
        actual = eEEEEEETest.gotE(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
