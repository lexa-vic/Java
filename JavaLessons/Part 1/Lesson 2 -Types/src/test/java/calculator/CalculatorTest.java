package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Алексей on 06.07.2016.
 */
public class CalculatorTest {

    @Test
    public void add() throws Exception {
        Calculator calc = new Calculator();

        calc.add(3, 2);

        double result = calc.getResult();
        assertEquals(5.0,result, 0.1);
    }

    @Test
    public void subtract() throws Exception {
        Calculator calc = new Calculator();

        calc.subtract(2, 3);

        double result = calc.getResult();
        assertEquals(-1,result, 0.1);
    }

    @Test
    public void div() throws Exception {
        Calculator calc = new Calculator();

        calc.div(10, 2);

        double result = calc.getResult();
        assertEquals(5,result, 0.1);
    }

    @Test
    public void mult() throws Exception {
        Calculator calc = new Calculator();

        calc.mult(6, 6);

        double result = calc.getResult();
        assertEquals(36, result, 0.1);
    }

}