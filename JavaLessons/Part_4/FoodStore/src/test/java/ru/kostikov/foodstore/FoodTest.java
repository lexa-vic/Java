package ru.kostikov.foodstore;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 07.09.2016.
 */
public class FoodTest {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void setExpireDate() throws Exception {
        String expected = "2016-09-03" ;
        String result = "";
        Food milk = new Food("Milk");
        milk.setExpireDate(expected);

        result = format.format(milk.getExpireDate());

        assertThat(expected,  is(result));
    }

    @Test(expected=ParseException.class)
    public void setExpireDateException() throws Exception {
        String expected = "2016" ;
        String result = "";
        Food milk = new Food("Milk");
        milk.setExpireDate(expected);
    }

    @Test
    public void setCreateDate() throws Exception {
        String expected = "2016-09-03" ;
        String result = "";
        Food milk = new Food("Milk");
        milk.setCreateDate(expected);

        result = format.format(milk.getCreateDate());

        assertThat(expected,  is(result));
    }

    @Test(expected=ParseException.class)
    public void setCreateDateException() throws Exception {
        String expected = "2016" ;
        String result = "";
        Food milk = new Food("Milk");
        milk.setExpireDate(expected);
    }

}