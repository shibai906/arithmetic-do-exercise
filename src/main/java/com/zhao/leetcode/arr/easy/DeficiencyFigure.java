package com.zhao.leetcode.arr.easy;

/**
 *  名称： 缺失数字
 *  地址： https://leetcode-cn.com/problems/missing-number/
 *  题目： 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class DeficiencyFigure {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
    }

    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int all = len % 2 == 1 ? (1 + len / 2) * len : ((3 + 2*len - 1) / 2) * (len / 2);
        for(int num : nums) {
            all -= num ;
        }
        return all;

    }

}
