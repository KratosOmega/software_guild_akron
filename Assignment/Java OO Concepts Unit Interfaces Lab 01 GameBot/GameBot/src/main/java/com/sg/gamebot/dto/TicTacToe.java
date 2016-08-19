package com.sg.gamebot.dto;

import java.util.Scanner;

/**
 * Created by Kratos on 6/19/16.
 */
public class TicTacToe implements Playable {
    private String gameName;
    private static char[][] board = new char[3][3];

    public TicTacToe() {
        this.gameName = "Tic Tac Toe";
    }

    public void execute() {
        Scanner keyboard = new Scanner(System.in);

        initBoard();
        // displayBoard();
        playGame(board);
    }

    public String whatIsGameName() {
        return this.gameName;
    }

    public static void initBoard() {
        // fills up the board with blanks
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    public static void displayBoard() {
        System.out.println("");
        System.out.println("  0  " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("    ---+---+---");
        System.out.println("  1  " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("    ---+---+---");
        System.out.println("  2  " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println("     0   1   2 ");
        System.out.println("");
    }

    public static void displayBoard2() {
        for (int r = 0; r < 3; r++) {
            System.out.print("\t" + r + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("\t  0 1 2 ");
    }

    public static boolean isEmpty(int row, int col, char[][] board){
        if(board[row][col] == ' '){
            return true;
        }else{
            return false;
        }
    }

    public static void playGame(char[][] board) {
        // Assume O is the first to go;
        Scanner keyboard = new Scanner(System.in);
        char turn = 'O';
        int row;
        int col;
        System.out.println("(...a game already in progress)");

        while (!isGameOver(board)) {
            displayBoard();

            System.out.print(turn + ", choose your location (row, column): ");
            row = keyboard.nextInt();
            col = keyboard.nextInt();

            // Move placeable validation check
            while(!isEmpty(row, col, board)){
                System.out.println("You can not move to " + row + ", " + col);
                System.out.print("Please re-choose your location (row, column): ");
                row = keyboard.nextInt();
                col = keyboard.nextInt();
            }

            board[row][col] = turn;

            if (whoIsWinner(board)) {
                if (turn == 'O') {
                    turn = 'X';
                } else {
                    turn = 'O';
                }
            } else {
                break;
            }
        }
    }

    // Check whether the board has empty space
    public static boolean isGameOver(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Determine who is the winner
    public static boolean whoIsWinner(char[][] board) {
        int rowCheck = 0;
        int colCheck = 0;
        int crossCheck1 = 0;
        int crossCheck2 = 0;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                rowCheck += board[row][col];
                colCheck += board[col][row];
                if (row == col) {
                    crossCheck1 += board[row][col];
                }
                if ((row + col) == 2) {
                    crossCheck2 += board[row][col];
                }
            }
            if (rowCheck == 237 || colCheck == 237) {
                displayBoard();
                System.out.println("\"O\" is the winner!!!");
                return false;
            }
            if (rowCheck == 264 || colCheck == 264) {
                displayBoard();
                System.out.println("\"X\" is the winner!!!");
                return false;
            }
            rowCheck = 0;
            colCheck = 0;
        }

        if (crossCheck1 == 237 || crossCheck2 == 237) {
            displayBoard();
            System.out.println("\"O\" is the winner!!!");
            return false;
        } else if (crossCheck1 == 264 || crossCheck2 == 264) {
            displayBoard();
            System.out.println("\"X\" is the winner!!!");
            return false;
        } else if (isGameOver(board)) {
            displayBoard();
            System.out.println("The game is a ties");
            return false;
        } else {
            return true;
        }
    }
}
