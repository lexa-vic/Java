package array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 11.07.2016.
 */
public class ArrayExampleTest {
    /**
     * Проверка сортировки
     * @throws Exception
     */
    @Test
    public void sort() throws Exception {
        int[] inBuf     = new int[] {3, 5, 1, 2, 10};
        int[] expectBuf = new int[] {1, 2, 3, 5, 10};

        ArrayExample arrayChange = new ArrayExample();

        arrayChange.sort(inBuf);

        assertThat(inBuf, is(expectBuf));
    }

    /**
     * Проверка поворота массива
     * @throws Exception
     */
    @Test
    public void rotate() throws Exception {
        int[][] inBuf     = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expectBuf = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
 
        ArrayExample arrayChange = new ArrayExample();

        inBuf = arrayChange.rotate(inBuf);

        assertThat(inBuf, is(expectBuf));
    }

    /**
     * Проверка удаления повторений строк
     * @throws Exception
     */
    @Test
    public void duplicateDelete() throws Exception {
        String[] inBuf     = new String[] {"abc", "qwe", "abc", "zxc", "zxc"};
        String[] expectBuf = new String[] {"abc", "qwe", "zxc", "", ""};

        ArrayExample arrayChange = new ArrayExample();

        arrayChange.duplicateDelete(inBuf);

        assertThat(inBuf, is(expectBuf));
    }

}