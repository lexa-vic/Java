package ru.kostikov.figures;

import ru.kostikov.players.Player;

/**
 * This interface discrabes chess figure with its parameters 
 * and behavior on board - how can it makes move.
 * Created by Алексей on 26.07.2016.
 */
public abstract class Figure {

    /** Figure's type.  */
    private Player  player;

    /** Possible X offset for moevement figures.*/
    private int[]   offsetSideX;

    /** Possible Y offset for moevement figures.*/
    private int[]   offsetSideY;

    /** Max Cell quantity for moevement figures.*/
    private int stepsCnt;

    /**
     * Constructor.
     * Set a player(black or white)
     * @param player
     */
    Figure(Player player){
        this.player = player;
    }

    /**
     * Set figure behavior.
     * @param stepsCnt      Max Cell quantity for moevement figures.
     * @param offsetSideX   Possible X offset for moevement figures.
     * @param offsetSideY   Possible Y offset for moevement figures.
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
