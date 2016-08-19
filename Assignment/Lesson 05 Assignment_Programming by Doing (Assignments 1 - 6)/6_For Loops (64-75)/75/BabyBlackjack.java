import java.util.Random;

public class BabyBlackjack{
    public static void main(String[] args){
        Random random = new Random();
        int humanCard1 = 1 + random.nextInt(10);
        int humanCard2 = 1 + random.nextInt(10);
        int computerCard1 = 1 + random.nextInt(10);
        int computerCard2 = 1 + random.nextInt(10);
        int humanTotal = humanCard1 + humanCard2;
        int computerTotal = computerCard1 + computerCard2;

        System.out.println("Bay Blackjack!\n");
        System.out.println("You drew " + humanCard1 + " and " + humanCard2);
        System.out.println("Your total is " + humanTotal + "\n");
        System.out.println("The dealer has " + computerCard1 + " and " + computerCard2);
        System.out.println("Dealer's total is " + computerTotal + "\n");

        if (humanTotal > computerTotal){
            System.out.println("YOU WIN!");
        }else{
            System.out.println("YOY LOSE!");
        }

    }
}
