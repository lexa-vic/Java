package ru.kostikov.zerosumgame;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.Move;

/**
 * Эвристическая оценка состояния игрового поля.
 */
public interface Heuristic{
    /**
     * Возвращает оценку состояния игрового поля.
     * 
     * @param field
     *            состояние игрового поля, порожденное ходом игрока player.
     * @param player
     *            идентификатор игрока для которого происходит оценка.
     * @param move
     *            ход, который привел к оцениваемому состоянию.
     * @return оценка состояния игрового поля.
     */
    int score(Field field, int player, Move move);
}
