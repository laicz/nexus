package com.zhou.haizhi.nexus.data_structure.link;

/**
 * 链表节点
 * Create by zhoumingbing on 2020-03-02
 */
public class LinkNode<E> {

    E e;
    LinkNode next;

    public LinkNode(E e) {
        this.e = e;
    }

    public LinkNode(E e, LinkNode next) {
        this.e = e;
        this.next = next;
    }

    @Override
    public String toString() {
        return "e=" + e + " -> " + next;
    }
}
