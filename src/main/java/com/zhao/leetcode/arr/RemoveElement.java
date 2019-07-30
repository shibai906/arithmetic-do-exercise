package com.zhao.leetcode.arr;

public class RemoveElement {

    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len < 1) {
            return 0;
        }
        int jishu = 0;
        for(int i = 0 ; i < len ; i ++) {
            if(nums[i] != val) {
                nums[jishu ++] = nums[i];
            }
        }
        return jishu;
    }

}
