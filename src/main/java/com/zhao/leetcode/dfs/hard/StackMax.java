package com.zhao.leetcode.dfs.hard;

import org.apache.kafka.common.metrics.stats.Max;

import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-03 15:24
 * @description
 * 地址：https://leetcode-cn.com/problems/maximum-value-of-k-coins-from-piles/
 * 题目：从栈中取出 K 个硬币的最大面值和
 * 描述：一张桌子上总共有 n 个硬币 栈 。每个栈有 正整数 个带面值的硬币。
 *
 * 每一次操作中，你可以从任意一个栈的 顶部 取出 1 个硬币，从栈中移除它，并放入你的钱包里。
 *
 * 给你一个列表 piles ，其中 piles[i] 是一个整数数组，分别表示第 i 个栈里 从顶到底 的硬币面值。同时给你一个正整数 k ，请你返回在 恰好 进行 k 次操作的前提下，你钱包里硬币面值之和 最大为多少 。
 *
 *
 **/
public class StackMax {

    // TODO: 2022/4/3 还没完全理解

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        // dp[i][j] 表示 前 i 个数组中取 j 个的最大值，返回值 dp[n][k]
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 0;
        for (int i = 1 ; i <= n; i ++) {
            for (int j = 1; j <= k; j ++) {
                int sum = 0;
                for (int kk = 0; kk <= piles.get(i - 1).size() && kk <= j ; kk ++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - kk] + sum);
                    if (kk < piles.get(i - 1).size()) {
                        sum += piles.get(i - 1).get(kk);
                    }
                }
            }
        }
        return dp[n][k];
    }


    /**
     * 全排列会超时
     */
    /*private int max = 0;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        dfs(piles, 0, k, 0);
        return max;
    }

    private void dfs(List<List<Integer>> piles, int startPiles, int times, int add) {

        if (times == 0) {
            max = Math.max(add, max);
        }
        if (piles.size() <= startPiles) {
            return;
        }
        dfs(piles, startPiles + 1, times, add);
        List<Integer> pile = piles.get(startPiles);
        for (int p : pile) {
            add += p;
            times --;
            dfs(piles, startPiles + 1, times, add);
        }
    }
*/
}
