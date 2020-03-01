package com.zhou.haizhi.nexus.data_structure.collection;

import com.zhou.haizhi.nexus.data_structure.binary_search_tree.BinarySearchTree;

/**
 * 底层由二分搜索树实现的集合
 * Create by zhoumingbing on 2020-02-23
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    public BinarySearchTreeSet() {
        this.bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
