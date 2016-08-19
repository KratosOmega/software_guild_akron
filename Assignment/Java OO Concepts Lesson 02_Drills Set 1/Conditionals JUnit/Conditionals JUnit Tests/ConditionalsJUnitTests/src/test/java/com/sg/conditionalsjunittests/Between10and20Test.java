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
public class Between10and20Test {
    int a, b;
    boolean expected, actual;

    @Test
    public void between10and20Test_1(){
        // Arrange
        a = 12;
        b = 99;
        expected = true;

        // Act
        ConditionalsJUnitDrills between10and20Test = new ConditionalsJUnitDrills();
        actual = between10and20Test.between10and20(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void between10and20Test_2(){
        // Arrange
        a = 21;
        b = 12;
        expected = true;

        // Act
        ConditionalsJUnitDrills between10and20Test = new ConditionalsJUnitDrills();
        actual = between10and20Test.between10and20(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void between10and20Test_3(){
        // Arrange
        a = 8;
        b = 99;
        expected = false;

        // Act
        ConditionalsJUnitDrills between10and20Test = new ConditionalsJUnitDrills();
        actual = between10and20Test.between10and20(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
