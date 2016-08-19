import java.util.Scanner;

public class SafeSquareRoot{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num;

        System.out.println("SQUARE ROOT!");
        System.out.print("Enter a number: ");
        num = scanner.nextInt();

        while (num < 0){
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.print("Try again: ");
            num = scanner.nextInt();
        }

        System.out.println("The sequare root of " + num + " is " + Math.sqrt(num) + ".");
    }
}
