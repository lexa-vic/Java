package ru.kostikov.tictactoe;

import java.util.List;


public class TicTacToeGame {

    private TicTacToeField field;

    private TicTacToeView view;

    public TicTacToeGame(TicTacToeView view, int size, int winLength) {
        this.view = view;

        field = new TicTacToeField(size, winLength);
        this.view = view;
        view.updateWithField(field);
    }

    public void newGame(Player PlayerX, Player PlayerO) {
        PlayerX.init(field);
        PlayerO.init(field);

        while (!field.isGameOver()) {
            while(!field.doMove(PlayerX.getMove(), TicTacToeField.PLAYER_X)){
                PlayerX.badMove();
            }
            view.animateMove(field, PlayerX);

            if (field.isGameOver()){
                break;
            }
            while(!field.doMove(PlayerO.getMove(), TicTacToeField.PLAYER_O)){
                PlayerO.badMove();
            }
            view.animateMove(field, PlayerO);

        }
        List<Cell> winLine = field.getWinLine();

        Player winner = null;
        if (field.getState() == TicTacToeField.State.WIN_X){
            winner = PlayerX;
        }else if (field.getState() == TicTacToeField.State.WIN_O){
            winner = PlayerO;
        }
        view.gameOver(winner, winLine);
    }
}
