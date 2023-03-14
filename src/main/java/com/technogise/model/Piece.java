package com.technogise.model;

import com.technogise.helper.ListHelper;
import com.technogise.moves.PossibleMovesProvider;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private final List<PossibleMovesProvider> movesProviders;
    PieceType pieceType;
    private Cell currentCell;

    public List<PossibleMovesProvider> getMovesProviders() {
        return movesProviders;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Piece(List<PossibleMovesProvider> movesProviders, PieceType pieceType) {
        this.movesProviders = movesProviders;
        this.pieceType = pieceType;
    }

    public List<Cell> nextPossibleCells(Board board) {
        List<Cell> result = new ArrayList<>();
        for (PossibleMovesProvider movesProvider : this.movesProviders) {
            List<Cell> cells = movesProvider.possibleMoves(this, board);
            if (cells != null) {
                result.addAll(cells);
            }
        }
        return ListHelper.removeDuplicates(result);
    }

}
