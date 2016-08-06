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

        try{
            result = board.getCell("A1").setFigure(new Pawn(player));
        }catch (BoardExeption be){
            System.out.print("Не найдена ячейка с таким именем");
        }

        assertThat(expect, is(result));
    }
}