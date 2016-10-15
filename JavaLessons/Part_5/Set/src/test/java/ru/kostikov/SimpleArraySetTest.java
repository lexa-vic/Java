package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 15.10.2016.
 */
public class SimpleArraySetTest {

    @Test
    public void whenAddNewItemThenGetsNewItem(){
        SimpleArraySet<Integer> set = new SimpleArraySet<>();

        set.add(1);

        Iterator<Integer> it = set.iterator();

        int result = it.next();

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenAddTwoSameItemThenSameNorAdd(){
        SimpleArraySet<Integer> set = new SimpleArraySet<>();

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
        SimpleArraySet<Integer> set = new SimpleArraySet<>();
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
        SimpleArraySet<Integer> set = new SimpleArraySet<>();
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
        SimpleArraySet<Integer> set = new SimpleArraySet<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = set.iterator();

        it.next();
        it.next();
        it.next();
    }

}