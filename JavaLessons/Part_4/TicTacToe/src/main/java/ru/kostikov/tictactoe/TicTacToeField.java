package ru.kostikov.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Представление игрового поля для игры Крестики-нолики.
 * 
 * @author dok
 * 
 */
public class TicTacToeField extends Field {

    protected TicTacToeField.State state = TicTacToeField.State.NONE;

    /**
     * Возможные состояния игрового поля.
     */
    public enum State {
        /** Игра в самом разгаре */
        NONE,
        /** Ничья */
        DRAW,
        /** Выиграли крестики */
        WIN_X,
        /** Выиграли нолики */
        WIN_O;
    }

    /** Идентификатор игрока Крестики */
    public static final int PLAYER_X = 1;

    /** Идентификатор игрока Нолики */
    public static final int PLAYER_O = -1;


    /** Конструктор с указанием размера поля и длины выйграшной комбинации
     * @param size
     * @param winLength
     */
    public TicTacToeField(int size, int winLength) {
        this(new int[size][size], winLength);
    }

    /**
     *  Конструктор с передачей самого поля и длины выйграшной комбинации
     * @param field
     * @param winLength
     */
    public TicTacToeField(int[][] field, int winLength) {
        if (field.length == 0 || field.length != field[0].length) {
            throw new IllegalArgumentException("Некорректные размеры игрового поля.");
        }
        if (field.length < winLength) {
            throw new IllegalArgumentException("Некорректная длина выигрышной длины.");
        }
        this.winLength = winLength;
        this.field = field;

        reviewState();
    }


    /**
     * Текущее состояние поля
     * @return State состояние поля
     */
    public State getState() {
        return state;
    }
    /**
     * Установка состояния поля
     * @param state
     */
    private void setState(State state) {
        this.state = state;
    }


    /**
     * Возвращает массив допустимых ходов.
     *
     * @return массив допустимых ходов.
     */
    @Override
    public Move[] getMoves() {
        List<Move> moves = new ArrayList<Move>();
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field.length; c++) {
                if (field[r][c] == 0) {
                    moves.add(new Move(r, c));
                }
            }
        }
        Move[] a = new Move[moves.size()];
        return moves.toArray(a);
    }

    /**
     * Выполняет ход, описанный объектом move за игрока с идентификатором player.
     *
     * @param m содержит координаты хода.
     * @param player идентификатор игрока, совершающего ход.
     *
     * @return true - ход выполнен, false = неверный ход
     */
    public boolean doMove(Move m, int player){
        if (m.col >= field.length || m.row >= field.length || field[m.row][m.col] != 0) {
            return false;
        }
        if (getState() != State.NONE) {
            return false;
        }
        field[m.row][m.col] = player;
        reviewState();
        return true;
    }

    /**
     * Отменяет ход, описанный объектом move за игрока с идентификатором player.
     *
     * @param m
     *            содержит координаты хода.
     * @param player
     *            идентификатор игрока, чей ход отменяется.
     */
//    public void undoMove(Move m, int player) {
//        field[m.row][m.col] = 0;
//        winLine = null;
//        setState(State.NONE);
//    }

    /**
     * Проверяет поле на предмет окончания игры.
     *
     * @return true если игра закончена.
     */
    public boolean isGameOver() {
        return state != State.NONE;
    }

//    public int getWinner() {
//        return (state == State.WIN_X) ? PLAYER_X : (state == State.WIN_O) ? PLAYER_O : 0;
//    }

    /**
     * Возвращает список клеток, составляющих выигрышную комбинацию. Или null, если
     * комбинация еще не собрана.
     */
    public List<Cell> getWinLine() {
        if (winLine == null) {
            winLine = getWinLine(field);
        }
        return winLine;
    }

    private List<Cell> getWinLine(int[][] field) {
        /* Проверяются строки */
        List<Cell> res = scanRows(field);
        if ((res != null) && (res.size() >= winLength))
            return res;
        /* Проверяются столбцы */
        res = scanColumns(field);
        if ((res != null) && (res.size() >= winLength))
            return res;
        /* Проверяются диагонали */
        res = scanDiagonals(field);
        if ((res != null) && (res.size() >= winLength))
            return res;
        return null;
    }

    /**
     * Проверяет, не изменилось ли состояние игрового поля.
     */
    private void reviewState() {
        List<Cell> line = getWinLine();
        if (line != null) {
            int r = line.get(0).row;
            int c = line.get(0).col;
            if (field[r][c] == PLAYER_X) {
                setState(State.WIN_X);
            } else if (field[r][c] == PLAYER_O) {
                setState(State.WIN_O);
            } else {
                throw new Error("Incorrect win line.");
            }
        } else if (FieldScanner.isFullField(field)) {
            setState(State.DRAW);
        }
    }



    /**
     * Ищет выигрышную комбинацию в строках.
     */
    private List<Cell> scanRows(int[][] field) {
        for (int r = 0; r < field.length; r++) {
            List<Cell> line = FieldScanner.scanRow(field, winLength, r);
            if (line != null) {
                return line;
            }
        }
        return null;
    }

    /**
     * Ищет выигрышную комбинацию в столбцах.
     */
    private List<Cell> scanColumns(int[][] field) {
        for (int c = 0; c < field.length; c++) {
            List<Cell> line = FieldScanner.scanCol(field, winLength, c);
            if (line != null) {
                return line;
            }
        }
        return null;
    }

    /**
     * Ищет выигрышную комбинацию в диагоналях.
     */
    private List<Cell> scanDiagonals(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            /* слева направо, сверху вниз */
            List<Cell> line = FieldScanner.scanUpDiagonal(true, field, winLength, i);
            if (line != null)
                return line;
            /* слева направо, снизу вверх */
            line = FieldScanner.scanDownDiagonal(true, field, winLength, i);
            if (line != null)
                return line;
            /* справа налево, сверху вниз */
            line = FieldScanner.scanUpDiagonal(false, field, winLength, i);
            if (line != null)
                return line;
            /* справа налево, снизу вверх */
            line = FieldScanner.scanDownDiagonal(false, field, winLength, i);
            if (line != null)
                return line;
        }
        return null;
    }

}
