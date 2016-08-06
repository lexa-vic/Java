package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
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
     * Конструктор фигуры ладьи
     * @param player Передаем игрока белые/черные
     */
    public Castle(Player player){
        super(player);

        // Устанавливаем поведение ладьи: ходит только по вертикали и горизонтали
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }

}
