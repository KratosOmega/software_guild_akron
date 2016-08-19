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
public class Front3Test {
    String str, expected, actual;

    @Test
    public void front3Test_1(){
        // Arrange
        str = "Microsfot";
        expected = "MicMicMic";

        // Act
        ConditionalsJUnitDrills front3Test = new ConditionalsJUnitDrills();
        actual = front3Test.front3(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void front3Test_2(){
        // Arrange
        str = "Chocolate";
        expected = "ChoChoCho";

        // Act
        ConditionalsJUnitDrills front3Test = new ConditionalsJUnitDrills();
        actual = front3Test.front3(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void front3Test_3(){
        // Arrange
        str = "at";
        expected = "atatat";

        // Act
        ConditionalsJUnitDrills front3Test = new ConditionalsJUnitDrills();
        actual = front3Test.front3(str);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
