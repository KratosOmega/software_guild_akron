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
public class Counter {

    public static void main(String[] args) {
        System.out.println("This is the testing for Counter.java --------: \n");
        Counter counter = new Counter();
        System.out.println("Testing for \"toTen\"\n");
        counter.toTen();
        System.out.println("\nTesting for \"toN\"");
        System.out.println("\nCount to 3...");
        counter.toN(3);
        System.out.println("\nCount to 8...");
        counter.toN(8);
        System.out.println("\nCount to 200...");
        counter.toN(200);
    }

    // ************************ non static method ************************
    public void toTen() {
        System.out.println("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n");
    }

    public void toN(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(i);
        }
    }
}
