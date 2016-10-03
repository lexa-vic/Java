package ru.kostikov.tictactoe;

/**
 * Created by Алексей on 27.09.2016.
 */
public interface Player {

    /**
     * Имя игрока
     * @return
     */
    String getName();
    /**
     * Установка поля на котором играем игрок
     * @param field
     */
    void init(Field field);

    /**
     * Запрос хода у игрока
     * @return
     */
    Move getMove();

    /**
     *  Callback ошибки хода
     */
    void badMove();
}
