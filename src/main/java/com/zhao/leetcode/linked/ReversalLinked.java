package com.zhao.leetcode.linked;

import com.zhao.leetcode.tree.Node;

/**
 * 反转链表
 */
public class ReversalLinked {

    static ListNode node = new ListNode(0);
    static ListNode opeNode = node;

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node = head;
        head.next = new ListNode(2);
        head =  head.next;
        head.next = new ListNode(3);
        head =  head.next;
        head.next = new ListNode(4);
        head =  head.next;
        head.next = new ListNode(5);
        head =  head.next;
        reverseListRescursion(node);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode reversal = new ListNode(0);
        reversal.next = new ListNode(head.val);
        while (head.next != null) {
            head = head.next;
            reversal.val = head.val;
            ListNode ope = new ListNode(reversal.val);
            ope.next = reversal;
            reversal = ope;
        }
        return reversal.next;
    }

    public static ListNode reverseListRescursion(ListNode head) {

        rescursion(head);
        return node.next;

    }

    public static void rescursion(ListNode head) {
        if(head == null) {
            return;
        }
        rescursion(head.next);
        opeNode.next = new ListNode(head.val);
        opeNode = opeNode.next;
    }

}
