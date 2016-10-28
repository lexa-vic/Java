package ru.kostikov;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Алексей on 28.10.2016.
 */
public class Cache<K, V> {

    Map<K, SoftReference<V>> cacheStore = new HashMap<K, SoftReference<V>>();

    void add(K key, V value){
        cacheStore.put(key, new SoftReference<V>(value));
    }

    V get(K key){
        SoftReference<V> softRef = cacheStore.get(key);
        return softRef != null ? softRef.get(): null;
    }

}
