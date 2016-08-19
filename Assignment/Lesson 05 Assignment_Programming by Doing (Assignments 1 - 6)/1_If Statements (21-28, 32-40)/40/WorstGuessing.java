import java.util.Scanner;

public class WorstGuessing{
    public static void main(String[] args){
        int secretNum = 7;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Worst Guessing Game EVER!!!");
        System.out.print("Please enter a number within 1-10 to guess what is my secret number: ");

        if(scanner.nextInt() == secretNum){
            System.out.println("Correct!!! You got it right, my secret number is: " + secretNum);
        }else {
            System.out.println("Wrong!!! My secret number is: " + secretNum);
        }
    }
}
