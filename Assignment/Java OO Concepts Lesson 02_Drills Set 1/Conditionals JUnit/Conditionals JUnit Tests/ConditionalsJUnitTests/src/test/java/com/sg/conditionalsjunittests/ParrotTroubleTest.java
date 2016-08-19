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
public class ParrotTroubleTest {
    int hour;
    boolean isTalking, expected, actual;

    @Test
    public void parrotTroubleTest_1(){
        // Arrange
        hour = 6;
        isTalking = true;
        expected = true;

        // Act
        ConditionalsJUnitDrills parrotTroubleTest = new ConditionalsJUnitDrills();
        actual = parrotTroubleTest.parrotTrouble(isTalking, hour);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void parrotTroubleTest_2(){
        // Arrange
        hour = 7;
        isTalking = true;
        expected = false;

        // Act
        ConditionalsJUnitDrills parrotTroubleTest = new ConditionalsJUnitDrills();
        actual = parrotTroubleTest.parrotTrouble(isTalking, hour);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }


    @Test
    public void parrotTroubleTest_3(){
        // Arrange
        hour = 6;
        isTalking = false;
        expected = false;

        // Act
        ConditionalsJUnitDrills parrotTroubleTest = new ConditionalsJUnitDrills();
        actual = parrotTroubleTest.parrotTrouble(isTalking, hour);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
