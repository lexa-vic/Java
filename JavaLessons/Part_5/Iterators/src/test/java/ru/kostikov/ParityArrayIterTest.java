package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 07.10.2016.
 */
public class ParityArrayIterTest {

    @Test
    public void whenArrayHasEvenNumbersThenIteratorsGiveIt(){
        int[] array = new int[]{1, 3, 2, 4, 5, 6, 8, 9, 11, 14, 12};
        int[] expectedArray = new int[]{2, 4, 6, 8, 14, 12};
        int[] resultArray = new int[expectedArray.length];

        ParityArrayIter it = new ParityArrayIter(array);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = (int)it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenArrayHasNotEvenNumbersAndThenIteratorsGiveNoNum(){
        int[] array = new int[]{1, 3};
        int[] expectedArray = new int[]{0};
        int[] resultArray = new int[expectedArray.length];

        ParityArrayIter it = new ParityArrayIter(array);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = (int)it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayNotUsehasNextAndThenThrowsExeption(){
        int[] array = new int[]{1,2, 3};
        int[] expectedArray = new int[]{0};

        ParityArrayIter it = new ParityArrayIter(array);
        it.next();
        it.next();
    }
}