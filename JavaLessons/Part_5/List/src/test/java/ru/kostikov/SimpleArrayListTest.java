package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 12.10.2016.
 */
public class SimpleArrayListTest {

    @Test
    public void whenAddNewItemThenGetsNewItem(){
        SimpleContainer<Integer> list = new SimpleArrayList<>();

        list.add(1);
        int result = list.get(0);

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenDeleteLastItemThenGetsNullIn(){
        SimpleContainer<Integer> list = new SimpleArrayList<>();

        list.add(1);
        list.delete(0);
        Integer result = list.get(0);
        Integer expect = null;

        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenAddMoreThanSizetThenGetsLastItemCorrect(){
        SimpleContainer<Integer> list = new SimpleArrayList<>(1);

        list.add(1);
        list.add(2);
        list.add(3);

        Integer result = list.get(2);

        Assert.assertThat(result, is(3));
    }

    @Test
    public void whenArrayHasElementThenIteratorsGiveIt(){
        SimpleContainer<Integer> list = new SimpleArrayList<>(3);
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = list.iterator();

        list.add(1);
        list.add(2);
        list.add(3);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenArrayHasNotEvenNumbersAndThenIteratorsGiveNoNum(){
        SimpleContainer<Integer> list = new SimpleArrayList<>(3);
        Integer[] expectedArray = new Integer[3];
        Integer[] resultArray = new Integer[3];

        Iterator<Integer> it = list.iterator();

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayHasNotElementThenThrowsExeption(){
        SimpleContainer<Integer> list = new SimpleArrayList<>(3);
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = list.iterator();

        it.next();
        it.next();
        it.next();
    }




}