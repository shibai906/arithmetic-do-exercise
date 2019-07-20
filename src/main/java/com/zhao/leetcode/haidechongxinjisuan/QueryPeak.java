package com.zhao.leetcode.haidechongxinjisuan;

/**
 * 寻找峰值
 */
public class QueryPeak {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,1}));
    }

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len < 2) {
            return 0;
        }
        if(len < 3) {
            if(nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        int i = 2,j = len - 3;
        while (i - j < 3) {
            if(nums[i] < nums[i - 1] && nums[i - 1] > nums[i - 2]) {
                return i - 1;
            }
            if(nums[j] < nums[j + 1] && nums[j + 1] > nums[j + 2]) {
                return j + 1;
            }
            j -- ;
            i ++ ;
        }
        if(nums[len - 1] < nums[0]) {
            return 0;
        }
        return len - 1;
    }

}
