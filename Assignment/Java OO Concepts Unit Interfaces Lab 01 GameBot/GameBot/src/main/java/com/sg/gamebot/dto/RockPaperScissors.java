package com.sg.gamebot.dto;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kratos on 6/19/16.
 */
public class RockPaperScissors implements Playable {
    private String gameName;

    public RockPaperScissors() {
        this.gameName = "Rock, Paper, Scissors";
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int myHand;
        int compHand;
        int rounds;

        int uWins = 0;
        int cWins = 0;
        int ties = 0;

        String play = "Yes";

        while(play.equals("Yes")){
            System.out.print("How many rounds you wish to play: ");
            rounds = scanner.nextInt();

            if (rounds >=1 && rounds <= 10){
                System.out.println("Game begin!!!");

                for (int i = 0; i < rounds; i++){
                    System.out.println("");
                    System.out.println("Give me your choice: 1 - Rock, 2 - Paper, 3 - Scissors");
                    myHand = scanner.nextInt();
                    compHand = 1 + random.nextInt(3);

                    if (myHand != 1 && myHand != 2 && myHand != 3){
                        System.out.println("You had given up on this round, Computer Win!!!");
                        cWins++;
                    }else{
                        if ((myHand - compHand) == 1){
                            System.out.println("You Win!!!");
                            uWins++;
                        }else if ((myHand - compHand) == -1){
                            System.out.println("Computer Win!!!");
                            cWins++;
                        }else if ((myHand - compHand) == 2){
                            System.out.println("Computer Win!!!");
                            cWins++;
                        }else if ((myHand - compHand) == -2){
                            System.out.println("You Win!!!");
                            uWins++;
                        }else if ((myHand - compHand) == 0){
                            System.out.println("Tie!!!");
                            ties++;
                        }
                    }
                }

                System.out.println("---------------------------------");
                System.out.println("Player won: " + uWins + " rounds.");
                System.out.println("Computer won: " + cWins + " rounds.");
                System.out.println("Ties: " + ties + " rounds.");
                if (uWins > cWins){
                    System.out.println("Player Wins the FINAL!!!");
                }else if (uWins < cWins){
                    System.out.println("Computer Wins the FINAL!!!");
                }else {
                    System.out.println("The FINAL is TIED!!!");
                }

                System.out.println("\n---------------------------------");
                System.out.println("Do you want to play again?");
                System.out.println("Enter \"Yes\" or \"No\" to make yoru decesion: ");
                play = scanner.next();
                System.out.println("");
            }else {
                System.out.println("This is madness!!! I am out of here!");
                break;
            }

            // Reset Data
            uWins = 0;
            cWins = 0;
            ties = 0;
        }
        System.out.println("Thanks for playing!");
    }

    public String whatIsGameName() {
        return this.gameName;
    }
}
