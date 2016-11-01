package ru.kostikov;

import java.io.*;

/**
 * Created by Алексей on 31.10.2016.
 */
public class SpaceCounter extends Thread{

    PrintStream output;
    InputStream input;

    public SpaceCounter(OutputStream output, InputStream input) {
        this.output = new PrintStream(new BufferedOutputStream(output), true);
        this.input = input;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.input))){
            int counter = 0;
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null && !this.isInterrupted()) {
                for (char c: sCurrentLine.toCharArray()){
                    if (c == ' ') counter++;
                }
                this.output.printf("Space count %d\n", counter);
            }

            if (this.isInterrupted()){
                this.output.printf("Space thread interrupted \n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
