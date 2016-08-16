package ru.kostikov.input;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.common.base.Joiner;

/**
 * Created by Алексей on 07.08.2016.
 */
public class InputStartTest {
    @Test
    public void checkParityOk() throws Exception {
        Input consoleInput = new ConsoleInput(new InputStreamReader(System.in));
        InputStart inStart = new InputStart(consoleInput);
        boolean expect     = true;
        boolean result     = inStart.checkParity(10);


        assertThat(expect,  is(result));
    }

    @Test
    public void checkParityNo() throws Exception {
        Input consoleInput = new ConsoleInput(new InputStreamReader(System.in));
        InputStart inStart = new InputStart(consoleInput);
        boolean expect     = false;
        boolean result     = inStart.checkParity(-15);


        assertThat(expect,  is(result));
    }

    @Test
    public void runParityNo() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("1\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите целое число: \r\n",
                                                    "Нечетное число\r\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        InputStart inStart = new InputStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        inStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runParityOk() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("2\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите целое число: \r\n",
                                                    "Четное число\r\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        InputStart inStart = new InputStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        inStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runParityTwice() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("-1\r\n", "y\r\n", "5000\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите целое число: \r\n",
                                                    "Нечетное число\r\n",
                                                    "Ещё раз (y/n): \r\n",
                                                    "Введите целое число: \r\n",
                                                    "Четное число\r\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        InputStart inStart = new InputStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        inStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

}