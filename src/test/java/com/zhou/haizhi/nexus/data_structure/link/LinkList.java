package com.zhou.haizhi.nexus.data_structure.link;

/**
 * Create by zhoumingbing on 2020-02-22
 */
public class LinkList<E> {

    private Node dummyHead;
    private int size;

    public LinkList() {
        this.dummyHead = new Node(null, null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed . Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//            Node newNode = new Node(e);
//            newNode.next = prev.next;
//            prev.next = newNode;
        prev.next = new Node(e, prev.next);

        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        //上面三步可以简化成下面一步
//        dummyHead.next = new Node(e, dummyHead.next);
//
//        size++;

        //使用dummyIndex就可以将添加第一个节点的逻辑和添加之后的节点统一化，不再有特殊处理
        add(0, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed . Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 设置某个节点的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed . Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断是否存在元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            result.append(cur).append("->");
            cur = cur.next;
        }
        result.append("NULL");
        return result.toString();
    }
}
