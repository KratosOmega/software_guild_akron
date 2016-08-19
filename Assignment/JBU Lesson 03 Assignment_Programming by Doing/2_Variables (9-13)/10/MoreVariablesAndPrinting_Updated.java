
public class MoreVariablesAndPrinting_Updated {

    public static void main(String[] args) {
        String name, eyes, teeth, hair;
        int age, height, weight;
        double height_in_cm, weight_in_kg;

        name = "Zed A. Shaw";
        age = 35;     // not a lie
        height = 74;  // inches
        height_in_cm = height * 2.54; // inches are converted into centimeters
        weight = 180; // lbs
        weight_in_kg = weight * 0.453592; // lbs are converted into kilos
        eyes = "Blue";
        teeth = "White";
        hair = "Brown";

        System.out.println("Let's talk about " + name + ".");
        System.out.println("He's " + height + " inches (or " + height_in_cm + " cm) tall.");
        System.out.println("He's " + weight + " pounds (or " + weight_in_kg + " kg) heavy.");
        System.out.println("Actually, that's not too heavy.");
        System.out.println("He's got " + eyes + " eyes and " + hair + " hair.");
        System.out.println("His teeth are usually " + teeth + " depending on the coffee.");

        // This line is tricky; try to get it exactly right.
        System.out.println("If I add " + age + ", " + height + ", and " + height + " I get " + (age + height + weight) + ".");
    }
}
