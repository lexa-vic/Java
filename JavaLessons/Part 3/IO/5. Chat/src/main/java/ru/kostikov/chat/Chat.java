package ru.kostikov.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 * Created by Алексей on 09.08.2016.
 */
public class Chat {

    /** Состояние чата в паузе или нет*/
    private boolean pause = false;

    /** Состояние чата - выход*/
    private boolean exit = false;

    /** Массив слов-команд чата*/
    String[] cmd = new String[3];

    /** Входной поток  */
    BufferedReader input;

    /**
     *  Конструктор, устанавливаем слова-командв
     */
    public Chat(BufferedReader input) {
        this.setPauseCmd("стоп");
        this.setResumeCmd("продолжить");
        this.setExitCmd("закончить");

        this.input = input;

    }

    /**
     * Установка команды паузы системы
     * @param word - слово-команда паузы
     */
    private void setPauseCmd(String word){
        this.cmd[0] = word.toLowerCase();
    }

    /**
     * Установка команды возобновления работы системы
     * @param word - слово-команда возобновления работы
     */
    private void setResumeCmd(String word){
        this.cmd[1] = word.toLowerCase();
    }

    /**
     * Установка команды выхода из системы
     * @param word - слово-команда возобновления работы
     */
    private void setExitCmd(String word){
        this.cmd[2] = word.toLowerCase();
    }

    /**
     * Проверка входящего слова, не является ли командой
     * Если является устанавливаем треуьемое состояние
     * @param cmdWord входное слово
     */
    private void checkCmdWord(String cmdWord){
        if (cmdWord != null){
            cmdWord = cmdWord.toLowerCase();
            // Пришла команда паузы
            if(this.cmd[0].equals(cmdWord)){
                this.pause = true;
            }else if(this.cmd[1].equals(cmdWord)){
                this.pause = false;
            }else if(this.cmd[2].equals(cmdWord)){
                this.exit = true;
            }
        }
    }

    /**
     * Проверка состояния паузы чата
     * @return boolean - true чат в паузе, ответы не отправляются
     */
    private boolean checkPause(){
        return this.pause;
    }

    /**
     * Проверка выходы из чата
     * @return true - требуется выход
     */
    private boolean checkExit(){
        return this.exit;
    }

    /**
     *  Основная логика чата
     */
    public void run(){

        String line;
        int lineCount = 0;
        ArrayList<String> stringBuf = new ArrayList<String>();

        // Читаем кол-во строк в файле
        try{

            while ((line = this.input.readLine()) != null) {
                stringBuf.add(line);
            }
        }
        catch (IOException ioe){
            ioe.getStackTrace();
        }

        do {

            Scanner in =  new Scanner(System.in);

            if (in.hasNextLine()){
                this.checkCmdWord(in.nextLine());

                if (!this.pause && !this.exit){
                    int lineNumber = new Random().nextInt(stringBuf.size());
                    String word = stringBuf.get(lineNumber);

                    System.out.println(word + lineNumber);
                }
            }
        }while(!this.exit);

    }

    public static void main(String[] args) {

        Chat chat = null;

        try {
            chat = new Chat(new BufferedReader(new FileReader("answers.txt")));
            //chat = new Chat(new StringReader("dasda\n"));
            chat.run();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");

        }


    }

}
