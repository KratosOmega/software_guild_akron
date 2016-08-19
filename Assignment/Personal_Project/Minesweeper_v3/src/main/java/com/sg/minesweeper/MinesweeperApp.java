/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.minesweeper;

import com.sg.minesweeper.operation.MinesweeperController;

/**
 *
 * @author Kratos
 */
public class MinesweeperApp {

    public static void main(String[] args) {
        MinesweeperController controller = new MinesweeperController();
        controller.execute();
    }
}
