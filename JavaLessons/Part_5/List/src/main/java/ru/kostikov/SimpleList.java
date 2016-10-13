package ru.kostikov;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Алексей on 13.10.2016.
 */
public interface SimpleList<E> extends SimpleContainer<E> {

    /**
     * Add new item by index
     * @param e - new item
     */
    void add(int index, E e);

}
