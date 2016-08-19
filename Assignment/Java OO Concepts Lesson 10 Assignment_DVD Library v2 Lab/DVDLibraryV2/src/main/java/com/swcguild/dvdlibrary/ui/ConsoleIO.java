/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.ui;

import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class ConsoleIO {

    Scanner input = new Scanner(System.in);

    // ------------ 1
    public int promptForInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    // ------------ 2
    public int promptForIntWithinRange(String prompt, int min, int max) {
        int result;
        System.out.print(prompt);
        try {
            result = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            result = 0;
        }

        while (result < min || result > max) {
            System.out.println("\nInvalid Input! Enter again!\n");
            System.out.print(prompt);
            try {
                result = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                result = 0;
            }
        }

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

        try {
            return Float.parseFloat(input.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    // ------------ 5
    public float promptForFloatWithinRange(String prompt, float min, float max) {
        float result;
        System.out.print(prompt);
        try {
            result = Float.parseFloat(input.nextLine());
        } catch (Exception e) {
            result = 0;
        }

        while (result < min || result > max) {
            System.out.println("\nInvalid Input! Enter again!\n");
            System.out.print(prompt);
            try {
                result = Float.parseFloat(input.nextLine());
            } catch (Exception e) {
                result = 0;
            }
        }

        return result;
    }

    // ------------ 6
    public double promptForDouble(String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    // ------------ 7
    public double promptForDoubleWithinRange(String prompt, double min, double max) {
        double result;
        System.out.print(prompt);
        try {
            result = Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            result = 0;
        }

        while (result < min || result > max) {
            System.out.println("\nInvalid Input! Enter again!\n");
            System.out.print(prompt);
            try {
                result = Double.parseDouble(input.nextLine());
            } catch (Exception e) {
                result = 0;
            }
        }

        return result;
    }

    // ------------ 8
    public void display(String message) {
        System.out.print(message);
    }

    // ------------ 9 Customized Display
    public void displayFormated(String msg1, String msg2, String msg3) {
        System.out.printf("[%-12s] -> $ %-5s (%-2s)  **\n", msg1, msg2, msg3);
    }

    public void printOut(String prompt) {
        System.out.println(prompt);
    }

    // ------------- 10 Utilities
    public void killNewLine() {
        input.nextLine();
    }
}
