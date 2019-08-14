package com.zhao.leetcode.tree;

import java.util.Stack;

/**
 *  地址： https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *  二叉搜索树中的搜索
 *  给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class BSTTreeSearch {

    public TreeNode searchBST(TreeNode root, int val) {

        // 自己方案
       /* if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if(root.val == val) {
                return root;
            }
            if(root.left != null) {
                stack.push(root.left);
            }
            if(root.right != null) {
                stack.push(root.right);
            }
        }
        return null;*/

       if(root == null) {
           return null;
       }
       if(root.val == val) {
           return root;
       }
       if(root.left != null && root.val > val) {
           return searchBST(root.left,val);
       }
       if(root.right != null && root.val < val) {
           return searchBST(root.right,val);
       }
       return null;

    }

}
