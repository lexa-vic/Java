package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 09.10.2016.
 */
public class PrimeArrayIterTest {

    @Test
    public void whenArrayHasPrimeNumbersThenIteratorsGiveIt(){
        int[] array = new int[]{3, 8, 4, 7, 11};
        int[] expectedArray = new int[]{3, 7, 11};
        int[] resultArray = new int[expectedArray.length];

        PrimeArrayIter it = new PrimeArrayIter(array);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = (int)it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenArrayHasNotEvenNumbersAndThenIteratorsGiveNoNum(){
        int[] array = new int[]{4};
        int[] expectedArray = new int[]{0};
        int[] resultArray = new int[expectedArray.length];

        PrimeArrayIter it = new PrimeArrayIter(array);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = (int)it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayNotUsehasNextAndThenThrowsExeption(){
        int[] array = new int[]{3};
        int[] expectedArray = new int[]{0};

        PrimeArrayIter it = new PrimeArrayIter(array);
        it.next();
        it.next();
    }

}