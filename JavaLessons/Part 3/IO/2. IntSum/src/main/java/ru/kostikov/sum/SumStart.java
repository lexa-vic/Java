package ru.kostikov.sum;

import ru.kostikov.input.ConsoleInput;
import ru.kostikov.input.Input;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 08.08.2016.
 */
public class SumStart {
    private Input in;

    /**
     * Конструктор нашей программы
     * @param in принимаем интерфейс входного потока
     */
    public SumStart(Input in){
        this.in = in;
    }

    public static void main(String[] args) {

        Input consoleInput = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        SumStart sumStart = new SumStart(consoleInput);

        sumStart.run();

    }

    /**
     *  Основная логика программы
     *  Реализует диалог с пользователем
     */
    public void run(){
        int      value1, value2;
        String[] cmd = {"y","n"};
        String   currentCmd = "";

        do{
            System.out.println("Введите первое целое число: ");
            value1 = in.readInt();

            System.out.println("Введите второе целое число: ");
            value2 = in.readInt();

            System.out.printf("Сумма: %d\n", (value1+value2));

            System.out.println("Ещё раз (y/n): ");
            currentCmd = in.readCmd(cmd);
        }while(!currentCmd.equals(cmd[1]));

    }
}
