public class BasicArrays1{
    public static void main(String[] args){
        int[] array = new int[10];

        for(int i = 0; i < array.length; i++){
            array[i] = -113;
        }

        for(int i = 0; i < array.length; i++){
            System.out.println("Slot "+ i +" contains a " + array[i]);
        }
    }
}
