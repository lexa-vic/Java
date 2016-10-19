package ru.kostikov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Алексей on 18.10.2016.
 */
public class SimpleTree<K extends Comparable> {
    /**
     * Node in the Tree.  Doubles as a means to pass key-value pairs back to
     * user (see Map.Entry).
     */
     public static class Node<K>{
        public K key;
        public Node<K> left;
        public Node<K> right;
        public Node<K> parent;

        public Node(K key, Node<K> parent) {
            this.key = key;
            this.parent = parent;
        }

    }
    /** Tree root */
    private Node<K> root = null;

    private boolean balanced = true;


    /**
     * Add new node
     * @param value
     */
    public void addChild(K value){
        Node<K> node = root;

        if (node == null){
            root = new Node<K>(value, null);
        } else {
            int cmp;
            Node<K> parent = null;
            Comparable<? super K> k = (Comparable<? super K>) value;

            do {
                parent = node;
                cmp = k.compareTo(node.key);

                if (cmp < 0) {
                    node = node.left;
                } else if (cmp > 0){
                    node = node.right;
                } else {
                    // Item already exist
                    return;
                }
            }while(node != null);

            Node<K> newItem = new Node<K>(value, parent);
            if (cmp < 0)
                parent.left = newItem;
            else
                parent.right = newItem;
        }
    }

    /**
     *  Gets all tree values
     * @return
     */
    public List<K> getChildren() {
        List<K> list = new ArrayList<K>();
        Node<K> p = root;

        if (p != null){
            getChildrenNodes(p, list);
        }
        return list;
    }

    /**
     * Finds node
     * @param value
     * @return
     */
    public Node<K> getNode(K value){
        Node<K> p = root;
        Comparable<? super K> k = (Comparable<? super K>) value;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }

    /**
     * Checks tree balance
     * @return true if tree is balanced
     */
    public boolean isBalancedTree(){
        balanceCheck(root);
        return this.balanced;
    }

    private void balanceCheck(Node<K> node){
        int branchCnt = 0;
        if (node.left != null){
            balanceCheck(node.left);
            branchCnt++;
        }
        if (node.right != null){
            balanceCheck(node.right);
            branchCnt++;
        }
        if ((branchCnt % 2) != 0){
            this.balanced = false;
        }

    }

    /**
     * Collect all values from nodes
     * @param node
     * @param valueArray
     */
    private void getChildrenNodes(Node<K> node, List<K> valueArray){
        valueArray.add(node.key);
        if (node.left != null){
            getChildrenNodes(node.left, valueArray);
        }

        if (node.right != null){
            getChildrenNodes(node.right, valueArray);
        }
    }
}
