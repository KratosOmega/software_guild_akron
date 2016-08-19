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
public class BackAroundTest {
    String str, expected, actual;

    @Test
    public void backAroundTest_1(){
        // Arrange
        str = "cat";
        expected = "tcatt";

        // Act
        ConditionalsJUnitDrills backAroundTest = new ConditionalsJUnitDrills();
        actual = backAroundTest.backAround(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void backAroundTest_2(){
        // Arrange
        str = "Hello";
        expected = "oHelloo";

        // Act
        ConditionalsJUnitDrills backAroundTest = new ConditionalsJUnitDrills();
        actual = backAroundTest.backAround(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void backAroundTest_3(){
        // Arrange
        str = "a";
        expected = "aaa";

        // Act
        ConditionalsJUnitDrills backAroundTest = new ConditionalsJUnitDrills();
        actual = backAroundTest.backAround(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
