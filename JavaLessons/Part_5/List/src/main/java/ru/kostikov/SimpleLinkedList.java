package ru.kostikov;

import javax.naming.OperationNotSupportedException;
import java.util.*;

/**
 * Created by Алексей on 12.10.2016.
 */
public class SimpleLinkedList<E> implements SimpleList<E>{

    protected class Node<E>{
        public E data;
        public Node prevNode;
        public Node nextNode;

        public Node(E data, Node prevNode, Node nextNode) {
            this.data = data;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    protected Node<E> first = null;
    protected Node<E> last = null;
    protected int size = 0;

    /**
     * Tells if the argument is the index of an existing element.
     */
    protected boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    protected boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    protected String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    protected void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    protected void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<E> node(int index) {

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.nextNode;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prevNode;
            return x;
        }
    }

    /**
     * Links e as last element.
     */
    protected void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e,l, null);

        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.nextNode = newNode;
        size++;
    }

    /**
     * Inserts element e before non-null Node succ.
     */
    protected void linkBefore(E e, Node<E> node) {

        final Node<E> pred = node.prevNode;
        final Node<E> newNode = new Node<>(e, pred, node);
        node.prevNode = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.nextNode = newNode;
        size++;
    }

    /**
     * Unlinks non-null node x.
     */
    protected void unlink(Node<E> x) {
        // assert x != null;
        final E element = x.data;
        final Node<E> next = x.nextNode;
        final Node<E> prev = x.prevNode;

        if (prev == null) {
            first = next;
        } else {
            prev.nextNode = next;
            x.prevNode = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prevNode = prev;
            x.nextNode = null;
        }

        x.data = null;
        size--;
    }

    /**
     * Add new item
     *
     * @param e - new item
     */
    @Override
    public void add(E e) {
        linkLast(e);
    }

    /**
     * Add new item by index
     *
     * @param index
     * @param e     - new item
     */
    @Override
    public void add(int index, E e){
        checkPositionIndex(index);

        if (index == size)
            linkLast(e);
        else
            linkBefore(e, node(index));
    }

    /**
     * Gets element by index
     *
     * @param index index of element
     * @return element value
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index){
        checkElementIndex(index);
        return node(index).data;
    }

    /**
     * Deletes element from array
     *
     * @param index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void delete(int index){
        checkElementIndex(index);
        unlink(node(index));
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
                return node(iterIndex++).data;
            }
        };

        return resultIter;
    }
}
