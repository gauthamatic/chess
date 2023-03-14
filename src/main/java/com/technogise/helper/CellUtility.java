package com.technogise.helper;

import com.technogise.model.Board;
import com.technogise.model.Cell;

public class CellUtility {

    public static Cell getCell(String pos, Board board){

        if ( pos == null || pos == "" || pos.length() > 2){
            throw new IllegalArgumentException("Invalid cell position format: " + pos +
                    ". It should be of the format : ColumnNameRowNumber");
        }

        int colNum = getColumnNum(pos.charAt(0));
        int rowNum = getRowNum(pos.charAt(1));

        return board.getCellAtLocation(rowNum,colNum);
    }

    private static int getColumnNum(char col) {
        switch (col) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            default:
                throw new IllegalArgumentException("Invalid column: "+ col + ". Column should be in range A to H");
        }
    }

    private static int getRowNum(char row) {
        int rowNum;
        if(Character.isDigit(row)){
            rowNum = Integer.parseInt(Character.toString(row));
        }
        else{
            throw new IllegalArgumentException("Invalid row number: " + row +
                    ". Row should be a number in range of 1 to 8");
        }
        if (rowNum < 1 || rowNum > 8){
            throw new IllegalArgumentException("Invalid row number: " + row + ". Row should be in range of 1 to 8");
        }
        return rowNum-1;
    }

    private static String getColumnName(int col) {
        switch (col) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            default:
                throw new IllegalArgumentException("Invalid column Number: "+ col + ". Column number should be in range 0 to 7");
        }
    }

    public static void printCell(Cell cell){
        String row = Integer.toString(cell.getX() + 1);
        String col = getColumnName(cell.getY());
        System.out.println(col+row);
    }

}
