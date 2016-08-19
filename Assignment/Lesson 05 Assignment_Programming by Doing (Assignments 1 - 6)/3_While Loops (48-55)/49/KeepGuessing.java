import java.util.Scanner;
import java.util.Random;

public class KeepGuessing{
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int num = 1 + random.nextInt(10);
        int guess;

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        System.out.print("Your guess: ");
        guess = scanner.nextInt();

        while(guess != num){
            System.out.println("Your guess is wrong, please try again!");
            System.out.print("Your guess: ");
            guess = scanner.nextInt();
        }

        System.out.println("\nYour guess is right!!!");
    }
}
