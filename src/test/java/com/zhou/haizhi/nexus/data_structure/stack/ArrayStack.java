package com.zhou.haizhi.nexus.data_structure.stack;

import com.zhou.haizhi.nexus.data_structure.array.Array;

/**
 * Create by zhoumingbing on 2020-02-22
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 这个方法是在array实现中才有的方法，因此无需写到接口中
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }
}
