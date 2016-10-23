package ru.kostikov;

import java.util.*;

/**
 * Created by Алексей on 18.10.2016.
 */
public class SimpleArraySortedSet<E extends Comparable> extends SimpleLinkedList<E> {
    public SimpleArraySortedSet() {
        super();
    }

//    public SimpleArraySortedSet(int size) {
//        super(size);
//    }

    List<E> list = new LinkedList<E>();
    int index = 0;

    /**
     * Add new item at end of array
     *
     * @param e - new item
     */
    @Override
    public void add(E e) {
        if (Collections.binarySearch(list, e, null) < 0) {
            list.add(e);
            Collections.sort(list);
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
