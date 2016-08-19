import java.util.Scanner;
import java.util.Random;

public class IsItThereOrNot{
    public static void main(String[] args){
        int[] array = new int[10];
        int search = 0;
        boolean notFound = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Array: ");
        for (int i = 0; i < 10; i++){
            array[i] = 1 + random.nextInt(50);
            System.out.print(" " + array[i]);
        }
        System.out.print("\nValue to find: ");
        search = scanner.nextInt();
        System.out.println("");

        for (int i = 0; i < array.length; i++){
            if(search == array[i]){
                System.out.println(search + " is in the array.");
                notFound = false;
            }
        }

        if(notFound){
            System.out.println(search + " is not in the array.");
        }
    }
}
