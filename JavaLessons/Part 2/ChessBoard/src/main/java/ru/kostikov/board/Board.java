package ru.kostikov.board;

import ru.kostikov.figures.Figure;
import ru.kostikov.figures.Pawn;
import ru.kostikov.players.*;

/**
 * Created by Алексей on 26.07.2016.
 */
public class Board {
    /** Размер доски */
    private final int BOARD_SIZE = 8;

    /** Непосредственно сама игровая доска */
    private Cell[][] board = new Cell[BOARD_SIZE][BOARD_SIZE];

    /** Именование ячеек по горизонтали доски */
    private char[] horizontalAxisNames = new char[BOARD_SIZE];

    /** Именование ячеек по вертикали доски */
    private char[] vertivalAxisNames   = new char[BOARD_SIZE];

    public Board(){

        /** Заполняем массив алфавитом по порядку*/
        for(int size = 0; size < this.BOARD_SIZE; size++){
            this.horizontalAxisNames[size] = (char)((int)'a' + size);
        }
        /** Заполняем массив номерами по порядку*/
        for(int size = 0; size < this.BOARD_SIZE; size++){
            this.vertivalAxisNames[size] = (char)((int)'1' + size);
        }

        /** Создаем ячейки поля - присваиваем им имена */
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){

                String name = String.valueOf(this.horizontalAxisNames[i]) + String.valueOf(this.vertivalAxisNames[j]);
                this.board[i][j] = new Cell(name, i, j);
            }
        }
    }

    /**
     * Поиск ячейки по имени
     * @param cellName
     * @return  Cell в случае успеха, NULL если не нашли
     */
    private Cell findCellByName(String cellName){
        Cell cell = null;

        for(int i = 0; i < BOARD_SIZE; i++) {
            // Ищем ячейку
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (this.board[i][j].getName().equals(cellName.toLowerCase())) {
                    cell = this.board[i][j];
                    i    = BOARD_SIZE;
                    break;
                }
            }
        }

        return cell;
    }

    /**
     * Установка фигуры на поле
     * @param figure
     * @param cellName
     * @return false - фигура не установлена
     */
    public boolean setFigure(Figure figure, String cellName){
        boolean result = false;

       Cell cell = findCellByName(cellName);

        if (cell != null){
            // Добавляем в фигуру ссылку на поле
            figure.setBoard(this.board);
            // Нашли ячейку, устанавливаем фигуру в ней
            result  = cell.setFigure(figure);
        }

        return result;
    }

    /**
     * Делаем ход
     * @param cellFrom
     * @param cellTo
     * @return false - ход не верный, true ход сделан
     */
    public boolean move(String cellFrom, String cellTo){
        boolean result = false;

        Cell cellF = findCellByName(cellFrom);
        Cell cellT = findCellByName(cellTo);

        if (cellF != null && cellT != null) {
            Figure figure = cellF.getFigure();

            if (figure != null){
                result = figure.moveTo(cellF, cellT);
            }
        }


        return result;
    }

}
