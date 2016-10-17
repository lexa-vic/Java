package ru.kostikov;

import java.util.*;

/**
 * The class implements handbook.
 * Created by Алексей on 17.10.2016.
 */
public class HandBook<K, V> implements Iterable<V>{

    protected class Entity<K, V>{
        public K key;
        public V value;

        public Entity(K key, V value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entity entity = (Entity) o;

            if (!key.equals(entity.key)) return false;
            return value.equals(entity.value);

        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }
    }
    /**
     * Ratio if there is no place to add.
     */
    protected static final int EXTEND_RATIO = 2;
    /** Default store size */
    protected static final int DEFAULT_SIZE = 16;
    /** Store for pairs */
    protected Entity[] store;

    public HandBook(){
        this(DEFAULT_SIZE);
    }

    public HandBook(int size){
        store = (Entity<K, V>[]) new Entity[size];
    }

    /**
     * Insert something using key
     * @param key
     * @param value
     * @return true - if insert ok
     */
    public boolean insert(K key, V value){
        boolean wasAdded = false;
        int position = getPosition(key);
        Entity<K, V> oldEntry = store[position];

        if (oldEntry == null) {
            store[position] = new Entity<>(key, value);
            wasAdded = true;
        } else if (key.equals(oldEntry.key)) {
            oldEntry.value = value;
        } else {
            extendArray();
            refillEntries();
            wasAdded = insert(key, value);
        }
        return wasAdded;
    }

    /**
     * Get bucket to entry.
     * @param key K.
     * @return int.
     */
    private int getPosition(K key) {
        int position = 0;
        if (key != null) {
            position = Math.abs(key.hashCode() % store.length);
        }
        return position;
    }

    /**
     * Extend array.
     */
    private void extendArray() {
        store = Arrays.copyOf(store, store.length * EXTEND_RATIO);
    }

    /**
     * Refill entries.
     */
    @SuppressWarnings("unchecked")
    private void refillEntries() {
        Entity<K, V>[] oldEntries = store;
        store = (Entity<K, V>[]) new Entity[store.length];
        for (Entity<K, V> entry : oldEntries) {
            if (entry != null) {
                store[getPosition(entry.key)] = entry;
            }
        }
    }

    /**
     * Gets value from key
     * @param key
     * @return value
     */
    public V get(K key){
        V value = null;
        Entity<K, V> entry = store[getPosition(key)];
        if (entry != null) {
            value = entry.value;
        }
        return value;
    }

    /**
     * Deletes item by key
     * @param key
     * @return
     */
    public boolean delete(K key){
        boolean wasDeleted = false;
        int position = getPosition(key);
        Entity<K, V> entry = store[position];
        if (entry != null && Objects.equals(key, entry.key)) {
            store[position] = null;
            wasDeleted = true;
        }
        return wasDeleted;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        Iterator<V> iter = new Iterator<V>() {
            /**  Next index. */
            private int nextIndex = 0;

            @Override
            public boolean hasNext() {
                boolean has = false;
                while (!has && nextIndex < store.length) {
                    if (store[nextIndex] != null) {
                        has = true;
                    } else {
                        nextIndex++;
                    }
                }
                return has;
            }

            @Override
            public V next() {
                if (!this.hasNext()){
                    throw new NoSuchElementException();
                }
                return (V)store[nextIndex++].value;
            }
        };
        return iter;
    }

}
