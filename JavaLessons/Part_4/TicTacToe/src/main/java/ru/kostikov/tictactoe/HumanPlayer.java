package ru.kostikov.tictactoe;

/**
 * Created by Алексей on 29.09.2016.
 */
public class HumanPlayer implements Player{
    Move currentMove;

    @Override
    public void setField(Field field) {

    }

    @Override
    public void setPlayerType(int figure) {

    }

    @Override
    public Move getMove() {
        return null;
    }

    public void setMove(Move move){
        this.currentMove = move;
    }
}
