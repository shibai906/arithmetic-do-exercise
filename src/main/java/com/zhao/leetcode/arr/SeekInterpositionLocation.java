package com.zhao.leetcode.arr;

/**
 * 搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *  你可以假设数组中无重复元素。
 */
public class SeekInterpositionLocation {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},0));
    }

    public static int searchInsert(int[] nums, int target) {

        int i = 0 , j = nums.length - 1 , middle = 0;
        while (i <= j) {
            middle = (i + j) / 2;
            if(nums[middle] > target) {
                j = middle - 1;
            } else if(nums[middle] < target) {
                i = middle + 1;
            } else {
                return middle;
            }
        }
        if(nums[middle] > target) {
            return middle;
        } else {
            return middle + 1;
        }

    }

}
