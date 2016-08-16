package ru.kostikov.figures;

import org.junit.Test;
import ru.kostikov.board.Board;
import ru.kostikov.board.BoardExeption;
import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;
import ru.kostikov.players.White;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 02.08.2016.
 */
public class BishopTest {

    @Test
    public void moveTo() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = true;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Bishop(player));
        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        try{
            Cell fcellFom = board.getCell("A1");
            Cell cellTo = board.getCell("H8");

            moveResult = board.move(fcellFom, cellTo);

        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }



        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void NoMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Bishop(player));
        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        try{
            board.getCell("B2").setFigure(new Bishop(player));
        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        try{
            Cell fcellFom = board.getCell("A1");
            Cell cellTo = board.getCell("B2");

            moveResult = board.move(fcellFom, cellTo);

        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void moveSequence() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = true;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Bishop(player));
        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        try{
            Cell fcellFom = board.getCell("A1");
            Cell cellTo = board.getCell("D4");

            moveResult = board.move(fcellFom, cellTo);

        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        try{
            Cell fcellFom = board.getCell("D4");
            Cell cellTo = board.getCell("G1");

            moveResult = board.move(fcellFom, cellTo);

        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void badMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        try{
            board.getCell("A1").setFigure(new Bishop(player));
        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        try{
            Cell fcellFom = board.getCell("qq");
            Cell cellTo = board.getCell("qq");

            moveResult = board.move(fcellFom, cellTo);

        }catch (IllegalArgumentException iae){
            System.out.print("Не найдена ячейка с таким именем");
        }

        assertThat(expectedResult, is(moveResult));
    }
}