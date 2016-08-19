package com.sg.gamebot.dto;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kratos on 6/19/16.
 */
public class Lucky7s implements Playable{

    private String gameName;

    public Lucky7s() {
        this.gameName = "Lucky Sevens";
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int diceA = 0;
        int diceB = 0;
        String nextRound = "play";
        String play = "";
        double bet = 0;
        int roll = 0;
        double max = 0;
        int rollAtMax = 0;
        double amount = 0;


        System.out.println("[$$$$$$$$$ Lucky Sevens $$$$$$$$$]");

        // start loop game until player enter something other than play
        while(nextRound.equals("play")){
            System.out.println("");
            System.out.print("Starting bet: [       ]\rStarting bet: [ ");
            bet = scanner.nextDouble();

            // bet validation
            if (bet <= 0){
                while(bet <= 0){
                    System.out.println("Please enter valid bet!");
                    System.out.print("Starting bet: [       ]\rStarting bet: [ ");
                    bet = scanner.nextDouble();
                }
            }
            max = bet;
            amount = bet;

            // get command from play to start roll dices
            while(!play.equals("roll")){
                System.out.print("When you ready, enter \"roll\" to start... [      ]\rWhen you ready, enter \"roll\" to start... [ ");
                play = scanner.next();
            }

            System.out.println("");

            while (amount > 0){
                diceA = 1 + random.nextInt(6);
                diceB = 1 + random.nextInt(6);
                roll++;

                if ((diceA + diceB) == 7){
                    amount += 4;
                }else {
                    amount--;
                }

                if (max < amount){
                    max = amount;
                    rollAtMax = roll;
                }

            }

            // Display results
            System.out.println("+--->>>         Results         <<<---+");
            System.out.println("|                                     |");
            System.out.println("     Starting Bet:        $ "+ bet  + "          ");
            System.out.println("|_____________________________________|");
            System.out.println("|                                     |");
            System.out.println("     Total Roll:          " + roll + "                                  ");
            System.out.println("|                                     |");
            System.out.println("     Highest Amount:      "+ max+" ");
            System.out.println("|                                     |");
            System.out.println("     Roll at Max:         "+ rollAtMax+"");
            System.out.println("|                                     |");
            System.out.println("+-------------------------------------+");

            System.out.println("");
            System.out.println("  +------------+      +------------+");
            System.out.println("  |    play    |      |    quit    |");
            System.out.println("  +------------+      +------------+");
            System.out.print("              [        ]\r              [  ");
            nextRound = scanner.next();

            // resest data variable for next round
            play = "";
            bet = 0;
            roll = 0;
            max = 0;
            rollAtMax = 0;
            amount = 0;
        }
    }

    public String whatIsGameName() {
        return this.gameName;
    }
}
