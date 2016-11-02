package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 02.11.2016.
 */
public class CounterTest {

    @Test
    public void whenTwoThreadsIncrementsOneCounter(){
        Counter counter = new Counter();
        Runnable cntIncrement = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++){
                    counter.increment();
                }
            }
        };

        Thread t1 = new Thread(cntIncrement);
        Thread t2 = new Thread(cntIncrement);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int expected = 20_000;
        int result = counter.getCounter();
        Assert.assertThat(expected, is(result));
    }

}