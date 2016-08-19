import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsStep1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int myHand;
        int compHand;

        System.out.println("Give me your choice: 1 - Rock, 2 - Paper, 3 - Scissors");
        myHand = scanner.nextInt();
        compHand = 1 + random.nextInt(3);

        if (myHand != 1 && myHand != 2 && myHand != 3){
            System.out.println("You had given up on this round, Computer Win!!!");
        }else{
            if ((myHand - compHand) == 1){
                System.out.println("You Win!!!");
            }else if ((myHand - compHand) == -1){
                System.out.println("Computer Win!!!");
            }else if ((myHand - compHand) == 2){
                System.out.println("Computer Win!!!");
            }else if ((myHand - compHand) == -2){
                System.out.println("You Win!!!");
            }else if ((myHand - compHand) == 0){
                System.out.println("Tie!!!");
            }
        }
    }
}
