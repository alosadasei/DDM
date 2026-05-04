package com.ddm.model.board;

import com.ddm.model.entity.Monster;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int WIDTH = 9;
    public static final int HEIGHT = 12;

    private Tile[][] grid;

    public Board() {
        grid = new Tile[WIDTH][HEIGHT];

        initializeBoard();
    }

    private void initializeBoard() {

        for (int x = 0; x < WIDTH; x++) {

            for (int y = 0; y < HEIGHT; y++) {

                grid[x][y] = new Tile(x, y);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if(!isInsideBoard(x, y)) {
            throw new IllegalArgumentException("Invalid board position");
        }

        return grid[x][y];
    }

    public boolean isInsideBoard(int x, int y) {
        return x >= 0
            && x < WIDTH
            && y >= 0
            && y < HEIGHT;
    }
}
