import java.util.Scanner;
import java.util.Random;

public class NumberGuess{
    public static void main(String[] args){
        Random random = new Random();
        int secretNum = 1 + random.nextInt(10);
        Scanner scanner = new Scanner(System.in);

        System.out.println("I'm thinking of a number from 1 to 10.");
        System.out.print("Your guess: ");

        if(scanner.nextInt() == secretNum){
            System.out.println("Correct!!! You got it right, my secret number is: " + secretNum);
        }else {
            System.out.println("Wrong!!! My secret number is: " + secretNum);
        }
    }
}
