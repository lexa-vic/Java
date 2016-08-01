package ru.kostikov.figures;

import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public class Bishop  extends Figure {

    private final int offsetSideX[] = new int[]{-1,  1,  1, -1};
    private final int offsetSideY[] = new int[]{ 1,  1, -1, -1};
    private final int stepsCnt      = 8;

    public Bishop(Player player){
        super(player);

        // Устанавливаем поведение слона: ходит только диагонали
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }

}
