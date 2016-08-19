import java.util.Scanner;

public class ForgetfulMachine{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a word!");
        scanner.next();

        System.out.println("Give me a second word!");
        scanner.next();
        System.out.println("");

        System.out.println("Great, now your favorite number?");
        scanner.nextInt();

        System.out.println("And your second-favorite number...");
        scanner.nextInt();
        System.out.println("");

        System.out.println("Whew!  Wasn't that fun?");
    }
}
