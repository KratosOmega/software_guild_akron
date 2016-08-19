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
public class RemoveDelTest {
    String str, expected, actual;

    @Test
    public void removeDelTest_1(){
        // Arrange
        str = "adelbc";
        expected = "abc";

        // Act
        ConditionalsJUnitDrills removeDelTest = new ConditionalsJUnitDrills();
        actual = removeDelTest.removeDel(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeDelTest_2(){
        // Arrange
        str = "adelHello";
        expected = "aHello";

        // Act
        ConditionalsJUnitDrills removeDelTest = new ConditionalsJUnitDrills();
        actual = removeDelTest.removeDel(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeDelTest_3(){
        // Arrange
        str = "adedbc";
        expected = "adedbc";

        // Act
        ConditionalsJUnitDrills removeDelTest = new ConditionalsJUnitDrills();
        actual = removeDelTest.removeDel(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
