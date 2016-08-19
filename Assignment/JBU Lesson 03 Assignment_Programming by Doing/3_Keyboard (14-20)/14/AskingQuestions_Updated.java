
import java.util.Scanner;

public class AskingQuestions_Updated {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int age;
        int height_feetPart;
        int height_inchPart;
        double weight;

        System.out.print("How old are you? ");
        age = keyboard.nextInt();

        System.out.print("How many feet tall are you? ");
        height_feetPart = keyboard.nextInt();

        System.out.print("And how many inches? ");
        height_inchPart = keyboard.nextInt();

        System.out.print("How much do you weigh? ");
        weight = keyboard.nextDouble();

        System.out.println("So you're " + age + " old, " + height_feetPart + "'" + height_inchPart + "\"" + " tall and " + weight + " heavy.");
    }
}
