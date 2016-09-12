package ru.kostikov.foodstore;

import java.util.ArrayList;

/**
 * Created by user on 10.09.2016.
 */
public class ControlQualityReproduct extends ControlQuality {
    private ArrayList<ReproductStore> reproductStores;

    public ControlQualityReproduct(ArrayList<Store> stores) {
        super(stores);

    }

    /**
     * Add reproduct sores
     * @param stores
     */
    public void setReproductStores(ArrayList<ReproductStore> stores) {
        this.reproductStores = stores;
    }

    /**
     * * Checks quality for reproduct food and put into any store
     * @param food
     */
    public void checkFoodQuality(ReproductFood food) {
        boolean result = false;
        for (ReproductStore st :reproductStores) {
            if (st.foodRequirements(food)){
                st.addFood(food);
                result = true;
                break;
            }
        }
        if(!result){
            super.checkFoodQuality(food);
        }
    }
}
