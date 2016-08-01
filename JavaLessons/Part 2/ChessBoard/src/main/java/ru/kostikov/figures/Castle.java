package ru.kostikov.figures;

import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public class Castle extends Figure{

    private final int offsetSideX[] = new int[]{-1,  0,  1,  0};
    private final int offsetSideY[] = new int[]{ 0,  1,  0, -1};
    private final int stepsCnt      = 8;

    public Castle(Player player){
        super(player);

        // Устанавливаем поведение ладьи: ходит только по вертикали и горизонтали
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }

}
