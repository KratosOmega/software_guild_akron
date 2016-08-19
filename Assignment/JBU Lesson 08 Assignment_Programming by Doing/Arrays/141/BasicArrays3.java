import java.util.Random;

public class BasicArrays3{
    public static void main(String[] args){
        Random random = new Random();
        int[] array = new int[1000];

        for(int i = 0; i < array.length; i++){
            array[i] = 10 + random.nextInt(90);
        }

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + "  ");
            if((i + 1) % 20 == 0){
                System.out.println("");
            }
        }
    }
}
