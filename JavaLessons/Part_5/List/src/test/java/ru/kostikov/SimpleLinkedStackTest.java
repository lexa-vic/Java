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
public class SimpleLinkedStackTest {
    @Test
    public void whenAddItemsThenPopFirstItem(){
        SimpleStack<Integer> stack = new SimpleLinkedStack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        int result = stack.pop();

        Assert.assertThat(result, is(3));
    }

    @Test
    public void whenAddItemsPopFirstThenFirsItemDeletes(){
        SimpleStack<Integer> stack = new SimpleLinkedStack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        stack.pop();
        int result = stack.pop();

        Assert.assertThat(result, is(2));
    }

    @Test
    public void whenAddItemsThenPeekFirstItem(){
        SimpleStack<Integer> stack = new SimpleLinkedStack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        int result = stack.peek();

        Assert.assertThat(result, is(3));
    }

    @Test
    public void whenAddItemsPeekFirstThenFirsNotItemDeletes(){
        SimpleStack<Integer> stack = new SimpleLinkedStack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        stack.peek();
        int result = stack.peek();

        Assert.assertThat(result, is(3));
    }

    @Test
    public void whenArrayHasElementThenIteratorsPollIt(){
        SimpleStack<Integer> stack = new SimpleLinkedStack<>();
        int[] expectedArray = new int[]{3, 2, 1};
        int[] resultArray = new int[3];

        Iterator<Integer> it = stack.iterator();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenArrayHasNotEvenNumbersAndThenIteratorsGiveNoNum(){
        SimpleStack<Integer> stack = new SimpleLinkedStack<>();
        Integer[] expectedArray = new Integer[3];
        Integer[] resultArray = new Integer[3];

        Iterator<Integer> it = stack.iterator();

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayHasNotElementThenThrowsExeption(){
        SimpleStack<Integer> stack = new SimpleLinkedStack<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = stack.iterator();

        it.next();
        it.next();
        it.next();
    }
}