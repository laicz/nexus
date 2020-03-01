package com.zhou.haizhi.nexus.data_structure.max_heap;

import com.zhou.haizhi.nexus.data_structure.array.Array;

/**
 * Create by zhoumingbing on 2020-02-29
 */
public class MaxHeap<E extends Comparable> {

    private Array<E> array;

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    public MaxHeap() {
        array = new Array<>();
    }

    public int getSize() {
        return this.array.getSize();
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 not have parent");
        }
        return index / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向二叉堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        this.array.addLast(e);
        if (this.getSize() > 1){
            siftUp(this.array.getSize() - 1);
        }
    }

    /**
     * 交换位置，保证子节点不大于父节点的特性
     *
     * @param i
     */
    private void siftUp(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("index 0 not be sift ");
        }
        while (i > 0 && (array.get(parent(i)).compareTo(array.get(i)) < 0)) {
            this.array.swap(parent(i), i);

            i = parent(i);
        }
    }

    public E findMax() {
        if (this.array.getSize() == 0) {
            throw new IllegalArgumentException("this max head is empty ");
        }
        return this.array.get(0);
    }

    public E extractMax() {
        E max = findMax();
        this.array.swap(0, this.getSize() - 1);
        this.array.removeLast();

        siftDown(0);
        return max;
    }

    public E findByIndex(int index) {
        if (index > this.array.getSize() - 1) {
            throw new IllegalArgumentException("out of point");
        }
        return this.array.get(index);
    }

    /**
     * 下沉
     *
     * @param i
     */
    private void siftDown(int i) {
        while (i < this.array.getSize() - 1) {
            E e = this.array.get(i);

            int target;
            int j = leftChild(i);
            if (j > this.array.getSize() - 1) {
                break;
            }
            if (j == this.array.getSize() - 2) {
                target = j;
            } else {
                target = this.array.get(j).compareTo(this.array.get(j + 1)) > 0 ? j : j + 1;
            }
            if (e.compareTo(this.array.get(target)) >= 0) {
                break;
            }
            this.array.swap(i, target);
            i = target;
        }
    }
}
