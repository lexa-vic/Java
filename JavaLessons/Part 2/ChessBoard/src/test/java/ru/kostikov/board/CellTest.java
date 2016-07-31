package ru.kostikov.board;

import org.junit.Test;
import ru.kostikov.figures.Figure;
import ru.kostikov.figures.Pawn;
import ru.kostikov.players.Player;
import ru.kostikov.players.White;

import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;
/**
 * Created by Алексей on 31.07.2016.
 */
public class CellTest {
    @Test
    public void setFigure() throws Exception {
        Cell   cell = new Cell("A1", 0, 0);
        Figure pawn = new Pawn(new White());

        cell.setFigure(pawn);

        assertThat(pawn, is(cell.getFigure()));
    }



    @Test
    public void setFigureBool() throws Exception {
        boolean result = false;
        boolean expect = true;
        Cell   cell = new Cell("A1", 0, 0);
        Figure pawn = new Pawn(new White());

        result = cell.setFigure(pawn);

        assertThat(expect, is(result));
    }

    @Test
    public void setFigureFail() throws Exception {
        boolean result = false;
        boolean expect = false;
        Cell   cell  = new Cell("A1", 0, 0);
        Figure pawn  = new Pawn(new White());
        Figure pawn2 = new Pawn(new White());

        result = cell.setFigure(pawn);
        result = cell.setFigure(pawn2);

        assertThat(expect, is(result));
    }

}