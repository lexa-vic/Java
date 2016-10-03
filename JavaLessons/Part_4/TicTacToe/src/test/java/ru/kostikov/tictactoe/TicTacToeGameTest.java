package ru.kostikov.tictactoe;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;
import ru.kostikov.ai.ComputerPlayer;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Алексей on 29.09.2016.
 */
public class TicTacToeGameTest {
    String resultStr;
    TicTacToeView view = new TicTacToeView() {
        @Override
        public void updateWithField(TicTacToeField field) {
        }

        @Override
        public void gameOver(Player winner, List<Cell> winLine) {
            if (winLine != null){
                resultStr = winner.getName();
            } else {
                resultStr = "Draw";
            }
        }

        @Override
        public void animateMove(TicTacToeField field, Player player) {

        }
    };
    @Test
    public void whenTwoHumanPlayerThenWinPlayer1() throws Exception {
        TicTacToeGame game = new TicTacToeGame(view, 3, 3);
        PlayerInput playerInput1 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(1,1),
                    new Move(0,0),
                    new Move(2,2)
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };
        PlayerInput playerInput2 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(0,1),
                    new Move(0,2),
                    new Move(2,1),
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };

        PlayerOutput playerOutput = new PlayerOutput() {
            @Override
            public void outputMove() {

            }
        };

        Player x = new HumanPlayer("Player 1", playerInput1, playerOutput);
        Player o = new HumanPlayer("Player 2", playerInput2, playerOutput);

        game.newGame(x, o);

        Assert.assertThat(resultStr ,is("Player 1"));

    }
    @Test
    public void whenTwoHumanPlayerThenWinPlayer2() throws Exception {
        TicTacToeGame game = new TicTacToeGame(view, 3, 3);
        PlayerInput playerInput1 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(1,1),
                    new Move(0,0),
                    new Move(2,2)
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };
        PlayerInput playerInput2 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(0,1),
                    new Move(0,2),
                    new Move(2,1),
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };

        PlayerOutput playerOutput = new PlayerOutput() {
            @Override
            public void outputMove() {

            }
        };

        Player x = new HumanPlayer("Player 1", playerInput2, playerOutput);
        Player o = new HumanPlayer("Player 2", playerInput1, playerOutput);

        game.newGame(x, o);

        Assert.assertThat(resultStr ,is("Player 2"));

    }

    @Test
    public void whenTwoHumanPlayerThenDraw() throws Exception {
        TicTacToeGame game = new TicTacToeGame(view, 3, 3);
        PlayerInput playerInput1 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(1,1),
                    new Move(2,2),
                    new Move(1,0),
                    new Move(0,1),
                    new Move(0,2),
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };
        PlayerInput playerInput2 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(2,0),
                    new Move(0,0),
                    new Move(1,2),
                    new Move(2,1),
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };

        PlayerOutput playerOutput = new PlayerOutput() {
            @Override
            public void outputMove() {

            }
        };

        Player x = new HumanPlayer("Player 1", playerInput1, playerOutput);
        Player o = new HumanPlayer("Player 2", playerInput2, playerOutput);

        game.newGame(x, o);

        Assert.assertThat(resultStr ,is("Draw"));
    }

    @Test
    public void whenHumanPlayerWithComputerOThenDraw() throws Exception {
        TicTacToeGame game = new TicTacToeGame(view, 3, 3);
        PlayerInput playerInput1 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(1,1),
                    new Move(2,0),
                    new Move(0,1),
                    new Move(1,2),
                    new Move(2,2),
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };

        PlayerOutput playerOutput = new PlayerOutput() {
            @Override
            public void outputMove() {

            }
        };

        Player x = new HumanPlayer("Player 1", playerInput1, playerOutput);
        Player o = new ComputerPlayer();

        game.newGame(x, o);

        Assert.assertThat(resultStr ,is("Draw"));
    }

    @Test
    public void whenHumanPlayerWithComputerXThenDraw() throws Exception {
        TicTacToeGame game = new TicTacToeGame(view, 3, 3);
        PlayerInput playerInput1 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(0,0),
                    new Move(0,2),
                    new Move(2,1),
                    new Move(1,0),
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };

        PlayerOutput playerOutput = new PlayerOutput() {
            @Override
            public void outputMove() {

            }
        };

        Player o = new HumanPlayer("Player 1", playerInput1, playerOutput);
        Player x = new ComputerPlayer();

        game.newGame(x, o);

        Assert.assertThat(resultStr ,is("Draw"));
    }

    @Test
    public void whenHumanPlayerWithComputerXThenComputerWins() throws Exception {
        TicTacToeGame game = new TicTacToeGame(view, 3, 3);
        PlayerInput playerInput1 = new PlayerInput() {
            private int step = 0;
            Move[] moves = new Move[]{
                    new Move(0,0),
                    new Move(1,0),
            };
            @Override
            public Move inputMove(Player player) {
                return moves[step++];
            }
        };

        PlayerOutput playerOutput = new PlayerOutput() {
            @Override
            public void outputMove() {

            }
        };

        Player o = new HumanPlayer("Player 1", playerInput1, playerOutput);
        Player x = new ComputerPlayer();

        game.newGame(x, o);

        Assert.assertThat(resultStr ,is("Computer"));
    }

}
