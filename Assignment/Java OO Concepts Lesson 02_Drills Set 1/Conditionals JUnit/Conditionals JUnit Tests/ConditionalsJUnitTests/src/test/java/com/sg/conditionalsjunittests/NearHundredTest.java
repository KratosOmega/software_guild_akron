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
public class NearHundredTest {
    int n;
    boolean expected, actual;

    @Test
    public void nearHundreTest_1(){
        // Arrange
        n = 103;
        expected = true;

        // Act
        ConditionalsJUnitDrills nearHundredTest = new ConditionalsJUnitDrills();
        actual = nearHundredTest.nearHundred(n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void nearHundreTest_2(){
        // Arrange
        n = 90;
        expected = true;

        // Act
        ConditionalsJUnitDrills nearHundredTest = new ConditionalsJUnitDrills();
        actual = nearHundredTest.nearHundred(n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void nearHundreTest_3(){
        // Arrange
        n = 89;
        expected = false;

        // Act
        ConditionalsJUnitDrills nearHundredTest = new ConditionalsJUnitDrills();
        actual = nearHundredTest.nearHundred(n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
