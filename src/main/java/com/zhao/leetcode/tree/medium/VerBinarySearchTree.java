package com.zhao.leetcode.tree.medium;

import com.zhao.leetcode.tree.TreeNode;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-06-26 16:03
 * @description
 * 地址：https://leetcode.cn/problems/validate-binary-search-tree/
 * 题目：验证二叉搜索树
 * 描述：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *  有效 二叉搜索树定义如下：
 *  节点的左子树只包含 小于 当前节点的数。
 *  节点的右子树只包含 大于 当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 **/
public class VerBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(true && false);
    }

    public boolean isValidBST(TreeNode root) {
        return digui(root, null, null);
    }

    public boolean digui(TreeNode root, Integer leftNum, Integer rightNum) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            if (left.val >= root.val || (leftNum != null && left.val <= leftNum)) {
                return false;
            }
        }
        if (right != null) {
            if (right.val <= root.val || (rightNum != null && right.val >= rightNum)) {
                return false;
            }
        }
        return digui(root.left, leftNum, root.val) && digui(root.right, root.val, rightNum);
    }

}
