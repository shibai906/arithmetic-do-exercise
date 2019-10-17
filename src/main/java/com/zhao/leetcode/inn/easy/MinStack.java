package com.zhao.leetcode.inn.easy;

public class MinStack {

    private class Node {
        Node(int value) {
            this.value = value;
        }
        int value;
        Node left;
        Node right;
    }

    Node head;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        Node node = new Node(x);
        if(head == null) {
            head = node;
        } else {
            node.left = head;
            head.right = node;
            head = head.right;

        }
    }

    public void pop() {
        if(head != null) {
            head = head.left;
            if(head != null)
                head.right = null;
        }
    }

    public int top() {
        if(head != null) {
            return head.value;
        }
        return 0;
    }

    public int getMin() {
        if(head == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Node opeHead = head;
        while (opeHead != null) {
            if(opeHead.value < min) {
                min = opeHead.value;
            }
            opeHead = opeHead.left;
        }
        return min;
    }

}
