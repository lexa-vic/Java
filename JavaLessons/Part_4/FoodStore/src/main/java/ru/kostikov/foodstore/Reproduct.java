package ru.kostikov.foodstore;

/**
 * Created by user on 10.09.2016.
 */
public interface Reproduct {
    /**
     * Reads, is this product reproducted.
     * @return boolean
     */
    boolean getReproductFlag();

    /**
     *  Sets the product reproducted.
     */
    void setReproductFlag(boolean value);
}
