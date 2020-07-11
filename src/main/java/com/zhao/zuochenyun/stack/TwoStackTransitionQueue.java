package com.zhao.zuochenyun.stack;

import java.util.Stack;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-05 11:34
 * @description
 **/
public class TwoStackTransitionQueue {

    public static void main(String[] args) {
        TwoStackTransitionQueue queue = new TwoStackTransitionQueue();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        queue.add(3);
        System.out.println(queue.peek());
    }

    public Stack<Integer> stackPush ;
    public Stack<Integer> stackPop ;

    public TwoStackTransitionQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int pushInt) {
        while (!stackPop.isEmpty()) {
            stackPush.add(stackPop.pop());
        }
        stackPush.add(pushInt);
    }

    public Integer pop() {
        if(stackPush.isEmpty() && stackPush.isEmpty()) {
            throw new NullPointerException();
        }
        while (!stackPush.isEmpty()) {
            stackPop.add(stackPush.pop());
        }
        return stackPop.pop();
    }

    public Integer peek() {
        if(stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new NullPointerException();
        }
        while (!stackPush.isEmpty()) {
            stackPop.add(stackPush.pop());
        }
        return stackPop.peek();
    }

}
