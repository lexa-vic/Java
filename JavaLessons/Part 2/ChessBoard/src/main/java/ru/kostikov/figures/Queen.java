package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
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
     * Конструктор фигуры ферзя
     * @param player Передаем игрока белые/черные
     */
    public Queen(Player player){
        super(player);

        // Устанавливаем поведение ферьзя: ходит во все стороны на сколько хочет
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
    }

}
