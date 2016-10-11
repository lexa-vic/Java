package ru.kostikov;

/**
 * Created by Алексей on 11.10.2016.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);

    E get(int index);
}
