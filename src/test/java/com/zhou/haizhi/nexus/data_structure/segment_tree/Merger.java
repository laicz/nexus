package com.zhou.haizhi.nexus.data_structure.segment_tree;

/**
 * Create by zhoumingbing on 2020-02-29
 */
public interface Merger<E> {
    E merger(E e1, E e2);
}
