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
public class SimpleLinkedSetTest {
    @Test
    public void whenAddNewItemThenGetsNewItem(){
        SimpleLinkedSet<Integer> set = new SimpleLinkedSet<>();

        set.add(1);

        Iterator<Integer> it = set.iterator();

        int result = it.next();

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenAddTwoSameItemThenSameNorAdd(){
        SimpleLinkedSet<Integer> set = new SimpleLinkedSet<>();

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
        SimpleLinkedSet<Integer> set = new SimpleLinkedSet<>();
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
        SimpleLinkedSet<Integer> set = new SimpleLinkedSet<>();
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
        SimpleLinkedSet<Integer> set = new SimpleLinkedSet<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = set.iterator();

        it.next();
        it.next();
        it.next();
    }
}