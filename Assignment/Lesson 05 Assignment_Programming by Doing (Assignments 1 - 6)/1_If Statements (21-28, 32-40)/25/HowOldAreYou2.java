import java.util.Scanner;

public class HowOldAreYou2{
    public static void main(String[] args){
        String name;
        int age;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Hey, what's your name? (Sorry, I keep forgetting.) ");
        name = scanner.next();

        System.out.print("Ok, " + name + " , how old are you? ");
        age = scanner.nextInt();


        if (age < 16){
            System.out.print("You can't drive, ");
        }else if (age <= 17){
            System.out.print("You can drive but not vote, ");
        }else if (age <= 24){
            System.out.print("You can vote but not rent a car, ");
        }else {
            System.out.print("You can do pretty much anything, ");
        }

        System.out.println(name + ".");
    }
}
