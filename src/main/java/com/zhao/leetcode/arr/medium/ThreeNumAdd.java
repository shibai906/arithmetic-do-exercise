package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-23 18:38
 * @description
 * 地址：https://leetcode-cn.com/problems/3sum/
 * 题目：三数之和
 * 描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 **/
public class ThreeNumAdd {

    public static void main(String[] args) {

        threeSum(new int[]{-1,0,1,2,-1,-4});

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] < 0 || nums[0] > 0) {
            return result;
        }
        for (int i = 0; i < n - 1; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = n - 1, ans = nums[i];
            while (start < end) {
                if (start > i + 1 && nums[start] ==  nums[start - 1]) {
                    start ++;
                    continue;
                }
                if (end < n - 1 && nums[end] ==  nums[end + 1]) {
                    end --;
                    continue;
                }
                int addThree = ans + nums[start] + nums[end];
                if (addThree == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start ++;
                    end --;
                }
                if (addThree > 0) {
                    end --;
                }
                if (addThree < 0) {
                    start ++;
                }
            }
        }

        return result;
    }

}
