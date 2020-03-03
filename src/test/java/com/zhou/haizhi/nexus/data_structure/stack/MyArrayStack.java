package com.zhou.haizhi.nexus.data_structure.stack;

/**
 * 基于数组实现顺序栈
 * Create by zhoumingbing on 2020-03-03
 */
public class MyArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 16;

    private E[] array;

    private int size;

    public MyArrayStack() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    /**
     * 写入数据
     *
     * @param e
     */
    @Override
    public void push(E e) {
        if (size == array.length - 1) {
            resize();
        }
        array[size] = e;
        size++;
    }

    private void resize() {
        int newLength = array.length << 1;
        E[] newArray = (E[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 弹出栈顶数据
     * 栈顶数据会返回并从栈中删除
     *
     * @return
     */
    @Override
    public E pop() {
        if (size == 0) {
            return null;
        }
        E e = array[size - 1];
        array[size - 1] = null;
        size--;
        return e;
    }

    /**
     * 查看栈顶数据
     * 栈顶数据返回，不会从栈中删除
     *
     * @return
     */
    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    /**
     * 获取当前栈中的数据量
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断当前栈是否存在数据
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
