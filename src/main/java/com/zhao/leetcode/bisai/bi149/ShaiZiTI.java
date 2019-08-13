package com.zhao.leetcode.bisai.bi149;

import java.util.ArrayList;
import java.util.List;

/**
 * 1155. 掷骰子的N种方法  显示英文描述
 * 用户通过次数 176
 * 用户尝试次数 282
 * 通过次数 177
 * 提交次数 470
 * 题目难度 Medium
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 *
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 *
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回
 */
public class ShaiZiTI {

    public static void main(String[] args) {

    }

    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d][target + 1];
        final int mod = 1000000007;
        for(int i = 1; i <= f && i <= target; i++)
            dp[0][i] = 1;
        for(int i = 1; i < d; i++){
            for(int j = 0; j <= target; j++){
                if(dp[i - 1][j] == 0)
                    continue;
                for(int k = 1; k <= f && j + k <= target; k++){
                    dp[i][j + k] += dp[i-1][j];
                    dp[i][j + k] %= mod;
                }
            }
        }
        return dp[d-1][target];
    }

}
