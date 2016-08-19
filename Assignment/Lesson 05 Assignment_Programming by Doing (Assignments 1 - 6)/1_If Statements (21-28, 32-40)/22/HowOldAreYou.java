
import java.util.Scanner;

public class HowOldAreYou {

    public static void main(String[] args) {
        String name;
        int age;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hey, what's your name? ");
        name = scanner.next();
        System.out.println("");

        System.out.print("Ok, " + name + ", how old are you? ");
        age = scanner.nextInt();
        System.out.println("");

        if (age < 16) {
            System.out.println("You can't drive.");
        }

        if (age < 18) {
            System.out.println("You can't vote.");
        }

        if (age < 25) {
            System.out.println("You can't rent a car.");
        }

        if (age >= 25) {
            System.out.println("You can do anything that's legal.");
        }
    }
}
