/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.minesweeper.ui;


/**
 *
 * @author Kratos
 */
public class MinesweeperUi {

    private ConsoleIO io;
    private GUIUtilities gui;

    public MinesweeperUi() {
        this.io = new ConsoleIO();
        this.gui = new GUIUtilities();
    }

    public int promptForWidth() {
        return io.promptForIntWithinRange("Please enter the width: ", 3, 100);
    }

    public int promptForHeight() {
        return io.promptForIntWithinRange("Please enter the height: ", 3, 100);
    }

    public int promptForHardnessLevel() {
        return io.promptForIntWithinRange("Please enter hardness level (1 - 5): ", 1, 5);
    }

    public String promptForCoordinate() {
        return io.promptForString("Please enter coordinate (x,y): ");
    }

    public void displayGG_Win() {
        io.display(gui.os_Quick_Notification_Builder("/", "Congratz!!! All mines are sweeped!!!") + "\n");
    }

    public void displayGG_Lose() {
        io.display(gui.os_Quick_Notification_Builder("/", "You hit the mine!!! GAME OVER!!!") + "\n");
    }
    
    public void nextPage(){
        String newLines = "";
        for(int i = 0; i < 100; i++){
            newLines += "\n";
        }
        io.display(newLines);
    }
}
