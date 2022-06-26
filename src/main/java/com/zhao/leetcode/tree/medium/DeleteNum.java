package com.zhao.leetcode.tree.medium;

import com.zhao.leetcode.tree.TreeNode;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-06-26 19:46
 * @description
 * 地址：https://leetcode.cn/problems/delete-node-in-a-bst/
 * 题目：删除二叉搜索树中的节点
 * 描述：给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 *  1、首先找到需要删除的节点；
 *  2、如果找到了，删除它。
 *
 **/
public class DeleteNum {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 首先特殊处理根节点
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            // 处理左右节点
            return getSon(root.left, root.right);
        }
        digui(root, key);
        return root;
    }

    private TreeNode getSon(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        TreeNode lastLeft = getLastLeft(right);
        lastLeft.left = left;
        return right;
    }

    private TreeNode getLastLeft(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return getLastLeft(root.left);
    }

    public void digui(TreeNode root, int key) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.val == key) {
            root.left = getSon(root.left.left, root.left.right);
        }
        if (root.right != null && root.right.val == key) {
            root.right = getSon(root.right.left, root.right.right);
        }
        if (root.val > key) {
            digui(root.left, key);
        }
        if (root.val < key) {
            digui(root.right, key);
        }
    }

}
