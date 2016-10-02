package ru.kostikov.tictactoe;

import ru.kostikov.ai.ComputerPlayer;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 30.09.2016.
 */
public class TicTacToeViewImp implements TicTacToeView, PlayerInput, PlayerOutput {
    private final int MIN_SIZE = 3;
    private final int MIN_WIN_LENGHT = 3;

    private PrintWriter output;
    private Scanner input;

    private Player player1 = new HumanPlayer("Man1",this, this);
    private Player player2 = new HumanPlayer("Man2",this, this);
    private String player1Figure = "";
//    private Player computerPlayer = new ComputerPlayer();

    /**
     * Коснтруктор, передаем входной и выходной потоки
     * @param input
     * @param output
     */
    public TicTacToeViewImp(InputStream input, OutputStream output) {
        this.input = new Scanner(input);
        this.output = new PrintWriter(output, true);
    }

    /**
     * Callback при запуске игры
     * @param field
     */
    @Override
    public void updateWithField(TicTacToeField field) {
        printField(field.field);
    }

    /**
     * Callback при завершении игры
     * @param winner  Возвращает победителя, если ничья - NULL
     * @param winLine Собранныя выйгрышная последовательность
     */
    @Override
    public void gameOver(Player winner, List<Cell> winLine) {
        if (winner == null){
            output.println("Ничья");
        } else if (winner.equals(player1)){
            output.printf("Победитель %s\n", player1.getName());
        } else if (winner.equals(player2)){
            output.printf("Победитель %s\n", player2.getName());
        }
    }

    /**
     * Анимация хода
     * @param field  поле
     * @param player Игрок сделавший ход
     */
    @Override
    public void animateMove(TicTacToeField field, Player player) {
        printField(field.field);
    }

    private void printField(int[][] field){
        output.printf(" \t");
        for (int c = 0; c < field.length; c++){
            output.printf("%d\t", c);
        }
        output.printf("\n");
        for(int i = 0; i < field.length; i++){
            output.printf("%d\t", i);
            for (int j = 0; j < field.length; j++){
                if (field[i][j] == 0){
                    output.printf(".\t");
                } else if (field[i][j] == 1){
                    output.printf("X\t");
                } else if (field[i][j] == -1){
                    output.printf("O\t");
                }
            }
            output.printf("\n");
        }
    }

    /**
     * Ввод хода игрока
     * @return Move ход фигуры на доске
     */
    @Override
    public Move inputMove(Player player) {
        boolean result = false;
        int x = 0;
        int y = 0;

        output.printf("Ход игрока %s\n", player.getName());

        while (!result){
            output.println("Введите строку: ");
            if (input.hasNextInt()){
                x = input.nextInt();
            }else{
                input.next();
                output.println("Введите число");
                continue;
            }
            output.println("Введите столбец: ");
            if (input.hasNextInt()){
                y = input.nextInt();
            }else{
                input.next();
                output.println("Введите число");
                continue;
            }
            result = true;
            output.flush();
        }
        return new Move(x, y);
    }

    @Override
    public void outputMove() {
        output.println("Неверный ход. Повторите ввод.");
    }

    /**
     *  Приветствие при запуске программы
     */
    public void welcomePrint(){
        output.println("Вас приветствует игра крестики-нолики");
        output.flush();
    }


    /**
     * Ввод размера поля
     * @return int - размер поля - сторона квадрата
     */
    public int enterFieldSize(){
        int result = 0;
        while (result < MIN_SIZE){
            output.println("Введите размер поля (больше 2): ");
            if (input.hasNextInt()){
                result = input.nextInt();
            }else{
                input.next();
                output.println("Введите число");
            }
            output.flush();
        }
        return result;
    }


    /**
     * Ввод длинны выгрышной комбинации
     * @return
     */
    public int enterWinLength(){
        int result = 0;
        while (result < MIN_WIN_LENGHT){
            output.println("Введите размер выйгрышной комбинации (больше 2): ");
            if (input.hasNextInt()){
                result = input.nextInt();
            }else{
                input.next();
                output.println("Введите число");
            }
            output.flush();
        }
        return result;
    }

    /**
     *  Выбо стороны за которую будем играть
     */
    public void choosePlayer(){
        boolean result = false;
        while (!result){
            output.println("Введите за кого хотите играть (x/o)): ");
            if (input.hasNext("[XxOo]")){
                player1Figure = input.next().toLowerCase();
                result = true;
            }else{
                input.next();
                output.println("Введите либо X, либо O");
            }
            output.flush();
        }
    }

    /**
     * Запуск игры
     * @param fieldSize размер поля
     * @param winLength длинна выгрышной комбинации
     */
    public void startGame(int fieldSize, int winLength  ){
        TicTacToeGame game = new TicTacToeGame(this, fieldSize, winLength);

        if (player1Figure.equals("x")){
            game.newGame(player1, player2);
        }else {
            game.newGame(player2, player1);
        }
    }

    /**
     * Запрос повторной игры
     * @return true - играем еще раз, false - хватит играть
     */
    public boolean playAgain(){
        boolean result = false;
        boolean exit = false;
        while (!exit){
            output.println("Играть еще раз (y/n)): ");
            if (input.hasNext("[YyNn]")){
                if (input.next().toLowerCase().equals("y")){
                    result = true;
                } else {
                    result = false;
                }
                exit = true;
            }else{
                input.next();
                output.println("Введите либо Y, либо N");
            }
            output.flush();
        }

        return result;
    }

    public static void main(String[] args) {

        TicTacToeViewImp viewGame = new TicTacToeViewImp(System.in, System.out);

        viewGame.welcomePrint();
        do {
            int fieldSize = viewGame.enterFieldSize();
            int winLength = viewGame.enterWinLength();
            viewGame.choosePlayer();
            viewGame.startGame(fieldSize, winLength);
        }while (viewGame.playAgain());
    }
}
