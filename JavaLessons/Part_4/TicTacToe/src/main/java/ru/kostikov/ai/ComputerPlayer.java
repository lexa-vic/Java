package ru.kostikov.ai;

import ru.kostikov.tictactoe.Field;
import ru.kostikov.tictactoe.Move;
import ru.kostikov.tictactoe.Player;

/**
 * Created by Алексей on 27.09.2016.
 */
public class ComputerPlayer implements Player {
    /** Игровое поле */
    private Field field;
    /** За кого играет фигура Х или О*/
    private int player;
    /** Паттерны игры */
    private GamePattern gamePatternX;
    private GamePattern gamePatternO;


    @Override
    public void setField(Field field) {
        this.field = field;
        this.createPatterns();
    }

    private void createPatterns(){
        this.gamePatternX = new GamePatternImp(field.winLength, field.PLAYER_X);
        this.gamePatternO = new GamePatternImp(field.winLength, field.PLAYER_O);
    }

    @Override
    public void setPlayerType(int figure) {
        player = figure;
    }

    @Override
    public Move getMove() {
        int score = 0;
        Move bestMove = null;
        for (Move move: this.field.getMoves()){
            String [] lines = getLines(this.field.field, this.field.winLength, move);

            for (String line : lines ){
                if (line != null && !line.equals("")){
                    int lineScore = 0;
                    lineScore += this.gamePatternX.getLineScore(line);
                    lineScore += this.gamePatternO.getLineScore(line);

                    if (lineScore > score){
                        bestMove = move;
                    }
                }
            }
        }
        return bestMove;
    }

    /**
     * Имя игрока
     *
     * @return
     */
    @Override
    public String getName() {
        return "Computer";
    }

    /**
     * Callback ошибки хода
     */
    @Override
    public void badMove() {

    }

    private String[] getLines(int[][] field, int winLength, Move move){
        String[] lines = new String[4];
        StringBuilder line = new StringBuilder();
        int x = move.getRow();
        int y = move.getCol();

        // Собираем линию по вертикали (|)
        for (int i = x - winLength; i <= x + winLength; i++){
            if (i >= 0 && i < field.length){
                line.append(String.valueOf(field[i][y]));
            }
        }
        lines[0] = line.toString();

        line = new StringBuilder();
        // Собираем линию по горизонтали(-)
        for (int i = y - winLength; i <= y + winLength; i++){
            if (i >= 0 && i < field.length){
                line.append(String.valueOf(field[x][i]));
            }
        }
        lines[1] = line.toString();

        line = new StringBuilder();
        int diag_y = y - winLength;
        // Собираем линию по диагонали(/)
        for (int i = x - winLength; i < x + winLength; i++){
            if (i >= 0 && i < field.length &&
                    diag_y >= 0 && diag_y < field.length ){
                line.append(String.valueOf(field[i][diag_y]));
            }
            diag_y +=1;
        }
        lines[2] = line.toString();
        line = new StringBuilder();

        diag_y = y + winLength;
        // Собираем линию по диагонали(/)
        for (int i = x - winLength; i <= x + winLength; i++){

            if (i >= 0 && i < field.length &&
                    diag_y >= 0 && diag_y < field.length ){
                line.append(String.valueOf(field[i][diag_y]));
            }
            diag_y -=1;
        }
        lines[3] = line.toString();

        return lines;
    }
}
