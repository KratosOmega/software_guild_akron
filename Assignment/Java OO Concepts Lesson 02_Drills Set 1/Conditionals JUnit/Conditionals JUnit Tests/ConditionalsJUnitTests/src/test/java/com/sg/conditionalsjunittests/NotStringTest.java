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
public class NotStringTest {
    String s, expected, actual;

    @Test
    public void notStringTest_1(){
        // Arrange
        s = "candy";
        expected = "not candy";

        // Act
        ConditionalsJUnitDrills notStringTest = new ConditionalsJUnitDrills();
        actual = notStringTest.notString(s);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void notStringTest_2(){
        // Arrange
        s = "x";
        expected = "not x";

        // Act
        ConditionalsJUnitDrills notStringTest = new ConditionalsJUnitDrills();
        actual = notStringTest.notString(s);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void notStringTest_3(){
        // Arrange
        s = "not bad";
        expected = "not bad";

        // Act
        ConditionalsJUnitDrills notStringTest = new ConditionalsJUnitDrills();
        actual = notStringTest.notString(s);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
