package ru.kostikov;

/**
 * Created by Алексей on 10.10.2016.
 */
public interface Store <T extends Base> {


    /**
     * Add new item to store
     * @param newItem
     */
    void add(T newItem);

    /**
     * Gets item from store by id
     * @param id
     * @return
     */
    T get(String id);

    /**
     * Deletes item from store
     * @param id
     */
    void delete(String id);

}


