
import java.util.Scanner;

public class GenderGame {

    public static void main(String[] args) {
        String gender, firstName, lastName;
        int age;
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your gender (M or F): ");
        gender = scanner.next();
        System.out.print("First Name: ");
        firstName = scanner.next();
        System.out.print("Last Name: ");
        lastName = scanner.next();
        System.out.print("Age: ");
        age = scanner.nextInt();

        if (age >= 20) {

            if (gender.equals("M")) {
                System.out.println("Then I shall call you Mr. " + lastName);
            } else {
                System.out.print("Are you married, " + firstName + " (y or n)? ");
                if (scanner.next().equals("y")) {
                    System.out.println("Then I shall call you Mrs. " + lastName);
                } else {
                    System.out.println("Then I shall call you Ms. " + lastName);
                }
            }
        } else {
            System.out.println("Then I shall call you " + firstName + " " + lastName);
        }
    }
}
