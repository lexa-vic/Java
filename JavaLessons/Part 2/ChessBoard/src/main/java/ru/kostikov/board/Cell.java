package ru.kostikov.board;

import com.google.common.base.Optional;
import ru.kostikov.figures.Figure;


/**
 * This class implements a cell in chess board.
 * It has name(E2, A1,..), and can manage figure whitch set in this cell
 * 
 * Created by Алексей on 27.07.2016.
 */
public class Cell {
    /** Cell's name*/
    private String name;

    /** Figure is set in the cell */
    private Figure figure = null;

    private int x;
    private int y;

    /**
     * Constructor.
     * Create Cell with name and coordinats on board.
     * @param name Cell's name
     * @param x    х-coordinate on board
     * @param y    у-coordinate on board
     */
    Cell(String name, int x, int y){
        this.name = name;
        this.x    = x;
        this.y    = y;
    }
    /**
     * Give Cell's name
     * @return String name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set a figure in the cell.
     * @param figure
     * @return true - sucsess, false - fail.
     */
    public boolean setFigure(Figure figure){
        boolean result = false;

        Optional<Figure> figureOptional = Optional.fromNullable(this.figure);
        if (!figureOptional.isPresent()){
            this.figure = figure;
            result = true;
        }
        return result;
    }
    /**
     * Give figure in the cell.
     * @return Figure
     */
    public Figure getFigure(){
        return this.figure;
    }

    /**
     * It calculate all possible movements in the cell. 
     * @param board Playing borad.
     * @return Cell[] Possible movements.
     */
    public Cell[] calcAllMoves(Cell[][] board) throws NullPointerException{

        Cell[] allMoves = new Cell[25];

        Optional<Figure> o = Optional.of(this.getFigure());

        int[] offsetSideX = this.getFigure().getOffsetSideX();
        int[] offsetSideY = this.getFigure().getOffsetSideY();
        int stepsCnt = this.getFigure().getSteps();
        int moveCnt = 0;

        for(int side = 0; side < offsetSideX.length; side++){
            for(int  i = 1; i <= stepsCnt; i++){
                if (((this.x + offsetSideX[side]*i) >= 0 && (this.x + offsetSideX[side]*i) < board.length) &&
                    ((this.y + offsetSideY[side]*i) >= 0 && (this.y + offsetSideY[side]*i) < board[this.x].length)){

                    Cell movingCell = board[this.x + offsetSideX[side]*i][this.y + offsetSideY[side]*i];

                    if (movingCell.getFigure() == null){
                        allMoves[moveCnt++] = movingCell;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
        }

        return allMoves;
    }
    /**
     * It moves figure from current Cell to another Cell
     * @param cellTo Cell-destination
     * @return boolean true - sucsess, move is done.
     */
    public boolean moveFigure(Cell cellTo){
        boolean result = false;

        result = cellTo.setFigure(this.getFigure());
        if (result){
            this.figure = null;
        }
        return result;
    }
}
