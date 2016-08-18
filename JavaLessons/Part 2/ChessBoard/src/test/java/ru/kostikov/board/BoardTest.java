package ru.kostikov.board;

import org.junit.Test;
import ru.kostikov.figures.Figure;
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
        Board board   = new Board();
        Player player = new White();
        Figure figure = new Pawn(player);

        board.getCell("a1").ifPresent(x -> x.setFigure(figure));

        assertThat(board.getCell("a1").get().getFigure(), is(figure));
    }
}