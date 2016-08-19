/*
 * Q1: It will be compiled, but at Runtime, it will report error due to the out of range of index since counter start from "0".
 * Q2: "box" length = 3, "x" index position = 2.
 * Q3: Because message's index range is starting from 0 to 30, even though the length is 31. Thus, if counter is set to equal to 31, it will report out of range error.
 *
 *
 */

import java.util.Scanner;

public class LetterAtATime {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("What is your message? ");
        String message = kb.nextLine();

        System.out.println("\nYour message is " + message.length() + " characters long.");
        System.out.println("The first character is at position 0 and is '" + message.charAt(0) + "'.");
        int lastpos = message.length() - 1;
        System.out.println("The last character is at position " + lastpos + " and is '" + message.charAt(lastpos) + "'.");
        System.out.println("\nHere are all the characters, one at a time:\n");

        for (int i = 0; i < message.length(); i++) {
            System.out.println("\t" + i + " - '" + message.charAt(i) + "'");
        }

        int vowels = 0;

        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            if (letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I' || letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U' ) {
                vowels++;
            }
        }

        System.out.println("\nYour message contains vowels (a A e E i I o O u U) " + vowels + " times. Isn't that interesting?");

    }
}
