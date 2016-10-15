package ru.kostikov;

import java.util.Iterator;

/**
 * Created by Алексей on 15.10.2016.
 */
public class SimpleLinkedSet<E> extends SimpleLinkedList<E> {

    public SimpleLinkedSet() {
        super();
    }

    /**
     * Add new item
     *
     * @param e - new item
     */
    @Override
    public void add(E e) {
        boolean result = true;
        Iterator<E> it = super.iterator();

        while(it.hasNext()){
            if (it.next().equals(e)){
                result = false;
            }
        }

        if (result){
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
