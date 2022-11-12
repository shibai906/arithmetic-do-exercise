package com.zhao.testOk;

import com.zhao.leetcode.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-08-09 11:33
 * @description
 **/
public class Main {

    List<Fu> list = new ArrayList();

    List<TypeEnum> typeEnums = new ArrayList();

    {
        list.add(new Zi1());
        list.add(new Zi2());
    }

    public static void main(String[] args) {
        Main m = new Main();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node1 =  m.reverseKGroup(node1, 2);
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        int num = 1;
        ListNode result = null, resultLast = null, newHead = head;
        while(head != null) {
            if (num == k) {
                ListNode jilu = head.next;
                head.next = null;
                head = jilu;
                if (resultLast == null) {
                    resultLast = newHead;
                }
                newHead = reverse(newHead);
                if (result == null) {
                    result = newHead;
                    resultLast = result;
                    while(resultLast.next != null) {
                        resultLast = resultLast.next;
                    }
                } else {
                    resultLast.next = newHead;
                    while(resultLast.next != null) {
                        resultLast = resultLast.next;
                    }
                }
                newHead = head;
                num = 1;
            } else {
                num ++;
                head = head.next;
            }

        }
        resultLast.next = newHead;
        return result;
    }


    private ListNode reverse(ListNode node) {

        ListNode nextNode = node.next;
        node.next = null;

        while(nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = temp;
        }
        return node;
    }


}
