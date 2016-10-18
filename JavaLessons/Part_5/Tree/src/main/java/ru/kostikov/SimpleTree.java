package ru.kostikov;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by Алексей on 18.10.2016.
 */
public class SimpleTree<K> {
    /**
     * Node in the Tree.  Doubles as a means to pass key-value pairs back to
     * user (see Map.Entry).
     */
     public static class Leaf<K>{
        K key;
        Leaf<K> left;
        Leaf<K> right;
        Leaf<K> parent;

        Leaf(K key) {
            this.key = key;
        }

        private Leaf<K> root;

    public void addChild(Leaf<K> leaf){
        if (root == null){
            root = leaf;
        } else {

        }
    }
    }
    List<K> getChildren() {
        return null;
    }
}
