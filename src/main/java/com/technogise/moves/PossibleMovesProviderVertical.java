package com.technogise.moves;

import com.technogise.model.Board;
import com.technogise.model.Cell;
import com.technogise.model.Piece;

import java.util.ArrayList;
import java.util.List;

import static com.technogise.moves.VerticalMoveDirection.*;


public class PossibleMovesProviderVertical extends PossibleMovesProvider {
    private VerticalMoveDirection verticalMoveDirection;

    public PossibleMovesProviderVertical(int maxSteps, VerticalMoveDirection verticalMoveDirection) {
        super(maxSteps);
        this.verticalMoveDirection = verticalMoveDirection;
    }


    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board) {
        List<Cell> result = new ArrayList<>();
        if (this.verticalMoveDirection == UP || this.verticalMoveDirection == BOTH) {
            result.addAll(findAllNextMoves(piece, board::getUpCell, board));
        }
        if (this.verticalMoveDirection == DOWN || this.verticalMoveDirection == BOTH) {
            result.addAll(findAllNextMoves(piece, board::getDownCell, board));
        }
        return result;
    }
}
