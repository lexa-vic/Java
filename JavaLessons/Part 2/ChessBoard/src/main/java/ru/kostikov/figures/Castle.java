package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
 * This class implements a Castle figure.
 * Created by Алексей on 26.07.2016.
 */
public class Castle extends Figure{

    private final int[] offsetSideX;
    private final int[] offsetSideY;
    private final int stepsCnt;

    {
        this.offsetSideX = new int[]{-1, 0, 1, 0};
        this.offsetSideY = new int[]{0, 1, 0, -1};
        this.stepsCnt    = 8;
    }

    /**
     * Constructor.
     * @param player Set player(balck/white)
     */
    public Castle(Player player){
        super(player);
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }

}
