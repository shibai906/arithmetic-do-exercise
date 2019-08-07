package com.zhao.leetcode.bisai.bi148;

/**
 * 递减元素使数组呈锯齿状  显示英文描述
 * 用户通过次数 4
 * 用户尝试次数 7
 * 通过次数 4
 * 提交次数 8
 * 题目难度 Easy
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都小于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * /7,4,8,9,7,7,5
 * /2,7,10,9,8,9
 */
public class Zigzag {

    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[]{10,1,1,6,6,6,1,8,8,5,1,2,6,6,6,4,4,8,7,1}));
    }

    public static int movesToMakeZigzag(int[] nums) {
        int len = nums.length;
        int maxji = 0 , maxou = 0 ;
        int[] arr = new int[len];
        for(int i = 0 ; i < nums.length ; i ++) {
            arr[i] = nums[i];
        }
        for(int i = 0 ; i < len; i +=2) {
            int num = 0 ;
            if(i > 0 && nums[i] >= nums[i - 1]) {
                num = nums[i] - nums[i-1] + 1  ;
                nums[i] -= num;
                maxji += num;
            }
            if(i < len - 1 && nums[i] >= nums[i + 1]) {
                num = nums[i] - nums[i+1] + 1;
                nums[i] -= num;
                maxji += num;
            }
            if(i > 0 && arr[i] <= arr[i - 1]) {
                num = arr[i - 1] - arr[i] + 1;
                arr[i - 1] -= num;
                maxou += num;
            }
            if(i < len - 1 && arr[i] <= arr[i + 1]) {
                num = arr[i + 1] - arr[i] + 1;
                arr[i + 1] -= num;
                maxou += num;
            }
        }
        return maxji > maxou ? maxou : maxji;

    }

}
