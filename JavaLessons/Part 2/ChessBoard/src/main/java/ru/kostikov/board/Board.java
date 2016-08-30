package ru.kostikov.board;

import java.util.Optional;


/**
 * This class implements a chess board.
 * It can get a Cell and make move.
 * Created by Алексей on 26.07.2016.
 */
public class Board {
    /** Board size */
    private final int BOARD_SIZE = 8;

    /** Chess board */
    private Cell[][] board = new Cell[BOARD_SIZE][BOARD_SIZE];

    public Board(){

        /** Horizonatal name Cells  */
        char[] horizontalAxisNames = new char[BOARD_SIZE];
        for(int size = 0; size < this.BOARD_SIZE; size++){
            horizontalAxisNames[size] = (char)((int)'a' + size);
        }
        /** Vertical name Cells  */
        char[] vertivalAxisNames = new char[BOARD_SIZE];
        for(int size = 0; size < this.BOARD_SIZE; size++){
            vertivalAxisNames[size] = (char)((int)'1' + size);
        }
        /** Create Cell - fill it name */
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){

                String name = String.valueOf(horizontalAxisNames[i]) + String.valueOf(vertivalAxisNames[j]);
                this.board[i][j] = new Cell(name, i, j);
            }
        }
    }

    /**
     * Give Cell by it name
     * @param cellName Name of Cell
     * @return Optional<Cell> Cell 
     */
    public Optional<Cell> getCell(String cellName){

        Optional<Cell> result = Optional.empty();

        for (Cell[] cells : this.board) {
            for (Cell cell : cells) {
                if (cell.getName().equalsIgnoreCase(cellName)) {
                    result = Optional.of(cell);
                    break;
                }
            }
            if (result.isPresent()) {
                break;
            }
        }
        return result;
    }

    /**
     * Move from one Cell to another
     * @param cellFrom  Cell from which move starts
     * @param cellTo    Cell where we want to go
     * @return boolean false - move is wrong, true - move is done successfully
     */
    public boolean move(Cell cellFrom, Cell cellTo) {
        boolean result = false;
        /** All figure moves */
        Cell[] moves;
        moves = cellFrom.calcAllMoves(board);
        if (!cellFrom.getName().equals(cellTo.getName())){
            for(Cell move: moves){
                if(move != null && move.getName().equals(cellTo.getName())){
                    result = cellFrom.moveFigure(cellTo);
                    break;
                }
            }
        }
        return result;
    }
}
