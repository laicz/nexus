package com.zhou.haizhi.nexus.data_structure.stack;

/**
 * 从用户的角度来说，支持这些操作就好了
 * 具体底层实现，用户并不关心
 * 实际底层有多种实现方式
 * Create by zhoumingbing on 2020-02-22
 */
public interface Stack<E> {

    /**
     * 压入数据
     *
     * @param e
     */
    void push(E e);

    /**
     * 弹出栈顶数据
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶数据(不会移除)
     *
     * @return
     */
    E peek();

    /**
     * 获取栈中数据的数量
     *
     * @return
     */
    int getSize();

    /**
     * 当前栈是否是空的
     *
     * @return
     */
    boolean isEmpty();
}
