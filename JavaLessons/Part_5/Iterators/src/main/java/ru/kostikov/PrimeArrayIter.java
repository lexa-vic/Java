package ru.kostikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Алексей on 09.10.2016.
 */
public class PrimeArrayIter implements Iterator {
    private int[] array;
    private int index = 0;

    public PrimeArrayIter(int[] array) {
        this.array = array;
    }

    /**
     * Checks is it number simple
     * @param k number
     * @return  true - number is sumple
     */
    public boolean isSimple (int k) {
        if (k % 2 == 0 && k != 2) return false;

        int maxDiv = (int) Math.sqrt(k);
        for (int i = 3; i <= maxDiv; i+=2) {
            if (k % i == 0) return false;
        }
        return true;
    }

    /**
     * Finds Even number in array
     * Ses index if find ok
     * @return true if find
     */
    private boolean findSimpleNum(){
        boolean result = false;

        for (;this.index < this.array.length; this.index++){
            if (isSimple(this.array[this.index])){
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return this.findSimpleNum();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        boolean result = this.findSimpleNum();

        if (!result){
            throw new NoSuchElementException();
        }

        return this.array[this.index++];
    }
}
