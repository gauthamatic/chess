package com.technogise.service;

import com.technogise.helper.BoardUtility;
import com.technogise.helper.CellUtility;
import com.technogise.model.*;

import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("Please type the Type of chess piece and it’s position (cell number) on the\n" +
                "chessboard. E.g. Pawn, G1");
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();

        String[] input = str.split(",");
        String pieceType = input[0].trim().toUpperCase();
        String position = input[1].trim().toUpperCase();

        Piece piece = PieceFactory.getPiece(pieceType);
        Board board = BoardUtility.createBoard();
        Cell currentCell = CellUtility.getCell(position,board);
        piece.setCurrentCell(currentCell);

        List<Cell> cells = piece.nextPossibleCells(board);
        System.out.println("Possible moves:");
        cells.forEach(CellUtility::printCell);
    }
}
