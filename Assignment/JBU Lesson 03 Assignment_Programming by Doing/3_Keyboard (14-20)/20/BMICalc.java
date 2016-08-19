
import java.util.Scanner;

public class BMICalc {

    public static void main(String[] args) {
        float height, weight;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your height in m: ");
        height = scanner.nextFloat();

        System.out.print("Your weight in kg: ");
        weight = scanner.nextFloat();

        System.out.println("");

        System.out.println("Your BMI is " + (weight / (height * height)));
    }
}
