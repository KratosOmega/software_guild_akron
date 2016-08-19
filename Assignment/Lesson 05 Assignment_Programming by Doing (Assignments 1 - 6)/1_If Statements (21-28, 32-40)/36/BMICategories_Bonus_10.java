
import java.util.Scanner;

public class BMICategories_Bonus_10 {

    public static void main(String[] args) {
        float height, weight, bmi;
        String category = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your height in m: ");
        height = scanner.nextFloat();

        System.out.print("Your weight in kg: ");
        weight = scanner.nextFloat();

        bmi = weight / (height * height);

        if (bmi < 15.0){
            category = "very severely underweight";
        }

        if (bmi >= 15.0 && bmi <= 16.0){
            category = "severely underweight";
        }

        if (bmi >= 16.1 && bmi <= 18.4){
            category = "underweight";
        }

        if (bmi >= 18.5 && bmi <= 24.9){
            category = "normal weight";
        }

        if (bmi >= 25.0 && bmi <= 29.9){
            category = "overweight";
        }

        if (bmi >= 30.0 && bmi <= 34.9){
            category = "moderately obese";
        }

        if (bmi >= 35.0 && bmi <= 39.9){
            category = "severely obese";
        }

        if (bmi >= 40.0){
            category = "very severely obese";
        }

        System.out.println("");
        System.out.println("Your BMI is " + bmi);
        System.out.println("BMI Category: " + category);
    }
}
