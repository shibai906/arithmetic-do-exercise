package com.zhao.leetcode.arr;

import java.util.List;

/**
 * 删除排序数组中的重复项
 */
public class DelRepetitionArr {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 1) {
            return 0;
        }
        int jishu = 1;
        for(int i = 1 ; i < len ; i ++) {
            if(nums[i] != nums[i - 1] ) {
                nums[jishu ++] = nums[i] ;
            }
        }
        return jishu;

    }

}
