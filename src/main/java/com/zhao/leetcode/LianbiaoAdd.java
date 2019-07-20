package com.zhao.leetcode;


import org.omg.CORBA.NO_IMPLEMENT;

import java.math.BigInteger;

public class LianbiaoAdd {

    public static void main(String[] args) {

/*        ListNode l1 = new ListNode(2);
        ListNode opel1 = l1 ;
        ListNode node = new ListNode(4);
        opel1.next = node;
        opel1 = opel1.next;

        node = new ListNode(3);
        opel1.next = node;
        opel1 = opel1.next;

        ListNode l2 = new ListNode(2);
        ListNode opel2 = l2 ;
        node = new ListNode(4);
        opel2.next = node;
        opel2 = opel2.next;

        node = new ListNode(3);
        opel2.next = node;
        opel2 = opel2.next;

        node = new ListNode(3);
        opel2.next = node;
        opel2 = opel2.next;

        ListNode l3 = addTwoNumbers(l1,l2);*/
        ListNode l1 = new ListNode(9) ;
        l1.next = new ListNode(8);
        ListNode l3 = addTwoNumbers(l1,new ListNode(1));
        System.out.println();

    }

/*    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode opel1 = l1;
        ListNode opel2 = l2;
        int i = 0 ;
        int j = 0 ;

        while (opel1 != null) {
            i ++ ;
            opel1 = opel1.next;
        }

        while (opel2 != null) {
            j ++ ;
            opel2 = opel2.next;
        }
        ListNode maxNode = null;
        ListNode minNode = null;
        int max = 0;
        int min = 0;
        if( i > j) {
            max = i;
            maxNode = l1;
            min = j;
            minNode = l2;
        } else {
            max = j;
            maxNode = l2;
            min = i;
            minNode = l1;
        }

        ListNode l3 = null;
        if(max == min) {
            int num = l1.val + l2.val;
            if(num >= 10) {
                l3 = new ListNode(num/10);
                l3.next = new ListNode(num%10);
            } else {
                l3 = new ListNode(num);
            }
            max -- ;
            min -- ;
            maxNode = maxNode.next;
            minNode = minNode.next;
        } else {
            max -- ;
            l3 = new ListNode(maxNode.val);
            maxNode = maxNode.next;
        }
        ListNode opel3 = l3;
        if(l3.next != null) {
            opel3 = opel3.next;
        }

        while (max > 0 || min > 0) {

            if(max == min) {
                opel3.next = new ListNode(maxNode.val);
                opel3 = opel3.next;
                max -- ;
                maxNode = maxNode.next;
            }

        }


        return l3;

    }*/

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1.next == null && l1.val == 0) {
            return l2;
        }
        if(l2.next == null && l2.val == 0) {
            return l1;
        }
        StringBuilder sb1 = new StringBuilder();
        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }

        StringBuilder sb2 = new StringBuilder();
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }
        String str1 = sb1.toString();
        String str2 = sb2.toString();
        int max = 0;
        if(str1.length() > str2.length()) {
            max = str1.length() - str2.length();
            str1 = str1.substring(max);
        }
        if(str2.length() > str1.length()) {
            max = str2.length() - str1.length();
            str2 = str2.substring(max);
        }

        java.math.BigInteger nums = new java.math.BigInteger(str1).add(new java.math.BigInteger(str2));

        String num = String.valueOf(nums) ;

        char[] chars = num.toCharArray();



        if(chars.length == 0) {
            ListNode returnl3 = new ListNode(0);
            while (max > 0) {
                max -- ;
                ListNode node = new ListNode(0);
                node.next = returnl3;
                returnl3 = node;

            }
            return new ListNode(0);
        }

        if(chars.length == 1) {
            ListNode returnl3 = new ListNode(chars[0] - 48);
            while (max > 0) {
                max -- ;
                ListNode node = new ListNode(0);
                node.next = returnl3;
                returnl3 = node;

            }
            return returnl3;
        }
        ListNode l3 = new ListNode(chars[1] - 48);
        l3.next = new ListNode(chars[0] - 48);

        for(int i = 2 ; i < chars.length ; i ++) {
            ListNode node = new ListNode(chars[i] - 48);
            node.next = l3;
            l3 = node;
        }

        while (max > 0) {
            max -- ;
            ListNode node = new ListNode(0);
            node.next = l3;
            l3 = node;

        }

        return l3;

    }

}

