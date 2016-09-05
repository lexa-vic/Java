package ru.kostikov.interactcalculator;

import calculator.Calculator;

/**
 * This class extends class Calculator, add trigonometrical functions.
 * Created by Алексей on 05.09.2016.
 */
public class EngineerCalculator extends Calculator {
    /* List of available functions */
    private String[] functions = {"sin", "cos", "tg"};
    /** Result of operation. */
    private double result;

    /**
     *	Sum.
     *	@param first first argument.
     *	@param second second argument.
     */
    @Override
    public void add(double first, double second){
        super.add(first, second);
        this.result = super.getResult();
    }
    /**
     *	Subtraction.
     *	@param first first argument.
     *	@param second second argument.
     */
    @Override
    public void subtract(double first, double second){
        super.subtract(first, second);
        this.result = super.getResult();
    }
    /**
     *	Divison.
     *	@param first first argument.
     *	@param second second argument.
     */
    @Override
    public void div(double first, double second){
        super.div(first, second);
        this.result = super.getResult();
    }

    /**
     *	Multiplication.
     *	@param first first argument.
     *	@param second second argument.
     */
    @Override
    public void mult(double first, double second){
        super.mult(first, second);
        this.result = super.getResult();
    }

    /**
     * Calculates the sinus
     * @param a value in radians
     * @return value
     */
    public double sin(double a){
        return this.result = Math.sin(a);
    }

    /**
     * Calculates the cosine
     * @param a value in radians
     * @return value
     */
    public double cos(double a){
        return this.result = Math.cos(a);
    }

    /**
     * Calculates the tangent
     * @param a value in radians
     * @return value
     */
    public double tg(double a){
        return this.result = Math.tan(a);
    }

    /**
     * Get support math functions.
     * @return String array support functions.
     */
    @Override
    public String[] getSupportFunctions(){
        return functions;
    }

    /**
     * Performs the selected operation
     * @param operator
     * @param a
     * @param b
     * @return Result of operation
     */
    public double calcOperation(String operator, double a, double b){
        this.result = super.calcOperation(operator,a,b);
        return this.result;
    }

    /**
     * Performs the selected function
     * @param operator
     * @param a
     * @return Result of function
     */
    public double calcFunction(String operator, double a) {
        if (operator.equals("sin")) {
            this.result = this.sin(a);
        } else if (operator.equals("cos")) {
            this.result = this.cos(a);
        } else if (operator.equals("tg")) {
            this.result = this.tg(a);
        }
        return this.result;
    }

    /**
     *	Result output.
     *	@return Result of operation.
     */
    @Override
    public double getResult()
    {
        return this.result;
    }
}
