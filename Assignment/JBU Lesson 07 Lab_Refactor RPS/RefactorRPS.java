
import java.util.Scanner;
import java.util.Random;

public class RefactorRPS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds;

        String play = "Yes";

        while (play.equals("Yes")) {
            System.out.print("How many rounds you wish to play: ");
            rounds = scanner.nextInt();

            if (rounds >= 1 && rounds <= 10) {
                System.out.println("Game begin!!!");
            } else {
                System.out.println("This is madness!!! I am out of here!");
                break;
            }
            play = playGame(rounds);
        }
        System.out.println("Thanks for playing!");
    }

    public static String summary(int userWins, int computerWins, int ties) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("Player won: " + userWins + " rounds.");
        System.out.println("Computer won: " + computerWins + " rounds.");
        System.out.println("Ties: " + ties + " rounds.");
        if (userWins > computerWins) {
            System.out.println("Player Wins the FINAL!!!");
        } else if (userWins < computerWins) {
            System.out.println("Computer Wins the FINAL!!!");
        } else {
            System.out.println("The FINAL is TIED!!!");
        }

        System.out.println("\n---------------------------------");
        System.out.println("Do you want to play again?");
        System.out.println("Enter \"Yes\" or \"No\" to make yoru decesion: ");
        return scanner.next();
    }

    public static String playGame(int rounds) {
        int uWins = 0;
        int cWins = 0;
        int ties = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rounds; i++) {
            System.out.println("");
            System.out.println("Give me your choice: 1 - Rock, 2 - Paper, 3 - Scissors");
            int myRPS = scanner.nextInt();
            int compRPS = 1 + random.nextInt(3);

            switch (compareRPS(myRPS, compRPS)) {
                case 1:
                    uWins++;
                    break;
                case -1:
                    cWins++;
                    break;
                case 0:
                    ties++;
                    break;
                default:
                    System.out.println("Error!");
            }
        }
        return summary(uWins, cWins, ties);
    }

    public static int compareRPS(int myRPS, int compRPS) {
        switch (myRPS - compRPS) {
            case 1:
            case -2:
                System.out.println("You Win!!!");
                return 1;
            case -1:
            case 2:
                System.out.println("Computer Win!!!");
                return -1;
            case 0:
                System.out.println("Tie!!!");
                return 0;
            default:
                System.out.println("You had given up on this round, Computer Win!!!");
                return -1;
        }
    }
}
