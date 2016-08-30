package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
 * This class implements a Pawn figure.
 * Created by Алексей on 26.07.2016.
 */
public class Pawn extends Figure {

    private final int[] offsetSideX;
    private final int[] offsetSideY;
    private final int stepsCnt;

    {
        this.stepsCnt = 1;
        this.offsetSideY = new int[]{1, -1};
        this.offsetSideX = new int[]{0, 0};
    }
    /**
     * Constructor.
     * @param player Set player(balck/white)
     */
    public Pawn( Player player){
        super(player);

        // Устанавливаем поведение пешки: ходит вперед и наза на одну клетку
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );

    }

}
