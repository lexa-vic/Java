package ru.kostikov.foodstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 07.09.2016.
 */
public class Warehouse extends Store {

    private double expired = 0.25;

    /**
     * Checks the food to the store.
     *
     * @param food
     * @return
     */
    @Override
    public boolean foodRequirements(Food food) {
        boolean result = false;
        long lifeTime = food.getExpireDate().getTime() - food.getCreateDate().getTime();
        long pastTime = currentTime - food.getCreateDate().getTime();
        double percents = (double) pastTime/lifeTime;

        if (percents <= this.expired){
            result = true;
        }
        return result;
    }
}
