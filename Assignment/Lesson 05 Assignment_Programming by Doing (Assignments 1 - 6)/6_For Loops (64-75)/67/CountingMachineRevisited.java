import java.util.Scanner;


public class CountingMachineRevisited{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int countFrom, countTo, countBy;

        System.out.print("Count From: ");
        countFrom = scanner.nextInt();
        System.out.print("Count To: ");
        countTo = scanner.nextInt();
        System.out.print("Count By: ");
        countBy =scanner.nextInt();

        for (int i = countFrom; i < countTo; i += countBy){
            System.out.print(i + " ");
        }

        System.out.println("");
    }
}
