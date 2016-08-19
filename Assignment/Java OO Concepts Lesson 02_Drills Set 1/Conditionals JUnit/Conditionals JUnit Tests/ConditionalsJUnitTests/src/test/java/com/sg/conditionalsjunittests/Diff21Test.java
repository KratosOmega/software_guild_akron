/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.conditionalsjunittests;

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
public class Diff21Test {
    int n, expected, actual;

    @Test
    public void diff21Test_1(){
        // Arrange
        n = 23;
        expected = 4;

        // Act
        ConditionalsJUnitDrills diff21Test = new ConditionalsJUnitDrills();
        actual = diff21Test.diff21(n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void diff21Test_2(){
        // Arrange
        n = 10;
        expected = 11;

        // Act
        ConditionalsJUnitDrills diff21Test = new ConditionalsJUnitDrills();
        actual = diff21Test.diff21(n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void diff21Test_3(){
        // Arrange
        n = 21;
        expected = 0;

        // Act
        ConditionalsJUnitDrills diff21Test = new ConditionalsJUnitDrills();
        actual = diff21Test.diff21(n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
