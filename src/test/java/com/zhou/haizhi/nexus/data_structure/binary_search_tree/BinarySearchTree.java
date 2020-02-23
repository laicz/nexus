package com.zhou.haizhi.nexus.data_structure.binary_search_tree;

/**
 * 二分搜索树中的数据要具有可比较性
 * Create by zhoumingbing on 2020-02-23
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }
}
