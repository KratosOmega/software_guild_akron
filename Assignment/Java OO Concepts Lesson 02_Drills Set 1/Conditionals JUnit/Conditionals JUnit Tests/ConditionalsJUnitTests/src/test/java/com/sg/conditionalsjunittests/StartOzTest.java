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
public class StartOzTest {
    String str, expected, actual;

    @Test
    public void startOzTest_1(){
        // Arrange
        str = "ozymandias";
        expected = "oz";

        // Act
        ConditionalsJUnitDrills startOzTest = new ConditionalsJUnitDrills();
        actual = startOzTest.startOz(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void startOzTest_2(){
        // Arrange
        str = "bzoo";
        expected = "z";

        // Act
        ConditionalsJUnitDrills startOzTest = new ConditionalsJUnitDrills();
        actual = startOzTest.startOz(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void startOzTest_3(){
        // Arrange
        str = "oxx";
        expected = "o";

        // Act
        ConditionalsJUnitDrills startOzTest = new ConditionalsJUnitDrills();
        actual = startOzTest.startOz(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
