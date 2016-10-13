package ru.kostikov;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Алексей on 11.10.2016.
 */
public interface SimpleContainer<E> extends Iterable<E> {

    /**
     * Add new item
     * @param e - new item
     */
    void add(E e);


    /**
    * Gets element by index
    * @param index index of element
    * @return element value
    * @throws IndexOutOfBoundsException
    */
    E get(int index);

    /**
     * Deletes element from array
     * @param index
     * @throws IndexOutOfBoundsException
     */
    void delete(int index);
}
