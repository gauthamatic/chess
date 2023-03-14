package com.technogise.chess.model;

import com.technogise.model.Board;
import com.technogise.model.Cell;
import com.technogise.model.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.technogise.chess.helpers.TestHelpers.*;

public class PossibleMovesTest {

    @Test
    public void testKingPossibleMoves(){
        Board board = createBoard();
        Piece piece = createKingPiece();
        Cell cell = board.getCellAtLocation(1, 1);
        piece.setCurrentCell(cell);

        List<Cell> cells = piece.nextPossibleCells(board);
        Assert.assertEquals(cells.size(),8);
    }

    @Test
    public void testQueenPossibleMoves(){
        Board board = createBoard();
        Piece piece = createQueenPiece();
        Cell cell = board.getCellAtLocation(0, 0);
        piece.setCurrentCell(cell);

        List<Cell> cells = piece.nextPossibleCells(board);
        Assert.assertEquals(cells.size(),21);
    }

    @Test
    public void testPawnPossibleMoves(){
        Board board = createBoard();
        Piece piece = createPawnPiece();
        Cell cell = board.getCellAtLocation(1, 1);
        piece.setCurrentCell(cell);

        List<Cell> cells = piece.nextPossibleCells(board);
        Assert.assertEquals(cells.size(),1);
        Assert.assertEquals(cells.get(0).getX(),2);
        Assert.assertEquals(cells.get(0).getY(),1);
    }

}
