package ru.kostikov;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;

public class OrderCalcTest {

    @Test
    public void testPrint() {
        Order first = new Order("BUY", 120.0f, 10, 1);
        Order second = new Order("BUY", 110.0f, -10, 2);
        Order third = new Order("BUY", 100.0f, 10, 3);
        Order fourth = new Order("BUY", 90.0f, -10, 4);

        Set<Order> orders = new HashSet<>();
        orders.add(first);
        orders.add(second);
        orders.add(third);
        orders.add(fourth);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        OrderCalc orderCalc = new OrderCalc(orders, baos);
        orderCalc.printResult();


        String expected = Joiner.on("").join("BID       |PRICE     |ASK       \r\n",
                "10        |120.0     |          \r\n",
                "          |110.0     |10        \r\n",
                "10        |100.0     |          \r\n",
                "          |90.0      |10        \r\n"
        );
        String outStr = baos.toString();

        Assert.assertThat(expected, is(outStr));
    }

    @Test
    public void whenBuyMoreThanSellShouldBid() {
        Order first = new Order("SELL", 120.0f, 10, 1);
        Order second = new Order("BUY", 120.0f, 10, 2);
        Order third = new Order("BUY", 120.0f, 10, 3);

        Set<Order> orders = new HashSet<>();
        orders.add(first);
        orders.add(second);
        orders.add(third);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        OrderCalc orderCalc = new OrderCalc(orders, baos);
        orderCalc.printResult();

        String expected = Joiner.on("").join("BID       |PRICE     |ASK       \r\n",
                                             "10        |120.0     |          \r\n"
                                             );
        String outStr = baos.toString();

        Assert.assertThat(expected, is(outStr));
    }

    @Test
    public void whenStackSellMoreThanBuyShouldAsk() {
        Order first = new Order("BUY", 120.0f, 10, 1);
        Order second = new Order("SELL", 120.0f, 10, 2);
        Order third = new Order("SELL", 120.0f, 10, 3);

        Set<Order> orders = new HashSet<>();
        orders.add(first);
        orders.add(second);
        orders.add(third);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        OrderCalc orderCalc = new OrderCalc(orders, baos);
        orderCalc.printResult();

        String expected = Joiner.on("").join("BID       |PRICE     |ASK       \r\n",
                                             "          |120.0     |10        \r\n"
                                            );
        String outStr = baos.toString();

        Assert.assertThat(expected, is(outStr));
    }

}