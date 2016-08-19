
import java.util.Scanner;

public class BMICalc_Bonus_ImperialMeasurements_13 {

    public static void main(String[] args) {
        int height_feetPart, height_inchPart;
        float height, weight;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your height (feet only): ");
        height_feetPart = scanner.nextInt();

        System.out.print("Your height (inches): ");
        height_inchPart = scanner.nextInt();

        System.out.print("Your weight in pounds: ");
        weight = scanner.nextFloat();

        System.out.println("");

        height = (height_feetPart * 12 + height_inchPart) * 0.0254f;
        weight = weight * 0.453592f;

        System.out.println("Your BMI is " + (weight / (height * height)));
    }
}
