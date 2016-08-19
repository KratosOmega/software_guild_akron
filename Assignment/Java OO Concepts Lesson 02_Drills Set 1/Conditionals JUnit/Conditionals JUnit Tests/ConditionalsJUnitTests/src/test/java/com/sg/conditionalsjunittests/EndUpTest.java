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
public class EndUpTest {
    String str, expected, actual;

    @Test
    public void endUpTest_1(){
        // Arrange
        str = "Hello";
        expected = "HeLLO";

        // Act
        ConditionalsJUnitDrills endUpTest = new ConditionalsJUnitDrills();
        actual = endUpTest.endUp(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void endUpTest_2(){
        // Arrange
        str = "hi there";
        expected = "hi thERE";

        // Act
        ConditionalsJUnitDrills endUpTest = new ConditionalsJUnitDrills();
        actual = endUpTest.endUp(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void endUpTest_3(){
        // Arrange
        str = "hi";
        expected = "HI";

        // Act
        ConditionalsJUnitDrills endUpTest = new ConditionalsJUnitDrills();
        actual = endUpTest.endUp(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
