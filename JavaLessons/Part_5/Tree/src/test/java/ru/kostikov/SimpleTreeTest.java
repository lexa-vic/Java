package ru.kostikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 18.10.2016.
 */
public class SimpleTreeTest {

    @Test
    public void whenAddAneNodeWhenGetThisNode(){
        SimpleTree<Integer> tree = new SimpleTree<>();
        List<Integer> nodes = new ArrayList<>();
        Integer[] expected = new Integer[]{5, 4, 3, 6, 7};

        tree.addChild(5);
        tree.addChild(4);
        tree.addChild(6);
        tree.addChild(3);
        tree.addChild(7);

        nodes = tree.getChildren();

        Assert.assertThat(expected, is(nodes.toArray()));
    }

    @Test
    public void whenFindNodeThenGetThisNode(){
        SimpleTree<Integer> tree = new SimpleTree<>();
        List<Integer> nodes = new ArrayList<>();
        Integer expected = 7;

        tree.addChild(5);
        tree.addChild(4);
        tree.addChild(6);
        tree.addChild(3);
        tree.addChild(7);

        SimpleTree.Node<Integer>  node = tree.getNode(7);

        Assert.assertThat(expected, is(node.key));
    }

    @Test
    public void whenFindNodeThenNotFindNode(){
        SimpleTree<Integer> tree = new SimpleTree<>();
        List<Integer> nodes = new ArrayList<>();
        Integer expected = 7;

        tree.addChild(5);
        tree.addChild(4);
        tree.addChild(6);
        tree.addChild(3);
        tree.addChild(7);

        SimpleTree.Node<Integer>  node = tree.getNode(8);

        Assert.assertThat(null, is(node));
    }

    @Test
    public void whenTreeIsBalancedThenReturnTrue(){
        SimpleTree<Integer> tree = new SimpleTree<>();
        List<Integer> nodes = new ArrayList<>();
        Integer expected = 7;

        tree.addChild(15);
        tree.addChild(7);
        tree.addChild(35);
        tree.addChild(1);
        tree.addChild(9);
        tree.addChild(20);
        tree.addChild(40);

        Assert.assertThat(true, is(tree.isBalancedTree()));
    }

    @Test
    public void whenTreeIsNotBalancedThenReturnFalse(){
        SimpleTree<Integer> tree = new SimpleTree<>();
        List<Integer> nodes = new ArrayList<>();
        Integer expected = 7;

        tree.addChild(5);
        tree.addChild(4);
        tree.addChild(6);
        tree.addChild(3);
        tree.addChild(7);

        Assert.assertThat(false, is(tree.isBalancedTree()));
    }



}