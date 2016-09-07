package ru.kostikov.foodstore;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 07.09.2016.
 */
public class WarehouseTest {
    @Test
    public void addFood() throws Exception {
        Food milk = new Food("Milk");
        Food result = null;
        Store warehouse = new Warehouse();
        warehouse.addFood(milk);
        result = warehouse.getFoodList().get(0);

        assertThat(milk,  is(result));
    }

    @Test
    public void foodRequirementsTrue() throws Exception {
        Food milk = new Food("Milk");
        Store warehouse = new Warehouse();
        boolean expect = true;
        boolean result = false;

        warehouse.setCurrentDate("2016-09-07");
        milk.setExpireDate("2016-10-03").setCreateDate("2016-09-03");
        result = warehouse.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

    @Test
    public void foodRequirementsFalse() throws Exception {
        Food milk = new Food("Milk");
        Store warehouse = new Warehouse();
        boolean expect = false;
        boolean result = true;

        warehouse.setCurrentDate("2016-09-07");
        milk.setExpireDate("2016-09-05").setCreateDate("2016-09-03");
        result = warehouse.foodRequirements(milk);

        assertThat(expect,  is(result));
    }

}