import java.util.Scanner;

public class Refresher2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name;
        int repeat = 10; // this is the key
        System.out.print("Your name: ");
        name = scanner.nextLine();
        System.out.println("");

        // One if
        if (name.equals("Mitchell")){
            repeat = 5;
        }

        // One for
        for (int i = 0; i < repeat; i++){
            System.out.println(name);
        }
    }
}
