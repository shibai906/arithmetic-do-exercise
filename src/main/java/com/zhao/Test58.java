package com.zhao;

import com.zhao.io.Test;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-24 20:39
 * @description
 **/
public class Test58 {

    public static void main(String[] args) {
        Test58 test58 = new Test58();
        test58.minCostClimbingStairs(new int[]{10,15,20});
    }

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(getMin(cost, 0), getMin(cost, 1));
    }
    private int getMin(int[] cost, int start) {
        int n = cost.length, last = 0, result = cost[start];
        start ++;
        for (; start < n; start ++) {
            int jilu = result;
            result = Math.min(last + cost[start], result);
            last = jilu;
        }
        return result;

    }

}
