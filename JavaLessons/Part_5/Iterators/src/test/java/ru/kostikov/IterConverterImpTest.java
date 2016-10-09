package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 09.10.2016.
 */
public class IterConverterImpTest {
    @Test
    public void whenThreeIteratorsInputThenOneSumOfItsOutpu(){
        List<Integer> array1 =  Arrays.asList( new Integer[]{4, 2, 0, 4, 6, 4, 9});
        List<Integer> array2 =  Arrays.asList( new Integer[]{0, 9, 8, 7, 5});
        List<Integer> array3 =  Arrays.asList( new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4});
        int[] resultArray = new int[array1.size() + array2.size() + array3.size()];
        int[] expectArray = new int[]{4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4};

        List<Iterator<Integer>> iterators = Arrays.asList(new Iterator[]{array1.iterator(), array2.iterator(), array3.iterator()});

        IterConverter iterConverter = new IterConverterImp();
        Iterator<Integer> convertIter = iterConverter.convert(iterators.iterator());

        int i = 0;
        while(convertIter.hasNext()){
            resultArray[i++] = convertIter.next();
        }

        Assert.assertThat(expectArray, is(resultArray));
    }
}