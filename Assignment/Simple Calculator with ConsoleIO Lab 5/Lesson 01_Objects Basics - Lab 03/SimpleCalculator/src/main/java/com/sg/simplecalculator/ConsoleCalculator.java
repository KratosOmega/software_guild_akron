/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author Kratos
 */
public class ConsoleCalculator {

    static double num1 = 0;
    static double num2 = 0;

    public static void main(String[] args) {

        ConsoleCalculator calculator = new ConsoleCalculator();
        String operation = "";

        while (true) {
            operation = calculator.chooseOperation();

            if (operation.equals("quit") || operation.equals("5")) {
                System.out.println("Thank You for using Kratos's Calculator!!!");
                break;
            } else {
                calculator.calculate(operation);
            }
        }
    }

    public String chooseOperation() {
        Scanner input = new Scanner(System.in);
        String operation;
        System.out.println("\n+--->>>> +-*/ <<<<---+");
        System.out.printf("|%-20s|\n", "Kratos's Calculator");
        System.out.printf("|%-20s|\n", "1. Addition (+)");
        System.out.printf("|%-20s|\n", "2. Subtraction (-)");
        System.out.printf("|%-20s|\n", "3. Muplication (*)");
        System.out.printf("|%-20s|\n", "4. Division (/)");
        System.out.printf("|%-20s|\n", "5. Quit (quit)");
        System.out.println("+--------------------+");
        System.out.println("Choose the operation...");
        System.out.print("> ");
        operation = input.next();

        return operation;
    }

    public double calculate(String operation) {

        MathOperation math = new MathOperation();

        switch (operation) {
            case "+":
            case "1":
                getOperands();
                System.out.println(num1 + " + " + num2 + " = " + String.format("%.2f", math.add(num1, num2)));
                return math.add(num1, num2);
            case "-":
            case "2":
                getOperands();
                System.out.println(num1 + " - " + num2 + " = " + String.format("%.2f", math.subtract(num1, num2)));
                return math.add(num1, num2);
            case "*":
            case "3":
                getOperands();
                System.out.println(num1 + " * " + num2 + " = " + String.format("%.2f", math.multiply(num1, num2)));
                return math.add(num1, num2);
            case "/":
            case "4":
                getOperands();
                if (math.divide(num1, num2) == 0 && num2 == 0) {
                    System.out.println("Division by 0? Seriously? I will just give you a big ZERO...");
                    System.out.println("Yes, I am laughing at you right now behind the computer...HAHAHA");
                    return 0;
                } else {
                    System.out.println(num1 + " / " + num2 + " = " + String.format("%.2f", math.divide(num1, num2)));
                    return math.add(num1, num2);
                }
            default:
                System.out.println("Invalid Operation!!!");
                return 0;
        }
    }

    public static void getOperands() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the 1st number: ");
        num1 = input.nextDouble();
        System.out.print("Enter the 2nd number: ");
        num2 = input.nextDouble();
    }
}
