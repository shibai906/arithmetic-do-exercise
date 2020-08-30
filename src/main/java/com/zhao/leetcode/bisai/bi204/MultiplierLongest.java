package com.zhao.leetcode.bisai.bi204;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-30 11:58
 * @description
 * 地址：https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/
 * 题目：乘积为正数的最长子数组长度
 * 描述：给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 *      一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *      请你返回乘积为正数的最长子数组长度。
 *
 **/
public class MultiplierLongest {

    public static void main(String[] args) {
        MultiplierLongest ml = new MultiplierLongest();
        System.out.println(ml.getMaxLen(new int[]{1,-2,-3,4}));
        System.out.println(ml.getMaxLen(new int[]{70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86}));
    }

    public int getMaxLen(int[] nums) {

        int max = 0 , num = 0 , num1 = 0;
        int cheng = 1 , cheng1 = 0;
        for(int i = 0 ; i < nums.length ; i ++) {
            cheng *= nums[i];
            cheng1 *= nums[i];
            num ++;
            if(cheng > 0) {
                cheng = 1;
                if(max < num) {
                    max = num;
                }
            }
            if(cheng1 != 0) {
                num1 ++ ;
                if(cheng1 > 0 && max < num1) {
                    cheng1 = 1;
                    max = num1;
                } else  {
                    cheng1 = -1;
                }
            }
            if(cheng < 0) {
                cheng = -1;
                cheng1 = 1;
            }
            if(cheng == 0) {
                num = 0;
                cheng = 1;
                cheng1 = 0;
                num1 = 0;
            }

        }
        return max;


    }

}
