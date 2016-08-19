import java.util.Scanner;

public class AddingValuesForLoop{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int endNum;
        int sum = 0;

        System.out.print("Number: ");
        endNum  = scanner.nextInt();
        System.out.println("");

        for (int i = 1; i <= endNum; i++){
            System.out.print(i + " ");
            sum += i;
        }

        System.out.println("\nThe sum is " + sum);
    }
}
