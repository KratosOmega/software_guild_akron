import java.util.Scanner;

public class CollatzSequence_Bonus_1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        int nextLine = 0;
        int steps = 0;

        System.out.print("Starting number: ");
        n = scanner.nextInt();
        System.out.printf("%15s", n); // use printf & ("%15s",n) to format the columns
        nextLine++;

        while (n > 1){
            if (n%2 == 0){
                n = n / 2;
            }else {
                n = 3*n+1;
            }
            System.out.printf("%15s", n);
            nextLine++;
            steps++;

            if (nextLine > 9){
                System.out.print("\n");
                nextLine = 0;
            }
        }
        System.out.println("");
        System.out.println("Terminated after " + steps + " steps.");
    }
}
