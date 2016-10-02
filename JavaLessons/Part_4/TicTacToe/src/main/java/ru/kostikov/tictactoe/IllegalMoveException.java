package ru.kostikov.tictactoe;

/**
 * Генерируется при попытке совершить недопустимый ход.
 */
public class IllegalMoveException extends Exception {

    /**
     * @return номер строки некорректного хода.
     */
    public int getRow() {
        return row;
    }

    /**
     * @return номер столбца некорректного хода.
     */
    public int getCol() {
        return col;
    }

    /**
     * @return идентификатор игрока, совершившего недопустимый ход.
     */
    public int getPlayerId() {
        return playerId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String getMessage() {
        return message + "Row: " + row + " Col: " + col + " Player id: " + playerId;
    }

    public IllegalMoveException(int row, int col, int playerId) {
        this.row = row;
        this.col = col;
        this.playerId = playerId;
    }

    public IllegalMoveException(String message, int row, int col, int playerId) {
        this(row, col, playerId);
        this.message = message;
    }

    private int row;
    private int col;
    private int playerId;
    private String message = "";
    private static final long serialVersionUID = -1314091062341628124L;
}
