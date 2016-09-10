package ru.kostikov.foodstore;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 10.09.2016.
 */
public class ControlQualityReproductTest {
    ArrayList<Store> stores = new ArrayList<>();
    ArrayList<ReproductStore> repStores = new ArrayList<>();
    Food milk = new Food("Milk");
    Food bread = new Food("Bread");
    Food meat = new Food("Pork");
    ReproductFood apple = new ReproductFood("Apple");

    Store shop = new Shop();
    Store trash = new Trash();
    Store warehouse = new Warehouse();
    ReproductStore fridgeWarehouse = new FridgeWarehouse();

    @Before
    public void init() throws ParseException {

        shop.setCurrentDate("2016-09-07");
        trash.setCurrentDate("2016-09-07");
        warehouse.setCurrentDate("2016-09-07");
        fridgeWarehouse.setCurrentDate("2016-09-07");

        this.repStores.add(fridgeWarehouse);
        this.stores.add(shop);
        this.stores.add(trash);
        this.stores.add(warehouse);


        apple.setReproductFlag(true);
        apple.setExpireDate("2016-09-06").setCreateDate("2016-09-01");

        milk.setExpireDate("2016-10-03").setCreateDate("2016-09-03");
        bread.setExpireDate("2016-09-06").setCreateDate("2016-09-01");
        meat.setExpireDate("2016-09-09").setCreateDate("2016-08-01");
    }

    @Test
    public void checkFoodQualityWarehouse() throws Exception {
        Food expect = milk;
        Food result = null;
        ControlQualityReproduct controlQuality = new ControlQualityReproduct(this.stores);

        controlQuality.checkFoodQuality(milk);
        result = warehouse.getFoodList().get(0);

        assertThat(expect,  is(result));
    }

    @Test
    public void checkFoodQualityTrash() throws Exception {
        Food expect = bread;
        Food result = null;
        ControlQualityReproduct controlQuality = new ControlQualityReproduct(this.stores);

        controlQuality.checkFoodQuality(bread);
        result = trash.getFoodList().get(0);

        assertThat(expect,  is(result));
    }

    @Test
    public void checkFoodQualityShop() throws Exception {
        Food expect = meat;
        Food result = null;
        ControlQualityReproduct controlQuality = new ControlQualityReproduct(this.stores);

        controlQuality.checkFoodQuality(meat);
        result = shop.getFoodList().get(0);

        assertThat(expect,  is(result));
    }

    @Test
    public void checkFoodQualityFridgeWarehouse() throws Exception {
        Food expect = apple;
        Food result = null;
        ControlQualityReproduct controlQuality = new ControlQualityReproduct(this.stores);
        controlQuality.setReproductStores(this.repStores);

        controlQuality.checkFoodQuality(apple);
        result = fridgeWarehouse.getFoodList().get(0);

        assertThat(expect,  is(result));
    }

}