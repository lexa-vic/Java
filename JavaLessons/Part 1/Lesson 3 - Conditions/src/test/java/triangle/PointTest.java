package triangle;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 08.07.2016.
 */
public class PointTest {
    private double distance;
    private Point p1;
    private Point p2;

    /**
     * Инициализация тестов, создание объектов точек
     * @throws Exception
     */
    @Before
    public void distanceToInit() throws Exception {
        this.p1 = new Point(0, 0);
        this.p2 = new Point(0, 0);
    }
    /**
     * Проверка рачета дистанции
     * @throws Exception
     */
    @Test
    public void distanceTo() throws Exception {

        this.p1.x = 1; this.p1.y = 1;
        this.p2.x = 1; this.p2.y = 2;

        this.distance = this.p1.distanceTo(this.p2);
        assertThat(this.distance, is(1.0));

    }

    /**
     * Дистанция между точками в обратную сторону
     * @throws Exception
     */
    @Test
    public void reverseDistanceTo() throws Exception {
        this.p1.x = 1; this.p1.y = 1;
        this.p2.x = 1; this.p2.y = 2;

        this.distance = this.p2.distanceTo(this.p1);
        assertThat(this.distance, is(1.0));
    }

    /**
     * Нулевая дистанция
     * @throws Exception
     */
    @Test
    public void zeroDistanceTo() throws Exception {

        this.p1.x = 0; this.p1.y = 0;
        this.p2.x = 0; this.p2.y = 0;

        this.distance = this.p1.distanceTo(this.p2);
        assertThat(this.distance, is(0.0));
    }

    /**
     * Дистнация с отрицательной координатой точки
     * @throws Exception
     */
    @Test
    public void negativCoordinateDistanceTo() throws Exception {
        this.p1.x = 0; this.p1.y = 0;
        this.p2.x =-1; this.p2.y = 0;

        this.distance = this.p1.distanceTo(this.p2);
        assertThat(this.distance, is(1.0));
    }
}