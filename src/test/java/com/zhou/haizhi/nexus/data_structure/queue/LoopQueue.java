package com.zhou.haizhi.nexus.data_structure.queue;

import org.omg.CORBA.Object;

/**
 * Create by zhoumingbing on 2020-02-22
 */
public class LoopQueue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 当tail和length之间相差1的时候进行扩容
     * @param e
     */
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }
}
