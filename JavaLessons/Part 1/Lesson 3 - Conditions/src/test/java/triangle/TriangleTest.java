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
    private Triangle triangle;


    @Before
    public void areaTriangelInit() throws Exception {
        this.p1 = new Point(0, 0);
        this.p2 = new Point(0, 3);
        this.p3 = new Point(4, 0);

        this.triangle = new Triangle(this.p1, this.p2, this.p3);
    }

    /**
     * Проверка расчета длины стороны
     * @throws Exception
     */
    @Test
    public void getSideATest() throws Exception {
        assertThat(this.triangle.getSideA(), is(3.0));
    }

    /**
     * Проверка расчета длины стороны
     * @throws Exception
     */
    @Test
    public void getSideBTest() throws Exception {
        assertThat(this.triangle.getSideB(), is(5.0));
    }

    /**
     * Проверка расчета длины стороны
     * @throws Exception
     */
    @Test
    public void getSideCTest() throws Exception {
        assertThat(this.triangle.getSideC(), is(4.0));
    }
    /**
     * Проерка расчета площади равнобедренно прямоугольного треугольника
     * @throws Exception
     */
    @Test
    public void areaTriangelOne() throws Exception {

        this.p1.x =  0; this.p1.y =  0;
        this.p2.x =  0; this.p2.y =  10;
        this.p3.x = 10; this.p3.y =  10;

        this.triangle = new Triangle(this.p1, this.p2, this.p3);

        assertThat(this.triangle.area(), is(50.0));
    }

    @Test
    public void areaTriangelTwo() throws Exception {
        this.p1.x =  1; this.p1.y =  1;
        this.p2.x = -3; this.p2.y =  4;
        this.p3.x = -2; this.p3.y = -2;

        this.triangle = new Triangle(this.p1, this.p2, this.p3);

        this.real_value = new BigDecimal(this.triangle.area()).setScale(1, RoundingMode.HALF_UP).doubleValue();
        assertThat(this.real_value, is(10.5));
    }
    @Test
    public void areaTriangelNotExist() throws Exception {
        this.p1.x = 0; this.p1.y = 0;
        this.p2.x = 0; this.p2.y = 0;

        this.triangle = new Triangle(this.p1, this.p2, this.p3);
        // Такого треугольника не должно сущестовать
        assertThat(this.triangle.area(), is(-1.0));
    }

}