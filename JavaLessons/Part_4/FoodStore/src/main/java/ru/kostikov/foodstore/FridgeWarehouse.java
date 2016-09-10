package ru.kostikov.foodstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10.09.2016.
 */
public class FridgeWarehouse extends ReproductStore{
    private double expired = 1.0;

    /**
     * This class receive only food for reproduct
     * @param food
     * @return
     */
    @Override
    public boolean foodRequirements(Food food) {
        return false;
    }

    /**
     * Checks the food to the store.
     *
     * @param food
     * @return
     */
    public boolean foodRequirements(ReproductFood food) {
        boolean result = false;
        long lifeTime = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        long pastTime = currentTime - food.getCreateDate().getTime();
        double percents = (double) pastTime/lifeTime;

        if (percents >= this.expired &&
            food.getReproductFlag()){
            result = true;
        }
        return result;
    }
}
