package equation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 10.07.2016.
 */
public class SquareTest {


    /**
     * Положительное значение функции
     * @throws Exception
     */
    @Test
    public void calculatePositivValueTest() throws Exception {

        Square func = new Square(2, 1, 1);

        assertThat(func.calculate(2.0), is(11.0));
    }

    /**
     * Отрицательное значение функции
     * @throws Exception
     */
    @Test
    public void calculateNegativeValueTest() throws Exception {

        Square func = new Square(-5, 3, 7);

        assertThat(func.calculate(5.0), is(-103.0));
    }

    /**
     * Корень уравнения
     * @throws Exception
     */
    @Test
    public void calculateZeroValueTest() throws Exception {

        Square func = new Square(-2, 1, 1);

        assertThat(func.calculate(1.0), is(0.0));
    }

}