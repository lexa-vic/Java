package ru.kostikov.figures;

import ru.kostikov.board.Board;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public class Pawn extends Figure {

    Pawn(Board board, Player player){
        super(board, player);
    }
    public boolean moveTo(int x, int y){

        return true;
    }
}
