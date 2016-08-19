import java.util.Scanner;

public class CountingMachine{
    public static void main(String[] args){
        int counter;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Count to: ");
        counter = scanner.nextInt();

        for (int i = 0; i <= counter; i++){
            System.out.print(i + " ");
        }

        System.out.println("");
    }
}
