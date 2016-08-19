/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.minesweeper.dto;

import com.sg.minesweeper.dao.SweepAround;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Kratos
 */
public class Cell {

    private boolean hasMine;
    private int mineCount;
    private Coordinate coordinate;
    private boolean isSweeped;
    private String content;

    // Regular for accepting input
    public Cell(boolean hasMine, int mineCount, Coordinate coordinate, boolean isSweeped, String content) {
        this.hasMine = hasMine;
        this.mineCount = mineCount;
        this.coordinate = coordinate;
        this.isSweeped = isSweeped;
        this.content = content;
    }

    // Regular for assign the empty cell with coordinate
    public Cell(Coordinate coordinate) {
        this.hasMine = false;
        this.mineCount = 0;
        this.coordinate = coordinate;
        this.isSweeped = false;
        this.content = " ";
    }

    public void setMineCountAndContent(int xMax, int yMax, Coordinate coordinate, Board board) {
        if (!this.hasMine) {
            List<String> coordinateAround = new ArrayList<>();
            List<Integer> coordinateXY = new ArrayList<>();

            int x = coordinate.getxCoordinate();
            int y = coordinate.getyCoordinate();

            // Check all 8 direction, if qualify, then add the movement,
            // Otherwise, pass to next check
            // Up
            if (x - 1 >= 0) {
                coordinateAround.add((x - 1) + "::" + y);
            }
            // Up + Right
            if (x - 1 >= 0 && y + 1 <= yMax) {
                coordinateAround.add((x - 1) + "::" + (y + 1));
            }
            // Right
            if (y + 1 <= yMax) {
                coordinateAround.add(x + "::" + (y + 1));
            }
            // Down + Right
            if (x + 1 <= xMax && y + 1 <= yMax) {
                coordinateAround.add((x + 1) + "::" + (y + 1));
            }
            // Down
            if (x + 1 <= xMax) {
                coordinateAround.add((x + 1) + "::" + y);
            }
            // Down + Left
            if (x + 1 <= xMax && y - 1 >= 0) {
                coordinateAround.add((x + 1) + "::" + (y - 1));
            }
            // Left
            if (y - 1 >= 0) {
                coordinateAround.add(x + "::" + (y - 1));
            }
            // Up + Left
            if (x - 1 >= 0 && y - 1 >= 0) {
                coordinateAround.add((x - 1) + "::" + (y - 1));
            }

            // Count Mines around
            this.mineCount = coordinateAround
                    .stream()
                    .filter(key -> board.getBoard().get(coordinateKeyDecoder_X(key)).get(coordinateKeyDecoder_Y(key)).hasMine)
                    .collect(Collectors.toList())
                    .size();

//            this.content = "?";
            if (this.mineCount == 0) {
                this.content = " ";
            } else {
                this.content = mineCount + "";
            }
        }
    }

    public void sweepAllAround(int xMax, int yMax, Board board) {
        List<Cell> emptyCellList = new ArrayList<>();
        emptyCellList.add(this);

        List<Cell> tempList;

        do {
            //loop celllist
//            tempList = new ArrayList<>();

            tempList = new ArrayList<>();
            for (Cell emptyCell : emptyCellList) {
                int x = emptyCell.getCoordinate().getxCoordinate();
                int y = emptyCell.getCoordinate().getyCoordinate();
                tempList.addAll(setSweepedForSingleEmptyCell(emptyCell, xMax, yMax, board));
            }

            if (!tempList.isEmpty()) {
                emptyCellList.clear();
                emptyCellList.addAll(tempList);
            } else {
                break;
            }

            // Add templist to emptyCellList if templist is not empty
        } while (!emptyCellList.isEmpty());
//
//        return cellList;
    }

    public List<Cell> setSweepedForSingleEmptyCell(Cell givenCell, int xMax, int yMax, Board board) {
        int x = givenCell.getCoordinate().getxCoordinate();
        int y = givenCell.getCoordinate().getyCoordinate();

        List<Cell> emptyCellsAround = new ArrayList<>();

        // Using a customized interface to define a block of code
        // Reduce the code duplication
        SweepAround sweepIt = new SweepAround() {
            @Override
            public void sweep(Cell tempCell, List<Cell> emptyCellsAround) {
                if (!tempCell.isSweeped) {
                    tempCell.setIsSweeped(true);
                    if (tempCell.mineCount == 0) {
                        emptyCellsAround.add(tempCell);
                    }
                }
            }
        };

        // Check all 8 direction, if qualify, then add the movement,
        // Otherwise, pass to next check
        // Up
        if (x - 1 >= 0) {
            Cell tempCell = board.getBoard().get(x - 1).get(y);
            sweepIt.sweep(tempCell, emptyCellsAround);

        }
        // Up + Right
        if (x - 1 >= 0 && y + 1 <= yMax) {
            Cell tempCell = board.getBoard().get(x - 1).get(y + 1);
            sweepIt.sweep(tempCell, emptyCellsAround);
        }
        // Right
        if (y + 1 <= yMax) {
            Cell tempCell = board.getBoard().get(x).get(y + 1);
            sweepIt.sweep(tempCell, emptyCellsAround);
        }
        // Down + Right
        if (x + 1 <= xMax && y + 1 <= yMax) {
            Cell tempCell = board.getBoard().get(x + 1).get(y + 1);
            sweepIt.sweep(tempCell, emptyCellsAround);
        }
        // Down
        if (x + 1 <= xMax) {
            Cell tempCell = board.getBoard().get(x + 1).get(y);
            sweepIt.sweep(tempCell, emptyCellsAround);
        }
        // Down + Left
        if (x + 1 <= xMax && y - 1 >= 0) {
            Cell tempCell = board.getBoard().get(x + 1).get(y - 1);
            sweepIt.sweep(tempCell, emptyCellsAround);
        }
        // Left
        if (y - 1 >= 0) {
            Cell tempCell = board.getBoard().get(x).get(y - 1);
            sweepIt.sweep(tempCell, emptyCellsAround);
        }
        // Up + Left
        if (x - 1 >= 0 && y - 1 >= 0) {
            Cell tempCell = board.getBoard().get(x - 1).get(y - 1);
            sweepIt.sweep(tempCell, emptyCellsAround);
        }

        return emptyCellsAround;
    }

    public String coordinateKeyEncoder() {
        return coordinate.getxCoordinate() + "::" + coordinate.getyCoordinate();
    }

    public int coordinateKeyDecoder_X(String encodedCoordinate) {
        return Integer.parseInt(encodedCoordinate.split("::")[0]);
    }

    public int coordinateKeyDecoder_Y(String encodedCoordinate) {
        return Integer.parseInt(encodedCoordinate.split("::")[1]);
    }

    public String getContent() {
        return content;
    }

    public boolean isHasMine() {
        return hasMine;
    }

    public int getMineCount() {
        return mineCount;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isIsSweeped() {
        return isSweeped;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setIsSweeped(boolean isSweeped) {
        this.isSweeped = isSweeped;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
