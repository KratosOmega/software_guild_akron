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
public class Adder {

    public static void main(String[] args) {
        System.out.println("This is the testing for Adder.java --------: \n");
        Adder adder = new Adder();
        System.out.print("The result of 1 + 1 =" + adder.add(1, 1) + "\n");
        System.out.print("The result of 2 + 3 =" + adder.add(2, 3) + "\n");
        System.out.print("The result of 5 + 8 =" + adder.add(5, 8) + "\n");
        System.out.print("The result of 42 + 95 =" + adder.add(42, 95) + "\n");
    }

    // ************************ non static method ************************
    public int add(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }
}
