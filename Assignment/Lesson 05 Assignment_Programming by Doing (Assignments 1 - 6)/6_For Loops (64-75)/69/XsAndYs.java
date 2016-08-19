public class XsAndYs{
    public static void main(String[] args){

        System.out.println("x\ty");
        System.out.println("-------");
        for (double i = -10; i <= 10; i += 0.5){
            System.out.println(i + "\t" + (i*i));
        }
    }
}
