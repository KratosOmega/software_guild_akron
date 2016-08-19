
import java.util.Scanner;

public class SpaceBoxing {

    public static void main(String[] args) {

        double earthWeight, planetWeight;
        int planetID;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your current earth weight: ");
        earthWeight = scanner.nextDouble();

        System.out.println("\nI have information for the following planets:");
        System.out.println("1. Venus   2. Mars    3. Jupiter");
        System.out.println("4. Saturn  5. Uranus  6. Neptune");

        System.out.print("\nWhich planet are you visiting? ");
        planetID = scanner.nextInt();

        if (planetID == 1) {
            planetWeight = earthWeight * 0.78;
        } else if (planetID == 2) {
            planetWeight = earthWeight * 0.39;
        } else if (planetID == 3) {
            planetWeight = earthWeight * 2.65;
        } else if (planetID == 4) {
            planetWeight = earthWeight * 1.17;
        } else if (planetID == 5) {
            planetWeight = earthWeight * 1.05;
        } else {
            planetWeight = earthWeight * 1.23;
        }

        System.out.println("\nYour weight would be " + planetWeight + " pounds on that planet.");
    }
}
