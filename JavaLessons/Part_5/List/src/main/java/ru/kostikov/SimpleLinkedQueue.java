package ru.kostikov;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Алексей on 13.10.2016.
 */
public class SimpleLinkedQueue<E> extends SimpleLinkedList<E> implements SimpleQueue<E> {

    /**
     * Add new item by index
     *
     * @param index
     * @param e     - new item
     * @throws UnsupportedOperationException
     */
    @Override
    public void add(int index, E e)  {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets element by index
     *
     * @param index index of element
     * @return element value
     * @throws UnsupportedOperationException
     */
    @Override
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Deletes element from array
     *
     * @param index
     * @throws UnsupportedOperationException
     */
    @Override
    public void delete(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
        E result = null;

        if (isElementIndex(0)){
            Node<E> n = node(0);
            result = n.data;
            unlink(n);
        }
        return result;
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E peek() {
        E result = null;

        if (isElementIndex(0)){
            Node<E> n = node(0);
            result = n.data;
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> resultIter = new Iterator<E>() {
            private int iterIndex = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;

                if (iterIndex < size){
                    result = true;
                }
                return result;
            }

            @Override
            public E next() {
                if (!this.hasNext()){
                    throw new NoSuchElementException();
                }
                return poll();
            }
        };

        return resultIter;
    }
}
