package triangle;

import org.junit.Before;
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

    private Point p1;
    private Point p2;
    private Point p3;
    private  double real_value = 0;


    @Before
    public void areaTriangelInit() throws Exception {
        this.p1 = new Point(0, 0);
        this.p2 = new Point(0, 10);
        this.p3 = new Point(10, 10);

    }
    /**
     * Проерка расчета площади равнобедренно прямоугольного треугольника
     * @throws Exception
     */
    @Test
    public void areaTriangelOne() throws Exception {

        Triangle triangle = new Triangle(this.p1, this.p2, this.p3);

        assertThat(triangle.area(), is(50.0));
    }

    @Test
    public void areaTriangelTwo() throws Exception {
        this.p1.x =  1; this.p1.y =  1;
        this.p2.x = -3; this.p2.y =  4;
        this.p3.x = -2; this.p3.y = -2;

        Triangle triangle = new Triangle(this.p1, this.p2, this.p3);

        real_value = new BigDecimal(triangle.area()).setScale(1, RoundingMode.HALF_UP).doubleValue();
        assertThat(real_value, is(10.5));
    }
    @Test
    public void areaTriangelNotExist() throws Exception {
        this.p1.x = 0; this.p1.y = 0;
        this.p2.x = 0; this.p2.y = 0;

        Triangle triangle = new Triangle(this.p1, this.p2, this.p3);
        // Такого треугольника не должно сущестовать
        assertThat(triangle.area(), is(-1.0));
    }
}