package ru.kostikov.tictactoe;

import java.util.List;

public abstract class Field {

    public int winLength;

    public int[][] field;

    public List<Cell> winLine;

    /**
     * Выполняет ход, описанный объектом move за игрока с идентификатором player.
     * 
     * @param move
     *            содержит координаты хода. 
     * @param player
     *            идентификатор игрока, совершающего ход.
     * @throws IllegalMoveException  
     */
    public abstract void doMove(Move move, int player) throws IllegalMoveException;

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