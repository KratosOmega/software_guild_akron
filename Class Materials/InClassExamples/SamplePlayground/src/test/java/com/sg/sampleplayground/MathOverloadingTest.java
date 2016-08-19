/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sampleplayground;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author softwareguild
 */
public class MathOverloadingTest {
    
    public MathOverloadingTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void addIntDoubleTest(){
        // Arrange
        int num1 = 5;
        double num2 = 3.14;
        double expected = 8.14;
        // Act
        MathOverloading math = new MathOverloading();
        double actual = math.add(num1, num2);
        // Assert
        Assert.assertEquals(expected, actual,0.0);
    }
}
