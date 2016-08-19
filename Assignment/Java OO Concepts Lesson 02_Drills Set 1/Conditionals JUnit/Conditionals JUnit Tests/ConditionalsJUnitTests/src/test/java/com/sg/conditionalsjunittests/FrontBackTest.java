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
public class FrontBackTest {
    String str, expected, actual;

    @Test
    public void frontBackTest_1(){
        // Arrange
        str = "code";
        expected = "eodc";

        // Act
        ConditionalsJUnitDrills frontBackTest = new ConditionalsJUnitDrills();
        actual = frontBackTest.frontBack(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontBackTest_2(){
        // Arrange
        str = "a";
        expected = "a";

        // Act
        ConditionalsJUnitDrills frontBackTest = new ConditionalsJUnitDrills();
        actual = frontBackTest.frontBack(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontBackTest_3(){
        // Arrange
        str = "ab";
        expected = "ba";

        // Act
        ConditionalsJUnitDrills frontBackTest = new ConditionalsJUnitDrills();
        actual = frontBackTest.frontBack(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
