package com.zhao.leetcode.arr;

/**
 * 乘积最大子序列
 *
 *
 *
 */
public class ProductMaxList {


    public static void main(String[] args) {

    }

    public static int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE , imax = 1 , imin = 1;
        for(int i = 0 ; i < nums.length ; i ++) {

            if(nums[i] < 0) {
                int temp = imax ;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i] , nums[i]);
            imin = Math.min(imin * nums[i], nums[i]); // 这里的imax，就是为了负数而准备的，其他时候无任何意义
            max = Math.max(imax,max);
        }
        return max;
    }



}
