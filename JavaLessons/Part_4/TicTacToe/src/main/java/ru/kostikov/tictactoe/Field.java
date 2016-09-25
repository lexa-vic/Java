package ru.kostikov.tictactoe;

import java.util.List;

public abstract class Field {

    protected int winLength;

    protected int[][] field;

    protected List<Cell> winLine;

    /**
     * Возвращает значение ячейки игрового поля.
     * @param row
     *            номер строки.
     * @param col
     *            номер столбца.
     * @return значение ячейки игрового поля.
     */
    public abstract int get(int row, int col);

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
     * Отменяет ход, описанный объектом move за игрока с идентификатором player.
     * 
     * @param move
     *            содержит координаты хода.
     * @param player
     *            идентификатор игрока, чей ход отменяется.
     */
    public abstract void undoMove(Move move, int player);

    /**
     * Проверяет поле на предмет окончания игры.
     * 
     * @return true если игра закончена.
     */
    public abstract boolean isGameOver();
}