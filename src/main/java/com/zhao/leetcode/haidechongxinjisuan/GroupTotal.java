package com.zhao.leetcode.haidechongxinjisuan;

import java.util.ArrayList;
import java.util.List;

// 组合总数 抄袭，有时间接着重新做这个题
public class GroupTotal {

    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates.length < 1 ) {
            return ans;
        }
        java.util.Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        digui(candidates,list,target,0);
        return ans;
    }

    private static void digui(int[] cand , List<Integer> list, int target , int begin) {

        if(target == 0) {
            ans.add(new ArrayList<>(list));
        }
        for(int i = begin ; i < cand.length && target >= cand[i] ; i ++) {
            list.add(cand[i]);
            digui(cand,list,target - cand[i] , i) ;
            list.remove(0);
        }

    }

}
