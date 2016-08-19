/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrayjunittests;

/**
 *
 * @author Kratos
 */
public class ArraysJUnitDrills {

    // **************************** FirstLast6.txt **************************** 
    public boolean firstLast6(int[] numbers) {
        return numbers[0] == 6 || numbers[numbers.length - 1] == 6;
    }

    // **************************** SameFirstLast.txt **************************** 
    public boolean sameFirstLast(int[] numbers) {
        return numbers.length >= 1 && numbers[0] == numbers[numbers.length - 1];
    }

    // **************************** MakePi.txt **************************** 
    public int[] makePi(int n) {
        int[] result;
        if (n == 0) {
            return result = new int[]{0};
        } else {
            long pi = (long) (Math.PI * (Math.pow(10, n - 1)) - Math.PI * (Math.pow(10, n - 1)) % 1);
            String piToString = "" + pi;
            result = new int[piToString.length()];
            for (int i = 0; i < piToString.length(); i++) {
                result[i] = Integer.parseInt("" + piToString.charAt(i));
            }
            return result;
        }
    }

    // **************************** CommonEnd.txt **************************** 
    public boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
    }

    // **************************** Sum.txt **************************** 
    public int sum(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    // **************************** RotateLeft.txt **************************** 
    public int[] rotateLeft(int[] numbers) {
        int length = numbers.length;
        int temp = numbers[0];

        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                numbers[i] = temp;
            } else {
                numbers[i] = numbers[i + 1];
            }
        }

        return numbers;
    }

    // **************************** Reverse.txt **************************** 
    public int[] reverse(int[] numbers) {
        int length = numbers.length;
        int counter;
        int oppositeSide = length - 1;
        int temp;

        // prepare counter
        if (length % 2 == 0) {
            counter = length / 2;
        } else {
            counter = (length - 1) / 2;
        }

        for (int i = 0; i < counter; i++) {
            temp = numbers[i];
            numbers[i] = numbers[oppositeSide];
            numbers[oppositeSide] = temp;
            oppositeSide--;
        }

        return numbers;
    }

    // **************************** HigherWins.txt **************************** 
    public int[] higherWins(int[] numbers) {
        int max;
        int length = numbers.length;

        if (numbers[0] < numbers[length - 1]) {
            max = numbers[length - 1];
        } else {
            max = numbers[0];
        }

        for (int i = 0; i < length; i++) {
            numbers[i] = max;
        }

        return numbers;
    }

    // **************************** GetMiddle.txt **************************** 
    public int[] getMiddle(int[] a, int[] b) {
        int[] middleNum = new int[2];

        middleNum[0] = a[1];
        middleNum[1] = b[1];

        return middleNum;
    }

    // **************************** HasEven.txt **************************** 
    public boolean hasEven(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    // **************************** KeepLast.txt **************************** 
    public int[] keepLast(int[] numbers) {
        int length = numbers.length;
        int[] newNumbers = new int[length * 2];

        newNumbers[length * 2 - 1] = numbers[length - 1];
        return newNumbers;
    }

    // **************************** Double23.txt **************************** 
    public boolean double23(int[] numbers) {
        int twoTwice = 0;
        int threeTwice = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 2) {
                twoTwice++;
            }
            if (numbers[i] == 3) {
                threeTwice++;
            }
            if (twoTwice > 2 || threeTwice > 2) {
                return false;
            }
        }
        return true;
    }

    // **************************** Fix23.txt **************************** 
    public int[] fix23(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == 2 && (i + 1) < length) {
                if (numbers[i + 1] == 3) {
                    numbers[i + 1] = 0;
                }
            }
        }
        return numbers;
    }

    // **************************** Unlucky.txt ****************************
    public boolean unlucky1(int[] numbers) {
        int length = numbers.length;

        switch (length) {
            case 1:
                return false;
            case 2:
                if (numbers[0] == 1 && numbers[1] == 3) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (numbers[0] == 1 && numbers[1] == 3) {
                    return true;
                } else if (numbers[1] == 1 && numbers[2] == 3) {
                    return true;
                } else {
                    return false;
                }
            default:
                if (numbers[0] == 1 && numbers[1] == 3) {
                    return true;
                } else if (numbers[1] == 1 && numbers[2] == 3) {
                    return true;
                } else if (numbers[length - 2] == 1 && numbers[length - 1] == 3) {
                    return true;
                } else {
                    return false;
                }
        }
    }
    // **************************** Make2.txt ****************************
    public int[] make2(int[] a, int[] b){
        int length = a.length;
        int[] result = new int[2];

        switch(length){
        case 0:
            result[0] = b[0];
            result[1] = b[1];
            break;
        case 1:
            result[0] = a[0];
            result[1] = b[0];
            break;
        default:
            result[0] = a[0];
            result[1] = a[1];
        }
        return result;
    }
}
