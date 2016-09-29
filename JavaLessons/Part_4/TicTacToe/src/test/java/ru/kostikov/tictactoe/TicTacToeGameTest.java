package ru.kostikov.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Алексей on 29.09.2016.
 */
public class TicTacToeGameTest {
    @Test
    public void whenTwoHumanPlayerThenNewGameStart() throws Exception {
        TicTacToeView view = mock(TicTacToeView.class);
        TicTacToeGame game = new TicTacToeGame(view, 3, 3);
        Player x = mock(HumanPlayer.class);
        Player o = mock(HumanPlayer.class);

        when(x.getMove()).thenReturn(new Move(1,1));
        when(x.getMove()).thenReturn(new Move(0,0));
        when(x.getMove()).thenReturn(new Move(2,2));

        when(o.getMove()).thenReturn(new Move(0,1));
        when(o.getMove()).thenReturn(new Move(0,2));
        when(o.getMove()).thenReturn(new Move(2,1));

        game.newGame(x, o);

//        verify(view, atLeastOnce()).gameOver();
    }

}
