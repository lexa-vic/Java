package ru.kostikov.figures;

import org.junit.Test;
import ru.kostikov.board.Board;
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

        board.setFigure(new Bishop(player), "A1");

        moveResult = board.move("A1", "H8");

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void NoMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        board.setFigure(new Bishop(player), "A1");
        board.setFigure(new Pawn(player), "B2");

        moveResult = board.move("A1", "B2");

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void moveSequence() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = true;
        Board board   = new Board();
        Player player = new White();

        board.setFigure(new Bishop(player), "A1");

        moveResult = board.move("A1", "D4");
        moveResult = board.move("D4", "G1");

        assertThat(expectedResult, is(moveResult));
    }
    @Test
    public void badMove() throws Exception {
        boolean moveResult     = false;
        boolean expectedResult = false;
        Board board   = new Board();
        Player player = new White();

        board.setFigure(new Pawn(player), "A1");

        moveResult = board.move("qq", "qq");

        assertThat(expectedResult, is(moveResult));
    }
}