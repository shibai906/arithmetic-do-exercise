package com.zhao.leetcode.bisai.bi270;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-12-05 10:53
 * @description 地址：https://leetcode-cn.com/contest/weekly-contest-270/problems/delete-the-middle-node-of-a-linked-list/
 * 题目：删除链表的中间节点
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * <p>
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * <p>
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2
 **/
public class DelZhong {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode juluHead = head;
        ListNode kuai = head.next;
        ListNode man = head;
        int i = 0;
        while (kuai != null && kuai.next != null) {
            if (i % 2 == 1) {
                man = man.next;
            }
            kuai = kuai.next;
            i ++;
        }
        man.next = man.next.next;


        return juluHead;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}