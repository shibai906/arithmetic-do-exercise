package com.zhao.leetcode.arr.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-06-06 21:15
 * @description
 * 地址：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 题目：最长递增子序列
 * 题意：给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *  子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 解法：动态规划
 **/
public class MacInc {
    public static void main(String[] args) {
        MacInc macInc = new MacInc();
        macInc.lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
    public int lengthOfLIS(int[] nums) {
        if(nums ==null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0 ; j < i ; j ++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0 ;
        for (int i : dp) {
            max = Math.max(max , i);
        }
        return max + 1;
    }

}
