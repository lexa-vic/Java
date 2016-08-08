package ru.kostikov.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Алексей on 06.08.2016.
 */
public class InputStart {
    private Input in;

    /**
     * Конструктор нашей программы
     * @param in принимаем интерфейс входного потока
     */
    public InputStart(Input in){
        this.in = in;
    }

    public static void main(String[] args) {

        Input consoleInput = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        InputStart inStart = new InputStart(consoleInput);

        inStart.run();

    }

    /**
     * Проверка четности принимаемого значения
     * @param value принимаемое значение
     * @return boolean false - нечетное число, true - четное число
     */
    public boolean checkParity(int value){
        return (value % 2 != 0) ? false : true;
    }

    /**
     *  Основная логика программы
     *  Реализует диалог с пользователем
     */
    public void run(){
        int      value = 0;
        String[] cmd = {"y","n"};
        String   currentCmd = "";

        do{
            System.out.println("Введите целое число: ");

            value = in.readInt();

            if (checkParity(value)){
                System.out.println("Четное число");
            }else{
                System.out.println("Нечетное число");
            }

            System.out.println("Ещё раз (y/n): ");
            currentCmd = in.readCmd(cmd);
        }while(!currentCmd.equals(cmd[1]));

    }
}
