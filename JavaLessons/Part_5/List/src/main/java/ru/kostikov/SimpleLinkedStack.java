package ru.kostikov;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Алексей on 13.10.2016.
 */
public class SimpleLinkedStack<E> extends SimpleLinkedList<E> implements SimpleStack<E> {

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
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack, if has not element return null
     */
    @Override
    public E pop() {
        E result = null;

        if (isElementIndex(size-1)){
            Node<E> n = node(size-1);
            result = n.data;
            unlink(n);
        }
        return result;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack, if has not element return null
     */
    @Override
    public E peek() {
        E result = null;

        if (isElementIndex(size-1)){
            Node<E> n = node(size-1);
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
                return pop();
            }
        };

        return resultIter;
    }
}
