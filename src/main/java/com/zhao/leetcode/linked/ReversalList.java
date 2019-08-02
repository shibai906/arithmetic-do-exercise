package com.zhao.leetcode.linked;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/submissions/
 * K个一组翻转链表
 *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *  k 是一个正整数，它的值小于或等于链表的长度。
 *  如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *  示例 :
 *  给定这个链表：1->2->3->4->5
 *  当 k = 2 时，应当返回: 2->1->4->3->5
 *  当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class ReversalList {

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
        reverseKGroup(node,1);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if(head == null) {
            return null;
        }
        ListNode reversal = new ListNode(0);
        ListNode root = reversal;
        ListNode result = null;
        ListNode last = head;
        int j = k - 1;
        reversal.next = new ListNode(head.val);
        while (head.next != null) {
            if(j == 0) {
                if(result == null) {
                    result = reversal.next;
                } else {
                    while (root.next != null) {
                        root = root.next;
                    }
                    root.next = reversal.next;
                }
                last = head.next;
                reversal = new ListNode(0);
                head = head.next;
                reversal.next = new ListNode(head.val);
                if(head.next == null) {
                    break;
                }
                j = k - 1;
            }
            if(j > 0) {
                head = head.next;
                reversal.val = head.val;
                ListNode ope = new ListNode(reversal.val);
                ope.next = reversal;
                reversal = ope;
                j -- ;
            }
        }
        if(result == null) {
            if(j > 0) {
                result = last;
            } else {
                result = reversal.next;
            }
            return result;
        }
        while (root.next != null) {
            root = root.next;
        }
        if(j > 0) {
            root.next = last;
        } else {
            root.next = reversal.next;
        }

        return result;

    }

}
