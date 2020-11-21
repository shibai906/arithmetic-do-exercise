package com.zhao.leetcode.linked;

import java.util.ArrayList;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-13 16:59
 * @description
 * 题目：从尾到头打印链表
 * 描述：从尾到头反过来打印出每个结点的值。
 **/
public class PrintList {

    ListNode newList = new ListNode(0);
    ListNode opeList = newList;

    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        PrintList pl = new PrintList();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        ListNode node1 = pl.reverseList(node);

    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        ListNode newNode = reverseList(next);
        next.next = head;
        return newNode;

    }

    public StringBuilder printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            printListFromTailToHead(listNode.next);
            sb.append(listNode.val);
        }
        return sb;
    }

    public void reverse(ListNode targetList) {
        if(targetList != null) {
            reverse(targetList.next);
            opeList.next = targetList;
            opeList = opeList.next;
            opeList.next = null;
        }
    }

}
