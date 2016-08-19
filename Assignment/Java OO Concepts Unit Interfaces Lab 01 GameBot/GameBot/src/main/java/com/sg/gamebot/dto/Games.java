package com.sg.gamebot.dto;

import java.util.ArrayList;

/**
 * Created by Kratos on 6/19/16.
 */
public class Games {

    private ArrayList<Playable> gameList;

    public Games() {
        gameList = new ArrayList<Playable>();
        gameList.add(new BlackJack());
        gameList.add(new Hangman());
        gameList.add(new Lucky7s());
        gameList.add(new RockPaperScissors());
        gameList.add(new TicTacToe());
    }

    public ArrayList<Playable> getGameList() {
        return gameList;
    }
}
