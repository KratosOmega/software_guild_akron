import java.util.Random;

public class FortuneCookie{
    public static void main(String[] args){
        Random random = new Random();

        int num = 1 + random.nextInt(6);

        switch(num){
        case 1:
            System.out.println("Fortune Cookie --------- 1");
            break;
        case 2:
            System.out.println("Fortune Cookie --------- 2");
            break;
        case 3:
            System.out.println("Fortune Cookie --------- 3");
            break;
        case 4:
            System.out.println("Fortune Cookie --------- 4");
            break;
        case 5:
            System.out.println("Fortune Cookie --------- 5");
            break;
        case 6:
            System.out.println("Fortune Cookie --------- 6");
            break;
        default:
            System.out.println("You are out of fortune!");
        }
    }
}
