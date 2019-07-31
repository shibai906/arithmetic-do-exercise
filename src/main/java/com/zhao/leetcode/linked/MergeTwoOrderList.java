package com.zhao.leetcode.linked;

import com.zhao.leetcode.linked.ListNode;

/**
 * 合并两个有序链表
 */
public class MergeTwoOrderList {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode opeL3 = l3;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                opeL3.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if(l2 == null) {
                opeL3.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if(l1.val < l2.val) {
                opeL3.next = new ListNode(l1.val);
                l1 = l1.next;

            } else if(l1.val > l2.val) {
                opeL3.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                opeL3.next = new ListNode(l1.val);
                opeL3 = opeL3.next;
                opeL3.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            opeL3 = opeL3.next;
        }

        return l3.next;
    }

}