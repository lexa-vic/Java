package ru.kostikov.input;

import java.io.InputStream;

/**
 * Created by Алексей on 06.08.2016.
 */
public interface Input {
    /**
     * Считывание целого числа из входного потока
     * @return
     */
    int    readInt();

    /**
     * Считывание заданной команды из входного потока
     * @param cmd массив комманд
     * @return String считанная команда
     */
    String readCmd(String [] cmd);
}
