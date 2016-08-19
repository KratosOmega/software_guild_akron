import java.util.Scanner;
import java.util.Random;

public class OneShotHiLo{
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = 1 + random.nextInt(100);
        int guessNum;

        System.out.println("I'm thinking of a number between 1-100.  Try to guess it.");
        System.out.print("> ");
        guessNum = scanner.nextInt();

        if (guessNum == num){
            System.out.println("You got it correct!!!");
        }else if (guessNum > num){
            System.out.println("Sorry, you are too high.  I was thinking of " + num + ".");
        }else {
            System.out.println("Sorry, you are too low.  I was thinking of " + num + ".");
        }
    }
}
