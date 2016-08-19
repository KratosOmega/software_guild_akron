import java.util.Scanner;
import java.util.Random;

public class HiLoLimited{
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = 1 + random.nextInt(100);
        int guess;
        int tries = 0;

        System.out.println("I have chosen a number between 1 ~ 100. Try to guess it.");
        System.out.print("Guess # "+ (tries + 1) +": ");
        guess = scanner.nextInt();
        tries++;

        while(guess != num && tries <7){
            if (guess > num){
                System.out.println("You guess is too high!");
                System.out.print("Guess # "+ (tries + 1) +": ");
                guess = scanner.nextInt();
                tries++;
            }else {
                System.out.println("You guess is too low!");
                System.out.print("Guess # "+ (tries + 1) +": ");
                guess = scanner.nextInt();
                tries++;
            }
        }

        if (tries >= 7){
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
            System.out.println("The correct number is " + num);
        }

        if (guess == num){
            System.out.println("You guessed it!  What are the odds?!?");
        }
    }
}
