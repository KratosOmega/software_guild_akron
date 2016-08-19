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
public class MaxTest {
    int a, b, c, expected, actual;

    @Test
    public void maxTest_1(){
        // Arragne
        a = 1;
        b = 2;
        c = 3;
        expected = 3;

        // Act
        ConditionalsJUnitDrills maxTest = new ConditionalsJUnitDrills();
        actual = maxTest.max(a, b, c);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxTest_2(){
        // Arragne
        a = 1;
        b = 3;
        c = 2;
        expected = 3;

        // Act
        ConditionalsJUnitDrills maxTest = new ConditionalsJUnitDrills();
        actual = maxTest.max(a, b, c);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void maxTest_3(){
        // Arragne
        a = 3;
        b = 2;
        c = 1;
        expected = 3;

        // Act
        ConditionalsJUnitDrills maxTest = new ConditionalsJUnitDrills();
        actual = maxTest.max(a, b, c);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
