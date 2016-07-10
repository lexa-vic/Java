package triangle;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 10.07.2016.
 */
public class MaxSideTest {
    @Test
    public void max() throws Exception {

        MaxSide maxSide = new MaxSide();

        assertThat(maxSide.max(20.0, 10.0), is(20.0));
    }

}