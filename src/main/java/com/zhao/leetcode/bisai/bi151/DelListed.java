package com.zhao.leetcode.bisai.bi151;

import com.zhao.leetcode.linked.ListNode;

public class DelListed {

    public static void main(String[] args) {

    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode opeNode = head;
        ListNode opeHead = head;
        int num = 0 ;
        while (opeHead != null) {
            if(opeHead.val < 0) {
                if(num == opeHead.val) {
                    if(opeNode == head) {
                        opeHead = opeHead.next;
                        opeNode = opeHead;
                        head = opeHead;
                    }
                } else {

                }
            }

        }


        return head;


    }

}
