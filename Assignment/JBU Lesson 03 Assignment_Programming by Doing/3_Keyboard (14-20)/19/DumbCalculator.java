
import java.util.Scanner;

public class DumbCalculator {

    public static void main(String[] args) {

        double numOne, numTwo, numThree;
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your first number? ");
        numOne = scanner.nextDouble();
        System.out.print("What is your second number? ");
        numTwo = scanner.nextDouble();
        System.out.print("What is your third number? ");
        numThree = scanner.nextDouble();

        System.out.println("");
        System.out.println("( " + numOne + " + " + numTwo + " + " + numThree + " ) / 2 is... " + (numOne + numTwo + numThree) / 2);
    }
}
