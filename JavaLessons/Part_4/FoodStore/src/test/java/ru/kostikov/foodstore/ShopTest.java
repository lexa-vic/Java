package ru.kostikov.foodstore;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 07.09.2016.
 */
public class ShopTest {
    @Test
    public void foodRequirementsFalse() throws Exception {
        Food milk = new Food("Milk");
        Store shop = new Shop();
        boolean expect = false;
        boolean result = true;

        shop.setCurrentDate("2016-09-07");
        milk.setExpireDate("2016-10-03").setCreateDate("2016-09-03");
        result = shop.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

    @Test
    public void foodRequirementsFalse75() throws Exception {
        Food milk = new Food("Milk");
        Store shop = new Shop();
        boolean expect = false;
        boolean result = true;

        shop.setCurrentDate("2016-09-27");
        milk.setExpireDate("2016-10-03").setCreateDate("2016-09-03");
        result = shop.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

    @Test
    public void foodRequirementsTrue() throws Exception {
        Food milk = new Food("Milk");
        Store shop = new Shop();
        boolean expect = true;
        boolean result = false;

        shop.setCurrentDate("2016-09-15");
        milk.setExpireDate("2016-10-05").setCreateDate("2016-09-03");
        result = shop.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

    @Test
    public void foodRequirementsTrueDiscount() throws Exception {
        Food milk = new Food("Milk");
        Store shop = new Shop();
        boolean expect = true;
        boolean result = false;

        shop.setCurrentDate("2016-09-27");
        milk.setExpireDate("2016-10-05").setCreateDate("2016-09-03");
        milk.setDiscount(10);
        result = shop.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

}