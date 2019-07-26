package com.zhao.leetcode;

/**
 * 删除链表中的节点
 */
public class DeleLikedNode {

    public static void main(String[] args) {

        ListNode node = new ListNode(5);
        ListNode opeNode = node;
        opeNode.next = new ListNode(4);
        opeNode = opeNode.next;
        opeNode.next = new ListNode(5);
        opeNode = opeNode.next;
        opeNode.next = new ListNode(1);
        opeNode = opeNode.next;
        opeNode.next = new ListNode(9);
        opeNode = opeNode.next;
        deleteNode(node);

    }

    public static void deleteNode(ListNode node) {

        int num = node.val;
        ListNode opeNode = node;
        while (opeNode.next != null) {
            if(opeNode.next.val == num) {
                opeNode.next = opeNode.next.next;
            }
            opeNode = opeNode.next;
        }
        node = node.next;
    }

}
