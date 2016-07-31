package ru.kostikov.board;

import org.junit.Test;
import ru.kostikov.figures.Pawn;
import ru.kostikov.players.Player;
import ru.kostikov.players.White;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 31.07.2016.
 */
public class BoardTest {
    @Test
    public void setFigure() throws Exception {
        Board board    = new Board();
        Player player  = new White();
        boolean result = false;
        boolean expect = true;

        result = board.setFigure(new Pawn(player), "A1");

        assertThat(expect, is(result));
    }
}