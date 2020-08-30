package com.zhao.leetcode.arr.medium;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-18 00:20
 * @description
 * 地址：https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 题目：寻找重复数
 * 描述：给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 **/
public class QueryRepetitionNum {

    public static void main(String[] args) {
        QueryRepetitionNum qn = new QueryRepetitionNum();
        System.out.println(qn.twoPointsFindDuplicate(new int[]{1,3,4,2,2}));
    }


    /**
     * 自己写的二分法
     * @param nums
     * @return
     */
    public int myTwoPointsFindDuplicate(int[] nums) {
        int len = nums.length;
        // r = len-1的原因在于它最大数为n - 1
        int l = 0 , r = len - 1 , ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for(int num : nums) {
                if(num <= mid) {
                    count ++;
                }
            }
            // 通过计算发现，要是等于mid的话，说明那些数都是自增到mid的
            if(count <= mid) {
                l = mid + 1;
            } else {
                // 一定存在这个数，满足个数大于中间值，要是没有，就不存在这个值
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public int slowAndFastFindDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    /**
     * 方法一：二分查找
     * 思路和算法：
     *  简单的理解就是通过二分查找基数，大于缩小区间，注意的一点是，要明白零界点
     *
     * @param nums
     * @return
     */
    public int twoPointsFindDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}
