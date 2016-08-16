package ru.kostikov.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import java.lang.Class;


/**
 * Created by Алексей on 09.08.2016.
 */
public class Chat {

    /** Состояние чата в паузе или нет*/
    private boolean pause = false;

    /** Состояние чата - выход*/
    private boolean exit = false;

    /** Кол-во доступных строк в потоке ответов*/
    private int linesCnt;

    /** Массив слов-команд чата*/
    private String[] cmd = new String[3];

    /** Входной поток c ответами */
    private Reader answers;

    /** Входной поток c сообщениями пользователя*/
    private Reader input;

    /** Выходной поток */
    private Writer output;

    /** Логгер*/
    private static final Logger log = Logger.getLogger(Chat.class);

    /** Массив строк вычитанного файла */
    private ArrayList<String> stringBuf = new ArrayList<String>();

    /**
     *  Конструктор, устанавливаем слова-командв
     */
    public Chat( Reader input, Writer output, Reader answers) {
        this.setPauseCmd("стоп");
        this.setResumeCmd("продолжить");
        this.setExitCmd("закончить");

        this.input   = input;
        this.output  = output;
        this.answers = answers;
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

    /** Выдает ответ из потока ответов
     * @return Считанная рандомная строка из потока
     */
    private String getAnswer(){

        String line;
        if (stringBuf.size() == 0){
            // Читаем кол-во строк в файле
            try{
                BufferedReader br = new BufferedReader(this.answers);

                while ((line = br.readLine()) != null) {
                    stringBuf.add(line);
                }
            }
            catch (IOException ioe){
                ioe.getStackTrace();
            }
        }
        int lineNumber = new Random().nextInt(stringBuf.size());
        return stringBuf.get(lineNumber);
    }

    /**
     *  Основная логика чата
     *  Ждет ввода строки пользователя.
     *  Выдает ответ из потока ответов.
     */
    public void run(){
        Scanner in =  new Scanner(this.input);

        do {
            if (in.hasNextLine()){
                String ourWord = in.nextLine();

                this.checkCmdWord(ourWord);
                log.debug(ourWord);

                if (!this.pause && !this.exit){
                    String word = this.getAnswer();
                    try {
                        this.output.write(word+"\r\n");
                        this.output.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    log.debug(word);
                }else{
                    try {
                        this.output.write("\r\n");
                        this.output.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }while(!this.exit);

        try {
            this.answers.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            String url = Chat.class.getClassLoader().getResource("answers.txt").getFile();

            Chat chat = new Chat(new InputStreamReader(System.in),
                         new BufferedWriter(new OutputStreamWriter(System.out)),
                         new FileReader(new File(url)));
            chat.run();
        } catch (FileNotFoundException e) {
            System.out.println("Файл c ответами не найден");
        }
    }
}
