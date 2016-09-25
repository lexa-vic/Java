package ru.kostikov.tictactoe;

/**
 * Координаты ячейки игрового поля.
 * 
 * @author dok
 * 
 */
public class Cell {
    /** Строка игрового поля начиная с 0. */
    public int row;
    /** Столбец игрового поля начиная с 0. */
    public int col;

    /**
     * Создает описание координат ячейки игрового поля.
     * 
     * @param row
     *            строка игрового поля начиная с 0.
     * @param col
     *            столбец игрового поля начиная с 0.
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}