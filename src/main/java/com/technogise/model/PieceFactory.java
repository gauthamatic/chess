package com.technogise.model;

import com.technogise.moves.PossibleMovesProvider;
import com.technogise.moves.PossibleMovesProviderDiagonal;
import com.technogise.moves.PossibleMovesProviderHorizontal;
import com.technogise.moves.PossibleMovesProviderVertical;

import java.util.Arrays;
import java.util.List;

import static com.technogise.model.PieceType.*;
import static com.technogise.moves.VerticalMoveDirection.BOTH;
import static com.technogise.moves.VerticalMoveDirection.UP;

public class PieceFactory {

    public static Piece getPiece(String type){
        if (type == null || type.isEmpty())
            throw new IllegalArgumentException("Unknown piece type "+ type);

        List<PossibleMovesProvider> moveProviders;

        switch (type) {
            case "PAWN":
                moveProviders = Arrays.asList(
                        new PossibleMovesProviderVertical(1, UP)
                );
                return new Piece(moveProviders, PAWN);
            case "KING":
                moveProviders = Arrays.asList(
                        new PossibleMovesProviderVertical(1, BOTH),
                        new PossibleMovesProviderHorizontal(1),
                        new PossibleMovesProviderDiagonal(1)
                );
                return new Piece(moveProviders, KING);
            case "QUEEN":
                moveProviders = Arrays.asList(
                        new PossibleMovesProviderVertical(8, BOTH),
                        new PossibleMovesProviderHorizontal(8),
                        new PossibleMovesProviderDiagonal(8)
                );
                return new Piece(moveProviders, QUEEN);
            default:
                throw new IllegalArgumentException("Unknown piece type "+ type +
                        ". Piece should be either PAWN, KING or QUEEN");
        }
    }
}
