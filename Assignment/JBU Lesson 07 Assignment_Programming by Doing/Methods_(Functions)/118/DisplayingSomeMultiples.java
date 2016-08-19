import java.util.Scanner;

public class DisplayingSomeMultiples{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print("Choose a number: ");
        num = scanner.nextInt();
        System.out.println("");

        for (int i = 1; i <= 12; i ++){
            System.out.println(num + "x" + i + " = " + (num*i));
        }
    }
}
