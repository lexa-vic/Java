package ru.kostikov.ai;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.Move;
import ru.kostikov.tictactoe.Player;

/**
 * Created by Алексей on 27.09.2016.
 */
public class DummyComputerPlayer implements Player {

    @Override
    public void setField(Field field) {

    }

    @Override
    public Move getMove(Move[] availableMoves) {
        return null;
    }
}
