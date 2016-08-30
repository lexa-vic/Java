package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
 * This class implements a Knight figure.
 * Created by Алексей on 26.07.2016.
 */
public class Knight extends Figure{

    private final int[] offsetSideX;
    private final int[] offsetSideY;
    private final int stepsCnt;

    {
        this.stepsCnt    = 1;
        this.offsetSideX = new int[]{-1, -1, 1, 1, 2, 2, -2, -2};
        this.offsetSideY = new int[]{-2, 2, -2, 2, 1, -1, 1, -1};
    }

    /**
     * Constructor.
     * @param player Set player(balck/white)
     */
    public Knight(Player player){
        super(player);
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }
}
