import java.util.Random;

public class Dice{
    public static void main(String[] args){
        Random random = new Random();
        int dice1 = 1 + random.nextInt(6);
        int dice2 = 1 + random.nextInt(6);

        System.out.println("Here comes the dices!\n");
        System.out.println("Roll #1: " + dice1);
        System.out.println("Roll #2: " + dice2);
        System.out.println("The total is " + (dice1 + dice2) + "!");
    }
}
