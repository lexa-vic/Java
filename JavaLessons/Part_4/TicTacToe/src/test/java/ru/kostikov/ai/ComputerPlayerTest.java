package ru.kostikov.ai;

import org.junit.Assert;
import org.junit.Test;
import ru.kostikov.tictactoe.Move;
import ru.kostikov.tictactoe.Player;
import ru.kostikov.tictactoe.TicTacToeField;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 29.09.2016.
 */
public class ComputerPlayerTest {
    @Test
    public void whenOneStepToWinThenCopmuterWins() throws Exception {
        int[][] field = new int[][]{{1, 0, 0},
                                    {0, 1, 0},
                                    {0, 0, 0}, };
        TicTacToeField ticTacToeField = new TicTacToeField(field, 3);

        Player computerPlayer = new ComputerPlayer();
        computerPlayer.setField(ticTacToeField);
        computerPlayer.setPlayerType(ticTacToeField.PLAYER_X);

        Move expectedMove = new Move(2,2);

        Assert.assertThat(expectedMove, is(computerPlayer.getMove()));

    }

}