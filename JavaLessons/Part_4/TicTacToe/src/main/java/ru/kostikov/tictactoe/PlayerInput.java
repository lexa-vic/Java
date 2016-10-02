package ru.kostikov.tictactoe;

/**
 * Created by Алексей on 02.10.2016.
 */
public interface PlayerInput {

    /**
     * Ввод координат хода игрока
     * @return Move ход
     */
    Move inputMove(Player player);
}
