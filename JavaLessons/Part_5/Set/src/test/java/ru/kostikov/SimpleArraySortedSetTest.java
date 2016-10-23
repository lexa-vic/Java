package ru.kostikov;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 18.10.2016.
 */
public class SimpleArraySortedSetTest {
    @Test
    public void whenAddNewItemThenGetsNewItem(){
        SimpleArraySortedSet<Integer> set = new SimpleArraySortedSet<>();

        set.add(1);

        Iterator<Integer> it = set.iterator();

        int result = it.next();

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenAddTwoSameItemThenSameNorAdd(){
        SimpleArraySortedSet<Integer> set = new SimpleArraySortedSet<>();

        set.add(1);
        set.add(1);
        set.add(3);

        Iterator<Integer> it = set.iterator();
        it.next();
        int result = it.next();

        Assert.assertThat(result, is(3));
    }

    @Test
    public void whenSetHasElementThenIteratorsPollIt(){
        SimpleArraySortedSet<Integer> set = new SimpleArraySortedSet<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = set.iterator();

        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenArrayHasNotEvenNumbersAndThenIteratorsGiveNoNum(){
        SimpleArraySortedSet<Integer> set = new SimpleArraySortedSet<>();
        Integer[] expectedArray = new Integer[3];
        Integer[] resultArray = new Integer[3];

        Iterator<Integer> it = set.iterator();

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayHasNotElementThenThrowsExeption(){
        SimpleArraySortedSet<Integer> set = new SimpleArraySortedSet<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = set.iterator();

        it.next();
        it.next();
        it.next();
    }
    @Test
    public void SpeedTest() throws Exception {
        SimpleArraySortedSet<Integer> set= new SimpleArraySortedSet<>();

        Random r = new Random();
        for(int index = 0 ; index < 50000 ; index ++ ){
            set.add(r.nextInt(index+1));
        }
    }
}