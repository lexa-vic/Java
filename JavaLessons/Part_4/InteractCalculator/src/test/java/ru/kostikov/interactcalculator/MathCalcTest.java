package ru.kostikov.interactcalculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 03.09.2016.
 */
public class MathCalcTest {
    @Test
    public void calc() throws Exception {
        String mathExpression = "(2+3)*5";
        double expect = 25;
        double result = 0;
        MathCalc mathCalc = new MathCalc();

        result = mathCalc.calc(mathExpression);

        assertThat(expect,  is(result));
    }

    @Test
    public void calcDiv() throws Exception {
        String mathExpression = "(10-2)/2";
        double expect = 4;
        double result = 0;
        MathCalc mathCalc = new MathCalc();

        result = mathCalc.calc(mathExpression);

        assertThat(expect,  is(result));
    }

    @Test(expected=ArithmeticException.class)
    public void calcErr() throws Exception {
        String mathExpression = "(10-2)/0";
        MathCalc mathCalc = new MathCalc();

        mathCalc.calc(mathExpression);
    }

}