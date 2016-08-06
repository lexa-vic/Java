package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public abstract class Figure {

    /** Тип фигуры белые\черные */
    private Player  player;

    /** Смещение по Х сторон в которые может ходить фигура*/
    private int[]   offsetSideX;

    /** Смещение по Y сторон в которые может ходить фигура*/
    private int[]   offsetSideY;

    /** Кол-во ячеек на которое может шагнуть фигура*/
    private int stepsCnt;


    /**
     * Конструктор, принимаем игрока(белые или черные)
     * @param player
     */
    Figure(Player player){
        this.player = player;
    }

    /**
     * Установка поведения фигуры
     * @param stepsCnt      кол-во клеток на которое может ходить фигура за ход
     * @param offsetSideX   Смещение по Х сторон в которые может ходить фигура
     * @param offsetSideY   Смещение по Y сторон в которые может ходить фигура
     */
    protected void setBehavior(int stepsCnt, int[] offsetSideX, int[] offsetSideY){
        this.stepsCnt    = stepsCnt;
        this.offsetSideX = offsetSideX;
        this.offsetSideY = offsetSideY;
    }

    /**
     * Кол-во шагов(ячеек) за один ход, которое может выполнить фигура
     * @return int stepsCnt
     */
    public int getSteps(){
        return this.stepsCnt;
    }

    /**
     * Смещение по Х сторон в которые может ходить фигура
     * @return int[]
     */
    public int[] getOffsetSideX(){
        return this.offsetSideX;
    }

    /**
     * Смещение по Y сторон в которые может ходить фигура
     * @return int[]
     */
    public int[] getOffsetSideY(){
        return this.offsetSideY;
    }


}
