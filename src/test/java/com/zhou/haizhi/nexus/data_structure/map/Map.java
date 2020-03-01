package com.zhou.haizhi.nexus.data_structure.map;

/**
 * Create by zhoumingbing on 2020-02-23
 */
public interface Map<K, V> {
    int getSize();

    boolean isEmpty();

    void add(K key, V value);

    boolean contains(K key);

    V getValue(K key);

    V remove(K key);
}
