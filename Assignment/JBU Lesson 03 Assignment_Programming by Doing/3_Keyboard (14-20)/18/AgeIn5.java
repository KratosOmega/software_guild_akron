
import java.util.Scanner;

public class AgeIn5 {

    public static void main(String[] args) {
        String name;
        int age;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hello.  What is your name? ");
        name = scanner.next();
        System.out.println("");

        System.out.print("Hi, " + name + "! How old are you? ");
        age = scanner.nextInt();
        System.out.println("");

        System.out.println("Did you know that in five years you will be " + (age + 5) + " years old?");
        System.out.println("And five years ago you were " + (age - 5) + "! Imagine that!");

    }
}
