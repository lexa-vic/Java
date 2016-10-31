package ru.kostikov;

import java.io.*;

/**
 * Created by Алексей on 31.10.2016.
 */
public class SpaceCounter implements Counter {

    PrintStream output;
    InputStream input;

    public SpaceCounter(OutputStream output, InputStream input) {
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
                for (char c: sCurrentLine.toCharArray()){
                    if (c == ' ') counter++;
                }
                this.output.printf("Space count %d\n", counter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
