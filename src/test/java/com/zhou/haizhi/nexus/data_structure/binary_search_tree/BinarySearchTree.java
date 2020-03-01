package com.zhou.haizhi.nexus.data_structure.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

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

    public boolean contains(E e) {
        return contains(root, e);
    }


    /**
     * 利用递归来查询出二分搜索树中的数据
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    public void remove(E e) {

    }

    public void add(E e) {
        root = add(root, e);
    }

    public List<Node> traverse() {
        List<Node> nodes = new ArrayList<>();
        traverse(root, nodes);
        return nodes;
    }

    private void traverse(Node node, List<Node> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node);
        traverse(node.left, nodes);
        System.out.println(node);
        traverse(node.right, nodes);
    }

    /**
     * 向以根节点为node的二叉树写入数据e
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        //使用递归优化
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }


    public class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
