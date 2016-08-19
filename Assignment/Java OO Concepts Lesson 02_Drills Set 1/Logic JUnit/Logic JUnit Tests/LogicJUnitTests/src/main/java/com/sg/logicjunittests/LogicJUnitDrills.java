/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.logicjunittests;

/**
 *
 * @author Kratos
 */
public class LogicJUnitDrills {

    // ****************************************************** GreatPartyTest.txt
    public boolean greatParty(int cigars, boolean isWeekend) {
        if (isWeekend) {
            if (cigars >= 40) {
                return true;
            }
        } else if (cigars >= 40 && cigars <= 60) {
            return true;
        }
        return false;
    }

    // ****************************************************** CanHazTable.txt
    public int canHazTable(int yourStyle, int dateStyle) {
        if (yourStyle >= 8 || dateStyle >= 8) {
            return 2;
        } else if (yourStyle <= 2 || dateStyle <= 2) {
            return 0;
        } else {
            return 1;
        }
    }

    // ****************************************************** PlayOutside.txt
    public boolean playOutside(int temp, boolean isSummer) {
        int upperLimit;

        if (isSummer) {
            upperLimit = 100;
        } else {
            upperLimit = 90;
        }

        if (temp >= 60 && temp < upperLimit) {
            return true;
        } else {
            return false;
        }
    }

    // ****************************************************** CaughtSpeeding.txt
    public int caughtSpeeding(int speed, boolean isBirthday) {
        int special;
        if (isBirthday) {
            special = 5;
        } else {
            special = 0;
        }

        if (speed <= 60 + special) {
            return 0;
        } else if (speed >= 61 + special && speed <= 80 + special) {
            return 1;
        } else {
            return 2;
        }
    }

    // ****************************************************** SkipSum.txt
    public int skipSum(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 19) {
            return 20;
        } else {
            return sum;
        }
    }

    // ****************************************************** AlarmClock.txt
    public String alarmClock(int day, boolean isVacation) {
        if (isVacation) {
            if (day == 0 || day == 6) {
                return "off";
            } else {
                return "10:00";
            }
        } else if (day == 0 || day == 6) {
            return "10:00";
        } else {
            return "7:00";
        }
    }

    // ****************************************************** LoveSix.txt
    public boolean loveSix(int a, int b) {
        return a == 6 || b == 6 || a + b == 6 || (a > b && a - b == 6) || (b > a && b - a == 6);
    }
    // ****************************************************** InRange.txt
    public boolean inRange(int n, boolean outsideMode) {
        if(outsideMode){
            return (n <= 1 || n >= 10);
        }else{
            return (n >= 1 && n <= 10);
        }
    }
    // ****************************************************** SpecialEleven.txt
    public boolean specialEleven(int n) {
        return (n % 11 ==0 || n % 11 == 1);
    }
    // ****************************************************** Mod20.txt
    public boolean mod20(int n) {
        return (n % 20 == 1 || n % 20 == 2);
    }
    // ****************************************************** Mod35.txt
    public boolean mod35(int n) {
        return ((n % 3 == 0 && n % 5 != 0) || (n % 5 == 0 && n % 3 != 0));
    }
    // ****************************************************** AnswerCell.txt
    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
        if (isAsleep){
            return false;
        }else if (isMom){
            return true;
        }else if (isMorning){
            return false;
        }else {
            return true;
        }
    }
    // ****************************************************** TwoIsOne.txt
    public boolean twoIsOne(int a, int b, int c) {
        int sum = a + b + c;
        if (sum % 2 != 0){
            return false;
        }else{
            int half = sum / 2;
            if (half == a || half == b || half == c){
                return true;
            }else{
                return false;
            }
        }
    }
    // ****************************************************** AreInOrder.txt
    public boolean areInOrder(int a, int b, int c, boolean bOk) {
        if (bOk){
            return (b >= a && c > b);
        }else{
            return (b > a && c > b);
        }
    }
    // ****************************************************** InOrderEqual.txt
    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        if (equalOk){
            return (c >= b && b >= a);
        }else{
            return (c > b && b > a);
        }
    }
    // ****************************************************** LastDigit.txt
    public boolean lastDigit(int a, int b, int c){
        int aM = a % 10;
        int bM = b % 10;
        int cM = c % 10;

        return (aM == bM || aM == cM || bM == cM);
    }
    // ****************************************************** .txt
    public int rollDice(int die1, int die2, boolean noDoubles) {
        if(die1 == die2){
            if (noDoubles){
                if (die1 == 6){
                    return 7;
                }else{
                    return die1 * 2 + 1;
                }
            }else{
                return die1 * 2;
            }
        }else{
            return die1 + die2;
        }
    }
}
