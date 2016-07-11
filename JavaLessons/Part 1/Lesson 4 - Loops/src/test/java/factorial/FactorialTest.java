package factorial;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 11.07.2016.
 */
public class FactorialTest {

    @Test
    public void calculateFactorial() throws Exception {
        Factorial n = new Factorial(5);

        assertThat(n.calculate(), is(120));
    }
    @Test
    public void calculateFactorialZero() throws Exception {
        Factorial n = new Factorial(0);

        assertThat(n.calculate(), is(1));
    }

}