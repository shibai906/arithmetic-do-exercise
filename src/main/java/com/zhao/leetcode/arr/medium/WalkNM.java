package com.zhao.leetcode.arr.medium;

/**
 * @author zhaohuan
 * @time 2019-10-30 11:20
 * 链接： https://leetcode-cn.com/problems/unique-paths/
 * 题目描述： 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 *  题目描述是，给一个M × N 的网格，机器人每次只能走一步，往左或者
 *
 */
public class WalkNM {

    public static void main(String[] args) {
        int num = walk(0,0,1,1);
        System.out.println(num);
    }

    // 方法二，看着别人的算法
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    // 方法一，超时
    public static int walk(int M , int N , int NMax , int MMax) {

        if(M == MMax - 1 || N == NMax - 1) {
            return 1;
        }
        return walk(M + 1 , N , NMax , MMax) + walk(M , N + 1 , NMax , MMax );

    }

}
