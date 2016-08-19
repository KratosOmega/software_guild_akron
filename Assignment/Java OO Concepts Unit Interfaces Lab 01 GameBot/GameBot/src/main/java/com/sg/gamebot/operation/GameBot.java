package com.sg.gamebot.operation;

import com.sg.gamebot.dto.Games;
import com.sg.gamebot.ui.GameBotUI;

import java.util.ArrayList;

/**
 * Created by Kratos on 6/19/16.
 * Controller
 */
public class GameBot {

    boolean quit = false;
    GameBotUI ui = new GameBotUI();
    String operation = "";
    Games games = new Games();


    // 1. Lists the games in the system
    public void execute(){
        while(!quit){
            ui.gameMenu();
            operation = ui.promptForOperation();

            switch (operation){
                case "1":
                    ui.message_NextSection();
                    selectPage(games.getGameList().get(0).whatIsGameName());
                    games.getGameList().get(0).execute();
                    break;
                case "2":
                    ui.message_NextSection();
                    selectPage(games.getGameList().get(1).whatIsGameName());
                    games.getGameList().get(1).execute();
                    break;
                case "3":
                    ui.message_NextSection();
                    selectPage(games.getGameList().get(2).whatIsGameName());
                    games.getGameList().get(2).execute();
                    break;
                case "4":
                    ui.message_NextSection();
                    selectPage(games.getGameList().get(3).whatIsGameName());
                    games.getGameList().get(3).execute();
                    break;
                case "5":
                    ui.message_NextSection();
                    selectPage(games.getGameList().get(4).whatIsGameName());
                    games.getGameList().get(4).execute();
                    break;
                case "quit":
                    quit = true;
                    ui.message_NextSection();
                    ui.message_QuitGame();
                    break;
                default:
                    ui.message_InvalidInput();
                    ui.message_NextSection();
            }
        }
    }

    public void selectPage(String gameName){
        switch (gameName){
            case "Black Jack":
                ui.page_Header_BlackJack();
                break;
            case "Hangman":
                ui.page_Header_Hangman();
                break;
            case "Lucky Sevens":
                ui.page_Header_Lucky7s();
                break;
            case "Rock, Paper, Scissors":
                ui.page_Header_RPS();
                break;
            case "Tic Tac Toe":
                ui.page_Header_TicTacTo();
                break;
            default:
                ui.message_InvalidInput();
        }
    }
}
