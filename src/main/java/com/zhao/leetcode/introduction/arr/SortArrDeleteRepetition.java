package com.zhao.leetcode.introduction.arr;

/**
 * 从排序数组中删除重复项
 */
public class SortArrDeleteRepetition {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int result = 0 ;
        for(int i = 1 ; i < nums.length ; i ++ ) {
            if(nums[i] != nums[result]) {
                nums[++result] = nums[i] ;
            }
        }
        return result + 1;

    }


}
