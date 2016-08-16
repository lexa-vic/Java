package ru.kostikov.polidrom;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.kostikov.input.ConsoleInput;
import ru.kostikov.input.Input;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 09.08.2016.
 */
public class PalidromStartTest {
    @Test
    public void isPalidromYes() throws Exception {
        boolean expected = true;
        boolean result = false;
        Input consoleInput = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        PalidromStart palidromStart = new PalidromStart(consoleInput);

        result = palidromStart.isPalidrom("Ротор");

        assertThat(expected,  is(result));
    }

    @Test
    public void isPalidromNo() throws Exception {
        boolean expected = false;
        boolean result = false;
        Input consoleInput = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        PalidromStart palidromStart = new PalidromStart(consoleInput);

        result = palidromStart.isPalidrom("Торт");

        assertThat(expected,  is(result));
    }

    @Test
    public void runSimple() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("Ротор\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите слово-палидром из пяти букв: \r\n",
                                                    "Слово является палидромом\r\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        PalidromStart palidromStart = new PalidromStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        palidromStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runIncorrectWord() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("qwer1\r\n","Ротор\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите слово-палидром из пяти букв: \r\n",
                                                    "Введите корректное слово\r\n",
                                                    "Слово является палидромом\r\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        PalidromStart palidromStart = new PalidromStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        palidromStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runNotPalidrom() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("Время\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите слово-палидром из пяти букв: \r\n",
                                                    "Слово не является палидромом\r\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        PalidromStart palidromStart = new PalidromStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        palidromStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runTwice() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("Время\r\n","y\r\n", "Ротор\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите слово-палидром из пяти букв: \r\n",
                                                    "Слово не является палидромом\r\n",
                                                    "Ещё раз (y/n): \r\n",
                                                    "Введите слово-палидром из пяти букв: \r\n",
                                                    "Слово является палидромом\r\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        PalidromStart palidromStart = new PalidromStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        palidromStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

}