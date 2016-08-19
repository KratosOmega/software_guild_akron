/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.minesweeper.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Kratos
 */
public class Board {

    private int xSize;
    private int ySize;
    private List<List<Cell>> board;
    private int sweepedCount;
    private int mineCount;
//    private List<Coordinate> mines;

    public Board(int xSize, int ySize, int mineCount) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.board = new ArrayList<>();
        this.sweepedCount = 0;
        this.mineCount = mineCount;

        // -------------------
        Random random = new Random();
        int xRandom;
        int yRandom;
        Set<Coordinate> minePlacer = new HashSet<>();

        while (minePlacer.size() < this.mineCount) {
            xRandom = 0 + random.nextInt(xSize);
            yRandom = 0 + random.nextInt(ySize);

            final Coordinate coordinate = new Coordinate(xRandom, yRandom);

            if (minePlacer.stream().filter(xy -> xy.returnCoordinate().equals(coordinate.returnCoordinate())).collect(Collectors.toList()).isEmpty()) {
                minePlacer.add(coordinate);
            }
        }

        List<Coordinate> mineLocations = new ArrayList<>();
        mineLocations.addAll(minePlacer);

        // Setup Empty board with given size;
        List<Cell> newRow;
        for (int x = 0; x < xSize; x++) {
            newRow = new ArrayList<>();
            for (int y = 0; y < ySize; y++) {
                newRow.add(new Cell(new Coordinate(x, y)));
            }
            this.board.add(newRow);
        }

        mineLocations
                .stream()
                .forEach(location -> {
                    this.board.get(location.getxCoordinate()).set(location.getyCoordinate(), new Cell(true, -1, location, false, "*"));
                });

        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                this.board.get(x).get(y).setMineCountAndContent(xSize - 1, ySize - 1, new Coordinate(x, y), this);
            }
        }
    }

    // ******************************************************** mines
    public List<Coordinate> setMines(int mineCount) {
        Random random = new Random();
        int xRandom;
        int yRandom;
        Set<Coordinate> minePlacer = new HashSet<>();

        while (minePlacer.size() < this.mineCount) {
            xRandom = 1 + random.nextInt(xSize);
            yRandom = 1 + random.nextInt(ySize);

            final Coordinate coordinate = new Coordinate(xRandom, yRandom);

            if (minePlacer.stream().filter(xy -> xy.returnCoordinate().equals(coordinate.returnCoordinate())).collect(Collectors.toList()).isEmpty()) {
                minePlacer.add(coordinate);
            }
        }

        List<Coordinate> returnedMines = new ArrayList<>();
        returnedMines.addAll(minePlacer);
        return returnedMines;
    }

    public void refreshBoard() {
        System.out.print("  ");
        for (int m = 0; m < xSize; m++) {
            System.out.print(" " + m);
        }
        System.out.print("\n  ");

        for (int m = 0; m < xSize; m++) {
            System.out.print(" -");
        }
        System.out.print("\n");

        for (int x = 0; x < xSize; x++) {
            System.out.print(x + " ");
            for (int y = 0; y < ySize; y++) {
                if (this.board.get(x).get(y).isIsSweeped()) {
                    System.out.print("|" + this.board.get(x).get(y).getContent());
                } else {
                    System.out.print("|?");
                }
            }
            System.out.println("|");
        }
        System.out.print("  ");
        for (int m = 0; m < xSize; m++) {
            System.out.print(" -");
        }
        System.out.print("\n");
    }

    public void displayBoard() {
        System.out.print("  ");
        for (int m = 0; m < xSize; m++) {
            System.out.print(" " + m);
        }
        System.out.print("\n  ");

        for (int m = 0; m < xSize; m++) {
            System.out.print(" -");
        }
        System.out.print("\n");

        for (int x = 0; x < xSize; x++) {
            System.out.print(x + " ");
            for (int y = 0; y < ySize; y++) {
                System.out.print("|" + this.board.get(x).get(y).getContent());
            }
            System.out.println("|");
        }
        System.out.print("  ");
        for (int m = 0; m < xSize; m++) {
            System.out.print(" -");
        }
        System.out.print("\n");
    }

    public boolean onClick(String coordinateOnClick) {
        // if hasMine = true
        int x = coordinateKeyDecoder_X(coordinateOnClick);
        int y = coordinateKeyDecoder_Y(coordinateOnClick);

        Cell cell = this.board.get(x).get(y);
        if (cell.isHasMine()) {
            return true;
        } else {
            cell.setIsSweeped(true);
            sweepedCount++;

            if (cell.getMineCount() == 0) {
                cell.sweepAllAround(xSize - 1, ySize - 1, this);
            }
            return false;
        }
        // Game over and diplay all map

        // Else then
        // if mineCount = 0
        // display connected empty cell, base on up, down, left, right
        // if mineCount > 0
        // display count
    }

    public boolean isMineAllSweeped() {
        // if there is still a cell has false for isSweeped, return false
        return this.sweepedCount == xSize * ySize - this.mineCount;
    }

    public int coordinateKeyDecoder_X(String encodedCoordinate) {
        return Integer.parseInt(encodedCoordinate.split(",")[0]);
    }

    public int coordinateKeyDecoder_Y(String encodedCoordinate) {
        return Integer.parseInt(encodedCoordinate.split(",")[1]);
    }

    public void setSweepedCount(int sweepedCount) {
        this.sweepedCount = sweepedCount;
    }

    public int getSweepedCount() {
        return sweepedCount;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }
}
