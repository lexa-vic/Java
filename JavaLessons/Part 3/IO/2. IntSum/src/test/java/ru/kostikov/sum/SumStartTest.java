package ru.kostikov.sum;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.kostikov.input.ConsoleInput;
import ru.kostikov.input.Input;
import ru.kostikov.input.InputStart;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 08.08.2016.
 */
public class SumStartTest {
    @Test
    public void runSimple() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("100\r\n","200\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите первое целое число: \r\n",
                                                    "Введите второе целое число: \r\n",
                                                     "Сумма: 300\n",
                                                     "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        SumStart sumStart = new SumStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        sumStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runIncorrectValue1() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("q\r\n","100\r\n","200\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите первое целое число: \r\n",
                                                    "Введите корректное число\r\n",
                                                    "Введите второе целое число: \r\n",
                                                    "Сумма: 300\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        SumStart sumStart = new SumStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        sumStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runIncorrectValue2() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("100\r\n","q\r\n","200\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите первое целое число: \r\n",
                                                    "Введите второе целое число: \r\n",
                                                    "Введите корректное число\r\n",
                                                    "Сумма: 300\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        SumStart sumStart = new SumStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        sumStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

    @Test
    public void runTwice() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("100\r\n","200\r\n", "y\r\n", "0\r\n","-2\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите первое целое число: \r\n",
                                                    "Введите второе целое число: \r\n",
                                                    "Сумма: 300\n",
                                                    "Ещё раз (y/n): \r\n",
                                                    "Введите первое целое число: \r\n",
                                                    "Введите второе целое число: \r\n",
                                                    "Сумма: -2\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        SumStart sumStart = new SumStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        sumStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

}