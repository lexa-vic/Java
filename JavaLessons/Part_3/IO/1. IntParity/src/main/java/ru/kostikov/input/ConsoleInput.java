package ru.kostikov.input;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Алексей on 07.08.2016.
 * Класс реализация интерфейса чтения входного потока
 */
public class ConsoleInput implements Input {
    private Scanner in;

    /**
     * Конструктор
     * @param input принимаем входной поток для обработки
     */
    public ConsoleInput(Reader input) {
        this.in = new Scanner(input);
    }

    /**
     * Чтение целого числа из входного потока, в случае ошибки выдает
     * сообщение о необоходимости повторного ввода
     * @return int считанное целое число
     */
    @Override
    public int readInt() {
        boolean valid = false;
        int     result = 0;

        do{
            if (this.in.hasNextInt()){
                result = in.nextInt();
                valid = true;
            }else{
                String err = "Введите корректное число";
                System.out.println(err);
                this.in.next();
            }

        }while(valid != true);

        return result;
    }

    /**
     * Считывание заданной команды с входного потока
     * В случае считывания чего-то другого выдается сообщение
     * @param cmd массив поддерживаемых комманд
     * @return String считанная команда
     */
    @Override
    public String readCmd(String[] cmd) {
        boolean valid = false;
        String  result = null;

        do{
            if (this.in.hasNext()){
                String currentCmd = this.in.next();

                if (cmd != null){
                    for(String str: cmd){
                        if(str.equals(currentCmd)){
                            result = currentCmd;
                            valid = true;
                            // Почему то после приема команды появляется пустая строка
                            this.in.nextLine();
                            break;
                        }
                    }
                }else{
                    result = currentCmd;
                    valid = true;
                }

                if (result == null){
                    String err = "Введите корректную команду";
                    System.out.println(err);
                }
            }
        }while(valid != true);

        return result;
    }

    /**
     * Считывание слова заданной длинны
     * @param wordLength заданная длина слова
     * @return считанное корректное слово
     */
    @Override
    public String readWord(int wordLength) {
        boolean valid = false;
        String  result = null;

        do{
            if (this.in.hasNextLine()){
                int letterCnt = 0;
                String word = this.in.nextLine();
                int readLength = word.length();

                if (readLength == wordLength && !word.contains(" ")){

                    for (letterCnt = 0; letterCnt < readLength; letterCnt++){
                        if (!Character.isLetter(word.toCharArray()[letterCnt])){
                            break;
                        }
                    }
                    // Все сивмолы в строке буквы
                    if (letterCnt == wordLength){
                        result = word;
                        valid = true;
                    }
                }

                if (result == null){
                    String err = "Введите корректное слово";
                    System.out.println(err);
                }
            }
        }while(valid != true);

        return result;
    }
}
