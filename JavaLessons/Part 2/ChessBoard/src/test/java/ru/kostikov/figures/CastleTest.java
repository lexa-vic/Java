package ru.kostikov.figures;

import org.junit.Test;
import ru.kostikov.board.Board;
import ru.kostikov.board.BoardExeption;
import ru.kostikov.players.Player;
import ru.kostikov.players.White;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 02.08.2016.
 */
public class CastleTest {
    @Test
    public void moveTo() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = true;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Castle(player));
        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        moveResult = board.move("A1", "A8");

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void NoMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Castle(player));
        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        try{
            board.getCell("B1").setFigure(new Castle(player));
        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        moveResult = board.move("A1", "H1");

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void moveSequence() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = true;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Castle(player));
        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        moveResult = board.move("A1", "A8");
        moveResult = board.move("A8", "H8");

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void badMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Castle(player));
        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        moveResult = board.move("qq", "qq");

        assertThat(expectedResult, is(moveResult));
    }
}