package com.zhou.haizhi.nexus.data_structure.union_find;

/**
 * 并查集
 * Create by zhoumingbing on 2020-02-29
 */
public interface UnionFind {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
