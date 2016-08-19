import java.util.Random;

public class Lotto{
    public static void main(String[] args){
        Random random = new Random();
        int num = 1 + random.nextInt(6);
        int num1 = 1 + random.nextInt(54);
        int num2 = 2 + random.nextInt(54);
        int num3 = 3 + random.nextInt(54);
        int num4 = 4 + random.nextInt(54);
        int num5 = 5 + random.nextInt(54);
        int num6 = 6 + random.nextInt(54);

        switch(num){
        case 1:
            System.out.println("Fortune Cookie --------- 1");
            System.out.println("       " + num1 + " - " + num2 + " - " + num3 + " - " + num4 + " - " + num5 + " - " + num6);
            break;
        case 2:
            System.out.println("Fortune Cookie --------- 2");
            System.out.println("       " + num1 + " - " + num2 + " - " + num3 + " - " + num4 + " - " + num5 + " - " + num6);
            break;
        case 3:
            System.out.println("Fortune Cookie --------- 3");
            System.out.println("       " + num1 + " - " + num2 + " - " + num3 + " - " + num4 + " - " + num5 + " - " + num6);
            break;
        case 4:
            System.out.println("Fortune Cookie --------- 4");
            System.out.println("       " + num1 + " - " + num2 + " - " + num3 + " - " + num4 + " - " + num5 + " - " + num6);
            break;
        case 5:
            System.out.println("Fortune Cookie --------- 5");
            System.out.println("       " + num1 + " - " + num2 + " - " + num3 + " - " + num4 + " - " + num5 + " - " + num6);
            break;
        case 6:
            System.out.println("Fortune Cookie --------- 6");
            System.out.println("       " + num1 + " - " + num2 + " - " + num3 + " - " + num4 + " - " + num5 + " - " + num6);
            break;
        default:
            System.out.println("You are out of fortune!");
        }
    }
}
