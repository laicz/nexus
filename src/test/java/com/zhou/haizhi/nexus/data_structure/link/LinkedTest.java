package com.zhou.haizhi.nexus.data_structure.link;

import org.junit.Test;

/**
 * Create by zhoumingbing on 2020-03-02
 */
public class LinkedTest {


    @Test
    public void reversal() {
        LinkNode<Integer> linkNode1 = new LinkNode<>(5);
        LinkNode<Integer> linkNode2 = new LinkNode<>(4, linkNode1);
        LinkNode<Integer> linkNode3 = new LinkNode<>(3, linkNode2);
        LinkNode<Integer> linkNode4 = new LinkNode<>(2, linkNode3);
        LinkNode<Integer> linkNode5 = new LinkNode<>(1, linkNode4);
//        System.out.println(linkNode5);
//        System.out.println(linkNode1);

        LinkNode<Integer> newLink = reversal1(linkNode5);
        System.out.println(newLink);
//        System.out.println(linkNode5);
//        System.out.println(linkNode1);
//        System.out.println(newLink);

        //循环实现反转
//        LinkNode<Integer> cur = linkNode5;
//        LinkNode<Integer> prev = null;
//        while (cur != null) {
//            LinkNode<Integer> next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        System.out.println(linkNode5);
//        System.out.println(linkNode1);
    }

    /**
     * 迭代实现链表反转
     * 1 -> 2 -> 3 -> 4 -> 5
     * <p>
     * null <- 1  2 -> 3 -> 4 -> 5
     * 此时就需要记录prev 1
     * cur = 2
     * <p>
     */
    private LinkNode<Integer> reversal1(LinkNode<Integer> head) {
        LinkNode<Integer> cur = head;
        LinkNode<Integer> prev = null;
        while (cur != null) {
            LinkNode<Integer> next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }


    /**
     * 递归实现反转
     * 1 -> 2 -> 3 -> 4 -> 5
     * <p>
     * 利用递归找到最后一个节点，然后再开始进行反转
     * 1 -> 2 -> 3 -> 4 -> null   5 -> 4
     * 1 -> 2 -> 3  -> null   5 -> 4 -> 3
     *
     * @param head
     * @return
     */
    private LinkNode reversal(LinkNode<Integer> head) {
        if (head.next == null) {
            return head;
        }
//        System.out.println(head);
        LinkNode last = reversal(head.next);
//        System.out.println("--------------------");
//        System.out.println(head);
//        System.out.println(last);
        head.next.next = head;
        head.next = null;
//        System.out.println(head);
        return last;
    }
}
