package ru.kostikov.interactcalculator;

/**
 * Created by Алексей on 03.09.2016.
 */
public class MathParseExeptions extends Exception {
    public MathParseExeptions(String msg){
        super(msg);
    }
}


/**
 *  This Exceptions occurs when a bracket is missing in the math expression.
 */
class ParseBracketsExpetion extends MathParseExeptions {
    public ParseBracketsExpetion(String msg){
        super(msg);
    }
}

/**
 *  This Exceptions occurs when a token impossible to recognize .
 */
class ParseUndefineTokenExpetion extends MathParseExeptions {
    public ParseUndefineTokenExpetion(String msg){
        super(msg);
    }
}