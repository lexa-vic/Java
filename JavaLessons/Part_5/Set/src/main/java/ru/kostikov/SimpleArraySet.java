package ru.kostikov;



import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Алексей on 15.10.2016.
 */
public class SimpleArraySet<E> extends SimpleArrayList<E> {
    public SimpleArraySet() {
        super();
    }

    public SimpleArraySet(int size) {
        super(size);
    }

    /**
     * Add new item at end of array
     *
     * @param e - new item
     */
    @Override
    public void add(E e) {

        if (!Arrays.asList(super.array).contains(e)){
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
