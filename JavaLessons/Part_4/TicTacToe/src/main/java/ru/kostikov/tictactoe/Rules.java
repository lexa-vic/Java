package ru.kostikov.tictactoe;

import ru.kostikov.tictactoe.Move;

/**
 * Интерфейс выдачи возможных ходов
 * 
 * @author dok
 * 
 */
public interface Rules {
    /**
     * Возвращает массив допустимых ходов.
     * 
     * @return массив допустимых ходов.
     */
    Move[] getMoves();
}
