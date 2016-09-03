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
    private Calculator calculator = new Calculator();
    /** Class expression parser*/
    private MathParser mathParser;

    /**
     *  Constructor.
     *  Init expression parser class.
     */
    public MathCalc(){
        this.mathParser = new MathParser(this.calculator.getSupportFunctions(),
                                         this.calculator.getSupportOperators());
    }

    /**
     * Calculates experession in Reverse Polish Notation(RPN).
     * @param experessionRPN Stack with experession in RPN.
     * @return result of expression.
     */
    private double calcRPN(Stack<String> experessionRPN) throws ArithmeticException{
        	/* stack for holding the calculations result */
        Stack<Double> stackAnswer = new Stack<Double>();

        /* reverse stack */
        Collections.reverse(experessionRPN);

        /* Clean answer stack */
        stackAnswer.clear();

        while (!experessionRPN.empty()){
            String token = experessionRPN.pop();

            if (this.mathParser.isNumber(token)){
                stackAnswer.push(Double.valueOf(token));
            }else if (this.mathParser.isOperator(token)){
                double b = stackAnswer.pop();
                double a = stackAnswer.pop();

                if (token.equals("+")) {
                    this.calculator.add(a, b);
                } else if (token.equals("-")) {
                    this.calculator.subtract(a, b);
                } else if (token.equals("*")) {
                    this.calculator.mult(a, b);
                } else if (token.equals("/")) {
                    this.calculator.div(a, b);
                }
                if (this.calculator.getResult() == Double.POSITIVE_INFINITY ||
                    this.calculator.getResult() == Double.NEGATIVE_INFINITY)
                    throw new ArithmeticException();

                stackAnswer.push(this.calculator.getResult()) ;
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
