package ru.kostikov.board;

import ru.kostikov.board.BoardExeption;

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
     * Взятие ячейки по имени
     * @param cellName Имя ячейки
     * @return Cell    ячейка
     * @throws BoardExeption исключение выбрасываемое если ячейка не найдена
     */
    public Cell getCell(String cellName) throws BoardExeption{
        Cell cell = findCellByName(cellName);

        if (cell == null){
            throw new BoardExeption("Ячейка не найдена");
        }

        return cell;
    }

    /**
     * Ход из одной ячейки в другую
     * @param cellFrom  ячейка из которой делается ход
     * @param cellTo    ячейка в которую делается ход
     * @return boolean false - ход не верный, true ход сделан
     */
    public boolean move(Cell cellFrom, Cell cellTo) {
        boolean result = false;

        if (cellTo != null) {
            /** Возможные ходы фигуры */
            Cell[] moves = new Cell[25];

            // Просчитываем все возможные ходы
            cellFrom.calcAllMoves(board, moves);

            // Если ячейки куда и откуда не равны, можно ходить
            if (!cellFrom.getName().equals(cellTo.getName())){

                for(Cell move: moves){
                    if(move != null && move.getName().equals(cellTo.getName())){
                        result = cellFrom.moveFigure(cellTo);
                        break;
                    }
                }
            }
        }
        return result;
    }
}