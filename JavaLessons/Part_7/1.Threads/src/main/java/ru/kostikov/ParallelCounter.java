package ru.kostikov;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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

    public void startThread(Counter counter){
        new Thread(new Runnable() {
            @Override
            public void run() {
                counter.count();
            }
        }).start();
    }

    public static void main(String[] args) {

        SpaceCounter spaceCounter = new SpaceCounter(System.out,ParallelCounter.setSourceFile("Example.txt"));
        WordCounter  wordCounter = new WordCounter(System.out,ParallelCounter.setSourceFile("Example2.txt"));

        ParallelCounter parallelCounter = new ParallelCounter();

        parallelCounter.startThread(spaceCounter);
        parallelCounter.startThread(wordCounter);
    }
}
