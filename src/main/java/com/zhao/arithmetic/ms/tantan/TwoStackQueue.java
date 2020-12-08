package com.zhao.arithmetic.ms.tantan;

import java.util.Stack;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-23 17:02
 * @description
 **/
public class TwoStackQueue {

    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public void push(int num) {
        if(!popStack.isEmpty()) {
            while (!popStack.isEmpty()) {
                pushStack.push(popStack.pop());
            }
        }
        pushStack.push(num);
    }

    public int pop() {

        if(!pushStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if(popStack.isEmpty()) {
            throw new RuntimeException();
        }
        return popStack.pop();

    }


    public static void main(String[] args) {

    }




}
