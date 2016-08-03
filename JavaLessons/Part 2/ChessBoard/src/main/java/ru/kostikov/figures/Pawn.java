package ru.kostikov.figures;

import ru.kostikov.board.Board;
import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public class Pawn extends Figure {

    private final int offsetSideX[] = new int[]{ 0,  0};
    private final int offsetSideY[] = new int[]{ 1, -1};
    private int stepsCnt      = 1;
    private boolean firstMove = false;

    public Pawn( Player player){
        super(player);

        this.firstMove = false;
        // Устанавливаем поведение пешки: ходит вперед и наза на одну клетку, кроме первого хода
        super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );

    }

    @Override
    public boolean moveTo(Cell cellFrom, Cell cellTo){
        boolean result = false;

        if (super.moveTo(cellFrom, cellTo)){

            if (!this.firstMove){

                this.firstMove = true;
                this.stepsCnt  = 1;
                super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
            }
            result = true;
        }
        return result;
    }


    /**
     * Просчитывае возможные ходы пешки
     * Пешка ходит только по вертикали на одну клетку.
     * Искулючение первый ход - по вертикали на две клетки
     * @return Cell массив возможных ходов
     */
    @Override
    protected Cell[] calcAllMoves(Cell currentCell) {

        // Первый ход пешки может быть через одну клетку
        if (this.firstMove == false && currentCell.getY() == this.player.defaultPawnPosition) {
            this.stepsCnt  = 2;
            super.setBehavior(this.stepsCnt, this.offsetSideX, this.offsetSideY );
        }

        return super.calcAllMoves(currentCell);
    }

}
