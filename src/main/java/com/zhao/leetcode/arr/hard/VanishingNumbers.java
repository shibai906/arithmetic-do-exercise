package com.zhao.leetcode.arr.hard;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-05 10:29
 * @description
 * 地址：https://leetcode-cn.com/problems/missing-two-lcci/
 * 题目：给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 思路一： 求出两个数字和，然后两个数字除以2，求出中位数，然后在取出左边右边值
 **/
public class VanishingNumbers {

    public static void main(String[] args) {
        VanishingNumbers numbers = new VanishingNumbers();
        System.out.println(numbers.missingTwo(new int[]{1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,25}));
    }
    public int[] missingTwo(int[] nums) {

        if (nums == null) {
            return nums;
        }
        int allLength = nums.length + 2;

        int all = add(1, allLength);

        for (int i = 0 ; i < nums.length; i ++) {
            all -= nums[i];
        }

        int ave = all / 2;

        int maxAll = add(ave + 1, allLength);

        int minAll = add(1, ave);

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > ave) {
                maxAll -= nums[i];
            } else {
                minAll -= nums[i];
            }
        }


        return new int[]{minAll, maxAll};
    }

    private int add(int i, int allLength) {
        int reslut = 0;
        for (;i <= allLength; i ++) {
            reslut += i;
        }
        return reslut;
    }

}
