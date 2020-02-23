package com.zhou.haizhi.nexus.data_structure.link;

/**
 * Create by zhoumingbing on 2020-02-23
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            ListNode cur = prev.next;
            if (val == cur.val) {
                prev.next = cur.next;
                cur.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = new Solution().removeElements(listNode, 2);
        System.out.println(listNode6);
    }
}
