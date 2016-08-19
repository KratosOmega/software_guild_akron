/*
 * Question 1: I think what the "if" does to the code under it, is to make a decesion of whether excute the codes or not base on the "true" or "false" value in its parentheses. If "if" gets a "true" value, it will execute the code below it. Otherwise, it won't.
 *
 * Question 2: The curly braces in the "if" statement are used to set the scope. Everything within the "if" statement's curly braces will either be excuted or ignored depends on the "true" or "false" value in the "if" parentheses.
 *
 * Question 3: Modification is added into the code
 *
 */

public class WhatIf {

    public static void main(String[] args) {
        int people = 20;
        // Line below is the original code line, it will be comment out and a new line will be added accroding to the assignment requirement
        //int cats = 30;
        int cats = 20; // This is the new line

        int dogs = 15;

        if (people < cats) {
            System.out.println("Too many cats!  The world is doomed!");
        }

        if (people > cats) {
            System.out.println("Not many cats!  The world is saved!");
        }

        if (people < dogs) {
            System.out.println("The world is drooled on!");
        }

        if (people > dogs) {
            System.out.println("The world is dry!");
        }

        dogs += 5;

        if (people >= dogs) {
            System.out.println("People are greater than or equal to dogs.");
        }

        if (people <= dogs) {
            System.out.println("People are less than or equal to dogs.");
        }

        if (people == dogs) {
            System.out.println("People are dogs.");
        }
    }
}
