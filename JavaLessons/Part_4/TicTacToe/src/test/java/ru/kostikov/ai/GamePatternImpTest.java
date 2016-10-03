package ru.kostikov.ai;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Алексей on 27.09.2016.
 */
public class GamePatternImpTest {
    GamePatternImp gamePatternImp = new GamePatternImp(3, 1);


    @Test
    public void whenPatternXXXThenScore10000() throws Exception {
        int expectedScore = 10000;
        int resultScore = gamePatternImp.getLineScore("111");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

    @Test
    public void whenPattern0XX0ThenScore1000() throws Exception {
        int expectedScore = 1000;
        int resultScore = gamePatternImp.getLineScore("0011010");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

    @Test
    public void whenPatternXX0ThenScore500() throws Exception {
        int expectedScore = 500;
        int resultScore = gamePatternImp.getLineScore("11001");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

    @Test
    public void whenPatternX0XThenScore400() throws Exception {
        int expectedScore = 400;
        int resultScore = gamePatternImp.getLineScore("101");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

    @Test
    public void whenPattern00X000ThenScore100() throws Exception {
        int expectedScore = 100;
        int resultScore = gamePatternImp.getLineScore("001000");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

    @Test
    public void whenPattern00X00ThenScore100() throws Exception {
        int expectedScore = 80;
        int resultScore = gamePatternImp.getLineScore("100100");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

    @Test
    public void whenPattern0X00ThenScore100() throws Exception {
        int expectedScore = 75;
        int resultScore = gamePatternImp.getLineScore("0100");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

    @Test
    public void whenPattern0X0ThenScore100() throws Exception {
        int expectedScore = 50;
        int resultScore = gamePatternImp.getLineScore("010");

        Assert.assertThat(expectedScore, is(resultScore) );
    }

}