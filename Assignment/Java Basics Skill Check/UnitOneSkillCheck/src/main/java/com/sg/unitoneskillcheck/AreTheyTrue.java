/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.unitoneskillcheck;

/**
 *
 * @author Kratos
 */
public class AreTheyTrue {

    public static void main(String[] args) {
        System.out.println("This is the testing for AreTheyTrue.java --------: \n");
        AreTheyTrue areTheyTrue = new AreTheyTrue();
        System.out.print("The result of true and true = " + areTheyTrue.howTrue(true, true) + "\n");
        System.out.print("The result of false and false = " + areTheyTrue.howTrue(false, false) + "\n");
        System.out.print("The result of true and false = " + areTheyTrue.howTrue(true, false) + "\n");
        System.out.print("The result of false and true = " + areTheyTrue.howTrue(false, true) + "\n");
    }

    // ************************ non static method ************************
    public String howTrue(boolean truthOne, boolean truthTwo) {
        if (truthOne && truthTwo) {
            return "BOTH";
        } else if (truthOne || truthTwo) {
            return "ONLY ONE";
        } else {
            return "NEITHER";
        }
    }
}
