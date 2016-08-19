import java.util.Random;

public class CopyingArrays{
    public static void main(String[] arge){
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        Random random = new Random();
        String arrayOne = "Array 1: ";
        String arrayTwo = "Array 2: ";

        for(int i = 0; i < array1.length; i++){
            array1[i] = 1 + random.nextInt(100);
        }

        for(int i = 0; i < array2.length; i++){
            array2[i] = array1[i];

            if(i == array2.length - 1){
                array1[i] = -7;
            }
            arrayOne += (" " + array1[i]);
            arrayTwo += (" " + array2[i]);
        }

        System.out.println(arrayOne);
        System.out.println(arrayTwo);
    }
}
