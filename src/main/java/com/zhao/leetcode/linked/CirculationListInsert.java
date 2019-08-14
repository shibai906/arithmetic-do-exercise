package com.zhao.leetcode.linked;

/**
 * 地址：https://leetcode-cn.com/problems/insert-into-a-cyclic-sorted-list/
 * 循环有序列表的插入
 *  给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素，使这个列表仍然是循环升序的。给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *  如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *  如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个点。否则。请返回原先给定的节点。
 */
public class CirculationListInsert {

    public static void main(String[] args) {

        Node node = new Node();
        Node opeNode = node;
        opeNode.val = 1;
        Node opeNext = new Node();
        opeNext = new Node();
        opeNext.val = 3;
        opeNode.next = opeNext;
        opeNode = opeNode.next;
        opeNext = new Node();
        opeNext.val = 4;
        opeNode.next = opeNext;
        opeNext.next = node;
        insert(node,2);

    }

    public static Node heInsert(Node head , int insertVal) {
        if (head == null) {
            Node result = new Node(insertVal);
            result.next = result;
            return result;
        }

        Node node = head;
        while (node.next != head) {
            if (node.val <= insertVal && insertVal <= node.next.val) {
                // 插入非最值
                break;
            } else if (node.val <= insertVal && node.next.val < insertVal &&  node.val > node.next.val) {
                // 插入一个最大值
                break;
            } else if (node.val > insertVal && node.next.val >= insertVal &&  node.val > node.next.val) {
                // 插入一个最小值
                break;
            } else {
                node = node.next;
            }
        }

        Node inserted = new Node(insertVal);
        inserted.next = node.next;
        node.next = inserted;
        return head;

    }

    public static Node insert(Node head, int insertVal) {

        if(head == null) {
            head = new Node(insertVal,null);
            return head.next;
        }
        Node nextHead = head;
        while (true) {
            if((nextHead.next.val >= insertVal && nextHead.val < insertVal) || (nextHead.next.val < nextHead.val )) {
                nextHead.next = new Node(insertVal,nextHead.next);
                return nextHead;
            }
            nextHead = nextHead.next;
        }

    }

}
