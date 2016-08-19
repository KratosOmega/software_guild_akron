import java.util.Scanner;

public class MoreUserInputOfData{
    public static void main(String[] args){
        String firstName, lastName, loginName;
        int grade, id;
        double gpa;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the following information so I can sell it for a profit!");
        System.out.println("");


        System.out.print("First name: ");
        firstName = scanner.next();

        System.out.print("Last name: ");
        lastName = scanner.next();

        System.out.print("Grade (9-12): ");
        grade = scanner.nextInt();

        System.out.print("Student ID: ");
        id = scanner.nextInt();

        System.out.print("Login: ");
        loginName = scanner.next();

        System.out.print("GPA (0.0-4.0): ");
        gpa = scanner.nextDouble();

        System.out.println("");

        System.out.println("Your information:");
        System.out.println("         Login: " + loginName);
        System.out.println("         ID:    " + id);
        System.out.println("         Name:  " + lastName + ", " + firstName);
        System.out.println("         GPA:   " + gpa);
        System.out.println("         Grade: " + grade);
    }
}
