package com.zhao.leetcode.bisai.bi200;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-02 11:04
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-200/problems/get-the-maximum-score/
 * 题目：最大得分
 * 描述：你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。
 *  一条 合法路径 定义如下：
 *  选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
 *  从左到右遍历当前数组。
 *  如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
 *  得分定义为合法路径中不同数字的和。
 *  请你返回所有可能合法路径中的最大得分。
 *  由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
 **/
public class MaxScore {

    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        maxScore.maxSum(new int[]{2,4,5,8,10} , new int[]{4,6,8,9});
    }

    public int maxSum(int[] nums1, int[] nums2) {
        int max = 1000000007;
        if(nums1 == null || nums1.length == 0) {
            return (int) (addNum(nums2) % max);
        }
        if(nums2 == null || nums2.length == 0) {
            return (int) (addNum(nums1) % max);
        }

        int minLen = Math.min(nums1.length , nums2.length) ;
        long[] num1Add = new long[minLen];
        long[] num2Add = new long[minLen];
        int len = 0 , i = 0 , j = 0;
        long add1 = 0 , add2 = 0;
        while (i < nums1.length  && j < nums2.length ) {

            if(nums1[i] == nums2[j]) {
                num1Add[len] = add1 + nums1[i ++];
                num2Add[len ++] = add2 + nums2[j ++];
                add1 = 0 ; add2 = 0 ;
            } else if(nums1[i] < nums2[j]) {
                add1 += nums1[i ++] ;
            } else if(nums1[i] > nums2[j]) {
                add2 += nums2[j ++];
            }
        }
        for( ; i < nums1.length ; i ++) {
            add1 += nums1[i];
        }
        for( ; j < nums2.length ; j ++) {
            add2 += nums2[j];
        }
        num1Add[len] = add1;
        num2Add[len ++] = add2;
        long result = 0;
        for(i = 0 ; i < len ; i ++) {
            result += Math.max(num1Add[i],num2Add[i]);
        }
        return (int) (result % max);

    }

    public long addNum(int arr[]) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        long result = 0;
        for(int num : arr) {
            result += num;
        }
        return result;
    }

}
