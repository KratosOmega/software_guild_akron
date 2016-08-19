/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_vendingmachine.operation;

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
public class DataFormatConverterTest {
    DataFormatConverter converter;
    // ----------------------------------------------------------------------------- convertStringToInt() Test
    // Ex: 1 -> 100
    // Ex: 1.00 -> 100
    // EX: 0.99 -> 99
    // Ex: 0.02 -> 2
    // EX: 1.12 -> 112
    
    @Test
    public void convertStringToIntTest_1(){
        // Arrange
        String money = "1";
        int expected = 100;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertStringToIntTest_2(){
        // Arrange
        String money = "1.00";
        int expected = 100;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertStringToIntTest_3(){
        // Arrange
        String money = "0.99";
        int expected = 99;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertStringToIntTest_4(){
        // Arrange
        String money = "0.02";
        int expected = 2;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertStringToIntTest_5(){
        // Arrange
        String money = "1.12";
        int expected = 112;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertStringToIntTest_6(){
        // Arrange
        String money = "1.02";
        int expected = 102;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertStringToIntTest_7(){
        // Arrange
        String money = "0.00";
        int expected = 0;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    
    
    @Test
    public void convertStringToIntTest_8(){
        // Arrange
        String money = "-10";
        int expected = -1;
        // Act
        converter = new DataFormatConverter();
        int actual = converter.numberFormater_2Decimal_StringToInteger(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    // ----------------------------------------------------------------------------- convertIntToString()
    // Ex: 100 -> 1.00
    // Ex; 99 -> 0.99
    // Ex: 2 -> 0.02
    // Ex: 1020 -> 10.20
    @Test
    public void convertIntToStringTest_1(){
        // Arrange
        int money = 100;
        String expected = "1.00";
        // Act
        converter = new DataFormatConverter();
        String actual = converter.numberFormater_2Decimal_IntegerToString(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertIntToStringTest_2(){
        // Arrange
        int money = 99;
        String expected = "0.99";
        // Act
        converter = new DataFormatConverter();
        String actual = converter.numberFormater_2Decimal_IntegerToString(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertIntToStringTest_3(){
        // Arrange
        int money = 2;
        String expected = "0.02";
        // Act
        converter = new DataFormatConverter();
        String actual = converter.numberFormater_2Decimal_IntegerToString(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void convertIntToStringTest_4(){
        // Arrange
        int money = 1020;
        String expected = "10.20";
        // Act
        converter = new DataFormatConverter();
        String actual = converter.numberFormater_2Decimal_IntegerToString(money);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    
    
    
    
    
//    public String convertIntToString(int money) {
//        String moneyInString = "";
//        String[] numList = (money + "").split("");
//
//        if (money >= 100) {
//            for (int i = 0; i < numList.length; i++) {
//                if (i == numList.length - 2) {
//                    moneyInString += "." + numList[i];
//                } else {
//                    moneyInString += numList[i];
//                }
//            }
//            return moneyInString;
//        } else {
//            return "0." + numList[0] + numList[1];
//        }
//    }
}
