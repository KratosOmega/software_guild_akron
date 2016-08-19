
import java.util.Scanner;

public class LittleQuiz {

    public static void main(String[] args) {
        String readyOrNot;
        int score = 0;
        int answer;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Are you ready for a quiz? ");
        readyOrNot = scanner.next();

        if ("N".equals(readyOrNot) || "n".equals(readyOrNot) || "No".equals(readyOrNot) || "no".equals(readyOrNot)) {
            System.out.print("Okay, take your time. Please type \"Ready\" when your are ready to go... ");
            readyOrNot = scanner.next();
        }else {
            readyOrNot = "Ready";
        }

        // Quiz Quesitons
        if ("Ready".equals(readyOrNot)) {
            System.out.println("Okay, here it comes!\n\n");

            // First Question
            System.out.println("Q1) What is the capital of Alaska?");
            System.out.println("         1) Melbourne");
            System.out.println("         2) Anchorage");
            System.out.println("         3) Juneau\n");
            System.out.print("> ");
            answer = scanner.nextInt();

            if (answer == 3) {
                score++;
                System.out.println("\nThat's right!\n");
            } else if (answer == 1) {
                System.out.println("\nSorry, \"Melbourne\" is not the capital of Alaska.\n");
            } else if (answer == 1) {
                System.out.println("\nSorry, \"Anchorage\" is not the capital of Alaska.\n");
            } else {
                System.out.println("\nYou selected a invalid option!\n");
            }

            // Second Question
            System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
            System.out.println("         1) Yes");
            System.out.println("         2) No\n");
            System.out.print("> ");
            answer = scanner.nextInt();

            if (answer == 2) {
                score++;
                System.out.println("\nThat's right!\n");
            } else if (answer == 1) {
                System.out.println("\nSorry, \"cat\" is a string. ints can only store numbers.\n");
            } else {
                System.out.println("\nYou selected a invalid option!\n");
            }

            // Third Question
            System.out.println("Q3) What is the result of 9+6/3?");
            System.out.println("         1) 5");
            System.out.println("         2) 11");
            System.out.println("         3) 15/3\n");
            System.out.print("> ");
            answer = scanner.nextInt();

            if (answer == 2) {
                score++;
                System.out.println("\nThat's right!\n");
            } else if (answer == 1) {
                System.out.println("\nSorry, \"5\" is not the correct answer.\n");
            } else if (answer == 3) {
                System.out.println("\nSorry, \"15/3\" is not the correct answer.\n");
            } else {
                System.out.println("\nYou selected a invalid option!\n");
            }

            System.out.println("Overall, you got " + score + " out of 3 correct.");
            System.out.println("Thanks for playing!");
        }
    }
}
