/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.logicjunittests;

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
public class LogicJUnitTests {

    // **************************************************************** greatParty()
    @Test
    public void greatPartyTest_1() {
        // Arrange
        int cigars = 30;
        boolean isWeekend = false;
        boolean expected = false;

        // Act
        LogicJUnitDrills greatPartyTest = new LogicJUnitDrills();
        boolean actual = greatPartyTest.greatParty(cigars, isWeekend);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void greatPartyTest_2() {
        // Arrange
        int cigars = 50;
        boolean isWeekend = false;
        boolean expected = true;

        // Act
        LogicJUnitDrills greatPartyTest = new LogicJUnitDrills();
        boolean actual = greatPartyTest.greatParty(cigars, isWeekend);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void greatPartyTest_3() {
        // Arrange
        int cigars = 70;
        boolean isWeekend = true;
        boolean expected = true;

        // Act
        LogicJUnitDrills greatPartyTest = new LogicJUnitDrills();
        boolean actual = greatPartyTest.greatParty(cigars, isWeekend);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // **************************************************************** canHazTable()
    @Test
    public void canHazTable_Test_1() {
        // Arrange
        int yourStyle = 5;
        int dateStyle = 10;
        int expected = 2;

        // Act
        LogicJUnitDrills canHazTableTest = new LogicJUnitDrills();
        int actual = canHazTableTest.canHazTable(yourStyle, dateStyle);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void canHazTable_Test_2() {
        // Arrange
        int yourStyle = 5;
        int dateStyle = 2;
        int expected = 0;

        // Act
        LogicJUnitDrills canHazTableTest = new LogicJUnitDrills();
        int actual = canHazTableTest.canHazTable(yourStyle, dateStyle);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void canHazTable_Test_3() {
        // Arrange
        int yourStyle = 5;
        int dateStyle = 5;
        int expected = 1;

        // Act
        LogicJUnitDrills canHazTableTest = new LogicJUnitDrills();
        int actual = canHazTableTest.canHazTable(yourStyle, dateStyle);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // **************************************************************** playOutside()
    @Test
    public void playOutsideTest_1() {
        // Arrange
        int temp = 70;
        boolean isSummer = false;
        boolean expected = true;

        // Act
        LogicJUnitDrills playOutsideTest = new LogicJUnitDrills();
        boolean actual = playOutsideTest.playOutside(temp, isSummer);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void playOutsideTest_2() {
        // Arrange
        int temp = 95;
        boolean isSummer = false;
        boolean expected = false;

        // Act
        LogicJUnitDrills playOutsideTest = new LogicJUnitDrills();
        boolean actual = playOutsideTest.playOutside(temp, isSummer);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void playOutsideTest_3() {
        // Arrange
        int temp = 95;
        boolean isSummer = true;
        boolean expected = true;

        // Act
        LogicJUnitDrills playOutsideTest = new LogicJUnitDrills();
        boolean actual = playOutsideTest.playOutside(temp, isSummer);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // **************************************************************** caughtSpeeding()
    @Test
    public void caughtSpeedingTest_1() {
        // Arrange
        int speed = 60;
        boolean isBirthday = false;
        int expected = 0;

        // Act
        LogicJUnitDrills caughtSpeedingTest = new LogicJUnitDrills();
        int actual = caughtSpeedingTest.caughtSpeeding(speed, isBirthday);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void caughtSpeedingTest_2() {
        // Arrange
        int speed = 65;
        boolean isBirthday = false;
        int expected = 1;

        // Act
        LogicJUnitDrills caughtSpeedingTest = new LogicJUnitDrills();
        int actual = caughtSpeedingTest.caughtSpeeding(speed, isBirthday);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void caughtSpeedingTest_3() {
        // Arrange
        int speed = 65;
        boolean isBirthday = true;
        int expected = 0;

        // Act
        LogicJUnitDrills caughtSpeedingTest = new LogicJUnitDrills();
        int actual = caughtSpeedingTest.caughtSpeeding(speed, isBirthday);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // **************************************************************** skipSum()
    @Test
    public void skipSumTest_1() {
        // Arrange
        int a = 3;
        int b = 4;
        int expected = 7;

        // Act
        LogicJUnitDrills skipSumTest = new LogicJUnitDrills();
        int actual = skipSumTest.skipSum(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void skipSumTest_2() {
        // Arrange
        int a = 9;
        int b = 4;
        int expected = 20;

        // Act
        LogicJUnitDrills skipSumTest = new LogicJUnitDrills();
        int actual = skipSumTest.skipSum(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void skipSumTest_3() {
        // Arrange
        int a = 10;
        int b = 11;
        int expected = 21;

        // Act
        LogicJUnitDrills skipSumTest = new LogicJUnitDrills();
        int actual = skipSumTest.skipSum(a, b);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // **************************************************************** alarmClock()

    @Test
    public void alarmClockTest_1() {
        // Arrange
        int day = 1;
        boolean isVacation = false;
        String expected = "7:00";

        // Act
        LogicJUnitDrills alarmClockTest = new LogicJUnitDrills();
        String actual = alarmClockTest.alarmClock(day, isVacation);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void alarmClockTest_2() {
        // Arrange
        int day = 5;
        boolean isVacation = false;
        String expected = "7:00";

        // Act
        LogicJUnitDrills alarmClockTest = new LogicJUnitDrills();
        String actual = alarmClockTest.alarmClock(day, isVacation);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void alarmClockTest_3() {
        // Arrange
        int day = 0;
        boolean isVacation = false;
        String expected = "10:00";

        // Act
        LogicJUnitDrills alarmClockTest = new LogicJUnitDrills();
        String actual = alarmClockTest.alarmClock(day, isVacation);

        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // **************************************************************** loveSix()
    @Test
    public void loveSixTest_1(){
        // Arrange
        int a = 6;
        int b = 4;
        boolean expected = true;
        // Act
        LogicJUnitDrills loveSixTest = new LogicJUnitDrills();
        boolean actual = loveSixTest.loveSix(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void loveSixTest_2(){
        // Arrange
        int a = 4;
        int b = 5;
        boolean expected = false;
        // Act
        LogicJUnitDrills loveSixTest = new LogicJUnitDrills();
        boolean actual = loveSixTest.loveSix(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void loveSixTest_3(){
        // Arrange
        int a = 1;
        int b = 5;
        boolean expected = true;
        // Act
        LogicJUnitDrills loveSixTest = new LogicJUnitDrills();
        boolean actual = loveSixTest.loveSix(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // **************************************************************** inRange()
    @Test
    public void inRangeTest_1(){
        // Arrange
        int n = 5;
        boolean outsideMode = false;
        boolean expected = true;
        // Act
        LogicJUnitDrills inRangeTest = new LogicJUnitDrills();
        boolean actual = inRangeTest.inRange(n, outsideMode);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void inRangeTest_2(){
        // Arrange
        int n = 11;
        boolean outsideMode = false;
        boolean expected = false;
        // Act
        LogicJUnitDrills inRangeTest = new LogicJUnitDrills();
        boolean actual = inRangeTest.inRange(n, outsideMode);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void inRangeTest_3(){
        // Arrange
        int n = 511;
        boolean outsideMode = true;
        boolean expected = true;
        // Act
        LogicJUnitDrills inRangeTest = new LogicJUnitDrills();
        boolean actual = inRangeTest.inRange(n, outsideMode);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // **************************************************************** specialEleven()

    @Test
    public void specialElevenTest_1(){
        // Arrange
        int n = 22;
        boolean expected = true;
        // Act
        LogicJUnitDrills specialElevenTest = new LogicJUnitDrills();
        boolean actual = specialElevenTest.specialEleven(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void specialElevenTest_2(){
        // Arrange
        int n = 23;
        boolean expected = true;
        // Act
        LogicJUnitDrills specialElevenTest = new LogicJUnitDrills();
        boolean actual = specialElevenTest.specialEleven(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void specialElevenTest_3(){
        // Arrange
        int n = 24;
        boolean expected = false;
        // Act
        LogicJUnitDrills specialElevenTest = new LogicJUnitDrills();
        boolean actual = specialElevenTest.specialEleven(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    // **************************************************************** mod20()
    @Test
    public void mod20Test_1(){
        // Arrange
        int n = 20;
        boolean expected = false;
        // Act
        LogicJUnitDrills mod20Test = new LogicJUnitDrills();
        boolean actual = mod20Test.mod20(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void mod20Test_2(){
        // Arrange
        int n = 21;
        boolean expected = true;
        // Act
        LogicJUnitDrills mod20Test = new LogicJUnitDrills();
        boolean actual = mod20Test.mod20(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void mod20Test_3(){
        // Arrange
        int n = 22;
        boolean expected = true;
        // Act
        LogicJUnitDrills mod20Test = new LogicJUnitDrills();
        boolean actual = mod20Test.mod20(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    // **************************************************************** mod35()
    @Test
    public void Test_1(){
        // Arrange
        int n = 3;
        boolean expected = true;
        // Act
        LogicJUnitDrills mod35Test = new LogicJUnitDrills();
        boolean actual = mod35Test.mod35(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void Test_2(){
        // Arrange
        int n = 10;
        boolean expected = true;
        // Act
        LogicJUnitDrills mod35Test = new LogicJUnitDrills();
        boolean actual = mod35Test.mod35(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void Test_3(){
        // Arrange
        int n = 15;
        boolean expected = false;
        // Act
        LogicJUnitDrills mod35Test = new LogicJUnitDrills();
        boolean actual = mod35Test.mod35(n);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }
    // **************************************************************** answerCell()
    @Test
    public void answerCellTest_1(){
        // Arrange
        boolean isMorning = false;
        boolean isMom = false;
        boolean isAsleep = false;
        boolean expected = true;
        // Act
        LogicJUnitDrills answerCellTest = new LogicJUnitDrills();
        boolean actual = answerCellTest.answerCell(isMorning, isMom, isAsleep);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void answerCellTest_2(){
        // Arrange
        boolean isMorning = false;
        boolean isMom = false;
        boolean isAsleep = true;
        boolean expected = false;
        // Act
        LogicJUnitDrills answerCellTest = new LogicJUnitDrills();
        boolean actual = answerCellTest.answerCell(isMorning, isMom, isAsleep);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void answerCellTest_3(){
        // Arrange
        boolean isMorning = true;
        boolean isMom = false;
        boolean isAsleep = false;
        boolean expected = false;
        // Act
        LogicJUnitDrills answerCellTest = new LogicJUnitDrills();
        boolean actual = answerCellTest.answerCell(isMorning, isMom, isAsleep);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }
    // **************************************************************** twoIsOne()
    @Test
    public void twoIsOneTest_1(){
        // Arrange
        int a = 1;
        int b = 2;
        int c = 3;
        boolean expected = true;
        // Act
        LogicJUnitDrills twoIsOneTest = new LogicJUnitDrills();
        boolean actual = twoIsOneTest.twoIsOne(a, b, c);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void twoIsOneTest_2(){
        // Arrange
        int a = 3;
        int b = 1;
        int c = 2;
        boolean expected = true;
        // Act
        LogicJUnitDrills twoIsOneTest = new LogicJUnitDrills();
        boolean actual = twoIsOneTest.twoIsOne(a, b, c);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void twoIsOneTest_3(){
        // Arrange
        int a = 3;
        int b = 2;
        int c = 2;
        boolean expected = false;
        // Act
        LogicJUnitDrills twoIsOneTest = new LogicJUnitDrills();
        boolean actual = twoIsOneTest.twoIsOne(a, b, c);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    // **************************************************************** areInOrder()
    @Test
    public void areInOrderTest_1(){
        // Arrange
        int a = 1;
        int b = 2;
        int c = 4;
        boolean bOk = false;
        boolean expected = true;
        // Act
        LogicJUnitDrills areInOrderTest = new LogicJUnitDrills();
        boolean actual = areInOrderTest.areInOrder(a, b, c, bOk);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void areInOrderTest_2(){
        // Arrange
        int a = 1;
        int b = 2;
        int c = 1;
        boolean bOk = false;
        boolean expected = false;
        // Act
        LogicJUnitDrills areInOrderTest = new LogicJUnitDrills();
        boolean actual = areInOrderTest.areInOrder(a, b, c, bOk);
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void areInOrderTest_3(){
        // Arrange
        int a = 1;
        int b = 1;
        int c = 2;
        boolean bOk = true;
        boolean expected = true;
        // Act
        LogicJUnitDrills areInOrderTest = new LogicJUnitDrills();
        boolean actual = areInOrderTest.areInOrder(a, b, c, bOk);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    // **************************************************************** inOrderEquals()
    @Test
    public void inOrderEqualsTest_1(){
        // Arrange
        int a = 2;
        int b = 5;
        int c = 11;
        boolean equalOk = false;
        boolean expected = true;
        // Act
        LogicJUnitDrills inOrderEqualTest = new LogicJUnitDrills();
        boolean actual = inOrderEqualTest.inOrderEqual(a, b, c, equalOk);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void inOrderEqualsTest_2(){
        // Arrange
        int a = 5;
        int b = 7;
        int c = 6;
        boolean equalOk = false;
        boolean expected = false;
        // Act
        LogicJUnitDrills inOrderEqualTest = new LogicJUnitDrills();
        boolean actual = inOrderEqualTest.inOrderEqual(a, b, c, equalOk);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void inOrderEqualsTest_3(){
        // Arrange
        int a = 5;
        int b = 5;
        int c = 7;
        boolean equalOk = true;
        boolean expected = true;
        // Act
        LogicJUnitDrills inOrderEqualTest = new LogicJUnitDrills();
        boolean actual = inOrderEqualTest.inOrderEqual(a, b, c, equalOk);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }
    // **************************************************************** lastDigit()
    @Test
    public void lastDigitTest_1(){
        // Arrange
        int a = 23;
        int b = 19;
        int c = 13;
        boolean expected = true;
        // Act
        LogicJUnitDrills lastDigitTest = new LogicJUnitDrills();
        boolean actual = lastDigitTest.lastDigit(a, b, c);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void lastDigitTest_2(){
        // Arrange
        int a = 23;
        int b = 19;
        int c = 12;
        boolean expected = false;
        // Act
        LogicJUnitDrills lastDigitTest = new LogicJUnitDrills();
        boolean actual = lastDigitTest.lastDigit(a, b, c);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void lastDigitTest_3(){
        // Arrange
        int a = 23;
        int b = 19;
        int c = 3;
        boolean expected = true;
        // Act
        LogicJUnitDrills lastDigitTest = new LogicJUnitDrills();
        boolean actual = lastDigitTest.lastDigit(a, b, c);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    // **************************************************************** rollDice()
    @Test
    public void rollDiceTest_1(){
        // Arrange
        int die1 = 2;
        int die2 = 3;
        boolean noDoubles = true;
        int expected = 5;
        // Act
        LogicJUnitDrills rollDiceTest = new LogicJUnitDrills();
        int actual = rollDiceTest.rollDice(die1, die2, noDoubles);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void rollDiceTest_2(){
        // Arrange
        int die1 = 3;
        int die2 = 3;
        boolean noDoubles = true;
        int expected = 7;
        // Act
        LogicJUnitDrills rollDiceTest = new LogicJUnitDrills();
        int actual = rollDiceTest.rollDice(die1, die2, noDoubles);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }

    @Test
    public void rollDiceTest_3(){
        // Arrange
        int die1 = 3;
        int die2 = 3;
        boolean noDoubles = false;
        int expected = 6;
        // Act
        LogicJUnitDrills rollDiceTest = new LogicJUnitDrills();
        int actual = rollDiceTest.rollDice(die1, die2, noDoubles);
        // Assert
        org.junit.Assert.assertEquals(expected,actual);
    }
}
