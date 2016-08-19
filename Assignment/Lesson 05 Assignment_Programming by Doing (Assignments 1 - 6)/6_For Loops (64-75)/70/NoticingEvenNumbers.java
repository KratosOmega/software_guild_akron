public class NoticingEvenNumbers{
    public static void main(String[] args){


        for (int i = 1; i <= 20; i++){
            System.out.print(i);
            if (i % 2 ==0){
                System.out.println(" <");
            }else {
                System.out.println("");
            }
        }
    }
}
