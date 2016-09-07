package ru.kostikov.foodstore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 07.09.2016.
 */
public abstract class Store {
    /** Store for a food*/
    private ArrayList<Food> foods = new ArrayList<>();

    protected long currentTime = System.currentTimeMillis();

    /**
     * Set cuurent time(date)
     * @param expireDate
     * @throws ParseException
     */
    public void setCurrentDate(String expireDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.currentTime = format.parse(expireDate).getTime();
    }

    /**
     * Adds food item to someone store.
     *
     * @param newFood
     */
    public void addFood(Food newFood) {
        this.foods.add(newFood);
    }

    /**
     * Gets all food in store.
     *
     * @return
     */
    public List<Food> getFoodList() {
        return this.foods;
    }

    /**
     * Checks the food to the store.
     * @return
     */
    abstract boolean foodRequirements(Food food);


}
