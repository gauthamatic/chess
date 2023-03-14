package com.technogise.chess.helpers;

import com.technogise.model.Board;
import com.technogise.model.Cell;
import com.technogise.model.Piece;
import com.technogise.moves.PossibleMovesProvider;
import com.technogise.moves.PossibleMovesProviderDiagonal;
import com.technogise.moves.PossibleMovesProviderHorizontal;
import com.technogise.moves.PossibleMovesProviderVertical;

import java.util.Arrays;
import java.util.List;

import static com.technogise.model.PieceType.*;
import static com.technogise.moves.VerticalMoveDirection.BOTH;
import static com.technogise.moves.VerticalMoveDirection.UP;

public class TestHelpers {

    public static Board createBoard() {
        Cell[][] cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        return new Board(8, cells);
    }

    public static Piece createKingPiece() {
        List<PossibleMovesProvider> pawnMoveProviders = Arrays.asList(
                new PossibleMovesProviderVertical(1, BOTH),
                new PossibleMovesProviderHorizontal(1),
                new PossibleMovesProviderDiagonal(1)
        );
        return new Piece(pawnMoveProviders, KING);
    }

    public static Piece createQueenPiece() {
        List<PossibleMovesProvider> pawnMoveProviders = Arrays.asList(
                new PossibleMovesProviderVertical(8, BOTH),
                new PossibleMovesProviderHorizontal(8),
                new PossibleMovesProviderDiagonal(8)
        );
        return new Piece(pawnMoveProviders, QUEEN);
    }

    public static Piece createPawnPiece() {
        List<PossibleMovesProvider> pawnMoveProviders = Arrays.asList(
                new PossibleMovesProviderVertical(1, UP)
        );
        return new Piece(pawnMoveProviders, PAWN);
    }

}
