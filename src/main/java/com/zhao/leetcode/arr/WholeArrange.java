package com.zhao.leetcode.arr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列，给顶一个没有重复数字的序列，返回其所有可能的全排列
 */
public class WholeArrange {

    public static void main(String[] args) {
        permute(new int[] {1,2,3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) {
            return ans;
        }
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        digui(nums, ans, list);
        return ans;
    }

    public static void digui(int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if(nums.length == 1) {
            ans.add(list);
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            List<Integer> integerList = new LinkedList<>(list);
            integerList.add(i, nums[list.size()]);
            if(list.size() == nums.length - 1) {
                ans.add(integerList);
            } else {
                digui(nums, ans, integerList);
            }
        }
    }

}
