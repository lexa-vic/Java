package ru.kostikov.tictactoe;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 30.09.2016.
 */
public class TicTacToeViewImp implements TicTacToeView {

//    private BufferedInputStream input;
    private PrintWriter output;
    private Scanner input;

    public TicTacToeViewImp(InputStream input, OutputStream output) {
        this.input = new Scanner(input);
        this.output = new PrintWriter(output, true);
    }

    @Override
    public void updateWithField(TicTacToeField field) {

    }

    @Override
    public void gameOver(Player winner, List<Cell> winLine) {

    }

    @Override
    public void animateMove(Move move, Player player) {

    }

    public void welcomePrint(){
        output.println("Вас приветствует игра крестики-нолики");
        output.flush();
    }

    public void startGame(int fieldSize, int winLength  ){




        TicTacToeGame game = new TicTacToeGame(this, 15, 5);
    }

    public int enterFieldSize(){
        int result = 0;
        while (result < 3){
            output.println("Введите размер поля (больше 3): ");
            if (input.hasNextInt()){
                result = input.nextInt();
            }else{
                input.next();
                output.println("Введите корректное число");
            }
        }
        return result;
    }

    public static void main(String[] args) {

        TicTacToeViewImp viewImp = new TicTacToeViewImp(System.in, System.out);

        viewImp.enterFieldSize();

    }

}
