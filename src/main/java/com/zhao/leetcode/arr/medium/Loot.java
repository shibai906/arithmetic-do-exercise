package com.zhao.leetcode.arr.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-09 15:51
 * @description 地址：https://leetcode-cn.com/problems/house-robber/
 * 题目：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 **/
public class Loot {

    public static void main(String[] args) {
        Loot t = new Loot();
        System.out.println(t.rob(new int[]{1,2,3,1}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int beforeTwo = nums[0], beforeOne = Math.max(nums[0], nums[1]);

        for (int i = 2 ; i < nums.length - 1; i ++) {
            int temp = beforeOne;
            beforeOne = Math.max(beforeTwo + nums[i], beforeOne);
            beforeTwo = temp;

        }
        if (n == 2) {
            return beforeOne;
        }
        int max = beforeOne;

        beforeTwo = nums[1];
        beforeOne = Math.max(nums[1], nums[2]);

        for (int i = 3 ; i < nums.length; i ++) {
            int temp = beforeOne;
            beforeOne = Math.max(beforeTwo + nums[i], beforeOne);
            beforeTwo = temp;

        }
        return Math.max(max, beforeOne);
    }

}
