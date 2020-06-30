package com.zhao.leetcode.arr.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-06-15 22:29
 * @description
 * 地址：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 题目：153. 寻找旋转排序数组中的最小值
 * 思路：二分查找的方式，然后找左右即可，
 **/
public class SpinMin {


    public static void main(String[] args) {
        SpinMin spinMin = new SpinMin();
        spinMin.findMin(3,4,5,1,2);
    }

    public int findMin(int ... nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int min = 0 , max = nums.length - 1 ;
        int mid = (max + min) / 2;
        while ( max > min) {
            if(nums[mid] > nums[max]) {
                min = mid + 1;
            }
            if(nums[mid] < nums[max]) {
                max = mid ;
            }
            mid = (max + min) /2 ;
        }
        return nums[mid];
    }

}
