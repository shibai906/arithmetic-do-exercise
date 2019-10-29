package com.zhao.leetcode.design;

import com.zhao.leetcode.linked.Node;

/**
 *  给出一个队列，先进先出，有push，pop，max
 *  设计可以分为两类设计，如果push，pop次数特别多，取最大值每次就从里面取出来，如果是获取max次数多，max值经常变，建议是使用TreeMap。
 *  如果
 */
public class QueueMax {
    int max = Integer.MIN_VALUE;
    Node head = null;
    Node opeHead = null;
    public void push(int value) {
        if(head == null) {
            head = new Node(value);
            opeHead = head;
            opeHead = opeHead.next;
        } else {
            opeHead.next = new Node(value);
            opeHead = opeHead.next;
        }
        if(max < value) {
            max = value;
        }
    }
    public int pop() {
        if(head == null) {
            throw new RuntimeException("此队列为空");
        }
        int value = head.val;
        head = head.next;
        if(value == max) {
            max = Integer.MIN_VALUE;
        }
        return value;
    }
    public int getMax() {
        if(head == null) {
            throw new RuntimeException("此队列为空");
        }
        if(max == Integer.MIN_VALUE) {
            Node node = head;
            while (node != null) {
                max = node.val > max ? node.val : max ;
                node = node.next;
            }
        }
        return max;
    }
}
