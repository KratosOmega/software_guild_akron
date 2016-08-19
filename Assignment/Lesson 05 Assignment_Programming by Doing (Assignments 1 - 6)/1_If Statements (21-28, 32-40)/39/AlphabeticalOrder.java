
import java.util.Scanner;

public class AlphabeticalOrder {

    public static void main(String[] args) {
        String lastName;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your last name: ");
        lastName = scanner.next();

        if (lastName.compareTo("Carswell") <= 0) {
            System.out.println("You don't have to wait long before we get to you, \"" + lastName + "\".");
        } else if (lastName.compareTo("Jones") <= 0) {
            System.out.println("That's not bad before we get to you, \"" + lastName + "\".");
        } else if (lastName.compareTo("Smith") <= 0) {
            System.out.println("Looks like a bit of a wait before we get to you, \"" + lastName + "\".");
        } else if (lastName.compareTo("Young") <= 0) {
            System.out.println("It's gonna be a while before we get to you, \"" + lastName + "\".");
        } else if (lastName.compareTo("Young") > 0) {
            System.out.println("Not going anywhere for a while before we get to you, \"" + lastName + "\".");
        }
    }
}
