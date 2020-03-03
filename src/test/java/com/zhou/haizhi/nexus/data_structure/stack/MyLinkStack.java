package com.zhou.haizhi.nexus.data_structure.stack;

/**
 * 基于链表实现链表栈
 * Create by zhoumingbing on 2020-03-03
 */
public class MyLinkStack<E> implements Stack<E> {

    private int size;

    private Node head;

    private Node tail;

    public MyLinkStack() {
        head = new Node();
        tail = head;
    }

    /**
     * 向栈顶添加元素
     *
     * @param e
     */
    @Override
    public void push(E e) {
        Node newNode = new Node(e);
        this.tail.next = newNode;
        this.tail = newNode;
        size++;
    }

    /**
     * 返回并删除栈顶元素
     *
     * @return
     */
    @Override
    public E pop() {
        if (this.head == this.tail){
            return null;
        }
        Node cur = this.head;
        Node prev = null;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        this.tail = prev;
        this.tail.next = null;
        size--;
        return cur.e;
    }

    @Override
    public E peek() {
        return this.tail.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        private E e;
        private Node next;

        private Node() {
        }

        private Node(E e) {
            this.e = e;
        }
    }
}
