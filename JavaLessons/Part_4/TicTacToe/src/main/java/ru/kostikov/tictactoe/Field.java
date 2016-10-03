package ru.kostikov.tictactoe;

import java.util.List;

public abstract class Field {

    public int winLength;

    public int[][] field;

    public List<Cell> winLine;

    /** Идентификатор игрока Крестики */
    public static final int PLAYER_X = 1;

    /** Идентификатор игрока Нолики */
    public static final int PLAYER_O = -1;


    /**
     * Выполняет ход, описанный объектом move за игрока с идентификатором player.
     *
     * @param move содержит координаты хода.
     * @param player идентификатор игрока, совершающего ход.
     *
     * @return true - ход выполнен, false = неверный ход
     */
    public abstract boolean doMove(Move move, int player);

    /**
     * Проверяет поле на предмет окончания игры.
     * 
     * @return true если игра закончена.
     */
    public abstract boolean isGameOver();

    /**
     * Возвращает массив допустимых ходов.
     *
     * @return массив допустимых ходов.
     */
    public abstract Move[] getMoves();
}