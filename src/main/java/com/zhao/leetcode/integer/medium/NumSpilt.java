package com.zhao.leetcode.integer.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-24 16:19
 * @description
 * 地址：https://leetcode.cn/problems/integer-break/
 * 题目： 整数拆分
 * 描述：给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *  返回 你可以获得的最大乘积 。
 **/
public class NumSpilt {
    // 动态规划
/*    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n +1];

        for (int i = 1 ; i <= n; i ++) {
            dp[i] = i;
            for (int j = 1; j < i; j ++) {
                dp[i] = Math.max(dp[i], (i - j) * dp[j]);
            }
        }
        return dp[n];
    }*/
    // 数学解法
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int yu = n % 3;
        n = n / 3;
        if (yu == 1) {
            yu += 3 ;
            n --;
        }
        if (yu == 0) {
            yu = 1;
        }
        return (int) (Math.pow(3, n) * yu);
    }

}
