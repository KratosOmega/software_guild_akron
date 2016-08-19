/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.loopsjunittests;

/**
 *
 * @author Kratos
 */
public class LoopsJUnitDrills {

    // ******************************************* StringTimes.txt
    public String stringTimes(String str, int n) {
        String largerString = "";

        for (int i = 0; i < n; i++) {
            largerString += str;
        }
        return largerString;
    }

    // ******************************************* FrontTimes.txt
    public String frontTimes(String str, int n) {
        char[] charList = str.toCharArray();
        String front = Character.toString(charList[0]) + Character.toString(charList[1]) + Character.toString(charList[2]);

        String frontTimes = "";

        for (int i = 0; i < n; i++) {
            frontTimes += front;
        }

        return frontTimes;
    }

    // ******************************************* CountXX.txt
    public int countXX(String str) {
        int countXX = 0;
        char[] charList = str.toCharArray();

        for (int i = 1; i < charList.length; i++) {
            if (charList[i] == 'x' && charList[i - 1] == 'x') {
                countXX++;
            }
        }

        return countXX;
    }

    // ******************************************* DoubleX.txt
    public boolean doubleX(String str) {
        int countXX = 0;
        char[] charList = str.toCharArray();

        for (int i = 1; i < charList.length; i++) {
            if (charList[i] == 'x' && charList[i + 1] != 'x') {
                return false;
            } else if (charList[i] == 'x' && charList[i + 1] == 'x') {
                return true;
            }
        }
        return false;
    }

    // ******************************************* EveryOther.txt
    public String everyOther(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i += 2) {
            result = result + str.charAt(i);
        }

        return result;
    }

    // ******************************************* StringSplosion.txt
    public String stringSplosion(String str) {
        String result = "";

        for (int m = 0; m < str.length(); m++) {
            for (int n = 0; n < m + 1; n++) {
                result += Character.toString(str.charAt(n));
            }
        }
        return result;
    }

    // ******************************************* CountLast2.txt
    public int countLast2(String str) {
        if (str.length() < 2) {
            return 0;
        }

        String end = str.substring(str.length() - 2);
        int count = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            String sub = str.substring(i, i + 2);

            if (sub.equals(end)) {
                count++;
            }
        }
        return count;
    }

    // ******************************************* Count9.txt
    public int count9(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 9) {
                count++;
            }
        }
        return count;
    }

    // ******************************************* ArrayFront9.txt
    public boolean arrayFront9(int[] numbers) {
        if (numbers.length < 4) {
            for (int m = 0; m < numbers.length; m++) {
                if (numbers[m] == 9) {
                    return true;
                }
            }
        } else {
            for (int n = 0; n < 4; n++) {
                if (numbers[n] == 9) {
                    return true;
                }
            }
        }
        return false;
    }

    // ******************************************* Array123.txt
    public boolean array123(int[] numbers) {
        int tracker = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                tracker = 1;
            } else if (numbers[i] == 2 && tracker == 1) {
                tracker = 2;
            } else if (numbers[i] == 3 && tracker == 2) {
                return true;
            } else {
                tracker = numbers[i];
            }
        }
        return false;
    }

    // ******************************************* SubStringMatch.txt
    public int subStringMatch(String a, String b) {
        boolean firstSameChar = false;
        int count = 0;
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) == b.charAt(i) && firstSameChar == false) {
                firstSameChar = true;
            } else if (a.charAt(i) == b.charAt(i) && firstSameChar == true) {
                count++;
            } else if (a.charAt(i) != b.charAt(i)) {
                firstSameChar = false;
            }
        }
        return count;
    }

    // ******************************************* StringX.txt
    public String stringX(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if ((i != 0 || i != str.length() - 1) && str.charAt(i) != 'x') {
                result += Character.toString(str.charAt(i));
            } else if (i == 0 || i == str.length() - 1) {
                result += Character.toString(str.charAt(i));
            }
        }
        return result;
    }

    // ******************************************* AltPairs.txt
    public String altPairs(String str) {
        int tracker = 0;
        int inc = 1;
        String result = "";

        for (int i = 0; i < str.length(); i += inc) {
            if (i == 0) {
                inc = 1;
            } else if (inc == 1) {
                inc = 3;
            } else {
                inc = 1;
            }
            result += Character.toString(str.charAt(i));
        }
        return result;
    }

    // ******************************************* DoNotYak.txt
    public String doNotYak(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 2) {
                if (str.charAt(i) == 'y' && str.charAt(i + 1) == 'a' && str.charAt(i + 2) == 'k') {
                    i += 2;
                } else {
                    result += Character.toString(str.charAt(i));
                }
            } else {
                result += Character.toString(str.charAt(i));
            }
        }
        return result;
    }

    // ******************************************* Array667.txt
    public int array667(int[] numbers) {
        int count = 0;
        boolean firstSix = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 6 && !firstSix) {
                firstSix = true;
            } else if ((numbers[i] == 6 || numbers[i] == 7) && firstSix) {
                count++;
            } else {
                firstSix = false;
            }
        }
        return count;
    }

    // ******************************************* NoTriples.txt
    public boolean noTriples(int[] numbers) {
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] == numbers[i + 1] && numbers[i + 1] == numbers[i + 2]) {
                return false;
            }
        }
        return true;
    }

    // ******************************************* Pattern51.txt
    public boolean pattern51(int[] numbers) {
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] + 5 == numbers[i + 1] && numbers[i] - 1 == numbers[i + 2]) {
                return true;
            }
        }
        return false;
    }
}
