package ru.kostikov.tictactoe;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 25.09.2016.
 */
public class TicTacToeFieldTest {
    @Test
    public void whenFieldEmptyThenGetMovesAllField() throws Exception {
        TicTacToeField field = new TicTacToeField(2, 1);
        Move[] expectedMoves = new Move[]{new Move(0,0), new Move(0,1), new Move(1,0), new Move(1,1)};
        Move[] resultMoves = null;

        resultMoves = field.getMoves();
        Assert.assertThat(expectedMoves, is(resultMoves));
    }

    @Test
    public void whenFieldNoMoreCellThenGetMovesNull() throws Exception {
        int[][] field = new int[][]{{1, 1 }, {1, 1}};
        TicTacToeField ticTacToeField = new TicTacToeField(field, 1);
        Move[] expectedMoves = new Move[0];
        Move[] resultMoves = null;

        resultMoves = ticTacToeField.getMoves();
        Assert.assertThat(expectedMoves, is(resultMoves));
    }

    @Test
    public void whenDoMoveThenFieldHavePlayerMove() throws Exception {
        TicTacToeField field = new TicTacToeField(2, 1);

        field.doMove(new Move(0,0), TicTacToeField.PLAYER_X);
        Assert.assertThat(field.field[0][0], is(TicTacToeField.PLAYER_X));
    }

    @Test
    public void whenPlayerWinThenGameOverTrue() throws Exception {
        int[][] field = new int[][]{{1, 0 }, {0, 1}};
        TicTacToeField ticTacToeField = new TicTacToeField(field, 2);

        Assert.assertThat(ticTacToeField.isGameOver(), is(true));
    }

    @Test
    public void whenPlayerNotWinThenGameOverFalse() throws Exception {
        int[][] field = new int[][]{{1, 0 }, {0, 0}};
        TicTacToeField ticTacToeField = new TicTacToeField(field, 2);

        Assert.assertThat(ticTacToeField.isGameOver(), is(false));
    }

    @Test
    public void whenPlayerWinThenGetRightWinLine() throws Exception {
        int[][] field = new int[][]{{1, 1 }, {0, 0}};
        TicTacToeField ticTacToeField = new TicTacToeField(field, 2);
        List<Cell> winLine = new ArrayList<>();
        winLine.add(new Cell(0,0));
        winLine.add(new Cell(0,1));

        Assert.assertThat(ticTacToeField.getWinLine(), is(winLine));
    }

}