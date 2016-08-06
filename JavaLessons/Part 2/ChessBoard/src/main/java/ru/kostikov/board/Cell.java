package ru.kostikov.board;

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

        if (this.figure == null && figure != null){
            this.figure = figure;

            result = true;
        }

        return result;
    }

    /**
     *  Удаляет фигуру из ячейкм
     */
    public void clearCell(){
        this.figure = null;
    }

    /**
     * Достает фигуру которая находится в ячейке
     * @return Figure
     */
    public Figure getFigure(){
        return this.figure;
    }

    /**
     * Координата х ячейки на поле
     * @return int x
     */
    public int getX(){
        return this.x;
    }

    /**
     * Координата у ячейки на поле
     * @return int y
     */
    public int getY(){
        return this.y;
    }


    /**
     * Расчет всех возможных ходов для фигуры в текущей ячейке
     * @param board    - поле в котором будут просчитываться ходы
     * @param allMoves - возможные ходы
     */
    public void calcAllMoves(Cell[][] board, Cell[] allMoves ){

        if (this.getFigure() != null && allMoves != null){

            int [] offsetSideX = this.getFigure().getOffsetSideX();
            int [] offsetSideY = this.getFigure().getOffsetSideY();
            int       stepsCnt = this.getFigure().getSteps();
            int moveCnt        = 0;

            for(int side = 0; side < offsetSideX.length; side++){
                for(int  i = 1; i <= stepsCnt; i++){
                    // Проверяем выход за границы поля
                    if (((this.getX() + offsetSideX[side]*i) >= 0 && (this.getX() + offsetSideX[side]*i) < board.length) &&
                        ((this.getY() + offsetSideY[side]*i) >= 0 && (this.getY() + offsetSideY[side]*i) < board[this.getX()].length)){

                        Cell movingCell = board[this.getX() + offsetSideX[side]*i][this.getY() + offsetSideY[side]*i];

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
        }
    }

    /**
     * Перемещяет фигур с текущей ячейки в ячеку, задаваемую параметром
     * @param cellTo ячека куда перемещается фигура
     * @return boolean - true если фигура переместилась
     */
    public boolean moveFigure(Cell cellTo){

        boolean result = false;

        if (cellTo != null)
        {
            cellTo.setFigure(this.getFigure());
        }

        if (result){
            this.clearCell();
        }
        return result;
    }
}
