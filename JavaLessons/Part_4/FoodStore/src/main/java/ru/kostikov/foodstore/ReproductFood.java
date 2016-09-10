package ru.kostikov.foodstore;

/**
 * Created by user on 10.09.2016.
 */
public class ReproductFood extends Food implements Reproduct {
    private boolean canReproduct;
    /**
     * Constructor
     *
     * @param Name Product name
     */
    public ReproductFood(String Name) {
        super(Name);
    }

    @Override
    public boolean getReproductFlag() {
        return canReproduct;
    }

    @Override
    public void setReproductFlag(boolean value) {
        this.canReproduct = value;
    }
}
