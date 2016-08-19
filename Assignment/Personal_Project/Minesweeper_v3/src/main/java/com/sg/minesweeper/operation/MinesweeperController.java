/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.minesweeper.operation;

import com.sg.minesweeper.dto.Board;
import com.sg.minesweeper.ui.MinesweeperUi;

/**
 *
 * @author Kratos
 */
public class MinesweeperController {

    private MinesweeperUi ui;

    public MinesweeperController() {
        this.ui = new MinesweeperUi();
    }

    public void execute() {
        int width = ui.promptForWidth();
        int height = ui.promptForHeight();
        int level = ui.promptForHardnessLevel();
        Board board = new Board(width, height, (int) width * height * level / 10);
        boolean quit = false;
        String coordinate = "";

        while (!quit) {
            ui.nextPage();
            board.refreshBoard();
            coordinate = ui.promptForCoordinate();
            if (board.onClick(coordinate)) {
                ui.nextPage();
                ui.displayGG_Lose();
                quit = true;
            } else if (board.isMineAllSweeped()) {
                ui.nextPage();
                ui.displayGG_Win();
                quit = true;
            }
        }
        board.displayBoard();
    }
}
