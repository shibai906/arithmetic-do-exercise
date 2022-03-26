package com.zhao.leetcode.dfs.medium;

import com.zhao.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-20 18:10
 * @description
 * 题目：路径总和 II
 * 描述：给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 **/
public class PathSynthesisTwo {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        pathSum(root, targetSum, list, result);
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result) {

        if (root == null) {
            return;
        }
        list.add(root.val);
        if (targetSum == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        pathSum(root.left, targetSum - root.val, list, result);
        pathSum(root.right, targetSum - root.val, list, result);
        list.remove(list.size() - 1);

    }


}
