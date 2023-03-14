package com.technogise.helper;

import com.technogise.model.Board;
import com.technogise.model.Cell;

public class BoardUtility {
    public static Board createBoard() {
        Cell[][] cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        return new Board(8, cells);
    }
}
