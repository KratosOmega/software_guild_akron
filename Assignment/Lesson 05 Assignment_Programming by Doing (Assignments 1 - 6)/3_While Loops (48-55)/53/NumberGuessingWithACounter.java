import java.util.Scanner;
import java.util.Random;

public class NumberGuessingWithACounter{
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int num = 1 + random.nextInt(10);
        int guess;
        int tries = 0;

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        System.out.print("Your guess: ");
        guess = scanner.nextInt();
        tries++;

        while(guess != num){
            System.out.println("Your guess is wrong, please try again!");
            System.out.print("Your guess: ");
            guess = scanner.nextInt();
            tries++;
        }

        System.out.println("\nYour guess is right!!!");
        if (tries == 1){
            System.out.println("You had tried for " + tries + " time");
        }else {
            System.out.println("You had tried for " + tries + " times");
        }
    }
}
