package ru.kostikov;

import java.io.*;

/**
 * Created by Алексей on 31.10.2016.
 */
public class WordCounter implements Counter {
    PrintStream output;
    InputStream input;

    public WordCounter(OutputStream output, InputStream input) {
        this.output = new PrintStream(new BufferedOutputStream(output), true);
        this.input = input;
    }

    /**
     * Counts spaces
     */
    public void count(){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.input))){
            int counter = 0;
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                counter += sCurrentLine.split(" ").length;
                this.output.printf("Word count %d\n", counter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
