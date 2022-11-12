package com.zhao.leetcode.bisai.bi318;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-11-06 13:43
 * @description
 * 地址：https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 * 题目：长度为 K 子数组中的最大和
 * 描述：
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 * <p>
 * 子数组 是数组中一段连续非空的元素序列。
 **/
public class ArrNumMax {

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        if (nums.length < k) {
            return 0;
        }
        long add = 0, result = 0;
        for (int i = 0; i < k; i++) {
            add += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result = getResult(k, map, add, result);
        for (int i = k; i < nums.length; i++) {
            add += nums[i];
            add -= nums[i - k];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            removeNum(map, nums[i - k]);
            if (map.size() == k && add > result) {
                result = add;
            }
        }
        return result;
    }

    private long getResult(int k, Map<Integer, Integer> map, long add, long result) {
        if (map.size() == k) {
            result = add;
        }
        return result;
    }

    private void removeNum(Map<Integer, Integer> map, int index) {

        Integer num = map.get(index);
        if (num == null) {
            System.out.println();
        }
        if (num == 1) {
            map.remove(index);
        } else {
            map.put(index, num - 1);
        }
    }

}
