package ru.kostikov.min;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.kostikov.input.ConsoleInput;
import ru.kostikov.input.Input;

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 08.08.2016.
 */
public class MinStartTest {
    @Test
    public void minAbsValue() throws Exception {
        Input consoleInput = new ConsoleInput(new InputStreamReader(System.in));
        MinStart minStart = new MinStart(consoleInput);
        int expected = -1;
        int result;
        int[] inBuf = {3, -1, -2};

        result = minStart.minAbsValue(inBuf);

        assertThat(expected,  is(result));
    }

    @Test
    public void runSimple() throws Exception {
        String resultAnswers;
        String answers         = Joiner.on("").join("-2\r\n","-1\r\n","10\r\n", "n\r\n");
        String expectedAnswers = Joiner.on("").join("Введите первое целое число: \r\n",
                                                    "Введите второе целое число: \r\n",
                                                    "Введите третье целое число: \r\n",
                                                    "Минимальное по модулю число: -1\n",
                                                    "Ещё раз (y/n): \r\n");


        Input consoleInput = new ConsoleInput(new StringReader(answers));
        MinStart minStart = new MinStart(consoleInput);

        ByteArrayOutputStream outBuf = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuf));

        minStart.run();

        resultAnswers = outBuf.toString();

        assertThat(expectedAnswers,  is(resultAnswers));
    }

}