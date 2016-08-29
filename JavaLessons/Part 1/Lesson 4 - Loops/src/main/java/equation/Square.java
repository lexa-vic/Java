package equation;

import static java.lang.Math.*;

/**
 * Class implements square equation.
 * Created by Алексей on 10.07.2016.
 */
public class Square {
    private final double a;
    private final double b;
    private final double c;

    /**
     * Constructor. Init coefficients. (a != 0)
     * @param a coefficient a
     * @param b coefficient b
     * @param c coefficient c
     */
    Square(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Calculates the function value in the point.
     * @param x Point.
     * @return The function value in the point
     */
    public double calculate(double x){

        return (this.a*pow(x, 2)+ this.b*x + this.c);
    }
}
