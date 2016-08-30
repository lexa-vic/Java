package array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Алексей on 11.07.2016.
 */
public class ArrayInit {

    public static void main(String[] args) {
        int[] inBuf     = new int[] {3, 5, 1, 2, 10};
        int[] expectBuf = new int[] {1, 2, 3, 5, 10};

        ArrayExample arrayChange = new ArrayExample();

        arrayChange.sort(inBuf);
        Arrays.equals(inBuf, expectBuf);
        int[][] inBuf2     = new int[][] {{1, 2}, {3, 4}};
        arrayChange.rotate(inBuf2);

    }
}
