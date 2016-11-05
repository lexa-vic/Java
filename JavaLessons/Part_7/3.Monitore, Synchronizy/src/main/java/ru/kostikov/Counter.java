package ru.kostikov;

/**
 * Created by Алексей on 02.11.2016.
 */
public class Counter {
    private int counter = 0;

    public synchronized int increment(){
        return counter++;
    }

    public synchronized int getCounter(){
        return counter;
    }
}
