package com.technogise.moves;

import com.technogise.model.Board;
import com.technogise.model.Cell;
import com.technogise.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovesProviderDiagonal extends PossibleMovesProvider {

    public PossibleMovesProviderDiagonal(int maxSteps) {
        super(maxSteps);
    }

    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board) {
        List<Cell> result = new ArrayList<>();
        result.addAll(findAllNextMoves(piece, board::getDiagonalUpperLeftCell, board));
        result.addAll(findAllNextMoves(piece, board::getDiagonalLowerLeftCell, board));
        result.addAll(findAllNextMoves(piece, board::getDiagonalUpperRightCell, board));
        result.addAll(findAllNextMoves(piece, board::getDiagonalLowerRightCell, board));
        return result;
    }
}
