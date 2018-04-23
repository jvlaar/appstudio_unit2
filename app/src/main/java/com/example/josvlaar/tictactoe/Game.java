package com.example.josvlaar.tictactoe;

import java.io.Serializable;

public class Game implements Serializable {
    final public int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public Tile draw(int row, int column) {
        if (board[row][column] != Tile.BLANK) {
            return Tile.INVALID;
        }
        if (playerOneTurn) {
            board[row][column] = Tile.CROSS;
            playerOneTurn = false;
            return Tile.CROSS;
        } else {
            board[row][column] = Tile.CIRCLE;
            playerOneTurn = true;
            return  Tile.CIRCLE;
        }
    }

    public Tile getState(int row, int column) {
        return board[row][column];
    }
}
