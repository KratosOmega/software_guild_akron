/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.loopsjunittests;

import org.junit.Test;

/**
 *
 * @author Kratos
 */
public class LoopsJUnitTests {

    // ************************************************ stringTimes()
    @Test
    public void stringTimesTest_1() {
        // Arrange
        String str = "Hi";
        int n = 2;
        String expected = "HiHi";
        // Act
        LoopsJUnitDrills stringTimesTest = new LoopsJUnitDrills();
        String actual = stringTimesTest.stringTimes(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringTimesTest_2() {
        // Arrange
        String str = "Hi";
        int n = 3;
        String expected = "HiHiHi";
        // Act
        LoopsJUnitDrills stringTimesTest = new LoopsJUnitDrills();
        String actual = stringTimesTest.stringTimes(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringTimesTest_3() {
        // Arrange
        String str = "Hi";
        int n = 1;
        String expected = "Hi";
        // Act
        LoopsJUnitDrills stringTimesTest = new LoopsJUnitDrills();
        String actual = stringTimesTest.stringTimes(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ frontTimes()
    @Test
    public void frontTimesTest_1() {
        // Arrange
        String str = "Chocolate";
        int n = 2;
        String expected = "ChoCho";
        // Act
        LoopsJUnitDrills frontTimesTest = new LoopsJUnitDrills();
        String actual = frontTimesTest.frontTimes(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontTimesTest_2() {
        // Arrange
        String str = "Chocolate";
        int n = 3;
        String expected = "ChoChoCho";
        // Act
        LoopsJUnitDrills frontTimesTest = new LoopsJUnitDrills();
        String actual = frontTimesTest.frontTimes(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontTimesTest_3() {
        // Arrange
        String str = "Abc";
        int n = 3;
        String expected = "AbcAbcAbc";
        // Act
        LoopsJUnitDrills frontTimesTest = new LoopsJUnitDrills();
        String actual = frontTimesTest.frontTimes(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ countXX()
    @Test
    public void countXXTest_1() {
        // Arrange
        String str = "abcxx";
        int expected = 1;
        // Act
        LoopsJUnitDrills countXXTest = new LoopsJUnitDrills();
        int actual = countXXTest.countXX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void countXXTest_2() {
        // Arrange
        String str = "xxx";
        int expected = 2;
        // Act
        LoopsJUnitDrills countXXTest = new LoopsJUnitDrills();
        int actual = countXXTest.countXX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void countXXTest_3() {
        // Arrange
        String str = "xxxx";
        int expected = 3;
        // Act
        LoopsJUnitDrills countXXTest = new LoopsJUnitDrills();
        int actual = countXXTest.countXX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ doubleX()
    @Test
    public void doubleXTest_1() {
        // Arrange
        String str = "axxbb";
        boolean expected = true;
        // Act
        LoopsJUnitDrills doubleXTest = new LoopsJUnitDrills();
        boolean actual = doubleXTest.doubleX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void doubleXTest_2() {
        // Arrange
        String str = "axaxxax";
        boolean expected = false;
        // Act
        LoopsJUnitDrills doubleXTest = new LoopsJUnitDrills();
        boolean actual = doubleXTest.doubleX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void doubleXTest_3() {
        // Arrange
        String str = "xxxxx";
        boolean expected = true;
        // Act
        LoopsJUnitDrills doubleXTest = new LoopsJUnitDrills();
        boolean actual = doubleXTest.doubleX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ everyOther()
    @Test
    public void everyOtherTest_1() {
        // Arrange
        String str = "Hello";
        String expected = "Hlo";
        // Act
        LoopsJUnitDrills everyOtherTest = new LoopsJUnitDrills();
        String actual = everyOtherTest.everyOther(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void everyOtherTest_2() {
        // Arrange
        String str = "Hi";
        String expected = "H";
        // Act
        LoopsJUnitDrills everyOtherTest = new LoopsJUnitDrills();
        String actual = everyOtherTest.everyOther(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void everyOtherTest_3() {
        // Arrange
        String str = "Heeololeo";
        String expected = "Hello";
        // Act
        LoopsJUnitDrills everyOtherTest = new LoopsJUnitDrills();
        String actual = everyOtherTest.everyOther(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ stringSplosion()
    @Test
    public void stringSpolosionTest_1() {
        // Arrange
        String str = "Code";
        String expected = "CCoCodCode";
        // Act
        LoopsJUnitDrills stringSpolosionTest = new LoopsJUnitDrills();
        String actual = stringSpolosionTest.stringSplosion(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringSpolosionTest_2() {
        // Arrange
        String str = "abc";
        String expected = "aababc";
        // Act
        LoopsJUnitDrills stringSpolosionTest = new LoopsJUnitDrills();
        String actual = stringSpolosionTest.stringSplosion(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringSpolosionTest_3() {
        // Arrange
        String str = "ab";
        String expected = "aab";
        // Act
        LoopsJUnitDrills stringSpolosionTest = new LoopsJUnitDrills();
        String actual = stringSpolosionTest.stringSplosion(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ countLast2()
    @Test
    public void countLast2Test_1() {
        // Arrange
        String str = "hixxhi";
        int expected = 1;
        // Act
        LoopsJUnitDrills countLast2Test = new LoopsJUnitDrills();
        int actual = countLast2Test.countLast2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void countLast2Test_2() {
        // Arrange
        String str = "xaxxaxaxx";
        int expected = 1;
        // Act
        LoopsJUnitDrills countLast2Test = new LoopsJUnitDrills();
        int actual = countLast2Test.countLast2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void countLast2Test_3() {
        // Arrange
        String str = "axxxaaxx";
        int expected = 2;
        // Act
        LoopsJUnitDrills countLast2Test = new LoopsJUnitDrills();
        int actual = countLast2Test.countLast2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ count9()
    @Test
    public void count9Test_1() {
        // Arrange
        int[] numbers = {1, 2, 9};
        int expected = 1;
        // Act
        LoopsJUnitDrills count9Test = new LoopsJUnitDrills();
        int actual = count9Test.count9(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void count9Test_2() {
        // Arrange
        int[] numbers = {1, 9, 9};
        int expected = 2;
        // Act
        LoopsJUnitDrills count9Test = new LoopsJUnitDrills();
        int actual = count9Test.count9(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void count9Test_3() {
        // Arrange
        int[] numbers = {1, 9, 9, 3, 9};
        int expected = 3;
        // Act
        LoopsJUnitDrills count9Test = new LoopsJUnitDrills();
        int actual = count9Test.count9(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ arrayFront9()
    @Test
    public void arrayFront9Test_1() {
        // Arrange
        int[] numbers = {1, 2, 9, 3, 4};
        boolean expected = true;
        // Act
        LoopsJUnitDrills arrayFront9Test = new LoopsJUnitDrills();
        boolean actual = arrayFront9Test.arrayFront9(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void arrayFront9Test_2() {
        // Arrange
        int[] numbers = {1, 2, 3, 4, 9};
        boolean expected = false;
        // Act
        LoopsJUnitDrills arrayFront9Test = new LoopsJUnitDrills();
        boolean actual = arrayFront9Test.arrayFront9(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void arrayFront9Test_3() {
        // Arrange
        int[] numbers = {1, 2, 3, 4, 5};
        boolean expected = false;
        // Act
        LoopsJUnitDrills arrayFront9Test = new LoopsJUnitDrills();
        boolean actual = arrayFront9Test.arrayFront9(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ array123()
    @Test
    public void array123Test_1() {
        // Arrange
        int[] numbers = {1, 1, 2, 3, 1};
        boolean expected = true;
        // Act
        LoopsJUnitDrills array123Test = new LoopsJUnitDrills();
        boolean actual = array123Test.array123(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void array123Test_2() {
        // Arrange
        int[] numbers = {1, 1, 2, 4, 1};
        boolean expected = false;
        // Act
        LoopsJUnitDrills array123Test = new LoopsJUnitDrills();
        boolean actual = array123Test.array123(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void array123Test_3() {
        // Arrange
        int[] numbers = {1, 1, 2, 1, 2, 3};
        boolean expected = true;
        // Act
        LoopsJUnitDrills array123Test = new LoopsJUnitDrills();
        boolean actual = array123Test.array123(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ subStringMatch()
    @Test
    public void subStringMatchTest_1() {
        // Arrange
        String a = "xxcaazz";
        String b = "xxbaaz";
        int expected = 3;
        // Act
        LoopsJUnitDrills subStringMatchTest = new LoopsJUnitDrills();
        int actual = subStringMatchTest.subStringMatch(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void subStringMatchTest_2() {
        // Arrange
        String a = "abc";
        String b = "abc";
        int expected = 2;
        // Act
        LoopsJUnitDrills subStringMatchTest = new LoopsJUnitDrills();
        int actual = subStringMatchTest.subStringMatch(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void subStringMatchTest_3() {
        // Arrange
        String a = "abc";
        String b = "axc";
        int expected = 0;
        // Act
        LoopsJUnitDrills subStringMatchTest = new LoopsJUnitDrills();
        int actual = subStringMatchTest.subStringMatch(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ stringX()
    @Test
    public void stringXTest_1() {
        // Arrange
        String str = "xxHxix";
        String expected = "xHix";
        // Act
        LoopsJUnitDrills stringXTest = new LoopsJUnitDrills();
        String actual = stringXTest.stringX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringXTest_2() {
        // Arrange
        String str = "abxxxcd";
        String expected = "abcd";
        // Act
        LoopsJUnitDrills stringXTest = new LoopsJUnitDrills();
        String actual = stringXTest.stringX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringXTest_3() {
        // Arrange
        String str = "xabxxxcdx";
        String expected = "xabcdx";
        // Act
        LoopsJUnitDrills stringXTest = new LoopsJUnitDrills();
        String actual = stringXTest.stringX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ altPairs()
    @Test
    public void altPairsTest_1() {
        // Arrange
        String str = "kitten";
        String expected = "kien";
        // Act
        LoopsJUnitDrills altPairsTest = new LoopsJUnitDrills();
        String actual = altPairsTest.altPairs(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void altPairsTest_2() {
        // Arrange
        String str = "Chocolate";
        String expected = "Chole";
        // Act
        LoopsJUnitDrills altPairsTest = new LoopsJUnitDrills();
        String actual = altPairsTest.altPairs(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void altPairsTest_3() {
        // Arrange
        String str = "CodingHorror";
        String expected = "Congrr";
        // Act
        LoopsJUnitDrills altPairsTest = new LoopsJUnitDrills();
        String actual = altPairsTest.altPairs(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ doNotYak()
    @Test
    public void doNotYakTest_1() {
        // Arrange
        String str = "yakpak";
        String expected = "pak";
        // Act
        LoopsJUnitDrills doNotTakTest = new LoopsJUnitDrills();
        String actual = doNotTakTest.doNotYak(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void doNotYakTest_2() {
        // Arrange
        String str = "pakyak";
        String expected = "pak";
        // Act
        LoopsJUnitDrills doNotTakTest = new LoopsJUnitDrills();
        String actual = doNotTakTest.doNotYak(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void doNotYakTest_3() {
        // Arrange
        String str = "yak123ya";
        String expected = "123ya";
        // Act
        LoopsJUnitDrills doNotTakTest = new LoopsJUnitDrills();
        String actual = doNotTakTest.doNotYak(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ array667()
    @Test
    public void array667Test_1() {
        // Arrange
        int[] numbers = {6, 6, 2};
        int expected = 1;
        // Act
        LoopsJUnitDrills array667Test = new LoopsJUnitDrills();
        int actual = array667Test.array667(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void array667Test_2() {
        // Arrange
        int[] numbers = {6, 6, 2, 6};
        int expected = 1;
        // Act
        LoopsJUnitDrills array667Test = new LoopsJUnitDrills();
        int actual = array667Test.array667(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void array667Test_3() {
        // Arrange
        int[] numbers = {6, 7, 2, 6};
        int expected = 1;
        // Act
        LoopsJUnitDrills array667Test = new LoopsJUnitDrills();
        int actual = array667Test.array667(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ noTriples()
    @Test
    public void noTriplesTest_1() {
        // Arrange
        int[] numbers = {1, 1, 2, 2, 1};
        boolean expected = true;
        // Act
        LoopsJUnitDrills noTriplesTest = new LoopsJUnitDrills();
        boolean actual = noTriplesTest.noTriples(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void noTriplesTest_2() {
        // Arrange
        int[] numbers = {1, 1, 2, 2, 2, 1};
        boolean expected = false;
        // Act
        LoopsJUnitDrills noTriplesTest = new LoopsJUnitDrills();
        boolean actual = noTriplesTest.noTriples(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void noTriplesTest_3() {
        // Arrange
        int[] numbers = {1, 1, 1, 2, 2, 2, 1};
        boolean expected = false;
        // Act
        LoopsJUnitDrills noTriplesTest = new LoopsJUnitDrills();
        boolean actual = noTriplesTest.noTriples(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ pattern51()
    @Test
    public void pattern51Test_1() {
        // Arrange
        int[] numbers = {1, 2, 7, 1};
        boolean expected = true;
        // Act
        LoopsJUnitDrills pattern51Test = new LoopsJUnitDrills();
        boolean actual = pattern51Test.pattern51(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void pattern51Test_2() {
        // Arrange
        int[] numbers = {1, 2, 8, 1};
        boolean expected = false;
        // Act
        LoopsJUnitDrills pattern51Test = new LoopsJUnitDrills();
        boolean actual = pattern51Test.pattern51(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void pattern51Test_3() {
        // Arrange
        int[] numbers = {2, 7, 1};
        boolean expected = true;
        // Act
        LoopsJUnitDrills pattern51Test = new LoopsJUnitDrills();
        boolean actual = pattern51Test.pattern51(numbers);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
