package com.technogise.model;

public class Board {
    int boardSize;
    Cell[][] cells;

    public Board(int boardSize, Cell[][] cells) {
        this.boardSize = boardSize;
        this.cells = cells;
    }

    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() - 1);
    }

    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() + 1);
    }

    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY());
    }

    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY());
    }

    public Cell getDiagonalUpperRightCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY() + 1);
    }

    public Cell getDiagonalLowerRightCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY() + 1);
    }

    public Cell getDiagonalUpperLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY() - 1);
    }

    public Cell getDiagonalLowerLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY() - 1);
    }

    public Cell getCellAtLocation(int x, int y) {
        if (x >= boardSize || x < 0) {
            return null;
        }
        if (y >= boardSize || y < 0) {
            return null;
        }

        return cells[x][y];
    }
}
