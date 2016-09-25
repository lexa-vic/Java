package ru.kostikov.tictactoe;

/**
 * Описание хода игрока, как номер строки и столбца на игровом поле.
 * 
 * @author dok
 * 
 */
public class Move {

    protected int row;
    protected int col;

    /**
     * @return номер строки ячейки поля, на которую совершается ход.
     */
    public int getRow() {
        return row;
    }

    /**
     * @return номер стобца ячейки поля, на которую совершается ход.
     */
    public int getCol() {
        return col;
    }

    /**
     * @param row
     *            номер строки ячейки поля, на которую совершается ход.
     * @param col
     *            номер столбца ячейки поля, на которую совершается ход.
     */
    public Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Move))
            return false;
        Move m = (Move) obj;
        return this.row == m.row && this.col == m.col;
    }
    
    @Override
    public int hashCode() {
        return Integer.parseInt("" +row + "" +col);
    }

    @Override
    public String toString() {
        return "row " + row + " col " + col;
    }

}
