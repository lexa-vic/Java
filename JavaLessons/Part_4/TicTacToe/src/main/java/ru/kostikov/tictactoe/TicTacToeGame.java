package ru.kostikov.tictactoe;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import ru.kostikov.zerosumgame.AlphaBetaSolver;
import ru.kostikov.zerosumgame.Solver;

public class TicTacToeGame {

    private Rules rules;

    private TicTacToeField field;

    private Solver solver;

    private TicTacToeView view;

    private final int size;

    private final int winLength;

    private final int maxDepth;

    private static final int PLAYER = TicTacToeField.PLAYER_X;

    private static final int AI = TicTacToeField.PLAYER_O;

    private static final Logger LOG = Logger.getLogger(TicTacToeGame.class);

    public TicTacToeGame(TicTacToeView view, int size, int winLength, int depth) {
        this.view = view;
        this.size = size;
        this.maxDepth = depth;
        this.winLength = winLength;
    }

    public void newGame() {
        LOG.info("New game. Field size = " + size + " Winlength = " + winLength
                + " Max depth = " + maxDepth);

        field = new TicTacToeField(size, winLength);
        rules = field;

        ExpertHeuristic heuristic = new ExpertHeuristic(PLAYER);
        solver = new AlphaBetaSolver(rules, PLAYER, field, heuristic, maxDepth);

        view.updateWithField(field);
    }

    public void movePlayer(Move m) {
        if (field.isGameOver()) {
            return;
        }
        LOG.info("Player move to " + m);
        field.doMove(m, PLAYER);
        view.animateMove(m, PLAYER);
    }

    public void moveAI() {
        if (field.isGameOver()) {
            return;
        }
        Move m = solver.getBestMove();
        LOG.info("AI move to " + m + "\n");
        field.doMove(m, AI);
        view.animateMove(m, AI);
    }

    public void checkGameState() {
        if (field.isGameOver()) {
            List<Cell> winLine = field.getWinLine();
            view.gameOver(field.getState(), winLine);
//            newGame();
        }
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame(new TicTacToeView() {
            @Override
            public void updateWithField(TicTacToeField field) {

            }

            @Override
            public void gameOver(TicTacToeField.State result, List<Cell> winLine) {
                System.out.println("Win");
                System.exit(1);
            }

            @Override
            public void animateMove(Move move, int player) {
                System.out.printf("Player %d x: %d y: %d\n",player, move.getRow(), move.getCol());
            }
        }, 3, 3, 3);

        game.newGame();
        BufferedReader inp =  new BufferedReader( new InputStreamReader(System.in));
        Scanner scanner = new Scanner(inp);

        while(true){

            try {

                int x = Integer.parseInt(inp.readLine());
                int y = Integer.parseInt(inp.readLine());
                Move m = new Move(x, y);

                game.movePlayer(m);
                game.moveAI();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
