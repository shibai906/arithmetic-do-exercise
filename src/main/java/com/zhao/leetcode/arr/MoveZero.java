package com.zhao.leetcode.arr;

/**
 * 移动零
 *  给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZero {

    public static void main(String[] args) {

    }

    public static void moveZeroes(int[] nums) {

        int count = 0 ;
        int len = nums.length;
        for(int i = 0 ; i < len ; i ++) {
            if(nums[i] != 0) {
                nums[count ++] = nums[i];
            }
        }
        while (count < len) {
            nums[count ++] = 0;
        }

    }

}
