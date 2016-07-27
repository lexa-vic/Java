package ru.kostikov.board;

import ru.kostikov.figures.Figure;

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

    Board(){

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

                String name = String.valueOf(this.horizontalAxisNames[j]) + String.valueOf(this.vertivalAxisNames[i]);
                board[i][j] = new Cell(name);
            }
        }
    }

    public static void main(String[] args) {

        Board board = new Board();



    }

}
