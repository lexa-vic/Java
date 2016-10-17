package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 17.10.2016.
 */
public class HandBookTest {


    @Test
    public void whenAddNewItemThenGetsNewItem(){
        HandBook<String, Integer> book = new HandBook<>();

        book.insert("First", 1);
        int result = book.get("First");

        Assert.assertThat(result, is(1));
    }

    @Test
    public void whenRewriteItemThenGetsNewValue(){
        HandBook<String, Integer> book = new HandBook<>();

        book.insert("First", 1);
        book.insert("Second", 2);
        book.insert("First", 11);
        int result = book.get("First");

        Assert.assertThat(result, is(11));
    }

    @Test
    public void whenDeletesItemThenNoDeletedItem(){
        HandBook<String, Integer> book = new HandBook<>();

        book.insert("First", 1);
        book.insert("Second", 2);

        book.delete("First");

        Integer result = book.get("First");
        Integer expected = null;

        Assert.assertThat(result, is(expected));
    }


    @Test
    public void whenArrayHasElementThenIteratorsGiveIt(){
        HandBook<String, Integer> book = new HandBook<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        book.insert("First", 1);
        book.insert("Second", 2);
        book.insert("Third", 3);

        Iterator<Integer> it = book.iterator();

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }
        Arrays.sort(resultArray);

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenArrayHasNotEvenNumbersAndThenIteratorsGiveNoNum(){
        HandBook<String, Integer> book = new HandBook<>();
        Integer[] expectedArray = new Integer[3];
        Integer[] resultArray = new Integer[3];

        Iterator<Integer> it = book.iterator();

        int i = 0;
        while (it.hasNext()){
            resultArray[i++] = it.next();
        }

        Assert.assertThat(expectedArray, is(resultArray));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayHasNotElementThenThrowsExeption(){
        HandBook<String, Integer> book = new HandBook<>();
        int[] expectedArray = new int[]{1, 2, 3};
        int[] resultArray = new int[3];

        Iterator<Integer> it = book.iterator();

        it.next();
        it.next();
        it.next();
    }
}