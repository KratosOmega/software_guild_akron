
import java.util.Scanner;

public class BMICalc_Bonus_ImperialMeasurements_10 {

    public static void main(String[] args) {
        float height, weight;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your height in inches: ");
        height = scanner.nextFloat();
        height = height * 0.0254f;

        System.out.print("Your weight in pounds: ");
        weight = scanner.nextFloat();
        weight = weight * 0.453592f;

        System.out.println("");

        System.out.println("Your BMI is " + (weight / (height * height)));
    }
}
