package ru.kostikov.tictactoe;

import java.util.List;

import ru.kostikov.tictactoe.TicTacToeField.State;


/**
 * Интерфейс графического представления игры.
 * 
 * @author dok
 * 
 */
public interface TicTacToeView {

    /**
     * Обновляет представление в соответствии с новым игровым полем.
     * 
     * @param field
     *            новое игровое поле.
     */
    void updateWithField(TicTacToeField field);

    /**
     * Сообщает об окончании игры.
     * 
     * @param result
     *            результат окончания.
     * @param winLine
     *            список ячеек в выигрышной комбинации. null, если ничья.
     */
    void gameOver(State result, List<Cell> winLine);


    /**
     * Анимирование сделанного хода.
     * 
     * @param move
     *            описание хода.
     * @param player
     *            идентификатор игрока, выполнившего ход.
     */
    void animateMove(Move move, int player);
}
