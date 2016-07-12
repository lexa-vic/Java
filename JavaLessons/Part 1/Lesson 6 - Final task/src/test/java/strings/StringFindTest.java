package strings;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 12.07.2016.
 */
public class StringFindTest {
    /**
     * Проверка вхождения подстроки в строку
     * @throws Exception
     */
    @Test
    public void containsTrue() throws Exception {
        boolean result = false;
        String origin  = "ab bc cd de ef";
        String sub     = "de";

        StringFind stringSub = new StringFind();

        result = stringSub.contains(origin, sub);

        assertThat(result, is(true));
    }

    /**
     * Проверка вхождения подстроки в строку
     * @throws Exception
     */
    @Test
    public void containsFalse() throws Exception {
        boolean result = false;
        String origin  = "ab bc cd de ef";
        String sub     = "xd";

        StringFind stringSub = new StringFind();

        result = stringSub.contains(origin, sub);

        assertThat(result, is(false));
    }

    /**
     * Проверка вхождения подстроки в строку
     * @throws Exception
     */
    @Test
    public void containsSame() throws Exception {
        boolean result = false;
        String origin  = "ab bc cd de ef";
        String sub     = "ab bc cd de ef";

        StringFind stringSub = new StringFind();

        result = stringSub.contains(origin, sub);

        assertThat(result, is(true));
    }

    /**
     * Проверка вхождения подстроки в строку
     * @throws Exception
     */
    @Test
    public void containsNull() throws Exception {
        boolean result = false;
        String origin  = "ab bc cd de ef";
        String sub     = "";

        StringFind stringSub = new StringFind();

        result = stringSub.contains(origin, sub);

        assertThat(result, is(false));
    }

}