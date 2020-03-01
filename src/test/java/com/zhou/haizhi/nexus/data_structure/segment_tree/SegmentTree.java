package com.zhou.haizhi.nexus.data_structure.segment_tree;

import org.omg.CORBA.Object;

/**
 * 线段树
 * Create by zhoumingbing on 2020-02-29
 */
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] data, Merger merger) {
        this.data = (E[]) new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        this.tree = (E[]) new Object[data.length * 4];
        this.merger = merger;
    }

    private void buildSegementTree(int treeIndex, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            this.tree[treeIndex] = data[leftIndex];
            return;
        }
        int newLeftIndex = leftChild(treeIndex);
        int newRightIndex = rightChild(treeIndex);

        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        buildSegementTree(newLeftIndex, leftIndex, mid);
        buildSegementTree(newRightIndex, mid + 1, rightIndex);

        this.tree[treeIndex] = merger.merger(tree[newLeftIndex], tree[newRightIndex]);
    }


    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
