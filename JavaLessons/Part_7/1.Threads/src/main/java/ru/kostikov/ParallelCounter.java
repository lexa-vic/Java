package ru.kostikov;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import static java.lang.Thread.sleep;

/**
 * Created by Алексей on 31.10.2016.
 */
public class ParallelCounter {
    private SpaceCounter spaceCounter = null;
    private WordCounter  wordCounter = null;

    public void mainThreadRun(){

        try {
            spaceCounter = new SpaceCounter(System.out, new FileInputStream(new File(ParallelCounter.class.getClassLoader().getResource("Example.txt").getFile())));
            wordCounter = new WordCounter(System.out, new FileInputStream(new File(ParallelCounter.class.getClassLoader().getResource("Example2.txt").getFile())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Start parallel counters");

        spaceCounter.start();
        wordCounter.start();

        try {
            spaceCounter.join();
            wordCounter.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread is stopped");
        }
        System.out.println("Finish parallel counters");
    }

    public void spaceThreadStop(){
        spaceCounter.interrupt();
    }

    public void wordThreadStop(){
        wordCounter.interrupt();
    }

    public static void main(String[] args) {

        ParallelCounter parallelCounter = new ParallelCounter();
        parallelCounter.mainThreadRun();

    }
}
