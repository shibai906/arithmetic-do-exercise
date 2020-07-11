package com.zhao.leetcode.arr.medium;

/**
 * @PROJECT_NAME: arithmetic-do-exercise
 * @USER: zhaohuan
 * @DATE: 2020/6/28 8:51 下午
 * @DESCRIPTION:
 * 题目：长度最小的子数组
 * 内容：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * 地址：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 注意：看题必须清楚
 *
 */
public class MinLengthArr {

    public static void main(String[] args) {

        MinLengthArr arr = new MinLengthArr();
        arr.minSubArrayLenByMe(11 ,new int[]{1,2,3,4,5});

    }

    public int minSubArrayLen(int s, int[] nums) {
        int lo = 1, hi = nums.length, min = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (windowExist(mid, nums, s)) {
                hi = mid - 1;//找到就缩小窗口的大小
                min = mid;//如果找到就记录下来
            } else
                lo = mid + 1;//没找到就扩大窗口的大小
        }
        return min;
    }

    //size窗口的大小
    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size)
                sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s)
                return true;
        }
        return false;
    }


    public int minSubArrayLenByMe(int s, int[] nums) {

        if(nums == null ) {
            return 0;
        }
        int sum = 0 , len = 0 , minLen = Integer.MAX_VALUE ;
        for(int i = 0 ; i <= nums.length ; ) {
            if (sum >= s) {
                minLen = Math.min(len, minLen);
                sum -= nums[i - len];
                len--;
            } else if(i < nums.length) {
                sum += nums[i];
                len++;
                i++;
            } else {
                i ++ ;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
