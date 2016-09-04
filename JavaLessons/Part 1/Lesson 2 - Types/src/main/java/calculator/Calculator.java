package calculator;

/**
 * Created by Алексей on 06.07.2016.
 * Calculator.
 * Calculates any math operations.
 */
public class Calculator{

    /* List of available functions */
    private final String[] functions = { "abs", "cos", "log", "neg", "pow", "sin", "sqrt", "tan"};
    /* List of available operators */
    private final String operators = "+-*/";

    /** Result of operation. */
    private double result;

    /**
     *	Sum.
     *	@param first first argument.
     *	@param second second argument.
     */
    public void add(double first, double second){
        this.result = first+second;
    }
    /**
     *	Subtraction.
     *	@param first first argument.
     *	@param second second argument.
     */
    public void subtract(double first, double second){
        this.result = first-second;
    }
    /**
     *	Divison.
     *	@param first first argument.
     *	@param second second argument.
     */
    public void div(double first, double second){
        this.result = first/second;
    }

    /**
     *	Multiplication.
     *	@param first first argument.
     *	@param second second argument.
     */
    public void mult(double first, double second){
        this.result = first*second;
    }

    /**
     * Get support math functions.
     * @return String array support functions.
     */
    public String[] getSupportFunctions(){
        return functions;
    }

    /**
     * Get support math operators.
     * @return String with support operators.
     */
    public String getSupportOperators(){
        return operators;
    }

    /**
     *	Result output.
     *	@return Result of operation.
     */
    public double getResult()
    {
        return this.result;
    }
}
