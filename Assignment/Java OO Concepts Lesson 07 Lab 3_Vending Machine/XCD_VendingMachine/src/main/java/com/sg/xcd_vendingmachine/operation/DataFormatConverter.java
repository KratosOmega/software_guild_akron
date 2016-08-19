/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.xcd_vendingmachine.operation;

/**
 *
 * @author Kratos
 */
public class DataFormatConverter {

    // ----------------------------------------------------------------------------- Convert input money (String version, which can have better percise than double) into integer
    // Ex: 1 -> 100
    // Ex: 1.00 -> 100
    // EX: 0.99 -> 99
    // Ex: 0.02 -> 2
    // EX: 1.12 -> 112
    // Only covert for positive number in format of 2 decimal point String version
    // This Method is created for some price calcualtion in precise perspective
    // Since double can not be used as perfect as good for 2 decimal calculation
    public int numberFormater_2Decimal_StringToInteger(String numInString) {
        boolean findDecimal = false;
        char[] charList = numInString.toCharArray();
        String formatedNum = "";
        // 0 ~ 9 in ASCII is 48 ~ 57 in decimal
        int startAT = 0;

        if (charList[0] == 45) {
            return -1;
        }

        if (charList[0] == 48) {
            startAT++;
        }

        for (int i = startAT; i < charList.length; i++) {
            if (charList[i] >= 48 && charList[i] <= 57) {
                formatedNum += charList[i] + "";
            }
            if (charList[i] == 46) {
                findDecimal = true;
            }
        }

        if (!findDecimal) {
            formatedNum = Integer.parseInt(formatedNum) * 100 + "";
        }

        return Integer.parseInt(formatedNum);
    }

    // ----------------------------------------------------------------------------- Convert integer back to String version for display
    // Ex: 100 -> 1.00
    // Ex; 99 -> 0.99
    // Ex: 2 -> 0.02
    public String numberFormater_2Decimal_IntegerToString(int num) {
        String formatedNum = "";
        String[] numList = (num + "").split("");

        if (num >= 100) {
            for (int i = 0; i < numList.length; i++) {
                if (i == numList.length - 2) {
                    formatedNum += "." + numList[i];
                } else {
                    formatedNum += numList[i];
                }
            }
            return formatedNum;
        } else if (num <= 99 && num >= 10) {
            return "0." + numList[0] + numList[1];
        } else {
            return "0.0" + numList[0];
        }
    }
}
