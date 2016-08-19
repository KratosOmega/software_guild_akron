/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.unitoneskillcheck;

import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class WhatIsYourNumber {

    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is the testing for WhatIsYourNumber.java --------: \n");
        System.out.print("Enter a number here: ");
        num = scanner.nextInt();

        System.out.println("The number that you enter is: " + num + "\n");

        Counter counter = new Counter();
        counter.toN(num);
        System.out.println("\nThank you for playing");
    }
}
