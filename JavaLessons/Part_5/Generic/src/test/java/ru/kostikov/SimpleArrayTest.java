package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 10.10.2016.
 */
public class SimpleArrayTest {

    @Test
    public void whenAddSimplListStringThenGetSameString(){
        SimpleArray<String> array = new SimpleArray<>(2);

        array.add("Hello");
        String result = array.get(0);

        Assert.assertThat(result, is("Hello"));
    }

    @Test
    public void whenDeletLastItemThenGetsPrevItem(){
        SimpleArray<String> array = new SimpleArray<>(2);

        array.add("Hi");
        array.add("Hello");

        array.delete(1);

        String result = array.get(0);

        Assert.assertThat(result, is("Hi"));
    }

    @Test
    public void whenUpdateLastItemThenGetsNewItem(){
        SimpleArray<String> array = new SimpleArray<>(2);

        array.add("Hi");
        array.add("Hello");

        array.update(1, "Yo");

        String result = array.get(1);

        Assert.assertThat(result, is("Yo"));
    }





}