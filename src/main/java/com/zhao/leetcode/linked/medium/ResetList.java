package com.zhao.leetcode.linked.medium;

import com.zhao.leetcode.linked.ListNode;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-05 22:56
 * @description
 * 地址：https://leetcode-cn.com/problems/reorder-list/
 * 题目：重排链表
 * 描述：给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *  L0 → L1 → … → Ln - 1 → Ln
 *  请将其重新排列后变为：
 *  L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *  不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *  解法：快慢指针
 *
 **/
public class ResetList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ResetList rl = new ResetList();
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        rl.reorderList(head);
    }

    public ListNode reorder(ListNode node) {

        ListNode tail = node;
        node = node.next;
        tail.next = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = tail;
            tail = node;
            node = next;
        }
        return tail;

    }

    // 按条件指向
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;

        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        fast = slow.next;
        ListNode tail = fast;
        fast = fast.next;
        tail.next = null;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = tail;
            tail = fast;
            fast = next;
        }
        fast = tail;
        slow.next = null;
        ListNode newNode = head;

        while (fast != null) {
            ListNode temp = newNode.next;
            newNode.next = fast;
            fast = fast.next;
            newNode = newNode.next;
            newNode.next = temp;
            newNode = newNode.next;
        }
    }

}
