
import java.util.Scanner;

public class TwentyQuestions {

    public static void main(String[] args) {
        String type, size;
        String answer = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("TWO QUESTIONS!");
        System.out.println("Think of an object, and I'll try to guess it.");
        System.out.println("\nQuestion 1) Is it animal, vegetable, or mineral?");
        System.out.print("> ");
        type = scanner.next();

        System.out.println("\nQuestion 2) Is it bigger than a breadbox?");
        System.out.print("> ");
        size = scanner.next();

        if (type.equals("animal")) {
            if (size.equals("yes")) {
                answer = "moose";
            } else if (size.equals("no")) {
                answer = "squirrel";
            }
        } else if (type.equals("vegetable")) {
            if (size.equals("yes")) {
                answer = "watermelon";
            } else if (size.equals("no")) {
                answer = "carrot";
            }
        } else if (type.equals("mineral")) {
            if (size.equals("yes")) {
                answer = "Camaro";
            } else if (size.equals("no")) {
                answer = "paper clip";
            }
        }

        System.out.println("\nMy guess is that you are thinking of a " + answer + ".");
        System.out.println("I would ask you if I'm right, but I don't actually care.");
    }
}
