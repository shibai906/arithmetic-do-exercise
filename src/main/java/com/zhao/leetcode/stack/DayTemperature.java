package com.zhao.leetcode.stack;

import java.util.Stack;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-21 18:29
 * @description
 * 地址：https://leetcode.cn/problems/iIQa4I/
 * 题目：每日温度
 * 描述：
 **/
public class DayTemperature {

    public static void main(String[] args) {
        DayTemperature dayTemperature = new DayTemperature();
        dayTemperature.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int n = temperatures.length;
        int[] result = new int[n];
        stack.push(0);
        for (int i = 1; i < n; i ++) {
            int pop = stack.peek();
            while (temperatures[pop] < temperatures[i]) {
                result[stack.pop()] = i - pop;
                if (stack.isEmpty()) {
                    break;
                }
                pop = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }

}
