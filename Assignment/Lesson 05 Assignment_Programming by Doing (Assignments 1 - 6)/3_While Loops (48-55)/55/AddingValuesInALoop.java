import java.util.Scanner;

public class AddingValuesInALoop{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int addNum;
        int sum = 0;

        System.out.println("I will add up the numbers you give me.");
        System.out.print("Number: ");
        addNum = scanner.nextInt();

        while (addNum != 0){
            sum += addNum;
            System.out.println("The total so far is " + sum);
            System.out.print("Number: ");
            addNum = scanner.nextInt();
        }

        System.out.println("The total is " + sum);
    }
}
