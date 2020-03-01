package com.zhou.haizhi.nexus.data_structure.red_black;

/**
 * Create by zhoumingbing on 2020-03-01
 */
public class RedBlackTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.color = RED;
        }
    }
}
