package com.sg.gamebot.ui;

import com.sg.gamebot.dto.Games;
import com.sg.gamebot.dto.Playable;

/**
 * Created by Kratos on 6/19/16.
 */
public class GameBotUI {

    private GUIUtilities gui;
    private Games games;
    private ConsoleIO io;

    public GameBotUI() {
        this.gui = new GUIUtilities();
        this.games = new Games();
        this.io = new ConsoleIO();
    }

    public void gameMenu() {
        String gamelistMenu = "";
        int index = 0;

        for (Playable game : games.getGameList()) {
            index++;
            if (index == games.getGameList().size()) {
                gamelistMenu += index + ". " + game.whatIsGameName();
            } else {
                gamelistMenu += index + ". " + game.whatIsGameName() + "/";
            }
        }
        io.display(gui.os_Quick_Menu_Builder("> OMEGA GameBot <", "/", gamelistMenu) + "\n");
        io.display(gui.os_Quick_Notification_Builder("/", "<Enter \"quit\" to Quit>") + "\n");
    }

    public String promptForOperation() {
        return io.promptForString("> Please Choose your operation: ");
    }

    public void message_QuitGame() {
        io.display(gui.os_Quick_Notification_Builder("/", "Thank you for playing!!!/Bye-Bye~"));
    }

    public void message_InvalidInput() {
        io.display(gui.os_Quick_Notification_Builder("/", "Invalid Input!!!/Please select again...") + "\n");
    }

    public void message_NextSection() {
        io.display(gui.os_Quick_Notification_Builder(";", "|  |;_|  |_;\\    /;\\  /;\\/;") + "\n");
    }

    public void page_Header_BlackJack() {
        io.display(gui.os_Quick_Notification_Builder(";", " ;>>> Black Jack <<<; ") + "\n");
    }

    public void page_Header_Lucky7s() {
        io.display(gui.os_Quick_Notification_Builder(";", " ;>>> Lucky Severns <<<; ") + "\n");
    }

    public void page_Header_TicTacTo() {
        io.display(gui.os_Quick_Notification_Builder(";", " ;>>> Tic Tac Toe <<<; ") + "\n");
    }

    public void page_Header_Hangman() {
        io.display(gui.os_Quick_Notification_Builder(";", " ;>>> Hangman <<<; ") + "\n");
    }

    public void page_Header_RPS() {
        io.display(gui.os_Quick_Notification_Builder(";", " ;>>> Rock, Paper, Scissors <<<; ") + "\n");
    }
}
