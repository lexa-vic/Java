package ru.kostikov.tictactoe;

import ru.kostikov.tictactoe.Move;

/**
 * Правил раскрытия вершины игрового дерева.
 * 
 * @author dok
 * 
 */
public interface Rules {
    /**
     * Возвращает массив допустимых ходов.
     * 
     * @param player
     *            идентификатор игрока, для которого возращаются допустимые ходы.
     * @return массив допустимых ходов.
     */
    Move[] getMoves(int player);
}
