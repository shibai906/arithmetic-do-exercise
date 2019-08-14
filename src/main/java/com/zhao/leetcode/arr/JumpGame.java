package com.zhao.leetcode.arr;

public class JumpGame {


    public static void main(String[] args) {
        System.out.println(canJump(2,3,1,1,4));
    }

    public static boolean canJump(int[] nums) {

        return canJumpFromPosition(nums, 0);
    }

    // 这里使用的是贪心算法
    public static boolean canJumpFromPosition( int[] nums , int weizhi) {


        if (weizhi == nums.length - 1) {
            return true;
        }


        for(int i = 1 ; i <= nums[weizhi] ; i ++) {
            if(canJumpFromPosition(nums,weizhi + i)) {
                 return true;
            }
        }

        return false;
    }

    // 我自己想的算法
    public static boolean canJump(Integer ... nums) {

        int len = nums.length;
        boolean[] dp = new boolean[len]; // 这里记录每个位置是否能到
        dp[0] = true;
        for(int i = 0 ; i < len ; i ++) {
            for(int j = nums[i] ; j > 0 ; j --) {
                if(j + i < len) {
                    if(dp[j+i] == true) {
                        break;
                    } else {
                        dp[j + i] = true;
                    }
                }
            }
            if(i + 1 < len && dp[i + 1] == false) {
                return false;
            }
        }

        return true;

    }

    // 贪心算法
    public static boolean greedCanJump(Integer ... nums) {

        int max = nums[0];
        for(int i = 1 ; i < nums.length ; i ++) {
            if(max == 0){
                return false;
            }
            max = max - 1 > nums[i] ? max - 1 : nums[i];
        }
        return true;

    }

}
