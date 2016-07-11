package equation;

import static java.lang.Math.*;

/**
 * Created by Алексей on 10.07.2016.
 */
public class Square {

    private final double a;
    private final double b;
    private final double c;

    /**
     * Указываем коэффициенты уравнения (a != 0)
     * @param a
     * @param b
     * @param c
     */
    Square(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Вычисление значения функции в точке
     * @param x точка
     * @return Значение функции в точке
     */
    public double calculate(double x){

        return (this.a*pow(x, 2)+ this.b*x + this.c);
    }
}
