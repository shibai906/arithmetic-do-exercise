package com.zhao.zuochenyun.stack;

import java.util.Stack;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-06-24 16:22
 * @description
 * 题目：实现一个特殊的栈、在实现栈的基本功能的基础上，实现返回栈中最小元素的操作
 *
 * 要求：
 *  1、pop、push、getMin操作的时间复杂度都是O(1)
 *  2、设计的栈类型可以使用现成的栈结构
 * 思路：
 *  只要记录每一步的最小值即可
 **/
public class StackByGetMin {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public StackByGetMin() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int num) {

        stackData.push(num);
        if(stackMin.empty()) {
            stackMin.push(num);
        } else {
            if(stackMin.peek() >= num) {
                stackMin.push(num);
            }
        }
    }

    public int pop() {
        if(stackData.isEmpty()) {
            throw new NullPointerException();
        }
        int num = stackData.pop();
        if(num == stackMin.peek()) {
            stackMin.pop();
        }
        return num;
    }

    public int getMin() {
        return stackMin.peek();
    }

}
