package ru.kostikov.board;

import java.util.Optional;


/**
 * Created by Алексей on 26.07.2016.
 */
public class Board {
    /** Размер доски */
    private final int BOARD_SIZE = 8;

    /** Непосредственно сама игровая доска */
    private Cell[][] board = new Cell[BOARD_SIZE][BOARD_SIZE];

    public Board(){

        /** Заполняем массив алфавитом по порядку*/
        /* Именование ячеек по горизонтали доски */
        char[] horizontalAxisNames = new char[BOARD_SIZE];
        for(int size = 0; size < this.BOARD_SIZE; size++){
            horizontalAxisNames[size] = (char)((int)'a' + size);
        }
        /** Заполняем массив номерами по порядку*/
        /* Именование ячеек по вертикали доски */
        char[] vertivalAxisNames = new char[BOARD_SIZE];
        for(int size = 0; size < this.BOARD_SIZE; size++){
            vertivalAxisNames[size] = (char)((int)'1' + size);
        }

        /** Создаем ячейки поля - присваиваем им имена */
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){

                String name = String.valueOf(horizontalAxisNames[i]) + String.valueOf(vertivalAxisNames[j]);
                this.board[i][j] = new Cell(name, i, j);
            }
        }
    }

    /**
     * Взятие ячейки по имени
     * @param cellName Имя ячейки
     * @return Cell    ячейка
     * @throws BoardExeption исключение выбрасываемое если ячейка не найдена
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
     * Ход из одной ячейки в другую
     * @param cellFrom  ячейка из которой делается ход
     * @param cellTo    ячейка в которую делается ход
     * @return boolean false - ход не верный, true ход сделан
     */
    public boolean move(Cell cellFrom, Cell cellTo) {
        boolean result = false;

        /** Возможные ходы фигуры */
        Cell[] moves;
        // Просчитываем все возможные ходы

        moves = cellFrom.calcAllMoves(board);
        // Если ячейки куда и откуда не равны, можно ходить
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
