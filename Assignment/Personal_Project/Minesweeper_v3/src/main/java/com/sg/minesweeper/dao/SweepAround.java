/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.minesweeper.dao;

import com.sg.minesweeper.dto.Cell;
import java.util.List;

/**
 *
 * @author Kratos
 */
public interface SweepAround {
    public void sweep(Cell tempCell, List<Cell> emptyCellsAround);
}