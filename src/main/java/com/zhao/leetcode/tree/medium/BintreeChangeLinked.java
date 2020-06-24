package com.zhao.leetcode.tree.medium;


import com.zhao.leetcode.tree.TreeNode;

import java.util.Stack;

/**
 *  地址： https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *  二叉树展开为链表
 *  给定一个二叉树，原地将它展开为链表。
 */
public class BintreeChangeLinked {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        TreeNode leftleft = new TreeNode(3);
        TreeNode leftRifht = new TreeNode(4);
        left.left = leftleft;
        left.right = leftRifht;
        TreeNode rigtRight = new TreeNode(6);
        right.right = rigtRight;
        TreeNode opeNode = root;
        flatten(opeNode);
    }

    public static void flatten(TreeNode root) {

        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        if(root.right != null) {
            stack.push(root.right);
        }
        if(root.left != null) {
            stack.push(root.left);
        }
        root.right = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            root.right = node;
            root.left = null;
            root = root.right;

        }

    }

}
