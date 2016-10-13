package ru.kostikov;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Алексей on 13.10.2016.
 */
public interface SimpleStack<E> extends SimpleContainer<E> {


    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack
     * @throws EmptyStackException  if this stack is empty.
     */
    public E pop();

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack
     * @throws  EmptyStackException  if this stack is empty.
     */
    public E peek();
}


