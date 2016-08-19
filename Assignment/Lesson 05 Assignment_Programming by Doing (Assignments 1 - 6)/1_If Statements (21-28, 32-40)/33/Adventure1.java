
import java.util.Scanner;

public class Adventure1 {

    public static void main(String[] args) {
        int nextRoom;
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO MITCHELL'S TINY ADVENTURE!\n");
        System.out.println("You are in a creepy house and you are in \"Room 1\"!");
        System.out.println("Select which room you want to explore by entering the \"1\" or \"2\". ");
        System.out.println("         1. Room 2");
        System.out.println("         2. Room 3");
        System.out.print("> ");
        nextRoom = scanner.nextInt();

        // First Selection Layer: Choose R2
        if (nextRoom == 1) {
            System.out.println("Now, you are in \"Room 2\", please make your decision for the next room:");
            System.out.println("         1. Room 4");
            System.out.println("         2. Room 5");
            System.out.print("> ");
            nextRoom = scanner.nextInt();

            // Second Selection Layer: Choose R4
            if (nextRoom == 1) {
                System.out.println("Now, you are in \"Room 4\", please make your decision for what to do in this room:");
                System.out.println("         1. Do something");
                System.out.println("         2. Do nothing");
                System.out.print("> ");
                nextRoom = scanner.nextInt();

                // Third Selection Layer: Choose do something
                if (nextRoom == 1) {
                    System.out.println("=========> You got Ending-1!");
                } // Third Selection Layer: Choose do nothing
                else if (nextRoom == 2) {
                    System.out.println("=========> You got Ending-2!");
                }
            } // Second Selection Layer: Choose R5
            else if (nextRoom == 2) {
                System.out.println("Now, you are in \"Room 5\", please make your decision for what to do in this room:");
                System.out.println("         1. Do something");
                System.out.println("         2. Do nothing");
                System.out.print("> ");
                nextRoom = scanner.nextInt();

                // Third Selection Layer: Choose do something
                if (nextRoom == 1) {
                    System.out.println("=========> You got Ending-3!");
                } // Third Selection Layer: Choose do nothing
                else if (nextRoom == 2) {
                    System.out.println("=========> You got Ending-4!");
                }
            }
        } // First Selection Layer: Choose R3
        else if (nextRoom == 2) {
            System.out.println("Now, you are in \"Room 3\", please make your decision for the next room:");
            System.out.println("         1. Room 6");
            System.out.println("         2. Room 7");
            System.out.print("> ");
            nextRoom = scanner.nextInt();

            // Second Selection Layer: Choose R6
            if (nextRoom == 1) {
                System.out.println("Now, you are in \"Room 4\", please make your decision for what to do in this room:");
                System.out.println("         1. Do something");
                System.out.println("         2. Do nothing");
                System.out.print("> ");
                nextRoom = scanner.nextInt();

                // Third Selection Layer: Choose do something
                if (nextRoom == 1) {
                    System.out.println("=========> You got Ending-5!");
                } // Third Selection Layer: Choose do nothing
                else if (nextRoom == 2) {
                    System.out.println("=========> You got Ending-6!");
                }
            } // Second Selection Layer: Choose R7
            else if (nextRoom == 2) {
                System.out.println("Now, you are in \"Room 5\", please make your decision for what to do in this room:");
                System.out.println("         1. Do something");
                System.out.println("         2. Do nothing");
                System.out.print("> ");
                nextRoom = scanner.nextInt();

                // Third Selection Layer: Choose do something
                if (nextRoom == 1) {
                    System.out.println("=========> You got Ending-7!");
                } // Third Selection Layer: Choose do nothing
                else if (nextRoom == 2) {
                    System.out.println("=========> You got Ending-8!");
                }
            }
        }
    }
}
