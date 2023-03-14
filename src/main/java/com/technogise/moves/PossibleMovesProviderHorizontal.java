package com.technogise.moves;

import com.technogise.model.Board;
import com.technogise.model.Cell;
import com.technogise.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovesProviderHorizontal extends PossibleMovesProvider {

    public PossibleMovesProviderHorizontal(int maxSteps) {
        super(maxSteps);
    }

    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, final Board board) {
        List<Cell> result = new ArrayList<>();
        result.addAll(findAllNextMoves(piece, board::getLeftCell, board));
        result.addAll(findAllNextMoves(piece, board::getRightCell, board));
        return result;
    }
}
