package ru.kostikov.syncchronizylist;

import ru.kostikov.SimpleLinkedList;

import java.util.Iterator;

/**
 * Created by Алексей on 03.11.2016.
 */
public class SynchronizedLinkedList<E> extends SimpleLinkedList<E> {

    public SynchronizedLinkedList() {
    }

    /**
     * Add new item
     *
     * @param e - new item
     */
    @Override
    public synchronized void add(E e) {
        super.add(e);
    }

    /**
     * Add new item by index
     *
     * @param index
     * @param e     - new item
     */
    @Override
    public synchronized void add(int index, E e) {
        super.add(index, e);
    }

    /**
     * Gets element by index
     *
     * @param index index of element
     * @return element value
     * @throws IndexOutOfBoundsException
     */
    @Override
    public synchronized E get(int index) {
        return super.get(index);
    }

    /**
     * Deletes element from array
     *
     * @param index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public synchronized void delete(int index) {
        super.delete(index);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return super.iterator();
    }
}
