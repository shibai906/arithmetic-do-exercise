package com.zhao.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地址： https://leetcode-cn.com/problems/implement-stack-using-queues/
 * 题目： 用队列实现栈
 * 描述： 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class QueueComeInn {

    Queue<Integer> que1 = new LinkedList<>();
    Queue<Integer> que2 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public QueueComeInn() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        que1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int result = 0 ;
        if(!que1.isEmpty()) {
            result = que1.remove();
            while (!que1.isEmpty()) {
                que2.add(result);
            }
        } else {
            result = que1.remove();
            while (!que2.isEmpty()) {
                que1.add(result);
            }
        }
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int result = 0 ;
        if(!que1.isEmpty()) {
            while (!que1.isEmpty()) {
                result = que1.remove();
                que2.add(result);
            }
        } else {
            while (!que2.isEmpty()) {
                result = que1.remove();
                que1.add(result);
            }
        }
        return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return que1.isEmpty() && que2.isEmpty();
    }

}
