package com.zhao.leetcode.bisai.bi150;

import com.zhao.leetcode.tree.TreeNode;

import java.util.Stack;

/**
 *  最大层内元素和
 *  给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 */
public class MaxCoreAdd {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(63909);
        TreeNode right = new TreeNode(43838);
        TreeNode left = new TreeNode(4549);
        root.right = right;
        root.left = left;
        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int max = root.val;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> opeStack = new Stack<>();
        stack.push(root);
        int num = 0 , result = 1 , ceng = 0;
        while (!stack.isEmpty()) {
            root = stack.pop();
            num += root.val;
            if(root.left != null) {
                opeStack.push(root.left);
            }
            if(root.right != null) {
                opeStack.push(root.right);
            }
            if(stack.isEmpty()) {
                ceng ++;
                if(num > max) {
                    max = num;
                    result = ceng;
                }
                num = 0;
                stack = opeStack;
                opeStack = new Stack<>();
            }
        }
        return result;
    }

}
