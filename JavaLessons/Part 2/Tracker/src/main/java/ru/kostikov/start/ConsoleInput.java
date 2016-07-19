package ru.kostikov.start;

import java.util.Scanner;

/**
 * Created by Алексей on 19.07.2016.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask (String question){
        System.out.println(question);
        return scanner.nextLine();
    }
}
