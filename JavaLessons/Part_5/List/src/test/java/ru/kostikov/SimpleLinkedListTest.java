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
public class SimpleLinkedListTest {

    @Test
    public void whenAddNewItemThenGetsNewItem(){
        SimpleContainer<Integer> list = new SimpleLinkedList<>();

        list.add(1);
        int result = list.get(0);

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenAddNewItemInCenterThenGetsNewItem(){
        SimpleContainer<Integer> list = new SimpleLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2, 5);
        int result = list.get(2);

        Assert.assertThat(result, is(5));
    }

    @Test
    public void whenAddNewItemInCenterThenGetsOffsetItemCorrect(){
        SimpleContainer<Integer> list = new SimpleLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2, 5);
        int result = list.get(3);

        Assert.assertThat(result, is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDeleteLastItemThenGetsNullIn(){
        SimpleContainer<Integer> list = new SimpleLinkedList<>();

        list.add(1);
        list.delete(0);
        list.get(0);
    }

    @Test
    public void whenAddMoreThanSizetThenGetsLastItemCorrect(){
        SimpleContainer<Integer> list = new SimpleLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Integer result = list.get(2);

        Assert.assertThat(result, is(3));
    }

    @Test
    public void whenArrayHasElementThenIteratorsGiveIt(){
        SimpleContainer<Integer> list = new SimpleLinkedList<>();
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
        SimpleContainer<Integer> list = new SimpleLinkedList<>();
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
        SimpleContainer<Integer> list = new SimpleLinkedList<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = list.iterator();

        it.next();
        it.next();
        it.next();
    }

}