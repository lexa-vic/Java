package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 13.10.2016.
 */
public class SimpleLinkedQueueTest {
    @Test
    public void whenAddItemsThenPollFirstItem(){
        SimpleQueue<Integer> queue = new SimpleLinkedQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        int result = queue.poll();

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenAddItemsPollFirstThenFirsItemDeletes(){
        SimpleQueue<Integer> queue = new SimpleLinkedQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.poll();
        int result = queue.poll();

        Assert.assertThat(result, is(2));
    }

    @Test
    public void whenAddItemsThenPeekFirstItem(){
        SimpleQueue<Integer> queue = new SimpleLinkedQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        int result = queue.peek();

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenAddItemsPeekFirstThenFirsNotItemDeletes(){
        SimpleQueue<Integer> queue = new SimpleLinkedQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.peek();
        int result = queue.peek();

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenArrayHasElementThenIteratorsPollIt(){
        SimpleQueue<Integer> queue = new SimpleLinkedQueue<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = queue.iterator();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenArrayHasNotEvenNumbersAndThenIteratorsGiveNoNum(){
        SimpleQueue<Integer> queue = new SimpleLinkedQueue<>();
        Integer[] expectedArray = new Integer[3];
        Integer[] resultArray = new Integer[3];

        Iterator<Integer> it = queue.iterator();

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayHasNotElementThenThrowsExeption(){
        SimpleQueue<Integer> queue = new SimpleLinkedQueue<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = queue.iterator();

        it.next();
        it.next();
        it.next();
    }
}