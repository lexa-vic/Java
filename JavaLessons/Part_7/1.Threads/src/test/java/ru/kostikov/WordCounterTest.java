package ru.kostikov;

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
public class WordCounterTest {
    @Test
    public void whenInputStringWhisSpacesThenOutputCountWords(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream("Hi, hello welcome ".getBytes());
        WordCounter spaceCounter = new WordCounter(baos, inputStream);
        String expected = "Word count 3\n";

        spaceCounter.run();

        Assert.assertThat(expected, is(baos.toString()));
    }
}