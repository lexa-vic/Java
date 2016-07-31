package ru.kostikov.figures;

import ru.kostikov.board.Board;
import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public class Pawn extends Figure {


    private boolean firstMove = false;

    public Pawn( Player player){
        super(player);
        this.firstMove = false;
    }

    @Override
    public boolean moveTo(Cell cellTo){
        boolean result = false;
        if (super.moveTo(cellTo)){
            this.firstMove = true;
            result         = true;
        }

        return result;
    }


    /**
     * Просчитывае возможные ходы пешки
     * Пешка ходит только по вертикали на одну клетку.
     * Искулючение первый ход - по вертикали на две клетки
     * @return Cell массив возможных ходов
     */
    protected Cell[] calcAllMoves(){
        Cell[] allmoves = new Cell[3];
        int moveCnt     = 0;
        int offset = 1;

        // Первый ход пешки может быть через одну клетку
        if (this.firstMove == false && this.cell.getY() == this.player.defaultPawnPosition ){
            offset = 2;
        }
        // Ищем ход
        for (int i = -1; i <= offset; i++){
            if ((this.cell.getY()+i) > 0 &&
                (this.cell.getY()+i) < this.board[this.cell.getX()].length){

                Cell movingCell = this.board[this.cell.getX()][this.cell.getY()+i];
                // Если там фигур нет, то можно ходить - добовляем в массив возможных ходов
                if (movingCell.getFigure() == null){
                    allmoves[moveCnt++] = movingCell;
                }
            }

        }

        return allmoves;
    }
}
