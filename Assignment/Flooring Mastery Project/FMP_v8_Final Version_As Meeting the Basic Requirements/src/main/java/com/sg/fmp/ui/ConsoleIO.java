/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fmp.ui;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class ConsoleIO {

    Scanner scanner = new Scanner(System.in);

    // ------------ 1
    public int promptForInt(String prompt) {
        int result = 0;
        boolean quit;
        System.out.print(prompt);

        do {
            try {
                result = Integer.parseInt(scanner.nextLine());
                quit = true;
            } catch (Exception e) {
                System.out.print("\nInvalid Input! Enter again: ");
                quit = false;
            }
        } while (!quit);

        return result;
    }

    // ------------ 2
    public int promptForIntWithinRange(String prompt, int min, int max) {
        int result = 0;
        boolean quit;
        System.out.print(prompt);

        do {
            try {
                result = Integer.parseInt(scanner.nextLine());

                if (result < min || result > max) {
                    System.out.print("\nInvalid Input! Enter again: ");
                    quit = false;
                } else {
                    quit = true;
                }
            } catch (Exception e) {
                System.out.print("\nInvalid Input! Enter again: ");
                quit = false;
            }
        } while (!quit);

        return result;
    }

    // ------------ 3
    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // ------------ 4
    public float promptForFloat(String prompt) {
        float result = 0;
        boolean quit;
        System.out.print(prompt);

        do {
            try {
                result = Float.parseFloat(scanner.nextLine());
                quit = true;
            } catch (Exception e) {
                System.out.print("\nInvalid Input! Enter again: ");
                quit = false;
            }
        } while (!quit);

        return result;
    }

    // ------------ 5
    public float promptForFloatWithinRange(String prompt, float min, float max) {
        float result = 0;
        boolean quit;
        System.out.print(prompt);

        do {
            try {
                result = Float.parseFloat(scanner.nextLine());

                if (result < min || result > max) {
                    System.out.print("\nInvalid Input! Enter again: ");
                    quit = false;
                } else {
                    quit = true;
                }
            } catch (Exception e) {
                System.out.print("\nInvalid Input! Enter again: ");
                quit = false;
            }
        } while (!quit);

        return result;
    }

    // ------------ 6
    public double promptForDouble(String prompt) {
        double result = 0;
        boolean quit;
        System.out.print(prompt);

        do {
            try {
                result = Double.parseDouble(scanner.nextLine());
                quit = true;
            } catch (Exception e) {
                System.out.print("\nInvalid Input! Enter again: ");
                quit = false;
            }
        } while (!quit);

        return result;
    }

    // ------------ 7
    public double promptForDoubleWithinRange(String prompt, double min, double max) {
        double result = 0;
        boolean quit;
        System.out.print(prompt);

        do {
            try {
                result = Double.parseDouble(scanner.nextLine());

                if (result < min || result > max) {
                    System.out.print("\nInvalid Input! Enter again: ");
                    quit = false;
                } else {
                    quit = true;
                }
            } catch (Exception e) {
                System.out.print("\nInvalid Input! Enter again: ");
                quit = false;
            }
        } while (!quit);

        return result;
    }

    // ------------ 8
    public void display(String message) {
        System.out.print(message);
    }

    public void displayLn(String message) {
        System.out.println(message);
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
        scanner.nextLine();
    }

    public void newLine() {
        System.out.println("");
    }

    public void refreshScreen() {
        String newLine = "";
        for (int i = 0; i < 60; i++) {
            newLine += "\n";
        }
        System.out.println(newLine);
    }

    // ----------------- Formated Display
    public void leftAdj(int width, String front, String back, String pre_fix, String post_fix, Object content) {
        String modifier = "%-" + width + "s";
        System.out.printf(modifier, front + " " + pre_fix + content + post_fix + " " + back);
    }

    public void leftAdj_2Dec(int width, String front, String back, String pre_fix, String post_fix, Object content) {
        DecimalFormat decimalOf2 = new DecimalFormat("0.00");
//        Double price2 = Double.parseDouble(decimalOf2.format(price));

        String modifier = "%-" + width + "s";
        System.out.printf(modifier, front + " " + pre_fix + decimalOf2.format(content) + post_fix + " " + back);
    }

    // **************** Speacial Case For Mastery Project
    public double promptForDoubleWithinRange_SpecialCase(String prompt, double min, double max) {
        double result = 0;
        boolean quit;
        String input = "";
        System.out.print(prompt);

        do {
            input = scanner.nextLine();
            try {
                result = Double.parseDouble(input);

                if (result < min || result > max) {
                    System.out.print("\nInvalid Input! Enter again: ");
                    quit = false;
                } else {
                    quit = true;
                }
            } catch (Exception e) {
                if (input.equals("")) {
                    quit = true;
                    result = -1;
                } else {
                    System.out.print("\nInvalid Input! Enter again: ");
                    quit = false;
                }

            }
        } while (!quit);

        return result;
    }
}
