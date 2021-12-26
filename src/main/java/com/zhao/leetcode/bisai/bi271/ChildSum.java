package com.zhao.leetcode.bisai.bi271;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-12-12 10:45
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-271/problems/sum-of-subarray-ranges/
 * 描述：给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 *
 * 返回 nums 中 所有 子数组范围的 和 。
 *
 * 子数组是数组中一个连续 非空 的元素序列。
 **/
public class ChildSum {

    public static void main(String[] args) {
        ChildSum sum = new ChildSum();
        sum.subArrayRanges(new int[]{4,-2,-3,4,1});
    }

    public long subArrayRanges(int[] nums) {
        long add = 0;
        for (int i = 0 ; i < nums.length; i ++ ) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < nums.length ; j ++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                add += Math.abs(max - min);
            }
        }
        return add;
    }

}
