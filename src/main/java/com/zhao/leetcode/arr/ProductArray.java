package com.zhao.leetcode.arr;

import java.util.Arrays;

/**
 * Product of Array Except Self
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
public class ProductArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int add = 1 ;
        int zeroCount = 0;
        for(int i = 0 ; i < len ; i ++) {
            if(nums[i] == 0) {
                zeroCount ++ ;
                if(zeroCount > 1) {
                    return new int[len];
                }
            } else {
                add *= nums[i];
            }

        }
        if(zeroCount == 1) {
            for(int i = 0 ; i < len ; i ++) {
                if(nums[i] != 0)
                    nums[i] = 0;
                else
                    nums[i] = add;
            }
        } else {
            for(int i = 0 ; i < len ; i ++) {
                nums[i] = add / nums[i];
            }
        }
        return nums;
    }

}
