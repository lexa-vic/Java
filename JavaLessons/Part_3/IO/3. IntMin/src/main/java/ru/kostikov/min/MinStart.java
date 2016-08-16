package ru.kostikov.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import ru.kostikov.input.ConsoleInput;
import ru.kostikov.input.Input;

/**
 * Created by Алексей on 08.08.2016.
 */
public class MinStart {

    private Input in;

    /**
     * Конструктор нашей программы
     * @param in принимаем интерфейс входного потока
     */
    public MinStart(Input in){
        this.in = in;
    }

    public static void main(String[] args) {

        Input consoleInput = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        MinStart minStart = new MinStart(consoleInput);

        minStart.run();

    }

    /**
     * Выисляет минимальное по модулю число из принимаемого массива
     * @param array массив целых чисел
     * @return int минимальное по модулю число из принимаемого массива
     */
    public int minAbsValue(int [] array){
        int result = 0;

        if(array != null){
            result = array[0];

            for(int i = 0; i < array.length-1; i++){
                if (Math.abs(array[i]) < Math.abs(array[i+1])){
                    result = array[i];
                }
            }
        }
        return result;
    }

    /**
     *  Основная логика программы
     *  Реализует диалог с пользователем
     */
    public void run(){
        int[] values = {0,0,0};
        String[] cmd = {"y","n"};
        String   currentCmd = "";

        do{
            System.out.println("Введите первое целое число: ");
            values[0] = this.in.readInt();

            System.out.println("Введите второе целое число: ");
            values[1] = this.in.readInt();

            System.out.println("Введите третье целое число: ");
            values[2] = this.in.readInt();

            System.out.printf("Минимальное по модулю число: %d\n", minAbsValue(values));

            System.out.println("Ещё раз (y/n): ");
            currentCmd = this.in.readCmd(cmd);
        }while(!currentCmd.equals(cmd[1]));

    }
}
