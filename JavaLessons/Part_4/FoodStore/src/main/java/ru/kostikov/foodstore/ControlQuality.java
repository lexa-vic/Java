package ru.kostikov.foodstore;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Алексей on 07.09.2016.
 */
public class ControlQuality {

    private ArrayList<Store> stores;

    public ControlQuality(ArrayList<Store> stores){
        this.stores = stores;
    }

    /**
     * Checks quality and put into any store
     * @param food
     */
    public void checkFoodQuality(Food food){
        boolean result = false;

        do {
            for (Store st :stores) {
                if (st.foodRequirements(food)){
                    st.addFood(food);
                    result = true;
                    break;
                }
            }
            if (!result && food.getDiscount() != 0){
                // No add operation to tores
                result = true;
            }else if (!result){
                // Gets discount
                food.setDiscount(10);
            }
        }while(!result);

    }
}
