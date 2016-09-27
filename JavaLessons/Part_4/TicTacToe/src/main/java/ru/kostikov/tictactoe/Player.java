package ru.kostikov.tictactoe;

/**
 * Created by Алексей on 27.09.2016.
 */
public interface Player {

    void setField(Field field);

    Move getMove(Move[] availableMoves);
}
