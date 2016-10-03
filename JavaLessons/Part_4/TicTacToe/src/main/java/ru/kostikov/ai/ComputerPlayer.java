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

    @Override
    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public void setPlayerType(int figure) {
        player = figure;
    }


    @Override
    public Move getMove() {

        for (Move move: this.field.getMoves()){
            String [] lines = getLines(this.field.field, this.field.winLength, move);

            for (String line : lines ){
                if (line != null && line.equals("")){

                }
            }

        }
        return null;
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
                if(field[i][y] == 1){
                    line.append("x");
                } else if (field[i][y] == 0) {
                    line.append("0");
                }
            }
        }
        lines[0] = line.toString();

        line = new StringBuilder();
        // Собираем линию по горизонтали(-)
        for (int i = y - winLength; i <= y + winLength; i++){
            if (i >= 0 && i < field.length){
                if(field[x][i] == 1){
                    line.append("x");
                } else if (field[x][i] == 0) {
                    line.append("0");
                }
            }
        }
        lines[1] = line.toString();

        line = new StringBuilder();
        int diag_y = y - winLength;
        // Собираем линию по диагонали(/)
        for (int i = x - winLength; i < x + winLength; i++){
            diag_y +=1;
            if (i >= 0 && i < field.length &&
                    diag_y >= 0 && diag_y < field.length ){
                if(field[i][diag_y] == 1){
                    line.append("x");
                } else if (field[i][diag_y] == 0) {
                    line.append("0");
                }
            }
        }
        lines[2] = line.toString();
        line = new StringBuilder();

        diag_y = y + winLength;
        // Собираем линию по диагонали(/)
        for (int i = x - winLength; i <= x + winLength; i++){
            diag_y -=1;
            if (i >= 0 && i < field.length &&
                    diag_y >= 0 && diag_y < field.length ){
                if(field[i][diag_y] == 1){
                    line.append("x");
                } else if (field[i][diag_y] == 0) {
                    line.append("0");
                }
            }
        }
        lines[3] = line.toString();

        return lines;
    }
}
