/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class ConsoleIOCalculator {

    Scanner input = new Scanner(System.in);

    // ------------ 1
    public int promptForInt(String prompt) {
        System.out.print(prompt);
        return input.nextInt();
    }

    // ------------ 2
    public int promptForIntWithinRange(String prompt, int min, int max) {
        int result;

        do {
            System.out.print(prompt);
            result = input.nextInt();
        } while (result < min || result > max);

        return result;
    }

    // ------------ 3
    public String promptForString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    // ------------ 4
    public float promptForFloat(String prompt) {
        System.out.print(prompt);
        return input.nextFloat();
    }

    // ------------ 5
    public float promptForFloatWithinRange(String prompt, float min, float max) {
        float result;

        do {
            System.out.print(prompt);
            result = input.nextFloat();
        } while (result < min || result > max);

        return result;
    }

    // ------------ 6
    public double promptForDouble(String prompt) {
        System.out.print(prompt);
        return input.nextDouble();
    }

    // ------------ 7
    public double promptForDoubleWithinRange(String prompt, double min, double max) {
        double result;

        do {
            System.out.print(prompt);
            result = input.nextDouble();
        } while (result < min || result > max);

        return result;
    }

    // ------------ 8
    public void display(String message) {
        System.out.print(message);
    }
    
    // ------------ 9 Customized Display
    public void displayFormated(String message) {
        System.out.printf("|%-20s|\n", message);
    }
}
