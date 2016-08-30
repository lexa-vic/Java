package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
 * This class implements a Pawn figure.
 * Created by Алексей on 26.07.2016.
 */
public class Queen extends Figure {

    private final int[] offsetSideX;
    private final int[] offsetSideY;
    private final int stepsCnt;

    {
        this.stepsCnt    = 8;
        this.offsetSideY = new int[]{1, 1, -1, -1, 0, 1, 0, -1};
        this.offsetSideX = new int[]{-1, 1, 1, -1, -1, 0, 1, 0};
    }
    /**
     * Constructor.
     * @param player Set player(balck/white)
     */
    public Queen(Player player){
        super(player);
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }

}
