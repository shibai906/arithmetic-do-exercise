package com.zhao.leetcode.stack;

import java.util.Stack;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-12 22:41
 * @description
 * 题目：栈的压入、弹出序列
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *          例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 **/
public class SequenceToJudge {

    public static void main(String[] args) {
        SequenceToJudge stj = new SequenceToJudge();
        System.out.println(stj.isPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        if(pushSequence == null && popSequence == null) {
            return true;
        }
        if(pushSequence == null || popSequence == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int len = pushSequence.length;
        for(int i = 0 ; i < len ; i ++) {
            if(stack.isEmpty()) {
                if(num + 1 >= len)  {
                    return false;
                }
                stack.push(pushSequence[num ++]);
            }
            if(stack.peek() == popSequence[i]) {
                stack.pop();
            } else {
                while (true) {
                    if(num >= len)  {
                        return false;
                    }
                    if(pushSequence[num] == popSequence[i]) {
                        num ++;
                        break;
                    }
                    stack.push(pushSequence[num ++]);
                }
            }
        }
        return true;


    }

}
