package ru.kostikov.figures;

import ru.kostikov.board.*;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public abstract class Figure {

    protected Board board;
    protected Player player;

    Figure(Board board, Player player){
        this.board  = board;
        this.player = player;
    }

    abstract public boolean moveTo(int x, int y);

}
