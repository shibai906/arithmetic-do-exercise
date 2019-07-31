package com.zhao.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *  组合总和 II
 *  这个题，亚马逊面试有类型的题型，准备尝试尝试当时做法，先排序，完了之后流水账形式。
 */
public class GroupSum {

    static List<List<Integer>> ans = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args) {
        combinationSum2(new int[]{2,5,2,1,2},5);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        int len = candidates.length - 1;
        while (len >= 0 && candidates[len] > target) {
            len -- ;
        }
        int[] arr = new int[len + 1];
        System.arraycopy(candidates,0,arr,0,len + 1);
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i ++) {
            if(i > 1 && arr[i] == arr[i - 1]) {
                continue;
            }
            digui2(arr,list,target,i );
            list.clear();
        }
        ans.remove(ans.size() - 1);
        return ans;
    }
    private static void digui2(int[] arr , List<Integer> list, int target , int begin ) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            while (begin > 1 && begin < arr.length && arr[begin] == arr[begin - 1]) {
                begin ++;
            }
        }

        for(int i = begin ; i < arr.length && target - arr[i] >= 0 ; i ++) {
            list.add(0,arr[i]);
            digui2(arr,list,target - arr[i], ++i );

            list.remove(0);
        }
    }


/*
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = candidates.length - 1;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        while(len >= 0 && candidates[len] > target) {
            len -- ;
        }
        if(target == 0) {
            for(int i = len ; i >= 0 ; i ++) {
                if(target - candidates[i] == 0) {
                    list.add(candidates[i]);
                    ans.add(new ArrayList<>(list));
                } else {
                    return ans;
                }
            }
        }
        for(int i = 0 ; i <= len ; ) {
            if(target  > 0) {
                target -= candidates[i];
                list.add(candidates[i]);
                i ++;
            } else if(target  < 0) {
                target += list.remove(0);
            } else {
                ans.add(new ArrayList<>(list));
                target = target + list.remove(0);
                i ++;
            }
        }
        return ans;
    }


*/
}
