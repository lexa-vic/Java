package ru.kostikov.chat;

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

    /**
     *  Конструктор, устанавливаем слова-командв
     */
    public Chat(){
        this.setPauseCmd("стоп");
        this.setResumeCmd("продолжить");
        this.setExitCmd("закончить");
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

    public void run(){

        do {

            Scanner in =  new Scanner(System.in);

            if (in.hasNextLine()){
                this.checkCmdWord(in.nextLine());

                if (!this.pause){
                    System.out.println("Bla");
                }
            }
        }while(!this.exit);

    }

    public static void main(String[] args) {
        Chat chat = new Chat();

        chat.run();
    }

}
