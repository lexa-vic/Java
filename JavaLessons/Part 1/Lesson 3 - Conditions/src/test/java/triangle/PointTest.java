package triangle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 08.07.2016.
 */
public class PointTest {
    /**
     * Проверка рачета дистанции
     * @throws Exception
     */
    @Test
    public void distanceTo() throws Exception {

        double distance;
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);

        distance = p1.distanceTo(p2);
        assertThat(distance, is(1.0));

        distance = p2.distanceTo(p1);
        assertThat(distance, is(1.0));

        p1.x = 0; p1.y = 0;
        p2.x = 0; p2.y = 0;

        distance = p1.distanceTo(p2);
        assertThat(distance, is(0.0));

        p2.x = -1;

        distance = p1.distanceTo(p2);
        assertThat(distance, is(1.0));
    }

}