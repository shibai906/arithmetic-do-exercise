package com.zhao.leetcode.linked;

import com.zhao.leetcode.linked.ListNode;

/**
 * 两个数之和
 */
public class NumAdd {
    public static void main(String[] args) {

//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(1);

        ListNode l3 = addTwoNumbers(l1,l2);




    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode l3 = new ListNode(0);
        ListNode opeNoe = l3;
        int carry = 0;
        while(l1 != null || l2 != null) {

            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = carry + num1 + num2;
            opeNoe.next = new ListNode(num % 10);
            opeNoe = opeNoe.next;
            carry = num / 10 ;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry > 0) {
            opeNoe.next = new ListNode(carry);
            opeNoe = opeNoe.next;
        }
        return l3.next;

    }


}