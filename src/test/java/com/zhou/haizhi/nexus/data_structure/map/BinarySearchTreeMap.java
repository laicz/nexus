package com.zhou.haizhi.nexus.data_structure.map;

/**
 * Create by zhoumingbing on 2020-02-23
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V getValue(K key) {
        Node node;
        return (node = getNode(root, key)) == null ? null : node.value;
    }

    @Override
    public V remove(K key) {
        Node node;
        return (node = remove(root, key)) == null ? null : node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) return null;
        return null;
    }

    /**
     * 添加元素
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            return add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            return add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    /**
     * 获取key是否存在
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


}
