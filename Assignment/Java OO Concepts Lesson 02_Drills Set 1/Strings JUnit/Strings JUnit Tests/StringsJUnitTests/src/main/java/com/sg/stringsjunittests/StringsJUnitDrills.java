/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.stringsjunittests;

/**
 *
 * @author Kratos
 */
public class StringsJUnitDrills {

    // ****************************** SayHi.txt
    public String sayHi(String name) {
        return "Hello " + name + "!";
    }

    // ****************************** Abba.txt
    public String abba(String a, String b) {
        return a + b + b + a;
    }

    // ****************************** MakeTags.txt
    public String makeTags(String tag, String content) {
        return "<" + tag + ">" + content + "</" + tag + ">";
    }

    // ****************************** InsertWord.txt
    public String insertWord(String container, String word) {
        String leftBracket = Character.toString(container.charAt(0)) + Character.toString(container.charAt(1));
        String rightBracket = Character.toString(container.charAt(2)) + Character.toString(container.charAt(3));

        return leftBracket + word + rightBracket;
    }

    // ****************************** MultipleEndings.txt
    public String multipleEndings(String str) {
        String lastTwo = Character.toString(str.charAt(str.length() - 2)) + Character.toString(str.charAt(str.length() - 1));

        return lastTwo + lastTwo + lastTwo;
    }

    // ****************************** FirstHalf.txt
    public String firstHalf(String str) {
        int half = str.length() / 2;
        String[] letters = str.split("");
        String result = "";

        for (int i = 0; i < half; i++) {
            result += letters[i];
        }
        return result;
    }

    // ****************************** TrimOne.txt
    public String trimOne(String str) {
        String[] letters = str.split("");
        String result = "";

        for (int i = 1; i < str.length() - 1; i++) {
            result += letters[i];
        }
        return result;
    }

    // ****************************** LongInMiddle.txt
    public String longInMiddle(String a, String b) {
        if (a.length() > b.length()) {
            return b + a + b;
        } else {
            return a + b + a;
        }
    }

    // ****************************** .tx
    public String rotateLeft2(String str) {
        String[] letters = str.split("");
        String firstTwo = letters[0] + letters[1];
        String result = "";

        for (int i = 2; i < letters.length; i++) {
            result += letters[i];
        }

        return result + firstTwo;
    }

    // ****************************** RotateRight2.txt
    public String rotateRight2(String str) {
        String[] letters = str.split("");
        String lastTwo = letters[letters.length - 2] + letters[letters.length - 1];
        String result = "";

        for (int i = 0; i < letters.length - 2; i++) {
            result += letters[i];
        }

        return lastTwo + result;
    }

    // ****************************** TakeOne.txt
    public String takeOne(String str, boolean fromFront) {
        String[] letters = str.split("");

        if (fromFront) {
            return letters[0];
        } else {
            return letters[letters.length - 1];
        }
    }

    // ****************************** MiddleTwo.txt
    public String middleTwo(String str) {
        String[] letters = str.split("");
        String result = "";
        int startAt = str.length() / 2 - 1;

        for (int i = startAt; i < startAt + 2; i++) {
            result += letters[i];
        }
        return result;
    }

    // ****************************** EndsWithLy.txt
    public boolean endsWithLy(String str) {
        String[] letters = str.split("");

        if (letters.length < 2) {
            return false;
        } else if (letters[letters.length - 2].equals("l") && letters[letters.length - 1].equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    // ****************************** FrontAndBack.txt
    public String frontAndBack(String str, int n) {
        String[] letters = str.split("");
        String result = "";

        for (int x = 0; x < n; x++) {
            result += letters[x];
        }

        for (int y = letters.length - n; y < letters.length; y++) {
            result += letters[y];
        }

        return result;
    }

    // ****************************** TakeTwoFromPosition.txt
    public String takeTwoFromPosition(String str, int n) {
        if (n <= str.length() - 2 && n >= 0) {
            return str.substring(n, n + 2);
        }
        return str.substring(0, 2);
    }

    // ****************************** HasBad.txt
    public boolean hasBad(String str) {
        int len = str.length();
        if (len == 3 && str.equals("bad")) {
            return true;
        } else if (len >= 4) {
            if (str.substring(0, 3).equals("bad")) {
                return true;
            }
            return str.substring(1, 4).equals("bad");
        } else {
            return false;
        }
    }
    // ****************************** AtFirst.txt
    public String atFirst(String str) {
        int length = str.length();

        if (length < 2){
            return str + "@";
        }else {
            return str.substring(0, 2);
        }
    }
    // ****************************** LastChars.txt
    public String lastChars(String a, String b) {
        String result = "";

        if (a.length() >= 1){
            result += Character.toString(a.charAt(0));
        }else{
            result += "@";
        }

        if (b.length() >= 1){
            result += Character.toString(b.charAt(b.length() - 1));
        }else{
            result += "@";
        }

        return result;
    }
    // ****************************** ConCat.txt
    public String conCat(String a, String b) {
        if (a.length() == 0 || b.length() == 0){
            return a + b;
        }else if (a.charAt(a.length()-1) == b.charAt(0)){
            return a.substring(0, a.length()-1) + b;
        }else {
            return a + b;
        }
    }
    // ****************************** SwapLast.txt
    public String swapLast(String str) {
        String[] letters = str.split("");
        String temp = letters[letters.length-1];
        String result = "";
        letters[letters.length-1] = letters[letters.length-2];
        letters[letters.length-2] = temp;

        for (int i = 0; i < letters.length; i++){
            result += letters[i];
        }
        return result;
    }
    // ****************************** FrontAgain.txt
    public boolean frontAgain(String str) {
        int length = str.length();
        if(length == 2){
            return true;
        }else{
            return str.charAt(0) == str.charAt(length-2) && str.charAt(1) == str.charAt(length-1);
        }
    }
    // ****************************** MinCat.txt
    public String minCat(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();

        if(aLength > bLength){
            return a.substring(aLength-bLength, aLength) + b;
        }else{
            return a + b.substring(bLength-aLength, bLength);
        }
    }
    // ****************************** TweakFront.txt
    public String tweakFront(String str) {
        String result = "";
        int length = str.length();

        if(length == 1){
            if (str.charAt(0) == 'a'){
                return str;
            }else {
                return "";
            }
        }else if(length == 2){
            if (str.charAt(0) == 'a'){
                result += "a";
            }
            if (str.charAt(1) == 'b'){
                result += "b";
            }
            return result;
        }else{
            if (str.charAt(0) == 'a'){
                result += "a";
            }
            if (str.charAt(1) == 'b'){
                result += "b";
            }
            return result + str.substring(2, length);
        }
    }
    // ****************************** StripX.txt
    public String stripX(String str) {
        int length = str.length();
        int front = 0;
        int back = length;

        if(str.charAt(0) == 'x'){
            front = 1;
        }
        if(str.charAt(length-1) == 'x'){
            back = length - 1;
        }

        return str.substring(front, back);
    }
}
