package ru.kostikov.polidrom;

import ru.kostikov.input.ConsoleInput;
import ru.kostikov.input.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 08.08.2016.
 */
public class PalidromStart {

    private Input in;

    /**
     * Конструктор нашей программы
     * @param in принимаем интерфейс входного потока
     */
    public PalidromStart(Input in){
        this.in = in;
    }

    public static void main(String[] args) {

        Input consoleInput = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        PalidromStart palidromStart = new PalidromStart(consoleInput);

        palidromStart.run();

    }

    /**
     * Проверка является ли слово словом-палидромом
     * @param word
     * @return
     */
    public boolean isPalidrom(String word){
        boolean result = false;

        word = word.toLowerCase();

        char[] charArray = word.toCharArray();

        // Переворот строки
        for(int i = 0; i < charArray.length/2; i++){
            char tmp;

            tmp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = tmp;
        }
           if (word.equals(new String(charArray))){
            result = true;
        }

        return result;
    }

    /**
     *  Основная логика программы
     *  Реализует диалог с пользователем
     */
    public void run(){
        String word;
        String[] cmd = {"y","n"};
        String   currentCmd = "";

        do{
            System.out.println("Введите слово-палидром из пяти букв: ");
            word = this.in.readWord(5);

            if(this.isPalidrom(word)){
                System.out.println("Слово является палидромом");
            }else{
                System.out.println("Слово не является палидромом");
            }

            System.out.println("Ещё раз (y/n): ");
            currentCmd = this.in.readCmd(cmd);
        }while(!currentCmd.equals(cmd[1]));

    }

}
