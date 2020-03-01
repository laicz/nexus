package com.zhou.haizhi.nexus.data_structure.collection;

/**
 * Create by zhoumingbing on 2020-02-23
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
