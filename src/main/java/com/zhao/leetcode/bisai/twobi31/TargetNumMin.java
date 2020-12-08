package com.zhao.leetcode.bisai.twobi31;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-25 23:24
 * @description
 * 地址：https://leetcode-cn.com/contest/biweekly-contest-31/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 * 题目：形成目标数组的子数组最少增加次数
 * 给你一个整数数组 target 和一个数组 initial ，initial 数组与 target  数组有同样的维度，且一开始全部为 0 。
 * 请你返回从 initial 得到  target 的最少操作次数，每次操作需遵循以下规则：
 * 在 initial 中选择 任意 子数组，并将子数组中每个元素增加 1 。
 * 答案保证在 32 位有符号整数以内。
 **/
public class TargetNumMin {

    public int minNumberOperations(int[] target) {
        if(target == null || target.length == 0) {
            return 0;
        }
        int dp[] = new int[target.length] ;
        dp[0] = target[0] ;
        for(int i = 1 ; i < target.length ; i ++) {
            dp[i] = dp[i - 1];
            if(target[i] - target[i - 1] > 0) {
                dp[i] += target[i] - target[i - 1];
            }
        }
        return dp[target.length - 1];
    }

}
