package ru.kostikov.figures;

import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public class King extends Figure {

    private final int offsetSideX[] = new int[]{-1,  1,  1, -1, -1,  0,  1,  0};
    private final int offsetSideY[] = new int[]{ 1,  1, -1, -1,  0,  1,  0, -1};
    private final int stepsCnt      = 1;


    public King(Player player){
        super(player);

        // Устанавливаем поведение короля: ходит во все стороны на одну клетку
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }

}
