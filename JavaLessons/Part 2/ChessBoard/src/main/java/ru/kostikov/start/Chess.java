package ru.kostikov.start;

import ru.kostikov.board.Board;
import ru.kostikov.board.BoardExeption;
import ru.kostikov.board.Cell;
import ru.kostikov.figures.*;
import ru.kostikov.players.*;

/**
 * Created by Алексей on 31.07.2016.
 */
public class Chess {

    public static void main(String[] args) {

        boolean moveResult = false;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("a1").setFigure(new Castle(player));
        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }


        try{
            Cell fcellFom = board.getCell("a1");
            Cell cellTo = board.getCell("a5");

            moveResult = board.move(fcellFom, cellTo);

        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }
    }

}
