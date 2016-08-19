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
public class StartHiTest {
    String str;
    boolean expected, actual;

    @Test
    public void startHiTest_1(){
        // Arrange
        str = "hi there";
        expected = true;

        // Act
        ConditionalsJUnitDrills startHiTest = new ConditionalsJUnitDrills();
        actual = startHiTest.startHi(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void startHiTest_2(){
        // Arrange
        str = "hi";
        expected = true;

        // Act
        ConditionalsJUnitDrills startHiTest = new ConditionalsJUnitDrills();
        actual = startHiTest.startHi(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void startHiTest_3(){
        // Arrange
        str = "high up";
        expected = false;

        // Act
        ConditionalsJUnitDrills startHiTest = new ConditionalsJUnitDrills();
        actual = startHiTest.startHi(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
