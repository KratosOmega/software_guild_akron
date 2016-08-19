
import java.util.Scanner;

public class BMICategories {

    public static void main(String[] args) {
        float height, weight, bmi;
        String category = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your height in m: ");
        height = scanner.nextFloat();

        System.out.print("Your weight in kg: ");
        weight = scanner.nextFloat();

        bmi = weight / (height * height);

        if (bmi < 18.5){
            category = "underweight";
        }

        if (bmi >= 18.5 && bmi <= 24.9){
            category = "normal weight";
        }

        if (bmi >= 25.0 && bmi <= 29.9){
            category = "overweight";
        }

        if (bmi >= 30.0){
            category = "obese";
        }

        System.out.println("");
        System.out.println("Your BMI is " + bmi);
        System.out.println("BMI Category: " + category);
    }
}
