package com.zhao.leetcode;

/**
 * 两两交换链表中的节点
 */
public class SwapLinedNode {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode opeHead = head;
        opeHead.next = new ListNode(2);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(3);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(4);
        opeHead = opeHead.next;
        swapPairs(head);

    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode opeHead = head;
        ListNode node = opeHead.next; // 记录第二个节点
        opeHead.next = opeHead.next.next; // 下一个节点如， 1 -> 2 -> 3 变为 1 -> 3
        node.next = opeHead; // 记录头节点
        head = node;
        while( opeHead != null && opeHead.next != null && opeHead.next.next != null) {
            node = opeHead;                 // 记录需要转换两个数字的前一个节点
            node.next = opeHead.next;       // 记录到下一个节点
            opeHead = opeHead.next;         // 需要转换数字的第1个节点指向下一个节点
            opeHead.next = opeHead.next.next;   // 去掉第二个数字
            node.next.next = opeHead;       // 拼接起来
        }
        return head;

    }

}
