package calculator;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 06.07.2016.
 */
public class CalculatorTest {
    /** Ссылка на тестируемый класс калькулятора */
    private Calculator calc;
    /** Результат */
    private double result;

    /** Инициализация перед тестами */
    @Before
    public void CreateCalc(){
        calc = new Calculator();
    }

    /** Тест сложения */
    @Test
    public void add() throws Exception {
        calc.add(3, 2);

        result = calc.getResult();
        assertThat(result, is(5.0));
    }

    /** Тест вычитания */
    @Test
    public void subtract() throws Exception {
        Calculator calc = new Calculator();

        calc.subtract(2, 3);

        result = calc.getResult();
        assertThat(result, is(-1.0));
    }

    /** Тест деления */
    @Test
    public void div() throws Exception {
        Calculator calc = new Calculator();

        calc.div(10, 2);

        result = calc.getResult();
        assertThat(result, is(5.0));
    }

    /** Тест умножения */
    @Test
    public void mult() throws Exception {
        Calculator calc = new Calculator();

        calc.mult(6, 6);

        result = calc.getResult();
        assertThat(result, is(36.0));
    }

}