package ru.kostikov.board;

import com.google.common.base.Optional;
import ru.kostikov.figures.Figure;


/**
 * Created by Алексей on 27.07.2016.
 */
public class Cell {
    /** Имя(идентификатор) ячейки*/
    private String name;

    /** Фигура расположенная в этой ячейке */
    private Figure figure = null;

    private int x;
    private int y;

    /**
     * Конструктор ячейки поля
     * @param name Имя ячейки
     * @param x    Её координата х на поле
     * @param y    Её координата у на поле
     */
    Cell(String name, int x, int y){
        this.name = name;
        this.x    = x;
        this.y    = y;
    }
    /**
     * Вызов имени ячейки
     * @return String name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Установка фигуры в ячейку
     * @param figure
     * @return
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
     * Достает фигуру которая находится в ячейке
     * @return Figure
     */
    public Figure getFigure(){
        return this.figure;
    }

    /**
     * Расчет всех возможных ходов для фигуры в текущей ячейке
     * @param board    - поле в котором будут просчитываться ходы
     * @return Cell[] - возможные ходы
     */
    public Cell[] calcAllMoves(Cell[][] board) throws NullPointerException{

        Cell[] allMoves = new Cell[25];

        // Проверка на Null
        Optional<Figure> o = Optional.of(this.getFigure());

        int[] offsetSideX = this.getFigure().getOffsetSideX();
        int[] offsetSideY = this.getFigure().getOffsetSideY();
        int stepsCnt = this.getFigure().getSteps();
        int moveCnt = 0;

        for(int side = 0; side < offsetSideX.length; side++){
            for(int  i = 1; i <= stepsCnt; i++){
                // Проверяем выход за границы поля
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
     * Перемещяет фигур с текущей ячейки в ячеку, задаваемую параметром
     * @param cellTo ячека куда перемещается фигура
     * @return boolean - true если фигура переместилась
     */
    public boolean moveFigure(Cell cellTo){
        boolean result = false;

        result = cellTo.setFigure(this.getFigure());
        // Убираем из этой ячейки
        if (result){
            this.figure = null;
        }
        return result;
    }
}
