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

        //board.setFigure(new Pawn(player), "A1");
        //board.setFigure(new Pawn(player), "A3");

        try{
            board.getCell("a1").setFigure(new Castle(player));//setFigure(new Castle(player), "a1");
        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        //board.setFigure(new Castle(player), "A1");
        try{
            Cell fcellFom = board.getCell("a1");
            Cell cellTo = board.getCell("a5");

            moveResult = board.move(fcellFom, cellTo);

        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        //moveResult = board.move("A1", "A2");
        //moveResult = board.move("A2", "A3");

    }

}
