package ru.kostikov.start;

import java.util.Scanner;

/**
 * Created by Алексей on 19.07.2016.
 */
public class ConsoleInput implements Input{

    private Scanner scanner = new Scanner(System.in);

    public String ask (String question){
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range){
        int key  = Integer.valueOf(this.ask(question));
        boolean exist = false;

        for (int value: range){
            if (value == key){
                exist = true;
                break;
            }
        }
        if (!exist){
            throw new MenuOutException("Out of range menu");
        }
        return key;
    }
}
