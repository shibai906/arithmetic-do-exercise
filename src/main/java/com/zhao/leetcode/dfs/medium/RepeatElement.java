package com.zhao.leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-06-04 15:56
 * @description
 * 地址：https://leetcode.cn/problems/4sjJUc/
 * 题目：含有重复元素集合的组合
 * 描述：给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 **/
public class RepeatElement {

    public static void main(String[] args) {
        RepeatElement re = new RepeatElement();
        re.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, list);
        return result;
    }
    public void dfs(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (candidates[start] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

/*
    错误解法，太错误了
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, list);
        return result;
    }
    public void dfs(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> list) {

        if (target == candidates[start]) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (; start < candidates.length; start ++) {
            if (candidates[start] > target) {
                break;
            }
            list.add(candidates[start]);
            if (target >= candidates[start]) {
                dfs(candidates, target - candidates[start], start + 1, result, list);
            }
            list.remove(list.size() - 1);
            // 不可能存在这种情况
            dfs(candidates, target, start + 1, result, list);
        }
    }
*/

}
