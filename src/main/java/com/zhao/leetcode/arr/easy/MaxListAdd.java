package com.zhao.leetcode.arr.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 地址： https://leetcode-cn.com/problems/maximum-subarray/
 * 题目： 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxListAdd {


    public static void main(String[] args) {
        maxSubArray(new int[]{-2,-1});
    }

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        int max = nums[0];
        int add = 0;
        for(int i = 0 ; i < nums.length ; i ++) {
            add += nums[i];
            list.add(nums[i]);
            if(add > max) {
                max = add;
            }
            while (add < 0 && !list.isEmpty()) {
                add -= list.remove(0);
                if(add > max && !list.isEmpty()) {
                    max = add;
                }
            }
        }
        return max;
    }

    public static int maxSubArrayTo(int[] nums) {
        int count = nums[0];
        int max = nums[0];
        for(int i = 1 ; i < nums.length ; i ++) {
            if(count > 0) {
                count += nums[i];
            } else {
                count = nums[i];
            }
            if(count > max) {
                max = count;
            }
        }
        return max;
    }





}
