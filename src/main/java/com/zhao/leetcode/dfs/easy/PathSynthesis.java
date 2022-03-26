package com.zhao.leetcode.dfs.easy;

import com.zhao.leetcode.tree.TreeNode;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-20 17:52
 * @description 名称：路径总和
 * 描述：给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有
 * 节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * 地址：https://leetcode-cn.com/problems/path-sum/
 */

public class PathSynthesis {

    public static boolean result = false;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(3);
        root.left = left;
//        root.right = right;
        PathSynthesis ps = new PathSynthesis();
        System.out.println(ps.hasPathSum(root, 1));

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        result = false;
        pathSum(root, targetSum);
        return result;

    }

    public void pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val && (root.left == null && root.right == null)) {
            result = true;
        }
        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
    }


}
