package ru.kostikov.interactcalculator;

import calculator.Calculator;
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
        MathCalc mathCalc = new MathCalc(new Calculator());

        result = mathCalc.calc(mathExpression);

        assertThat(expect,  is(result));
    }

    @Test
    public void calcDiv() throws Exception {
        String mathExpression = "(10-2)/2";
        double expect = 4;
        double result = 0;
        MathCalc mathCalc = new MathCalc(new Calculator());

        result = mathCalc.calc(mathExpression);

        assertThat(expect,  is(result));
    }

    @Test(expected=ArithmeticException.class)
    public void calcErr() throws Exception {
        String mathExpression = "(10-2)/0";
        MathCalc mathCalc = new MathCalc(new Calculator());

        mathCalc.calc(mathExpression);
    }

    @Test
    public void calcSin() throws Exception {
        String mathExpression = "sin(0)";
        double expect = 0;
        double result = 5;
        MathCalc mathCalc = new MathCalc(new EngineerCalculator());

        result = mathCalc.calc(mathExpression);

        assertThat(expect,  is(result));
    }

    @Test
    public void calcCos() throws Exception {
        String mathExpression = "cos(0)+5*(1+1)";
        double expect = 11;
        double result = 0;
        MathCalc mathCalc = new MathCalc(new EngineerCalculator());

        result = mathCalc.calc(mathExpression);

        assertThat(expect,  is(result));
    }

}