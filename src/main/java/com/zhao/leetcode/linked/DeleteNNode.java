package com.zhao.leetcode.linked;

import com.zhao.leetcode.ListNode;

/**
 * 删除链表的倒数第N个节点
 */
public class DeleteNNode {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode opeHead = head;

        ListNode index = head;

        while (n > 0) {
            index = index.next;
            n -- ;
        }
        if(index == null) {
            return opeHead.next;
        }
        while (index.next != null) {
            opeHead = opeHead.next;
            index = index.next;
        }
        opeHead.next = opeHead.next.next;

        return head;
    }


}
