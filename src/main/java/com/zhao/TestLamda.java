package com.zhao;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * 测试lamda表达式
 */
public class TestLamda {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        ListNode head = new ListNode();
        head.val = 1;
        ListNode nextHead = new ListNode();
        nextHead.val = 2;
        head.next = nextHead;

        TestLamda tl = new TestLamda();
        tl.reveseList(head);


    }

    public ListNode reveseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        head = head.next;
        newHead.next = null;

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }



}

class ListNode {
    int val;
    ListNode next = null;
    ListNode pre = null;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }
}
