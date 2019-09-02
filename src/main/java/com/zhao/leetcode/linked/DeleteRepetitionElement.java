package com.zhao.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

public class DeleteRepetitionElement {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode opeHead = head;
        opeHead.next = new ListNode(1);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(2);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(3);
        opeHead = opeHead.next;
        opeHead.next = new ListNode(3);
        deleteDuplicatesGai(head);

    }

    /**
     *  方法1，使用List存储状态，然后从list中取出来
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        ListNode opeHead = head;
        boolean flag = false;
        while (head.next != null) {
            for(int num : list) {
                if(head.next.val == num) {
                    flag = true;
                }
            }
            if(flag) {
                head.next = head.next.next;
            } else {
                head = head.next;
                list.add(head.val);
            }
            flag = false;
        }
        return opeHead;
    }

    /**
     * 根据排序特别来制作
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {

        if(head == null) {
            return head;
        }
        ListNode opeHead = head;
        while (head.next != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
                if(head.next == null) {
                    break;
                }
            }
            head = head.next;
        }
        return opeHead;
    }

    public static ListNode deleteDuplicatesGai(ListNode head) {

        if(head == null) {
            return head;
        }
        ListNode opeHead = head;
        ListNode waitHead = head;
        boolean flag = false;
        while ( head != null && head.next != null) {

            while (head.next != null && head.val == head.next.val) {
                flag = true;
                head.next = head.next.next;
            }
            if(flag) {
                if(opeHead == head) {
                    opeHead = head.next;
                    head = opeHead;
                } else {
                    waitHead.next = head.next;
                    head = waitHead;
                }
            } else {
                waitHead = head;
                head = head.next;
            }
            flag = false;
        }
        return opeHead;
    }

}
