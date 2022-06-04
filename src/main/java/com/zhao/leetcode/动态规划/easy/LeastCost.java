package com.zhao.leetcode.动态规划.easy;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-06-04 15:51
 * @description
 * 地址：https://leetcode.cn/problems/GzCJIP/
 * 题目：爬楼梯的最少成本
 * 描述：数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *  每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 *  请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 **/
public class LeastCost {


    public int minCostClimbingStairs(int[] cost) {
        int prev = 0, result = 0;
        for (int i = 2; i <= cost.length; i ++) {
            int jilu = result;
            result = Math.min(result + cost[i - 1], prev + cost[i - 2]);
            prev = jilu;

        }
        return result;
    }

}
