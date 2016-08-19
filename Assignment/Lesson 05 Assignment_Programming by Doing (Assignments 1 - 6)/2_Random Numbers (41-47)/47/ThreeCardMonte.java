import java.util.Scanner;
import java.util.Random;

public class ThreeCardMonte{
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int ace = 1 + random.nextInt(3);

        System.out.println("Which one is the ace?");
        System.out.println("         ##  ##  ##");
        System.out.println("         ##  ##  ##");
        System.out.println("         1   2   3");

        System.out.print("> ");
        if (scanner.nextInt() == ace){
            switch (ace){
            case 1:
                System.out.println("         You WIN!!!");
                System.out.println("         AA  ##  ##");
                System.out.println("         AA  ##  ##");
                System.out.println("         1   2   3");
                break;
            case 2:
                System.out.println("         You WIN!!!");
                System.out.println("         ##  AA  ##");
                System.out.println("         ##  AA  ##");
                System.out.println("         1   2   3");
                break;
            case 3:
                System.out.println("         You WIN!!!");
                System.out.println("         ##  ##  AA");
                System.out.println("         ##  ##  AA");
                System.out.println("         1   2   3");
                break;
            default:
                System.out.println("ERROR!");
            }
        }else {
            switch (ace){
            case 1:
                System.out.println("         You LOSE!!!");
                System.out.println("         AA  ##  ##");
                System.out.println("         AA  ##  ##");
                System.out.println("         1   2   3");
                break;
            case 2:
                System.out.println("         You LOSE!!!");
                System.out.println("         ##  AA  ##");
                System.out.println("         ##  AA  ##");
                System.out.println("         1   2   3");
                break;
            case 3:
                System.out.println("         You LOSE!!!");
                System.out.println("         ##  ##  AA");
                System.out.println("         ##  ##  AA");
                System.out.println("         1   2   3");
                break;
            default:
                System.out.println("ERROR!");
            }
        }
    }
}
