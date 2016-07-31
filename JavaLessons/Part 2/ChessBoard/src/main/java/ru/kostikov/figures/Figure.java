package ru.kostikov.figures;

import ru.kostikov.board.*;
import ru.kostikov.players.Player;

/**
 * Created by Алексей on 26.07.2016.
 */
public abstract class Figure {

    protected Cell[][] board;
    private   Cell[]   moves = null;
    protected Cell     cell;
    protected Player   player;


    /**
     * Конструктор, принимаем игрока(белые или черные)
     * @param player
     */
    Figure(Player player){
        this.player = player;
    }

    /**
     * Установка, где находится фигура
     * @param cell
     */
    public void setCell(Cell cell){
        this.cell = cell;
    }

    /**
     * @param cellTo
     * @return
     */
    public boolean moveTo(Cell cellTo) {
        boolean result = false;

        if (cellTo != null) {
            // Просчитываем все возможные ходы
            this.moves = calcAllMoves();

            // Если для эта фгура не стоит на какй-то клетке
            if (this.cell == null) {
                // Устанавливаем туда куда ходим
                result = cellTo.setFigure(this);
                result = true;
            }
            // Если ячейки куда и откуда не равны, можно ходить
            else if (!this.cell.getName().equals(cellTo.getName())) {
                if (this.moves != null){
                    for(Cell move: this.moves){
                        if(move != null && move.getName() == cellTo.getName()){
                            Cell preCell = this.cell;

                            result = cellTo.setFigure(this);
                            if (result){
                                preCell.clearCell();
                            }
                            break;

                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Устанавливаем поле где находится фигура
     * @param board
     */
    public void setBoard(Cell[][] board){
        this.board = board;
    }

    /**
     * Расчет всех возможных ходов для фигуры в текущей ячейке
     * @return
     */
    abstract protected Cell[] calcAllMoves();

}
