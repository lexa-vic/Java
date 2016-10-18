package ru.kostikov;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Алексей on 18.10.2016.
 */
public class SimpleArraySortedSet<E> extends SimpleArrayList<E> {
    public SimpleArraySortedSet() {
        super();
    }

    public SimpleArraySortedSet(int size) {
        super(size);
    }

    /**
     * Add new item at end of array
     *
     * @param e - new item
     */
    @Override
    public void add(E e) {
        Arrays.sort(super.array, 0, super.index);
        if (Arrays.binarySearch(super.array, 0, super.index, e) < 0) {
            super.add(e);
        }
    }

    /**
     * Add new item by index
     *
     * @param index
     * @param e     - new item
     */
    @Override
    public void add(int index, E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets element by index
     *
     * @param index index of element
     * @return element value
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Deletes element from array
     *
     * @param index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void delete(int index) {
        throw new UnsupportedOperationException();
    }
}
