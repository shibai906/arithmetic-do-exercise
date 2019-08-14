package com.zhao.leetcode.arr;

/**
 *  地址： https://leetcode-cn.com/problems/first-missing-positive/
 *  给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 *
 *
 */
public class DeficiencyFirstNumber {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];

        for(int i = 0 ; i < len ; i++) {
            if(nums[i] <= len && nums[i] > 0) {
                arr[nums[i] - 1] = -1;
            }
        }
        for(int i = 0 ; i < len ; i ++) {
            if(arr[i] == 0) {
                return i + 1;
            }
        }
        return len + 1;

    }

}
