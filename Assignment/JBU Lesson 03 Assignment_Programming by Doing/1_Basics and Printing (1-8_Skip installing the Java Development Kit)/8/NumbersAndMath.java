
public class NumbersAndMath {

    public static void main(String[] args) {
        // This is a message to explain what action will be done
        System.out.println("I will now count my chickens:");

        // Display "Hens" & the counts of Hens after finishing the calculation of (25 + 30 / 6)
        System.out.println("Hens " + (25 + 30 / 6));
        // Display "Roosters" & the counts of Hens after finishing the calculation of (100 - 25 * 3 % 4)
        System.out.println("Roosters " + (100 - 25 * 3 % 4));

        // This is a message to explain what action will be done
        System.out.println("Now I will count the eggs:");

        // Display the counts of eggs after finishing the calculation of (3 + 2 + 1 - 5 + 4 % 2 - 1 / 4 + 6)
        //System.out.println(3 + 2 + 1 - 5 + 4 % 2 - 1 / 4 + 6);

        // Since whole number calculation will eliminate the fractions automatically
        // it is necessary to add floating point number into the calculation which requires the fractions
        // Thus, I replace the "1" with "1.0"
        System.out.println(3 + 2 + 1 - 5 + 4 % 2 - 1.0 / 4 + 6); //This line is rewrited base on the above comment-out code

        // This is a message that throws a question
        System.out.println("Is it true that 3 + 2 < 5 - 7?");

        // Display the answer to the question above after finishing the calculation of (3 + 2 < 5 - 7)
        System.out.println(3 + 2 < 5 - 7);

        // Display a question & answer it after finishing the calculation of (3 + 2)
        System.out.println("What is 3 + 2? " + (3 + 2));
        // Display a question & answer it after finishing the calculation of (5 - 7)
        System.out.println("What is 5 - 7? " + (5 - 7));

        // Display a message
        System.out.println("Oh, that's why it's false.");

        // Display a message
        System.out.println("How about some more.");

        // Display a question & answer it after the comparison of (5 > -2)
        System.out.println("Is it greater? " + (5 > -2));
        // Display a question & answer it after the comparison of (5 >= -2)
        System.out.println("Is it greater or equal? " + (5 >= -2));
        // Display a question & answer it after the comparison of (5 <= -2)
        System.out.println("Is it less or equal? " + (5 <= -2));
    }
}
