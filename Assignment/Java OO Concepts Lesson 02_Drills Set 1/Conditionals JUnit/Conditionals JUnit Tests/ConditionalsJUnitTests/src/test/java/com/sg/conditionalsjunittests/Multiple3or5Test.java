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
public class Multiple3or5Test {
    int number;
    boolean expected, actual;

    @Test
    public void multiple3or5Test_1(){
        // Arrange
        number = 3;
        expected = true;

        // Act
        ConditionalsJUnitDrills multiple3or5Test = new ConditionalsJUnitDrills();
        actual = multiple3or5Test.multiple3or5(number);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiple3or5Test_2(){
        // Arrange
        number = 10;
        expected = true;

        // Act
        ConditionalsJUnitDrills multiple3or5Test = new ConditionalsJUnitDrills();
        actual = multiple3or5Test.multiple3or5(number);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiple3or5Test_3(){
        // Arrange
        number = 8;
        expected = false;

        // Act
        ConditionalsJUnitDrills multiple3or5Test = new ConditionalsJUnitDrills();
        actual = multiple3or5Test.multiple3or5(number);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
