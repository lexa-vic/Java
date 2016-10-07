package ru.kostikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implemets array with iterator wich gets only even number
 * Created by Алексей on 07.10.2016.
 */
public class ParityArrayIter implements Iterator {

    private int[] array;
    private int index = 0;

    public ParityArrayIter(int[] array) {
        this.array = array;
    }

    /**
     * Finds Even number in array
     * Ses index if find ok
     * @return true if find
     */
    private boolean findEvenNum(){
        boolean result = false;

        for (;this.index < this.array.length; this.index++){
            if ((this.array[this.index] % 2) == 0 && this.array[this.index] != 0){
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
        return this.findEvenNum();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        boolean result = this.findEvenNum();

        if (!result){
            throw new NoSuchElementException();
        }

        return this.array[this.index++];
    }
}
