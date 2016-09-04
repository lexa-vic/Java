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
    private final String[] functions = { "abs", "cos", "log", "neg", "pow", "sin", "sqrt", "tan"};
    /* List of available operators */
    private final String operators = "+-*/";

    @Test
    public void parse() throws Exception {
        String mathExpression = "(2+3)*5";
        String outputExpect = "23+5*";
        String outputResult = "";

        MathParser mathParser = new MathParser(functions, operators);

        outputResult = mathParser.parse(mathExpression).toString().replace("[", "").replace("]", "").replace(",","").replace(" ", "");
        assertThat(outputExpect,  is(outputResult));
    }

    @Test(expected=ParseBracketsExpetion.class)
    public void parseOpenBracketMissing() throws Exception {
        String mathExpression = "(2+3))*5";

        MathParser mathParser = new MathParser(functions, operators);
        mathParser.parse(mathExpression);
    }

    @Test(expected=ParseBracketsExpetion.class)
    public void parseCloseBracketMissing() throws Exception {
        String mathExpression = "((2+3)*5";

        MathParser mathParser = new MathParser(functions, operators);
        mathParser.parse(mathExpression);
    }

    @Test(expected=ParseUndefineTokenExpetion.class)
    public void parseUndefToken() throws Exception {
        String mathExpression = "a(2+3)*5";

        MathParser mathParser = new MathParser(functions, operators);
        mathParser.parse(mathExpression);
    }

}