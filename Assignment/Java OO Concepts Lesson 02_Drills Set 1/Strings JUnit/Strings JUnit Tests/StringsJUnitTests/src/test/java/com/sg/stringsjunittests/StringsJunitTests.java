/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.stringsjunittests;

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
public class StringsJunitTests {

    // ************************************************ sayHi()
    @Test
    public void sayHiTest_1(){
        // Arrange
        String name = "Bob";
        String expected = "Hello Bob!";
        // Act
        StringsJUnitDrills sayHiTest = new StringsJUnitDrills();
        String actual = sayHiTest.sayHi(name);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void sayHiTest_2(){
        // Arrange
        String name = "Alice";
        String expected = "Hello Alice!";
        // Act
        StringsJUnitDrills sayHiTest = new StringsJUnitDrills();
        String actual = sayHiTest.sayHi(name);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void sayHiTest_3(){
        // Arrange
        String name = "X";
        String expected = "Hello X!";
        // Act
        StringsJUnitDrills sayHiTest = new StringsJUnitDrills();
        String actual = sayHiTest.sayHi(name);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ abba()
    @Test
    public void abbaTest_1(){
        // Arrange
        String a = "Hi";
        String b = "Bye";
        String expected = "HiByeByeHi";
        // Act
        StringsJUnitDrills abbaTest = new StringsJUnitDrills();
        String actual = abbaTest.abba(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void abbaTest_2(){
        // Arrange
        String a = "Yo";
        String b = "Alice";
        String expected = "YoAliceAliceYo";
        // Act
        StringsJUnitDrills abbaTest = new StringsJUnitDrills();
        String actual = abbaTest.abba(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void abbaTest_3(){
        // Arrange
        String a = "What";
        String b = "Up";
        String expected = "WhatUpUpWhat";
        // Act
        StringsJUnitDrills abbaTest = new StringsJUnitDrills();
        String actual = abbaTest.abba(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ makeTags()
    @Test
    public void makeTagsTest_1(){
        // Arrange
        String tag = "i";
        String content = "Yay";
        String expected = "<i>Yay</i>";
        // Act
        StringsJUnitDrills makeTagsTest = new StringsJUnitDrills();
        String actual = makeTagsTest.makeTags(tag, content);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeTagsTest_2(){
        // Arrange
        String tag = "i";
        String content = "Hello";
        String expected = "<i>Hello</i>";
        // Act
        StringsJUnitDrills makeTagsTest = new StringsJUnitDrills();
        String actual = makeTagsTest.makeTags(tag, content);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeTagsTest_3(){
        // Arrange
        String tag = "cite";
        String content = "Yay";
        String expected = "<cite>Yay</cite>";
        // Act
        StringsJUnitDrills makeTagsTest = new StringsJUnitDrills();
        String actual = makeTagsTest.makeTags(tag, content);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ ()
    @Test
    public void insertWordTest_1(){
        // Arrange
        String container = "<<>>";
        String word = "Yay";
        String expected = "<<Yay>>";
        // Act
        StringsJUnitDrills insertWordTest = new StringsJUnitDrills();
        String actual = insertWordTest.insertWord(container, word);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void insertWordTest_2(){
        // Arrange
        String container = "<<>>";
        String word = "WooHoo";
        String expected = "<<WooHoo>>";
        // Act
        StringsJUnitDrills insertWordTest = new StringsJUnitDrills();
        String actual = insertWordTest.insertWord(container, word);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void insertWordTest_3(){
        // Arrange
        String container = "[[]]";
        String word = "word";
        String expected = "[[word]]";
        // Act
        StringsJUnitDrills insertWordTest = new StringsJUnitDrills();
        String actual = insertWordTest.insertWord(container, word);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ multipleEndings()
    @Test
    public void multipleEndingsTest_1(){
        // Arrange
        String str = "Hello";
        String expected = "lololo";
        // Act
        StringsJUnitDrills multipleEndingsTest = new StringsJUnitDrills();
        String actual = multipleEndingsTest.multipleEndings(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void multipleEndingsTest_2(){
        // Arrange
        String str = "ab";
        String expected = "ababab";
        // Act
        StringsJUnitDrills multipleEndingsTest = new StringsJUnitDrills();
        String actual = multipleEndingsTest.multipleEndings(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void multipleEndingsTest_3(){
        // Arrange
        String str = "Hi";
        String expected = "HiHiHi";
        // Act
        StringsJUnitDrills multipleEndingsTest = new StringsJUnitDrills();
        String actual = multipleEndingsTest.multipleEndings(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ firstHalf()
    @Test
    public void firstHalfTest_1(){
        // Arrange
        String str = "WooHoo";
        String expected = "Woo";
        // Act
        StringsJUnitDrills firstHalfTest = new StringsJUnitDrills();
        String actual = firstHalfTest.firstHalf(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void firstHalfTest_2(){
        // Arrange
        String str = "HelloThere";
        String expected = "Hello";
        // Act
        StringsJUnitDrills firstHalfTest = new StringsJUnitDrills();
        String actual = firstHalfTest.firstHalf(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void firstHalfTest_3(){
        // Arrange
        String str = "abcdef";
        String expected = "abc";
        // Act
        StringsJUnitDrills firstHalfTest = new StringsJUnitDrills();
        String actual = firstHalfTest.firstHalf(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ trimOne()
    @Test
    public void trimOneTest_1(){
        // Arrange
        String str = "Hello";
        String expected = "ell";
        // Act
        StringsJUnitDrills trimOneTest = new StringsJUnitDrills();
        String actual = trimOneTest.trimOne(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void trimOneTest_2(){
        // Arrange
        String str = "java";
        String expected = "av";
        // Act
        StringsJUnitDrills trimOneTest = new StringsJUnitDrills();
        String actual = trimOneTest.trimOne(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void trimOneTest_3(){
        // Arrange
        String str = "coding";
        String expected = "odin";
        // Act
        StringsJUnitDrills trimOneTest = new StringsJUnitDrills();
        String actual = trimOneTest.trimOne(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ longInMiddle()
    @Test
    public void longInMiddleTest_1(){
        // Arrange
        String a = "Hello";
        String b = "hi";
        String expected = "hiHellohi";
        // Act
        StringsJUnitDrills longInMiddleTest = new StringsJUnitDrills();
        String actual = longInMiddleTest.longInMiddle(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void longInMiddleTest_2(){
        // Arrange
        String a = "hi";
        String b = "Hello";
        String expected = "hiHellohi";
        // Act
        StringsJUnitDrills longInMiddleTest = new StringsJUnitDrills();
        String actual = longInMiddleTest.longInMiddle(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void longInMiddleTest_3(){
        // Arrange
        String a = "aaa";
        String b = "b";
        String expected = "baaab";
        // Act
        StringsJUnitDrills longInMiddleTest = new StringsJUnitDrills();
        String actual = longInMiddleTest.longInMiddle(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }


    // ************************************************ rotateLeft2()
    @Test
    public void rotateLeft2Test_1(){
        // Arrange
        String str = "Hello";
        String expected = "lloHe";
        // Act
        StringsJUnitDrills rotateLeft2Test = new StringsJUnitDrills();
        String actual = rotateLeft2Test.rotateLeft2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateLeft2Test_2(){
        // Arrange
        String str = "java";
        String expected = "vaja";
        // Act
        StringsJUnitDrills rotateLeft2Test = new StringsJUnitDrills();
        String actual = rotateLeft2Test.rotateLeft2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateLeft2Test_3(){
        // Arrange
        String str = "Hi";
        String expected = "Hi";
        // Act
        StringsJUnitDrills rotateLeft2Test = new StringsJUnitDrills();
        String actual = rotateLeft2Test.rotateLeft2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ rotateRight2()
    @Test
    public void rotateRight2Test_1(){
        // Arrange
        String str = "Hello";
        String expected = "loHel";
        // Act
        StringsJUnitDrills rotateRight2Test = new StringsJUnitDrills();
        String actual = rotateRight2Test.rotateRight2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateRight2Test_2(){
        // Arrange
        String str = "java";
        String expected = "vaja";
        // Act
        StringsJUnitDrills rotateRight2Test = new StringsJUnitDrills();
        String actual = rotateRight2Test.rotateRight2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateRight2Test_3(){
        // Arrange
        String str = "Hi";
        String expected = "Hi";
        // Act
        StringsJUnitDrills rotateRight2Test = new StringsJUnitDrills();
        String actual = rotateRight2Test.rotateRight2(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ takeOne()
    @Test
    public void takeOneTest_1(){
        // Arrange
        String str = "Hello";
        boolean fromFront = true;
        String expected = "H";
        // Act
        StringsJUnitDrills takeOneTest = new StringsJUnitDrills();
        String actual = takeOneTest.takeOne(str, fromFront);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeOneTest_2(){
        // Arrange
        String str = "Hello";
        boolean fromFront = false;
        String expected = "o";
        // Act
        StringsJUnitDrills takeOneTest = new StringsJUnitDrills();
        String actual = takeOneTest.takeOne(str, fromFront);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeOneTest_3(){
        // Arrange
        String str = "oh";
        boolean fromFront = true;
        String expected = "o";
        // Act
        StringsJUnitDrills takeOneTest = new StringsJUnitDrills();
        String actual = takeOneTest.takeOne(str, fromFront);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ middleTwo()
    @Test
    public void middleTwoTest_1(){
        // Arrange
        String str = "string";
        String expected = "ri";
        // Act
        StringsJUnitDrills middleTwoTest = new StringsJUnitDrills();
        String actual = middleTwoTest.middleTwo(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void middleTwoTest_2(){
        // Arrange
        String str = "code";
        String expected = "od";
        // Act
        StringsJUnitDrills middleTwoTest = new StringsJUnitDrills();
        String actual = middleTwoTest.middleTwo(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void middleTwoTest_3(){
        // Arrange
        String str = "Practice";
        String expected = "ct";
        // Act
        StringsJUnitDrills middleTwoTest = new StringsJUnitDrills();
        String actual = middleTwoTest.middleTwo(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    // ************************************************ endsWithLy()
    @Test
    public void endsWithLyTest_1(){
        // Arrange
        String str = "oddly";
        boolean expected = true;
        // Act
        StringsJUnitDrills endsWithLyTest = new StringsJUnitDrills();
        boolean actual = endsWithLyTest.endsWithLy(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void endsWithLyTest_2(){
        // Arrange
        String str = "y";
        boolean expected = false;
        // Act
        StringsJUnitDrills endsWithLyTest = new StringsJUnitDrills();
        boolean actual = endsWithLyTest.endsWithLy(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void endsWithLyTest_3(){
        // Arrange
        String str = "oddy";
        boolean expected = false;
        // Act
        StringsJUnitDrills endsWithLyTest = new StringsJUnitDrills();
        boolean actual = endsWithLyTest.endsWithLy(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ frontAndBack()
    @Test
    public void frontAndBackTest_1(){
        // Arrange
        String str = "Hello";
        int n = 2;
        String expected = "Helo";
        // Act
        StringsJUnitDrills frontAndBackTest = new StringsJUnitDrills();
        String actual = frontAndBackTest.frontAndBack(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontAndBackTest_2(){
        // Arrange
        String str = "Chocolate";
        int n = 3;
        String expected = "Choate";
        // Act
        StringsJUnitDrills frontAndBackTest = new StringsJUnitDrills();
        String actual = frontAndBackTest.frontAndBack(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontAndBackTest_3(){
        // Arrange
        String str = "Chocolate";
        int n = 1;
        String expected = "Ce";
        // Act
        StringsJUnitDrills frontAndBackTest = new StringsJUnitDrills();
        String actual = frontAndBackTest.frontAndBack(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ takeTwoFromPosition()
    @Test
    public void takeTwoFromPositionTest_1(){
        // Arrange
        String str = "java";
        int n = 0;
        String expected = "ja";
        // Act
        StringsJUnitDrills takeTwoFromPositionTest = new StringsJUnitDrills();
        String actual = takeTwoFromPositionTest.takeTwoFromPosition(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeTwoFromPositionTest_2(){
        // Arrange
        String str = "java";
        int n = 2;
        String expected = "va";
        // Act
        StringsJUnitDrills takeTwoFromPositionTest = new StringsJUnitDrills();
        String actual = takeTwoFromPositionTest.takeTwoFromPosition(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeTwoFromPositionTest_3(){
        // Arrange
        String str = "java";
        int n = 3;
        String expected = "ja";
        // Act
        StringsJUnitDrills takeTwoFromPositionTest = new StringsJUnitDrills();
        String actual = takeTwoFromPositionTest.takeTwoFromPosition(str, n);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ hasBad()
    @Test
    public void hasBadTest_1(){
        // Arrange
        String str = "badxx";
        boolean expected = true;
        // Act
        StringsJUnitDrills hasBadTest = new StringsJUnitDrills();
        boolean actual = hasBadTest.hasBad(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasBadTest_2(){
        // Arrange
        String str = "xbadxx";
        boolean expected = true;
        // Act
        StringsJUnitDrills hasBadTest = new StringsJUnitDrills();
        boolean actual = hasBadTest.hasBad(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasBadTest_3(){
        // Arrange
        String str = "xxbadxx";
        boolean expected = false;
        // Act
        StringsJUnitDrills hasBadTest = new StringsJUnitDrills();
        boolean actual = hasBadTest.hasBad(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ atFirst()
    @Test
    public void atFirstTest_1(){
        // Arrange
        String str = "hello";
        String expected = "he";
        // Act
        StringsJUnitDrills atFirstTest = new StringsJUnitDrills();
        String actual = atFirstTest.atFirst(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void atFirstTest_2(){
        // Arrange
        String str = "hi";
        String expected = "hi";
        // Act
        StringsJUnitDrills atFirstTest = new StringsJUnitDrills();
        String actual = atFirstTest.atFirst(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void atFirstTest_3(){
        // Arrange
        String str = "h";
        String expected = "h@";
        // Act
        StringsJUnitDrills atFirstTest = new StringsJUnitDrills();
        String actual = atFirstTest.atFirst(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ lastChars()
    @Test
    public void lastCharsTest_1(){
        // Arrange
        String a = "last";
        String b = "chars";
        String expected = "ls";
        // Act
        StringsJUnitDrills lastCharsTest = new StringsJUnitDrills();
        String actual = lastCharsTest.lastChars(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void lastCharsTest_2(){
        // Arrange
        String a = "yo";
        String b = "mama";
        String expected = "ya";
        // Act
        StringsJUnitDrills lastCharsTest = new StringsJUnitDrills();
        String actual = lastCharsTest.lastChars(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void lastCharsTest_3(){
        // Arrange
        String a = "hi";
        String b = "";
        String expected = "h@";
        // Act
        StringsJUnitDrills lastCharsTest = new StringsJUnitDrills();
        String actual = lastCharsTest.lastChars(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ conCat()
    @Test
    public void conCatTest_1(){
        // Arrange
        String a = "abc";
        String b = "cat";
        String expected = "abcat";
        // Act
        StringsJUnitDrills conCatTest = new StringsJUnitDrills();
        String actual = conCatTest.conCat(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void conCatTest_2(){
        // Arrange
        String a = "dog";
        String b = "cat";
        String expected = "dogcat";
        // Act
        StringsJUnitDrills conCatTest = new StringsJUnitDrills();
        String actual = conCatTest.conCat(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void conCatTest_3(){
        // Arrange
        String a = "abc";
        String b = "";
        String expected = "abc";
        // Act
        StringsJUnitDrills conCatTest = new StringsJUnitDrills();
        String actual = conCatTest.conCat(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ swapLast()
    @Test
    public void swapLastTest_1(){
        // Arrange
        String str = "coding";
        String expected = "codign";
        // Act
        StringsJUnitDrills swapLastTest = new StringsJUnitDrills();
        String actual = swapLastTest.swapLast(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapLastTest_2(){
        // Arrange
        String str = "cat";
        String expected = "cta";
        // Act
        StringsJUnitDrills swapLastTest = new StringsJUnitDrills();
        String actual = swapLastTest.swapLast(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapLastTest_3(){
        // Arrange
        String str = "ab";
        String expected = "ba";
        // Act
        StringsJUnitDrills swapLastTest = new StringsJUnitDrills();
        String actual = swapLastTest.swapLast(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ frontAgain()
    @Test
    public void frontAgainTest_1(){
        // Arrange
        String str = "edited";
        boolean expected = true;
        // Act
        StringsJUnitDrills frontAgainTest = new StringsJUnitDrills();
        boolean actual = frontAgainTest.frontAgain(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontAgainTest_2(){
        // Arrange
        String str = "edit";
        boolean expected = false;
        // Act
        StringsJUnitDrills frontAgainTest = new StringsJUnitDrills();
        boolean actual = frontAgainTest.frontAgain(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void frontAgainTest_3(){
        // Arrange
        String str = "ed";
        boolean expected = true;
        // Act
        StringsJUnitDrills frontAgainTest = new StringsJUnitDrills();
        boolean actual = frontAgainTest.frontAgain(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ minCat()
    @Test
    public void minCatTest_1(){
        // Arrange
        String a = "Hello";
        String b = "Hi";
        String expected = "loHi";
        // Act
        StringsJUnitDrills minCatTest = new StringsJUnitDrills();
        String actual = minCatTest.minCat(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void minCatTest_2(){
        // Arrange
        String a = "Hello";
        String b = "java";
        String expected = "ellojava";
        // Act
        StringsJUnitDrills minCatTest = new StringsJUnitDrills();
        String actual = minCatTest.minCat(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void minCatTest_3(){
        // Arrange
        String a = "java";
        String b = "Hello";
        String expected = "javaello";
        // Act
        StringsJUnitDrills minCatTest = new StringsJUnitDrills();
        String actual = minCatTest.minCat(a, b);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ tweakFront()
    @Test
    public void tweakFrontTest_1(){
        // Arrange
        String str = "Hello";
        String expected = "llo";
        // Act
        StringsJUnitDrills tweakFrontTest = new StringsJUnitDrills();
        String actual = tweakFrontTest.tweakFront(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void tweakFrontTest_2(){
        // Arrange
        String str = "away";
        String expected = "aay";
        // Act
        StringsJUnitDrills tweakFrontTest = new StringsJUnitDrills();
        String actual = tweakFrontTest.tweakFront(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void tweakFrontTest_3(){
        // Arrange
        String str = "abed";
        String expected = "abed";
        // Act
        StringsJUnitDrills tweakFrontTest = new StringsJUnitDrills();
        String actual = tweakFrontTest.tweakFront(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
    // ************************************************ stripX()
    @Test
    public void stripXTest_1(){
        // Arrange
        String str = "xHix";
        String expected = "Hi";
        // Act
        StringsJUnitDrills stripXTest = new StringsJUnitDrills();
        String actual = stripXTest.stripX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stripXTest_2(){
        // Arrange
        String str = "xHi";
        String expected = "Hi";
        // Act
        StringsJUnitDrills stripXTest = new StringsJUnitDrills();
        String actual = stripXTest.stripX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void stripXTest_3(){
        // Arrange
        String str = "Hxix";
        String expected = "Hxi";
        // Act
        StringsJUnitDrills stripXTest = new StringsJUnitDrills();
        String actual = stripXTest.stripX(str);
        // Assert
        org.junit.Assert.assertEquals(expected, actual);
    }
}
