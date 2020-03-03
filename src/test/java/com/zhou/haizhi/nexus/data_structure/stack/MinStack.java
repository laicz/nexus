package com.zhou.haizhi.nexus.data_structure.stack;

/**
 * 可以返回最小值的栈
 * Create by zhoumingbing on 2020-03-03
 */
public class MinStack<E extends Comparable> {


    /**
     * 由于栈
     */
    private class Node {
        private E e;
        private Node next;
        private E min;
    }
}
