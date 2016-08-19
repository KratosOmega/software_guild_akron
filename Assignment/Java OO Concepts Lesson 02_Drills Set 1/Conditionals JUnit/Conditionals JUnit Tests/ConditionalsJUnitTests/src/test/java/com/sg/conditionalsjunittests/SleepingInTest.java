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
public class SleepingInTest {
    boolean isWeekday, isVacation, expected, actual;

    @Test
    public void passTest_CanSleepIn_1(){
        // Arrange
        isWeekday = false;
        isVacation = false;
        expected = true;

        // Act
        ConditionalsJUnitDrills canSleepInTest = new ConditionalsJUnitDrills();
        actual = canSleepInTest.canSleepIn(isWeekday, isVacation);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void passTest_CanSleepIn_2(){
        // Arrange
        isWeekday = false;
        isVacation = true;
        expected = true;

        // Act
        ConditionalsJUnitDrills canSleepInTest = new ConditionalsJUnitDrills();
        actual = canSleepInTest.canSleepIn(isWeekday, isVacation);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void failTest_CanSleepIn_1(){
        // Arrange
        isWeekday = true;
        isVacation = false;
        expected = false;

        // Act
        ConditionalsJUnitDrills canSleepInTest = new ConditionalsJUnitDrills();
        actual = canSleepInTest.canSleepIn(isWeekday, isVacation);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
