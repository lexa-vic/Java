package ru.kostikov.foodstore;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 07.09.2016.
 */
public class TrashTest {
    @Test
    public void foodRequirementsFalse() throws Exception {
        Food milk = new Food("Milk");
        Store trash = new Trash();
        boolean expect = false;
        boolean result = true;

        trash.setCurrentDate("2016-09-07");
        milk.setExpireDate("2016-10-03").setCreateDate("2016-09-03");
        result = trash.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

    @Test
    public void foodRequirementsTrue() throws Exception {
        Food milk = new Food("Milk");
        Store trash = new Trash();
        boolean expect = true;
        boolean result = false;

        trash.setCurrentDate("2016-09-07");
        milk.setExpireDate("2016-09-05").setCreateDate("2016-09-03");
        result = trash.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

}