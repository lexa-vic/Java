package ru.kostikov.figures;

import org.junit.Test;
import ru.kostikov.board.Board;
import ru.kostikov.board.BoardExeption;
import ru.kostikov.board.Cell;
import ru.kostikov.players.Player;
import ru.kostikov.players.White;

import java.util.Optional;

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

        board.getCell("a1").ifPresent(x -> x.setFigure(new Bishop(player)));

        Optional<Cell> fcellFom = board.getCell("A1");
        Optional<Cell> cellTo = board.getCell("H8");

        moveResult = board.move(fcellFom.get(), cellTo.get());



        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void NoMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        board.getCell("A1").ifPresent(x -> x.setFigure(new Bishop(player)));
        board.getCell("B2").ifPresent(x -> x.setFigure(new Bishop(player)));

        Optional<Cell> fcellFom  = board.getCell("A1");
        Optional<Cell> cellTo  = board.getCell("B2");

        moveResult = board.move(fcellFom.get(), cellTo.get());

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void moveSequence() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = true;
        Board board   = new Board();
        Player player = new White();

        board.getCell("A1").ifPresent(x -> x.setFigure(new Bishop(player)));

        Optional<Cell>  fcellFom = board.getCell("A1");
        Optional<Cell>  cellTo = board.getCell("D4");

        moveResult = board.move(fcellFom.get(), cellTo.get());

        fcellFom = board.getCell("D4");
        cellTo = board.getCell("G1");

        moveResult = board.move(fcellFom.get(), cellTo.get());

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void badMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        board.getCell("A1").ifPresent(x -> x.setFigure(new Bishop(player)));

        Optional<Cell>   fcellFom = board.getCell("qq");
        Optional<Cell>   cellTo = board.getCell("qq");

        if (fcellFom.isPresent() && cellTo.isPresent()){
            moveResult = board.move(fcellFom.get(), cellTo.get());
        }

        assertThat(expectedResult, is(moveResult));
    }
}