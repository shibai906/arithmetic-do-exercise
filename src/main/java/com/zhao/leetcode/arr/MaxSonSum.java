package com.zhao.leetcode.arr;

import java.util.Arrays;

/**
 * 最大子序和
 *  给定一个整数数组nums，找到具有最大和的连续子数组(子数组最少包含一个元素)，返回其最大和
 */
public class MaxSonSum {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0] ,num = nums[0], j = 0;
        for(int i = 1 ; i < nums.length ; i ++ ) {
            if(num > max) {
                max = num;
            }
            if(num + nums[i] <= 0) {
                num = 0 ;
                i = j;
                j ++ ;
                continue;
            }
            num += nums[i];
        }
        return max;


        /*int max = nums[0] ,num = nums[0];
        for(int i = 1 ; i < nums.length ; i ++ ) {
            if(num > max) {
                max = num;
            }
            if(num + nums[i] <= 0) {
                if(num!=0){
                    num = 0 ;
                    i --;
                }
                continue;
            }
            num += nums[i];
        }
        return max;*/

    }

}
