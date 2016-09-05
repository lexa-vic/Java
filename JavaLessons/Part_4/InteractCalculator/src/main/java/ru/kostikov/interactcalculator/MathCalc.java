package ru.kostikov.interactcalculator;

import calculator.Calculator;

import java.util.Collections;
import java.util.Stack;


/**
 * This class get math expression parse it using MathParse and calculate using class Calculator.
 * Created by Алексей on 03.09.2016.
 */
public class MathCalc {
    /** Class with math functions*/
    private Calculator calculator;
    /** Class expression parser*/
    private MathParser mathParser;

    /**
     *  Constructor.
     *  Init expression parser class.
     */
    public MathCalc(Calculator calculator){
        this.calculator = calculator;
        this.mathParser = new MathParser(this.calculator.getSupportFunctions(),
                                         this.calculator.getSupportOperators());
    }

    /**
     * Calculates expression in Reverse Polish Notation(RPN).
     * @param expressionRPN Stack with expression in RPN.
     * @return result of expression.
     */
    private double calcRPN(Stack<String> expressionRPN) throws ArithmeticException{
        /* stack for holding the calculations result */
        Stack<Double> stackAnswer = new Stack<Double>();

        /* reverse stack */
        Collections.reverse(expressionRPN);

        /* Clean answer stack */
        stackAnswer.clear();

        while (!expressionRPN.empty()){
            String token = expressionRPN.pop();

            if (this.mathParser.isNumber(token)){
                stackAnswer.push(Double.valueOf(token));
            }else if (this.mathParser.isOperator(token)){
                double result;
                double b = stackAnswer.pop();
                double a = stackAnswer.pop();

                result = this.calculator.calcOperation(token, a, b);

                if (result == Double.POSITIVE_INFINITY ||
                    result == Double.NEGATIVE_INFINITY)
                    throw new ArithmeticException();

                stackAnswer.push(result) ;
            }else if (this.mathParser.isFunction(token)){
                double result;
                double a = stackAnswer.pop();

                result = this.calculator.calcFunction(token, a);

                if (result == Double.POSITIVE_INFINITY ||
                    result == Double.NEGATIVE_INFINITY)
                    throw new ArithmeticException();

                stackAnswer.push(result) ;
            }
        }
        return stackAnswer.pop();
    }

    /**
     * Calculates math expression
     * @param expression expression in String
     * @return result in Double
     * @throws MathParseExeptions
     * @throws ArithmeticException
     */
    public double calc(String expression) throws MathParseExeptions, ArithmeticException {
        return calcRPN(this.mathParser.parse(expression));
    }
}
