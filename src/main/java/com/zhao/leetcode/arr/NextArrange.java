package com.zhao.leetcode.arr;

public class NextArrange {

    public static void main(String[] args) {
        nextPermutation(new int[]{1});
    }


    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2 ;
        while (i >= 0 && nums[i] >= nums[i + 1] ) {
            i -- ;
        }
        if(i >= 0) {
            int j = i + 1 ;
            while (j < nums.length  && nums[j] > nums[i]) {
                j ++ ;
            }
            swap(nums , i , j - 1 );
        }
        resource(nums, i + 1);
    }

    private static void resource(int[] nums, int start) {
        int j = nums.length - 1 ;
        while (start < j) {
            swap(nums,start,j);
            start ++ ;
            j -- ;
        }
    }

    public static void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }


}
