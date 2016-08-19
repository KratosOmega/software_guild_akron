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
public class MissingCharTest {
    String str, expected, actual;
    int n;

    @Test
    public void missingCharTest_1(){
        // Arrange
        str = "kitten";
        n = 1;
        expected = "ktten";

        // Act
        ConditionalsJUnitDrills missingCharTest = new ConditionalsJUnitDrills();
        actual = missingCharTest.missingChar(str, n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void missingCharTest_2(){
        // Arrange
        str = "kitten";
        n = 0;
        expected = "itten";

        // Act
        ConditionalsJUnitDrills missingCharTest = new ConditionalsJUnitDrills();
        actual = missingCharTest.missingChar(str, n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void missingCharTest_3(){
        // Arrange
        str = "kitten";
        n = 4;
        expected = "kittn";

        // Act
        ConditionalsJUnitDrills missingCharTest = new ConditionalsJUnitDrills();
        actual = missingCharTest.missingChar(str, n);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
