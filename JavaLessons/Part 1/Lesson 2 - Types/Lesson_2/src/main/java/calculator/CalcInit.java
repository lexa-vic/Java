package calculator;

/**
 * Created by Алексей on 06.07.2016.
 */
public class CalcInit{

    public static void main(String[] argv){
        Calculator calc = new Calculator();

        calc.add(2.5, 2.5);
        System.out.printf("Summa:          %.4f\n", calc.getResult());

        calc.div(7, 2);
        System.out.printf("Division:       %.4f\n", calc.getResult());

        calc.subtract(10, 2);
        System.out.printf("Subtraction:    %.4f\n", calc.getResult());

        calc.mult(5, 5);
        System.out.printf("Multiplication: %.4f\n", calc.getResult());


    }

}