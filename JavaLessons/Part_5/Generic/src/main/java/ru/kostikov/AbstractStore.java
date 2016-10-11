package ru.kostikov;

/**
 * Created by Алексей on 11.10.2016.
 */
public class AbstractStore implements Store<Base> {
    protected SimpleArray<Base> store;
    protected int size;

    public AbstractStore(int size) {
        this.store = new SimpleArray<>(size);
        this.size = size;
    }

    /**
     * Add new item to store
     *
     * @param newItem
     */
    @Override
    public void add(Base newItem) {
        this.store.add(newItem);
    }

    /**
     * Gets item from store by id
     *
     * @param id
     * @return
     */
    @Override
    public Base get(String id) {
        Base result = null;
        for (int i=0; i < this.size; i++){
            if (this.store.get(i) != null) {
                if (this.store.get(i).getId().equals(id)){
                    result = this.store.get(i);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Deletes item from store
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        Base result = null;
        for (int i=0; i < this.size; i++){
            if (this.store.get(i) != null) {
                if (this.store.get(i).getId().equals(id)){
                    this.store.delete(i);
                    break;
                }
            }
        }
    }
}
