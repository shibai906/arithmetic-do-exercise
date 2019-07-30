package com.zhao.leetcode.linked;

/**
 * 删除链表中倒数第N个节点
 */
public class DelLinkedNLode {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode opeHead = head;
        opeHead.next = new ListNode(2);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(3);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(4);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(5);
        opeHead = opeHead.next;
        removeNthFromEnd(head,2);


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        if(n < 1) {
            return head;
        }
        ListNode biaoji = head;
        ListNode last = head;
        for(int i = 0 ; i < n ; i ++) {
            last = last.next;
            if(last == null) {
                if(biaoji.next != null || biaoji.next != null) {
                    head = head.next;
                    return head;
                }
                else {
                    return head.next;
                }
            }
        }
        while (last.next != null) {
            biaoji = biaoji.next;
            last = last.next;
        }
        biaoji.next = biaoji.next.next;
        return head;
    }

}

