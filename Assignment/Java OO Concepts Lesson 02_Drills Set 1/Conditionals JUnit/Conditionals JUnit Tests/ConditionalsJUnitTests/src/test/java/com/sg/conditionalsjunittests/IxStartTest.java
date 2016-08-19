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
public class IxStartTest {
    String str;
    boolean expected, actual;

    @Test
    public void ixStartTest_1(){
        // Arrange
        str = "mix snacks";
        expected = true;

        // Act
        ConditionalsJUnitDrills ixStartTest = new ConditionalsJUnitDrills();
        actual = ixStartTest.ixStart(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void ixStartTest_2(){
        // Arrange
        str = "pix snacks";
        expected = true;

        // Act
        ConditionalsJUnitDrills ixStartTest = new ConditionalsJUnitDrills();
        actual = ixStartTest.ixStart(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void ixStartTest_3(){
        // Arrange
        str = "piz snacks";
        expected = false;

        // Act
        ConditionalsJUnitDrills ixStartTest = new ConditionalsJUnitDrills();
        actual = ixStartTest.ixStart(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
