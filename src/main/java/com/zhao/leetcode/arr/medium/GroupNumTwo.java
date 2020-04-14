package com.zhao.leetcode.arr.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-14 11:00
 * leetcode 地址：https://leetcode-cn.com/problems/combination-sum-ii/
 * 题目：组合总和 II
 * 要求： 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *       candidates 在上一层的基础上，先剪重复的，然后再减之前执行过的。
 *
 *
 **/
public class GroupNumTwo {

    public static void main(String[] args) {
        GroupNumTwo groupNumTwo = new GroupNumTwo();
        List<List<Integer>> list = groupNumTwo.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> cun = new LinkedList<>();
        for(int cand : candidates) {
            list.add(cand);
        }

        dfs(list,0,cun,result , target);
        return result;

    }

    private void dfs(LinkedList<Integer> list,int start, LinkedList<Integer> cun,  List<List<Integer>> result , int target) {
        if(target == 0) {
            result.add(new ArrayList<>(cun));
        }
        if(target < 0) {
            return;
        }
        int last = 0;
        for(int i = start ; i < list.size() ; i ++) {
            if(i > 0) {
                last = list.get(i - 1);
            }
            if(i == 0 || last != list.get(i)) {
                int remove = list.remove(i);
                cun.addLast(remove);
                dfs(list , i,cun,result,target - remove);
                cun.removeLast();
                list.add(i,remove);
            }
        }


    }


}
