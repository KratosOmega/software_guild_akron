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
public class MischeviousChildrenTest {
    boolean aSmile, bSmile, expected, actual;

    @Test
    public void passTest_AreWeInTrouble_1(){
        // Arrange
        aSmile = true;
        bSmile = true;
        expected = true;

        // Act
        ConditionalsJUnitDrills mischeviousChildrenTest = new ConditionalsJUnitDrills();
        actual = mischeviousChildrenTest.areWeInTrouble(aSmile, bSmile);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_AreWeInTrouble_2(){
        // Arrange
        aSmile = false;
        bSmile = false;
        expected = true;

        // Act
        ConditionalsJUnitDrills mischeviousChildrenTest = new ConditionalsJUnitDrills();
        actual = mischeviousChildrenTest.areWeInTrouble(aSmile, bSmile);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void failTest_AreWeInTrouble_1(){
        // Arrange
        aSmile = true;
        bSmile = false;
        expected = false;

        // Act
        ConditionalsJUnitDrills mischeviousChildrenTest = new ConditionalsJUnitDrills();
        actual = mischeviousChildrenTest.areWeInTrouble(aSmile, bSmile);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
