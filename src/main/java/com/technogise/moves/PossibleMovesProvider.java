package com.technogise.moves;

import com.technogise.model.Board;
import com.technogise.model.Cell;
import com.technogise.model.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class PossibleMovesProvider {
    int maxSteps;

    public PossibleMovesProvider(int maxSteps) {
        this.maxSteps = maxSteps;
    }


    public List<Cell> possibleMoves(Piece piece, Board inBoard) {
        return possibleMovesAsPerCurrentType(piece, inBoard);
    }

    protected abstract List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board);


    protected List<Cell> findAllNextMoves(Piece piece, NextCellProvider nextCellProvider, Board board) {
        List<Cell> result = new ArrayList<>();
        Cell nextCell = nextCellProvider.nextCell(piece.getCurrentCell());
        int numSteps = 1;
        while (nextCell != null && numSteps <= maxSteps) {
            result.add(nextCell);
            nextCell = nextCellProvider.nextCell(nextCell);
            numSteps++;
        }
        return result;
    }

}
