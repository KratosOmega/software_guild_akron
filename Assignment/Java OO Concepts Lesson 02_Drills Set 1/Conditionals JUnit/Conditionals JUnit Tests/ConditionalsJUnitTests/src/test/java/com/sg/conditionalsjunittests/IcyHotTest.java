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
public class IcyHotTest {
    int temp1, temp2;
    boolean expected, actual;

    @Test
    public void icyHotTest_1(){
        // Arrange
        temp1 = 120;
        temp2 = -1;
        expected = true;

        // Act
        ConditionalsJUnitDrills icyHotTest = new ConditionalsJUnitDrills();
        actual = icyHotTest.icyHot(temp1, temp2);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void icyHotTest_2(){
        // Arrange
        temp1 = -1;
        temp2 = 120;
        expected = true;

        // Act
        ConditionalsJUnitDrills icyHotTest = new ConditionalsJUnitDrills();
        actual = icyHotTest.icyHot(temp1, temp2);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void icyHotTest_3(){
        // Arrange
        temp1 = 2;
        temp2 = 120;
        expected = false;

        // Act
        ConditionalsJUnitDrills icyHotTest = new ConditionalsJUnitDrills();
        actual = icyHotTest.icyHot(temp1, temp2);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
