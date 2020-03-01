package com.zhou.haizhi.nexus.data_structure.collection;

import com.zhou.haizhi.nexus.data_structure.link.LinkList;

/**
 * Create by zhoumingbing on 2020-02-27
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkList<E> list;

    public LinkedListSet(LinkList<E> list) {
        this.list = list;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
