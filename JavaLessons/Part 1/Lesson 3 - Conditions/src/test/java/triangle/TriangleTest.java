package triangle;

import org.junit.Test;

import static java.lang.Math.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Алексей on 08.07.2016.
 */
public class TriangleTest {

    /**
     * Проверка расчета максимальной стороны
     * @throws Exception
     */
    @Test
    public void max() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 10);
        Point p3 = new Point(10, 10);
        double real_value = 0;

        Triangle triangle = new Triangle(p1, p2, p3);

        real_value = new BigDecimal(triangle.max()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        assertThat(real_value, is(14.14));

        p2.x = 20; p2.y = 0;
        p3.x =  2; p3.y = -2;

        triangle = new Triangle(p1, p2, p3);

        assertThat(triangle.max(), is(20.00));

        p1.x = 0; p1.y = 0;
        p2.x = 0; p2.y = 0;

        triangle = new Triangle(p1, p2, p3);
        // Такого треугольника не должно сущестовать
        assertThat(triangle.max(), is(-1.0));
    }

    /**
     * Проерка расчета плщади треугольника
     * @throws Exception
     */
    @Test
    public void area() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 10);
        Point p3 = new Point(10, 10);
        double real_value = 0;

        Triangle triangle = new Triangle(p1, p2, p3);

        assertThat(triangle.area(), is(50.0));

        p1.x =  1; p1.y =  1;
        p2.x = -3; p2.y =  4;
        p3.x = -2; p3.y = -2;

        triangle = new Triangle(p1, p2, p3);

        real_value = new BigDecimal(triangle.area()).setScale(1, RoundingMode.HALF_UP).doubleValue();
        assertThat(real_value, is(10.5));

        p1.x = 0; p1.y = 0;
        p2.x = 0; p2.y = 0;

        triangle = new Triangle(p1, p2, p3);
        // Такого треугольника не должно сущестовать
        assertThat(triangle.area(), is(-1.0));

    }

}