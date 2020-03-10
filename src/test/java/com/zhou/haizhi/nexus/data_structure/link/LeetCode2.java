package com.zhou.haizhi.nexus.data_structure.link;

/**
 * 使用链表
 * Create by zhoumingbing on 2020-03-08
 */
public class LeetCode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6)));

        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        l1 = new ListNode(0, l1);
        l2 = new ListNode(0, l2);

        l1 = reversal(l1);
        l2 = reversal(l2);

        ListNode result = new ListNode(l1.val + l2.val);
        ListNode cur = result;
        while (!(l1 == null && l2 == null)) {

            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            cur.next = new ListNode(val);
            cur = cur.next;
        }
        result = reversal(result);
        return result.next;
    }

    private ListNode reversal(ListNode head) {
        if (head.next == null) {
            return head;
        }
//        System.out.println(head);
        ListNode last = reversal(head.next);
//        System.out.println("--------------------");
//        System.out.println(head);
//        System.out.println(last);
        head.next.next = head;
        head.next = null;
//        System.out.println(head);
        return last;
    }
}
