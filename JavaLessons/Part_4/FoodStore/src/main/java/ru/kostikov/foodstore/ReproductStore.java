package ru.kostikov.foodstore;

/**
 * Created by user on 10.09.2016.
 */
public abstract class ReproductStore extends Store {
    /**
     * Checks the food to the store.
     *
     * @param food
     * @return
     */
    abstract boolean foodRequirements(ReproductFood food);
}
