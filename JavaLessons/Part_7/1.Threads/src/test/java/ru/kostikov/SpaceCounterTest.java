package ru.kostikov;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 31.10.2016.
 */
public class SpaceCounterTest {

    @Test
    public void whenInputStringWhisSpacesThenOutputCountSpace(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream("Hi, , a b 3 ".getBytes());
        SpaceCounter spaceCounter = new SpaceCounter(baos, inputStream);
        String expected = "Space count 5\n";

        spaceCounter.count();

        Assert.assertThat(expected, is(baos.toString()));
    }

}