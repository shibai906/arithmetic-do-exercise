package com.zhao.leetcode.arr.medium;

import java.util.*;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-04-14 10:17
 * leetcode address： https://leetcode-cn.com/problems/combination-sum/
 * topic： 组合总和
 * 做法：给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *  此处的剪枝用的是去重，只需要执行一半即可
 *
 **/
public class GroupNum {

    /**
     * 首先我们使用剪枝叶的办法
     * @param args
     */
    public static void main(String[] args) {
        GroupNum groupNum = new GroupNum();
        List<List<Integer>> list = groupNum.combinationSum(new int[]{3,7,6,2},7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates == null) {
            return list;
        }

        tailor(candidates , 0 , candidates.length , new LinkedList<>() , list , target);

        return list;
    }

    public void tailor (int[] candidates , int start , int end , LinkedList<Integer> inn , List<List<Integer>> result , int target) {
        if(target == 0) {
            result.add(new ArrayList<>(inn));
            return;
        }
        if(target < 0) {
            return;
        }

        for(int i = start ; i < end ; i ++) {
            inn.addLast(candidates[i]);
            tailor(candidates, i ,end,inn,result,target - candidates[i]);
            inn.removeLast();
        }
    }





























    /**
     * 一下方法是leetcode提供的官方解法，咱们学习这些知识，来自己实现一边
     */
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        int len = candidates.length;
//
//        // 排序是为了提前终止搜索
//        Arrays.sort(candidates);
//
//        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
//        return res;
//    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
//    private void dfs(int[] candidates,
//                     int len,
//                     int residue,
//                     int begin,
//                     Deque<Integer> path,
//                     List<List<Integer>> res) {
//        if (residue == 0) {
//            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = begin; i < len; i++) {
//
//            // 在数组有序的前提下，剪枝
//            if (residue - candidates[i] < 0) {
//                break;
//            }
//
//            path.addLast(candidates[i]);
//            dfs(candidates, len, residue - candidates[i], i, path, res);
//            path.removeLast();
//
//        }
//    }

}
