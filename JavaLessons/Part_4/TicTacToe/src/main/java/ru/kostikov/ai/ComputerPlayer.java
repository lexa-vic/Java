package ru.kostikov.ai;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.Move;
import ru.kostikov.tictactoe.Player;

/**
 * Created by Алексей on 27.09.2016.
 */
public class ComputerPlayer implements Player {
    /** Игровое поле */
    private Field field;
    /** За кого играет фигура Х или О*/
    private int player;

    @Override
    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public void setPlayerType(int figure) {
        player = figure;
    }


    @Override
    public Move getMove() {

        this.field.getMoves();
        return null;
    }

    /**
     * Имя игрока
     *
     * @return
     */
    @Override
    public String getName() {
        return "Computer";
    }

    /**
     * Callback ошибки хода
     */
    @Override
    public void badMove() {

    }
}
