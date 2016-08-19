/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.consoleiocalculator;

/**
 *
 * @author Kratos
 */
public class ConsoleCalculator {

    static double num1;
    static double num2;

    public static void main(String[] args) {
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        ConsoleCalculator calculator = new ConsoleCalculator();
        String operation;

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
        ConsoleIOCalculator console = new ConsoleIOCalculator();
        String operation;

        console.display("\n+--->>>> +-*/ <<<<---+\n");
        console.displayFormated("Kratos's Calculator");
        console.displayFormated("1. Addition (+)");
        console.displayFormated("2. Subtraction (-)");
        console.displayFormated("3. Muplication (*)");
        console.displayFormated("4. Division (/)");
        console.displayFormated("5. Quit (quit)");
        console.display("+--------------------+\n");
        operation = console.promptForString("Choose your operation:\n> ");

        return operation;
    }

    public double calculate(String operation) {

        ConsoleIOCalculator console = new ConsoleIOCalculator();
        MathOperation math = new MathOperation();

        switch (operation) {
            case "+":
            case "1":
                getOperands();
                console.display(num1 + " + " + num2 + " = " + String.format("%.2f", math.add(num1, num2)) + "\n");
                return math.add(num1, num2);
            case "-":
            case "2":
                getOperands();
                console.display(num1 + " - " + num2 + " = " + String.format("%.2f", math.subtract(num1, num2)) + "\n");
                return math.add(num1, num2);
            case "*":
            case "3":
                getOperands();
                console.display(num1 + " * " + num2 + " = " + String.format("%.2f", math.multiply(num1, num2)) + "\n");
                return math.add(num1, num2);
            case "/":
            case "4":
                getOperands();
                if (math.divide(num1, num2) == 0 && num2 == 0) {
                    console.display("Division by 0? Seriously? I will just give you a big ZERO...\n");
                    console.display("Yes, I am laughing at you right now behind the computer...HAHAHA\n");
                    return 0;
                } else {
                    console.display(num1 + " / " + num2 + " = " + String.format("%.2f", math.divide(num1, num2)) + "\n");
                    return math.add(num1, num2);
                }
            default:
                console.display("Invalid Operation!!!\n");
                return 0;
        }
    }

    public static void getOperands() {
        ConsoleIOCalculator console = new ConsoleIOCalculator();

        num1 = console.promptForDouble("Enter the 1st number: ");
        num2 = console.promptForDouble("Enter the 2nd number: ");
    }
}
