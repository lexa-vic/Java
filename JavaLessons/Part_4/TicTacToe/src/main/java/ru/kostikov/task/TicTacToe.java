package ru.kostikov.task;

/**
 * Дополнительное задание по задаче крестики-нолики
 * Реализовать проверку победы через рекурсию
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class TicTacToe {

    private final int[][] values;
    private final int PLAYER_X = 1;
    private final int WIN_LENGTH = 3;


    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        boolean result = false;

        for (int i = 0; i < this.values.length; i++){
            for (int j = 0; j < this.values.length; j++){
                if (this.values[i][j] == PLAYER_X){
                    if (findWinSequence(i,j, i, j, 1,  PLAYER_X)){
                        return true;
                    }
                }
            }
        }

        return result;
    }


    private boolean findWinSequence(int PrevRow, int PrevCol, int row, int col, int currentLength, int player){
        boolean result = false;

        if (currentLength == 1){
            for (int i = row-1; i <= row+1; i++){
                for (int j = col-1; j <= col+1; j++){
                    if (i < 0 || i >= this.values.length){continue;}
                    if (j < 0 || j >= this.values.length){continue;}
                    if (i == row && j == col){continue;}

                    if (this.values[i][j] == player){
                        int winLength = currentLength+1;
                        result = findWinSequence(PrevRow,PrevCol, i, j, winLength, player);
                        if (result){ break;}
                    }
                }
            }
        } else {
            int a = row - PrevRow;
            int b = col - PrevCol;
            int newRow = row+a;
            int newCol = col+b;
            if (newRow >= 0 && newRow < this.values.length &&
                    newCol >= 0 && newCol < this.values.length){
                if (this.values[newRow][newCol] == player){
                    if (++currentLength != WIN_LENGTH){
                        result = findWinSequence(row, col, newRow, newCol, currentLength, player);
                    } else {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
