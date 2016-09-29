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
        PlayerX.setField(field);
        PlayerO.setField(field);

        PlayerX.setPlayerType(TicTacToeField.PLAYER_X);
        PlayerO.setPlayerType(TicTacToeField.PLAYER_O);

        while (field.isGameOver()) {
            field.doMove(PlayerX.getMove(), TicTacToeField.PLAYER_X);
            field.doMove(PlayerO.getMove(), TicTacToeField.PLAYER_O);
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

//    public void movePlayer(Move m) {
//        if (field.isGameOver()) {
//            return;
//        }
//        LOG.info("Player move to " + m);
//        field.doMove(m, PLAYER);
//        view.animateMove(m, PLAYER);
//    }
//
//    public void moveAI() {
//        if (field.isGameOver()) {
//            return;
//        }
//        Move m = solver.getBestMove();
//        LOG.info("AI move to " + m + "\n");
//        field.doMove(m, AI);
//        view.animateMove(m, AI);
//    }
//
//    public void checkGameState() {
//        if (field.isGameOver()) {
//            List<Cell> winLine = field.getWinLine();
//            view.gameOver(field.getState(), winLine);
////            newGame();
//        }
//    }

//    public static void main(String[] args) {
//        TicTacToeGame game = new TicTacToeGame(new TicTacToeView() {
//            @Override
//            public void updateWithField(TicTacToeField field) {
//
//            }
//
//            @Override
//            public void gameOver(TicTacToeField.State result, List<Cell> winLine) {
//                System.out.println("Win");
//                System.exit(1);
//            }
//
//            @Override
//            public void animateMove(Move move, int player) {
//                System.out.printf("Player %d x: %d y: %d\n",player, move.getRow(), move.getCol());
//            }
//        }, 3, 3, 3);
//
//        game.newGame();
//        BufferedReader inp =  new BufferedReader( new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(inp);
//
//        while(true){
//
//            try {
//
//                int x = Integer.parseInt(inp.readLine());
//                int y = Integer.parseInt(inp.readLine());
//                Move m = new Move(x, y);
//
//                game.movePlayer(m);
//                game.moveAI();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


}
