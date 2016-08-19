/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.conditionalsjunittests;

/**
 *
 * @author Kratos
 */
public class ConditionalsJUnitDrills {

    // ************************************************************ MischeviousChildren.txt
    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        if((aSmile && bSmile) || (!aSmile && !bSmile)){
            return true;
        }else{
            return false;
        }
    }

    // ************************************************************ SleepingIn.txt
    public boolean canSleepIn(boolean isWeekday, boolean isVacation) {
        if(!isWeekday || isVacation){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ SumDouble.txt
    public int sumDouble(int a, int b) {
        if(a == b){
            return (a+b)*2;
        }else{
            return a+b;
        }
    }
    // ************************************************************ Diff21.txt
    public int diff21(int n) {
        if (n > 21){
            return (n - 21) * 2;
        }else{
            return 21 - n;
        }
    }
    // ************************************************************ ParrotTrouble.txt
    public boolean parrotTrouble(boolean isTalking, int hour) {
        if(isTalking){
            if(hour < 7 || hour > 20){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    // ************************************************************ Makes10.txt
    public boolean makes10(int a, int b) {
        if(a == 10 || b == 10){
            return true;
        }else if ((a + b) == 10){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ NearHundred.txt
    public boolean nearHundred(int n) {
        if ((n >= 90 && n <= 110) || (n >= 190) && (n <= 210)){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ PosNeg.txt
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative){
            if (a < 0 && b < 0){
                return true;
            }
        }else if ((a < 0 && b > 0) || (a > 0 && b < 0)){
            return true;
        }
        return false;
    }
    // ************************************************************ NotString.txt
    public String notString(String s) {
        String[] stringList = s.split("\\s+");
        if (stringList[0].equals("not")){
            return s;
        }else{
            return "not " + s;
        }
    }
    // ************************************************************ MissingChar.txt
    public String missingChar(String str, int n) {
        char[] charList = str.toCharArray();
        String stringWithCharRemoved = "";

        for (int i = 0; i < charList.length; i++){
            if (i != n){
                stringWithCharRemoved += ("" + charList[i]);
            }
        }

        return stringWithCharRemoved;
    }
    // ************************************************************ FrontBack.txt
    public String frontBack(String str) {
        if(str.length() == 1){
            return str;
        }else if(str.length() == 2){
            return ("" + str.charAt(1) + str.charAt(0));
        }else{
            char[] charList = str.toCharArray();
            char temp = charList[0];
            charList[0] = charList[charList.length - 1];
            charList[charList.length - 1] = temp;

            return String.valueOf(charList);
        }
    }
    // ************************************************************ Front3.txt
    public String front3(String str) {
        if (str.length() <= 2){
            return str + str + str;
        }else{
            String front = "" + str.charAt(0) + str.charAt(1) + str.charAt(2);
            return front + front + front;
        }
    }
    // ************************************************************ BackAround.txt
    public String backAround(String str) {
        String lastLetter = "" + str.charAt(str.length() - 1);
        return lastLetter + str + lastLetter;
    }
    // ************************************************************ Multiple3or5.txt
    public boolean multiple3or5(int number) {
        if (number % 3 == 0 || number % 5 == 0){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ StartHi.txt
    public boolean startHi(String str) {
        String firstWord = str.split("\\s+")[0];
        if (firstWord.equals("hi") || firstWord.equals("Hi")){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ IcyHot.txt
    public boolean icyHot(int temp1, int temp2) {
        if(temp1 > 100){
            if(temp2 < 0){
                return true;
            }
        }else if(temp1 < 0){
            if(temp2 > 100){
                return true;
            }
        }
        return false;
    }
    // ************************************************************ Between10and20.txt
    public boolean between10and20(int a, int b) {
        if ((a >= 10 && a <= 20) || (b >= 10 && b <= 20)){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ HasTeen.txt
    public boolean hasTeen(int a, int b, int c) {
        if (a >= 13 && a <= 19){
            return true;
        }else if (b >= 13 && c <= 19){
            return true;
        }else if (c >= 13 && c <= 19){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ SoAlone.txt
    public boolean soAlone(int a, int b) {
        if (((a >= 13 && a <= 19) && (b >= 13 && b <= 19)) || ((a < 13 && a > 19) && (b < 13 && b > 19))){
            return false;
        }else{
            return true;
        }
    }
    // ************************************************************ RemoveDel.txt
    public String removeDel(String str) {
        char[] charList = str.toCharArray();
        if (charList.length < 4){
            return str;
        }else if(charList[1] == 'd' && charList[2] == 'e' && charList[3] == 'l'){
            String returnedString = "" + charList[0];

            for(int i = 4; i < charList.length; i++){
                returnedString += ("" + charList[i]);
            }
            return returnedString;
        }else {
            return str;
        }
    }
    // ************************************************************ IxStart.txt
    public boolean ixStart(String str) {
        String[] wordList = str.split("\\s+");
        String firstWord = wordList[0];
        int wordLength = firstWord.length();

        if(firstWord.charAt(wordLength - 1) == 'x' && firstWord.charAt(wordLength - 2) == 'i'){
            return true;
        }else{
            return false;
        }
    }
    // ************************************************************ StartOz.txt
    public String startOz(String str) {
        String emptyString = "";

        if (str.length() >= 2){
            char firstChar = str.charAt(0);
            char secondChar = str.charAt(1);

            if (firstChar == 'o' && secondChar == 'z'){
                return ("" + firstChar + secondChar);
            }else if (firstChar == 'o'){
                return ("" + firstChar);
            }else if (secondChar == 'z'){
                return ("" + secondChar);
            }else{
                return emptyString;
            }
        }else{
            return emptyString;
        }
    }
    // ************************************************************ Max.txt
    public int max(int a, int b, int c) {
        int max = a;

        int[] numbers = {a, b, c};
        for (int i = 0; i < numbers.length; i++){
            if (max < numbers[i]){
                max = numbers[i];
            }
        }
        return max;
    }
    // ************************************************************ Closer.txt
    public int closer(int a, int b) {
        int aDiff = 0;
        int bDiff = 0;

        if (a < 10){
            aDiff = 10 - a;
        }else {
            aDiff = a - 10;
        }

        if (b < 10){
            bDiff = 10 - b;
        }else{
            bDiff = b - 10;
        }

        if (aDiff > bDiff){
            return b;
        }else if (bDiff > aDiff){
            return a;
        }else{
            return 0;
        }
    }
    // ************************************************************ EEEEEEE.txt
    public boolean gotE(String str) {
        char[] charList = str.toCharArray();
        int eCounter = 0;

        for (int i = 0; i < charList.length; i++){
            if (charList[i] == 'e'){
                eCounter++;
            }
        }

        if (eCounter >= 1 && eCounter <= 3){
            return true;
        }else {
            return false;
        }
    }
    // ************************************************************ .txt
    public String endUp(String str) {
        char[] charList = str.toCharArray();
        int length = charList.length;
        String returnedString = "";

        if (length <= 3){
            for (int i = 0; i < length; i++){
                if (charList[i] >= 97 && charList[i] <= 122){
                    returnedString += ("" + (char) (charList[i] - 32));
                }else {
                    returnedString += ("" + charList[i]);
                }
            }
        }else{
            for(int i = length - 1; i > length -4; i--){
                if (charList[i] >= 97 && charList[i] <= 122){
                    charList[i] = (char) (charList[i] - 32);
                }
            }

            for (int i = 0; i < length; i++){
                returnedString += ("" + charList[i]);
            }
        }
        return returnedString;
    }
    // ************************************************************ EveryNth.txt
    public String everyNth(String str, int n) {
        int length = str.length();
        String returnedString = "" + str.charAt(0);

        length -= length % n;

        for (int i = n; i <= length; i+=n){
            returnedString += ("" + str.charAt(i));
        }
        return returnedString;
    }
}
