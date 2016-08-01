package ru.kostikov.figures;

import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public class Knight extends Figure{

    private final int offsetSideX[] = new int[]{-1, -1,  1, 1, 2,  2, -2, -2};
    private final int offsetSideY[] = new int[]{-2,  2, -2, 2, 1, -1,  1, -1};
    private final int stepsCnt      = 1;

    public Knight(Player player){
        super(player);

        // Устанавливаем поведение коня: ходит буквой Г
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }
}
