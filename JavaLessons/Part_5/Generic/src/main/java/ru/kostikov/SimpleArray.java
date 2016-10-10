package ru.kostikov;


import java.util.ArrayList;

/**
 * Created by Алексей on 10.10.2016.
 */
public class SimpleArray<T> {

    /** Array of items  */
    Object[] array;

    /** Current index of storage */
    int index;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Checks range
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >=  this.array.length){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index );
        }
    }


    /**
     * Add new item
     * @param newItem - new item
     * @return true if add ok
     */
    public boolean add(T newItem){
        boolean result = false;

        if (this.index < this.array.length){
            this.array[this.index++] = newItem;
            result = true;
        }

        return result;
    }

    /**
     * Gets element by index
     * @param index index of element
     * @return element value
     * @throws IndexOutOfBoundsException
     */
    public T get(int index){

        rangeCheck(index);
        return (T) this.array[index];
    }

    /**
     * @param index
     * @param newValue
     */
    public void update(int index, T newValue){
        rangeCheck(index);

        this.array[index] = newValue;
    }


    /**
     * Deletes element from array
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void delete(int index){
        rangeCheck(index);

        int numMoved = this.index - index - 1;
        if (numMoved > 0)
            System.arraycopy(this.array, index+1, this.array, index,
                    numMoved);
        this.array[--this.index] = null;
    }



}
