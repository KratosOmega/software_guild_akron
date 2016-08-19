import java.util.Random;

public class LocatingLargest{
    public static void main(String[] args){
        int max = 0;
        int location = 0;
        int[] array = new int[10];
        Random random = new Random();

        System.out.print("Array: ");
        for (int i = 0; i < 10; i++){
            array[i] = 1 + random.nextInt(100);
            System.out.print(" " + array[i]);
        }
        System.out.print("\n\nThe largest value is: ");


        for (int i = 0; i < array.length; i++){
            if (max < array[i]){
                max = array[i];
                location = i;
            }
        }
        System.out.println(max);
        System.out.println("It is in slot " + (location + 1) + ".");
    }
}
