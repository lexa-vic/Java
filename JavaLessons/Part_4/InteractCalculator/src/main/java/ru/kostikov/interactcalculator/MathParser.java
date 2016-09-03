package ru.kostikov.interactcalculator;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * This class pars mathematical expression in infix notation and convert it into Reverse Polish Notation.
 * Created by Алексей on 03.09.2016.
 */
public class MathParser {
    /** List of available functions */
    private String[] FUNCTIONS = { };
    /** List of available operators */
    private String OPERATORS = "";
    /* Temporary stack that holds operators, functions and brackets */
    private Stack<String> stackOperations = new Stack<String>();
    /* Stack for holding expression converted to reversed polish notation */
    private Stack<String> stackRPN = new Stack<String>();
    /* Stack for holding the calculations result */
    private Stack<String> stackAnswer = new Stack<String>();

    public MathParser(String[] supportFuctions, String supportOperators){
        FUNCTIONS = supportFuctions;
        OPERATORS = supportOperators;
    }

    /**
     * Parses the math expression (complicated formula) and stores the result
     *
     * @param expression input expression (math formula)
     * @throws <code>MathParseExeptions</code> if the input expression is not
     *         correct
     */
    public Stack<String>  parse(String expression) throws MathParseExeptions{
		/* Cleaning stacks */
        stackOperations.clear();
        stackRPN.clear();

		/*
		 * Make some preparations: remove spaces; handle unary + and -, handle
		 * degree character.
		 */
        expression = expression.replace(" ", "")
                .replace("°", "*" + Double.toString(Math.PI) + "/180")
                .replace("(-", "(0-").replace(",-", ",0-").replace("(+", "(0+")
                .replace(",+", ",0+");
        if (expression.charAt(0) == '-' || expression.charAt(0) == '+') {
            expression = "0" + expression;
        }
		/* Splitting input string into tokens. */
        StringTokenizer stringTokenizer = new StringTokenizer(expression,
                this.OPERATORS + "()", true);

		/* Loop for handling each token - shunting-yard algorithm. */
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (isOpenBracket(token)) {
                this.stackOperations.push(token);
            } else if (isCloseBracket(token)) {

                while (!this.stackOperations.empty()
                        && !isOpenBracket(this.stackOperations.lastElement())) {
                    this.stackRPN.push(this.stackOperations.pop());
                }
                /** If open bracket is missing stackOperation will be empty */
                if(!this.stackOperations.empty()){
                    this.stackOperations.pop();
                }else{
                    throw new ParseBracketsExpetion("Open bracket is missing");
                }

                if (!this.stackOperations.empty()
                        && isFunction(this.stackOperations.lastElement())) {
                    this.stackRPN.push(this.stackOperations.pop());
                }
            } else if (isNumber(token)) {
                this.stackRPN.push(token);
            } else if (isOperator(token)) {
                while (!this.stackOperations.empty()
                        && isOperator(this.stackOperations.lastElement())
                        && getPrecedence(token) <= getPrecedence(this.stackOperations
                        .lastElement())) {
                    this.stackRPN.push(this.stackOperations.pop());
                }
                this.stackOperations.push(token);
            } else if (isFunction(token)) {
                this.stackOperations.push(token);
            } else {
                throw new ParseUndefineTokenExpetion("Unrecognized token");
            }
        }
        while (!this.stackOperations.empty()) {
            if (isOpenBracket(this.stackOperations.lastElement())) {
                throw new ParseBracketsExpetion("Close bracket is missing");
            }
            this.stackRPN.push(this.stackOperations.pop());
        }

        return this.stackRPN;
    }

    /**
     * Check if the token is number (0-9)
     *
     * @param token Input token
     * @return boolean output
     */
    public boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Check if the token is function (e.g. "sin")
     *
     * @param token Input token
     * @return boolean output
     */
    public boolean isFunction(String token) {
        for (String item : FUNCTIONS) {
            if (item.equals(token)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the token is opening bracket
     *
     * @param token Input token
     * @return boolean output
     */
    private boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    /**
     * Check if the token is closing bracket
     *
     * @param token Input token
     * @return boolean output
     */
    private boolean isCloseBracket(String token) {
        return token.equals(")");
    }

    /**
     * Check if the token is operator (e.g. "+")
     *
     * @param token Input String token
     * @return boolean output
     */
    public boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    /**
     * Gets the precedence of the operator
     *
     * @param token Input token
     * @return byte precedence
     */
    private byte getPrecedence(String token) {
        if (token.equals("+") || token.equals("-")) {
            return 1;
        }
        return 2;
    }

}
