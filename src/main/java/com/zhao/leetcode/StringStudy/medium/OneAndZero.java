package com.zhao.leetcode.StringStudy.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-06-06 20:01
 * @description 经典动态规划问题
 * 地址：https://leetcode-cn.com/problems/ones-and-zeroes/
 * 题目：一和零
 * 理解程度：70%，还待学习和理解
 **/
public class OneAndZero {

    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 0; i < length; i++) {
            int[] nums = this.getNums(strs[i]);
            int zero = nums[0];
            int one = nums[1];
            for (int k = 0 ; k < m ; k ++) {
                for (int j = 0 ; j < n ; j ++) {
                    dp[i][k][j] = dp[i - 1][k][j];
                    if (zero <= k && one <= j) {
                        dp[i][k][j] = Math.max(dp[i][k][j], dp[i -1][k - zero][j - one] +1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    private int[] getNums(String str) {
        int[] arr = new int[2];
        int zero = 0, one = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        arr[0] = zero;
        arr[1] = one;
        return arr;
    }

}
