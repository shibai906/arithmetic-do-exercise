package com.zhao.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WholeArrangeTwo {


    private static List<List<Integer>> anslist = new ArrayList<>();


    public static void main(String[] args) {

        permuteUnique(new int[]{1,1,2});

    }


    // 自己的算法，在原有的基础上，使用list集合加一个验证
    public static List<List<Integer>> MypermuteUnique(int[] nums) {
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
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= list.size(); i++) {
            List<Integer> integerList = new LinkedList<>(list);
            integerList.add(i, nums[list.size()]);
            if(lists.contains(list)) {
                continue;
            }
            if(list.size() == nums.length - 1) {
                if (!ans.contains(integerList)) {
                    ans.add(integerList);
                }
            } else {
                digui(nums, ans, integerList);
            }
        }
    }





    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        getPermution(list, used, nums);
        return anslist;
    }

    public static void getPermution(List<Integer> list, int[] used, int[] nums) {
        if (list.size() == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>(list);
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == 0){
                    tmp.add(nums[i]);
                }
            }
            anslist.add(tmp);
            return;
        }
        int lastUsed = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 如果nums[i] == lastUsed，则跳过本次循环
            if (used[i] == 0 && nums[i] != lastUsed) {
                used[i] = 1;
                list.add(nums[i]);
                getPermution(list, used, nums);
                lastUsed = nums[i];
                used[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> pruningPermuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] used = new int[nums.length];
        pruningRecursive(res,list,used,nums);
        return res;

    }

    public static void pruningRecursive(List<List<Integer>> res , List<Integer> list , int[] used , int[] nums) {

        if(list.size() == nums.length - 1) {
            List<Integer> ope = new ArrayList<>(list);
            for(int i = 0 ; i < nums.length ; i ++) {
                if(used[i] == 0) {
                    ope.add(nums[i]);
                }
            }
            res.add(ope);
            return;
        }
        int lastUsed = Integer.MIN_VALUE;
        for(int i = 0 ; i < used.length ; i ++) {
            if(used[i] == 0 && nums[i] != lastUsed) {
                used[i] = 1 ;
                list.add(nums[i]);
                pruningRecursive(res,list,used,nums);
                lastUsed = nums[i];
                used[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

}
