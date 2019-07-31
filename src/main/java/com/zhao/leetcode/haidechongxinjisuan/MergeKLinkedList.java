package com.zhao.leetcode.haidechongxinjisuan;

import com.zhao.leetcode.linked.ListNode;

/**
 * 合并k个排序链表
 * 自己思路，等有时间进行详细观察
 */
public class MergeKLinkedList {

    public static void main(String[] args) {
        Integer in = null;
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        ListNode opeHead1 = listNodes[0];
        opeHead1.next = new ListNode(4);
        opeHead1 = opeHead1.next;
        opeHead1.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        ListNode opeHead2 = listNodes[1];
        opeHead2.next = new ListNode(3);
        opeHead2 = opeHead2.next;
        opeHead2.next = new ListNode(4);

        listNodes[2] = new ListNode(2);
        ListNode opeHead3 = listNodes[2];
        opeHead3.next = new ListNode(6);
        mergeTwoLists(listNodes);
    }

    public static ListNode mergeTwoLists(ListNode[] lists) {
        if(lists.length < 1) {
            return null;
        }
        int len = lists.length;
        Integer[] integers = new Integer[len] ;
        for(int i = 0 ; i < len ; i ++ ) {
            if(lists[i] == null) {
                integers[i] = null;
            } else {
                integers[i] = lists[i].val;
            }
        }
        ListNode result = new ListNode(0);
        ListNode opeResult = result;
        while(true) {
            Integer min = integers[0];
            Integer biaoji = 0 ;
            for(int i = 1 ; i < len ; i ++) {
                if(integers[i] != null) {
                    if(!integers[i].equals(min)) {
                        min = min == null ? integers[i] : min < integers[i] ? min : integers[i];
                        if(min.equals(integers[i])) {
                            biaoji = i;
                        }
                    }

                }
            }
            if(min == null) {
                break;
            }
            opeResult.next = new ListNode(min);
            opeResult = opeResult.next;
            lists[biaoji] = lists[biaoji].next;
            if(lists[biaoji] == null) {
                integers[biaoji] = null;
            } else {
                integers[biaoji] = lists[biaoji].val;
            }

        }
        return result.next;
    }

}
