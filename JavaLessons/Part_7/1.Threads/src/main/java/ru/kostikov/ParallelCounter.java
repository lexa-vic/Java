package ru.kostikov;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by Алексей on 31.10.2016.
 */
public class ParallelCounter {

    public static InputStream setSourceFile(String fileName){
        InputStream inputFileStream = null;
        try {
            inputFileStream = new FileInputStream(new File(ParallelCounter.class.getClassLoader().getResource(fileName).getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return inputFileStream;
    }

    private Thread getThread(Counter counter){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                counter.count();
            }
        });
    }

    public Thread mainThread(){
        SpaceCounter spaceCounter = new SpaceCounter(System.out,ParallelCounter.setSourceFile("Example.txt"));
        WordCounter  wordCounter = new WordCounter(System.out,ParallelCounter.setSourceFile("Example2.txt"));

        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start parallel counters");

                Thread spaceThread = getThread(spaceCounter);
                Thread wordThread = getThread(wordCounter);

                spaceThread.start();
                wordThread.start();

                spaceThread.interrupt();

                try {
                    spaceThread.join();
                    wordThread.join();
                } catch (InterruptedException e) {
                    System.out.println("Main thread is stopped");
                }
                System.out.println("Finish parallel counters");
            }
        });

        return mainThread;
    }

    public static void main(String[] args) {

        ParallelCounter parallelCounter = new ParallelCounter();

        Thread mainThread = parallelCounter.mainThread();

        mainThread.start();
        mainThread.interrupt();
    }
}
