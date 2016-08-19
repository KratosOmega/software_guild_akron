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
public class Makes10Test {
    int a, b;
    boolean expected, actual;

    @Test
    public void makes10Test_1(){
        // Arrange
        a = 9;
        b = 10;
        expected = true;

        // Act
        ConditionalsJUnitDrills makes10Test = new ConditionalsJUnitDrills();
        actual = makes10Test.makes10(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void makes10Test_2(){
        // Arrange
        a = 9;
        b = 9;
        expected = false;

        // Act
        ConditionalsJUnitDrills makes10Test = new ConditionalsJUnitDrills();
        actual = makes10Test.makes10(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void makes10Test_3(){
        // Arrange
        a = 1;
        b = 9;
        expected = true;

        // Act
        ConditionalsJUnitDrills makes10Test = new ConditionalsJUnitDrills();
        actual = makes10Test.makes10(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
