package com.sg.gamebot.dto;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Kratos on 6/19/16.
 * Feature:
 * 1. Allow player to bet & there is a maximum bet validation check
 * 2. Win will get double bet, lose will lose 1 bet
 * 3. Provide status summary for each round
 * 4. Player can choose to keep playing or quit
 * 5. Player will be force to quit if he got no money
 * 6. Provide card graph
 * 7. Provide card suits
 * 8. Support 2 value of Ace, either be 1 or 11
 */
public class BlackJack implements Playable {

    private String gameName;

    public BlackJack() {
        this.gameName = "Black Jack";
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int drawCard; // Used for drawing new card
        int wallet = 500;
        int bet = 0;
        int highestScore = 0;
        String choice;
        String newCard = "";
        String nextRound = "continue";

        // Variable need to reset every time
        boolean win = false;
        boolean gameOver = false;
        int myTotal = 0;
        int dealerTotal = 0;
        int myAce = 0;
        int dealerAce = 0;
        int step = 1;
        int dealerHighestPoint = 0;
        int myHighestPoint = 0;
        String my_1st_card = "";
        String my_2nd_card = "";
        String dealer_1st_card = "";
        String dealer_2nd_card = "";

        while (nextRound.equals("continue")) {
            // Take bet
            System.out.print("Please your bet on the table: ");
            bet = scanner.nextInt();
            while (bet > wallet) {
                System.out.print("You don't have that much money! Re-enter you bet:  ");
                bet = scanner.nextInt();
            }

            System.out.println("!!! --->>> Hand Off The Table Now <<<--- !!!\n");

            // Before everything else, we need to setup cards --- Spread out 2 cards for me, 2 card for dealer
            while (my_1st_card.equals("") || my_2nd_card.equals("") || dealer_1st_card.equals("") || dealer_2nd_card.equals("")) {
                drawCard = 2 + random.nextInt(13);
                switch (drawCard) {
                    case 11:
                        if (my_1st_card.equals("")) {
                            my_1st_card = "J";
                            myTotal += 10;
                        } else if (my_2nd_card.equals("")) {
                            my_2nd_card = "J";
                            myTotal += 10;
                        } else if (dealer_1st_card.equals("")) {
                            dealer_1st_card = "J";
                            dealerTotal += 10;
                        } else if (dealer_2nd_card.equals("")) {
                            dealer_2nd_card = "J";
                            dealerTotal += 10;
                        } else {
                            System.out.println("Error!");
                        }
                        break;
                    case 12:
                        if (my_1st_card.equals("")) {
                            my_1st_card = "Q";
                            myTotal += 10;
                        } else if (my_2nd_card.equals("")) {
                            my_2nd_card = "Q";
                            myTotal += 10;
                        } else if (dealer_1st_card.equals("")) {
                            dealer_1st_card = "Q";
                            dealerTotal += 10;
                        } else if (dealer_2nd_card.equals("")) {
                            dealer_2nd_card = "Q";
                            dealerTotal += 10;
                        } else {
                            System.out.println("Error!");
                        }
                        break;
                    case 13:
                        if (my_1st_card.equals("")) {
                            my_1st_card = "K";
                            myTotal += 10;
                        } else if (my_2nd_card.equals("")) {
                            my_2nd_card = "K";
                            myTotal += 10;
                        } else if (dealer_1st_card.equals("")) {
                            dealer_1st_card = "K";
                            dealerTotal += 10;
                        } else if (dealer_2nd_card.equals("")) {
                            dealer_2nd_card = "K";
                            dealerTotal += 10;
                        } else {
                            System.out.println("Error!");
                        }
                        break;
                    case 14:
                        if (my_1st_card.equals("")) {
                            my_1st_card = "A";
                            myAce++;
                        } else if (my_2nd_card.equals("")) {
                            my_2nd_card = "A";
                            myAce++;
                        } else if (dealer_1st_card.equals("")) {
                            dealer_1st_card = "A";
                            dealerAce++;
                        } else if (dealer_2nd_card.equals("")) {
                            dealer_2nd_card = "A";
                            dealerAce++;
                        } else {
                            System.out.println("Error!");
                        }
                        break;
                    default:
                        if (my_1st_card.equals("")) {
                            my_1st_card += drawCard;
                            myTotal += drawCard;
                        } else if (my_2nd_card.equals("")) {
                            my_2nd_card += drawCard;
                            myTotal += drawCard;
                        } else if (dealer_1st_card.equals("")) {
                            dealer_1st_card += drawCard;
                            dealerTotal += drawCard;
                        } else if (dealer_2nd_card.equals("")) {
                            dealer_2nd_card += drawCard;
                            dealerTotal += drawCard;
                        } else {
                            System.out.println("Error!");
                        }
                }
            }

            // ************************************* Cards are all setup up to this point *****************************
            while (!gameOver) {
                switch (step) {
                    case 1:
                        // Display the cards initial setup result, randomly hide 1 of dealer's card
                        System.out.println("");

                        // Display my hand cards ****************************************************
                        System.out.println("     *-*-*-*   *-*-*-*");
                        System.out.println("     |     |   |     |");
                        System.out.println("        " + my_1st_card + "         " + my_2nd_card);
                        System.out.println("     |     |   |     |");
                        System.out.println("     *-*-*-*   *-*-*-*");
                        System.out.println("You get a " + my_1st_card + " and a " + my_2nd_card);

                        // Update my current total points & Check whether I win 21 at the VERY Beginning
                        // If I did hit 21 at the beginning, no further need to go!

                        if (myAce != 0) {
                            if ((myTotal + myAce + 10) == 21) {
                                System.out.println("Your total is " + (myTotal + myAce + 10));
                                win = true;
                                gameOver = true;
                            } else {
                                System.out.println("Your total can be either " + (myTotal + myAce) + " or " + (myTotal + myAce + 10));
                            }
                        } else {
                            System.out.println("Your total is " + myTotal);
                        }

                        if (!gameOver) {
                            // Display dealer's hand cards **********************************************
                            drawCard = 1 + random.nextInt(2);
                            System.out.println("");
                            if (drawCard == 1) {
                                System.out.println("     *-*-*-*   *-*-*-*");
                                System.out.println("     |     |   |     |");
                                System.out.println("        " + dealer_1st_card + "         ?");
                                System.out.println("     |     |   |     |");
                                System.out.println("     *-*-*-*   *-*-*-*");
                                System.out.println("The dealer has a " + dealer_1st_card + " showing, and a hidden card.");
                            } else {
                                System.out.println("     *-*-*-*   *-*-*-*");
                                System.out.println("     |     |   |     |");
                                System.out.println("        " + dealer_2nd_card + "         ?");
                                System.out.println("     |     |   |     |");
                                System.out.println("     *-*-*-*   *-*-*-*");
                                System.out.println("The dealer has a " + dealer_2nd_card + " showing, and a hidden card.");
                            }

                            // Update dealer's current total points
                            System.out.println("Dealer's total is hidden too.\n");
                        }

                        // Move to the phase 2
                        step = 2;
                        break;

                    case 2:
                        // ******************************************************************* This is my turn
                        System.out.println("\n>>>>>>>>>> Decide! <<<<<<<<<<\n");
                        System.out.print("Would you like to \"hit\" or \"stay\"? --> ");
                        choice = scanner.next();
                        System.out.println("");

                        while (!choice.equals("stay")) {
                            drawCard = 2 + random.nextInt(13);
                            switch (drawCard) {
                                case 11:
                                    newCard = "J";
                                    myTotal += 10;
                                    break;
                                case 12:
                                    newCard = "Q";
                                    myTotal += 10;
                                    break;
                                case 13:
                                    newCard = "K";
                                    myTotal += 10;
                                    break;
                                case 14:
                                    newCard = "A";
                                    myAce++;
                                    break;
                                default:
                                    newCard = "" + drawCard;
                                    myTotal += drawCard;
                            }

                            System.out.println("");
                            System.out.println("---------------------");
                            System.out.println("     *-*-*-*");
                            System.out.println("     |     |");
                            System.out.println("        " + newCard);
                            System.out.println("     |     |");
                            System.out.println("     *-*-*-*\n");
                            System.out.println("You drew a " + newCard);

                            // Update my current total points
                            if (myAce != 0) {
                                System.out.println("Your total can be either " + (myTotal + myAce) + " or " + (myTotal + myAce + 10));
                                if ((myTotal + myAce + 10) == 21 || (myTotal + myAce) == 21) {
                                    win = true;
                                    gameOver = true;
                                    break;
                                }
                            } else {
                                System.out.println("Your total is " + myTotal);
                                if (myTotal == 21) {
                                    win = true;
                                    gameOver = true;
                                    break;
                                }
                            }

                            if ((myTotal + myAce) > 21) {
                                System.out.println("Your total BUSTS!!!");
                                // choice = "stay";
                                gameOver = true;
                                break;
                            } else {
                                // Offer choice
                                System.out.print("Would you like to \"hit\" or \"stay\"? --> ");
                                choice = scanner.next();
                                System.out.println("");
                            }
                        }

                        // Move to the phase 3
                        step = 3;
                        break;

                    case 3:
                        // ******************************************************************* This is dealer's turn
                        choice = "hit";
                        System.out.println("\n---------------------");
                        System.out.println("OK, now is dealer's turn...");
                        // Display dealer's inital 2 cards ****************************************************
                        System.out.println("Dealer's cards in hands are: ");
                        System.out.println("     *-*-*-*   *-*-*-*");
                        System.out.println("     |     |   |     |");
                        System.out.println("        " + dealer_1st_card + "         " + dealer_2nd_card);
                        System.out.println("     |     |   |     |");
                        System.out.println("     *-*-*-*   *-*-*-*");
                        System.out.println("He got a " + dealer_1st_card + " and a " + dealer_2nd_card);

                        if (dealerAce != 0) {
                            System.out.println("Dealer's total can be either " + (dealerTotal + dealerAce) + " or " + (dealerTotal + dealerAce + 10));
                        } else {
                            System.out.println("Dealer's total is " + dealerTotal);
                        }

                        if ((dealerTotal + dealerAce + 10) == 21) {
                            // Dealer's 2 Cards is BlackJack, this is the end
                            gameOver = true;
                        } else if ((dealerTotal + dealerAce) <= 16) {

                            // Check if Dealer's 2 Cards are > 16
                            while (!choice.equals("stay")) {
                                drawCard = 2 + random.nextInt(13);
                                switch (drawCard) {
                                    case 11:
                                        newCard = "J";
                                        dealerTotal += 10;
                                        break;
                                    case 12:
                                        newCard = "Q";
                                        dealerTotal += 10;
                                        break;
                                    case 13:
                                        newCard = "K";
                                        dealerTotal += 10;
                                        break;
                                    case 14:
                                        newCard = "A";
                                        dealerAce++;
                                        break;
                                    default:
                                        newCard = "" + drawCard;
                                        dealerTotal += drawCard;
                                }

                                System.out.println("");
                                System.out.println("---------------------");
                                System.out.println("Dealer chooses to hit: ");
                                System.out.println("     *-*-*-*");
                                System.out.println("     |     |");
                                System.out.println("        " + newCard);
                                System.out.println("     |     |");
                                System.out.println("     *-*-*-*\n");
                                System.out.println("Dealer drew a " + newCard);

                                if (dealerAce != 0) {
                                    System.out.println("Dealer's total can be either " + (dealerTotal + dealerAce) + " or " + (dealerTotal + dealerAce + 10));
                                    if ((dealerTotal + dealerAce + 10) == 21 || (dealerTotal + dealerAce) == 21) {
                                        // Dealer's 2 Cards is BlackJack, this is the end
                                        gameOver = true;
                                        break;
                                    }
                                } else {
                                    System.out.println("Dealer's total is " + dealerTotal);
                                    if (dealerTotal == 21) {
                                        gameOver = true;
                                        break;
                                    }
                                }

                                if ((dealerTotal + dealerAce) > 16 && (dealerTotal + dealerAce) < 21) {
                                    System.out.println("");
                                    System.out.println("---------------------");
                                    System.out.println("Dealer chooses to stay");
                                    // Move to default (The Final Step)
                                    step = 0;
                                    break;
                                } else if ((dealerTotal + dealerAce) > 21) {
                                    System.out.println("");
                                    System.out.println("---------------------");
                                    System.out.println("Dealer's total BUSTS!");
                                    win = true;
                                    gameOver = true;
                                    break;
                                }
                            }
                        } else {
                            System.out.println("");
                            System.out.println("---------------------");
                            System.out.println("Dealer chooses to stay");
                            // Move to default (The Final Step)
                            step = 0;
                        }

                        break;

                    default:
                        // Prepare my highest point for battle!
                        if (myAce != 0) {
                            if ((myTotal + myAce + 10) < 21) {
                                myHighestPoint = myTotal + myAce + 10;
                            } else {
                                myHighestPoint = myTotal + myAce;
                            }
                        } else {
                            myHighestPoint = myTotal;
                        }

                        // Prepare dealer's highest point for battle!
                        if (dealerAce != 0) {
                            if ((dealerTotal + dealerAce + 10) < 21) {
                                dealerHighestPoint = dealerTotal + dealerAce + 10;
                            } else {
                                dealerHighestPoint = dealerTotal + dealerAce;
                            }
                        } else {
                            dealerHighestPoint = dealerTotal;
                        }

                        // Display mine & dealer's total
                        System.out.println("\n#####################");
                        System.out.println("Your total points are " + myHighestPoint);
                        System.out.println("Dealer's total points are " + dealerHighestPoint);

                        // Compare
                        if (myHighestPoint > dealerHighestPoint) {
                            win = true;
                        }
                        gameOver = true;
                }
            }

            // Summary Section ************************************************************************

            if (win) {
                wallet += bet * 2;
            } else {
                wallet -= bet;
            }

            if (highestScore < wallet) {
                highestScore = wallet;
            }

            System.out.println("\n");

            if (wallet == 0) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("$      Summary      $");
                System.out.println("$-------------------$");
                System.out.println("    Wallet: $ " + wallet + "       ");
                System.out.println("$                   $");
                System.out.println("    Highest: " + highestScore + "            ");
                System.out.println("$                   $");
                if (win) {
                    System.out.println("    You Win!");
                } else {
                    System.out.println("    You Lose!");
                }
                System.out.println("$                   $");
                System.out.println("                     ");
                System.out.println("$                   $");
                System.out.println("$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("You better leave now, you have no money to stay in this table any more!");
                nextRound = "leave";
            } else {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("$      Summary      $");
                System.out.println("$-------------------$");
                System.out.println("    Wallet: $ " + wallet + "       ");
                System.out.println("$                   $");
                System.out.println("    Highest: " + highestScore + "            ");
                System.out.println("$                   $");
                if (win) {
                    System.out.println("    You Win!");
                } else {
                    System.out.println("    You Lose!");
                }
                System.out.println("$                   $");
                System.out.println("                     ");
                System.out.println("$                   $");
                System.out.println("$$$$$$$$$$$$$$$$$$$$$");
                System.out.print("Do you want to \"continue\" or \"quit\"?   ");
                nextRound = scanner.next();
                System.out.println("");
            }

            // Reset All Setting
            win = false;
            gameOver = false;
            myTotal = 0;
            dealerTotal = 0;
            myAce = 0;
            dealerAce = 0;
            step = 1;
            dealerHighestPoint = 0;
            myHighestPoint = 0;
            my_1st_card = "";
            my_2nd_card = "";
            dealer_1st_card = "";
            dealer_2nd_card = "";
        }
    }

    public String whatIsGameName() {
        return this.gameName;
    }
}
