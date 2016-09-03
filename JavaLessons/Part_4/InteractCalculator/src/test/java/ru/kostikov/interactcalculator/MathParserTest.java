package ru.kostikov.interactcalculator;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 03.09.2016.
 */
public class MathParserTest {
    /* List of available functions */
    private final String[] FUNCTIONS = { "abs", "cos", "log", "neg", "pow", "sin", "sqrt", "tan"};
    /* List of available operators */
    private final String OPERATORS = "+-*/";

    @Test
    public void parse() throws Exception {
        String mathExpression = "(2+3)*5";
        String outputExpect = "23+5*";
        String outputResult = "";

        MathParser mathParser = new MathParser(FUNCTIONS, OPERATORS);

        try {
            outputResult = mathParser.parse(mathExpression).toString().replace("[", "").replace("]", "").replace(",","").replace(" ", "");
        }catch (ParseBracketsExpetion pbe)
        {
            pbe.printStackTrace();
        }catch (ParseUndefineTokenExpetion pute)
        {
            pute.printStackTrace();
        }
        assertThat(outputExpect,  is(outputResult));
    }

    @Test
    public void parseOpenBracketMissing() throws Exception {
        String mathExpression = "(2+3))*5";
        boolean result = false;
        boolean expect = true;

        MathParser mathParser = new MathParser(FUNCTIONS, OPERATORS);

        try {
            mathParser.parse(mathExpression);
        }catch (ParseBracketsExpetion pbe)
        {
            result = true;
        }catch (ParseUndefineTokenExpetion pute)
        {
            pute.printStackTrace();
        }
        assertThat(expect,  is(result));
    }

    @Test
    public void parseCloseBracketMissing() throws Exception {
        String mathExpression = "((2+3)*5";
        boolean result = false;
        boolean expect = true;

        MathParser mathParser = new MathParser(FUNCTIONS, OPERATORS);

        try {
            mathParser.parse(mathExpression);
        }catch (ParseBracketsExpetion pbe)
        {
            result = true;
        }catch (ParseUndefineTokenExpetion pute)
        {
            pute.printStackTrace();
        }
        assertThat(expect,  is(result));
    }

    @Test
    public void parseUndefToken() throws Exception {
        String mathExpression = "a(2+3)*5";
        boolean result = false;
        boolean expect = true;

        MathParser mathParser = new MathParser(FUNCTIONS, OPERATORS);

        try {
            mathParser.parse(mathExpression);
        }catch (ParseBracketsExpetion pbe)
        {
            pbe.printStackTrace();
        }catch (ParseUndefineTokenExpetion pute)
        {
            result = true;
        }
        assertThat(expect,  is(result));
    }

}