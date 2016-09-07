package ru.kostikov.foodstore;

import java.util.List;

/**
 * Created by Алексей on 07.09.2016.
 */
public class Shop extends Store {
    private double expired_low = 0.25;
    private double expired_hi = 0.75;
    private double trash = 1.00;

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

        if ((percents <= this.expired_hi && percents >= this.expired_low) ||
             percents >= this.expired_low  &&  percents <= this.trash && food.getDiscount() != 0x00){
            result = true;
        }
        return result;
    }
}
