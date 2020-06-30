package com.zhao.leetcode.tree.easy;


import com.zhao.leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 *  地址： https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *      题目：538. 把二叉搜索树转换为累加树
 *      给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class BinarySearchTreeChangeAddTree {

    public static void main(String[] args) {

        com.zhao.leetcode.tree.TreeNode root = new com.zhao.leetcode.tree.TreeNode(1);
        com.zhao.leetcode.tree.TreeNode opeRoot = root;
        opeRoot.left = new com.zhao.leetcode.tree.TreeNode(2);
        opeRoot.right = new com.zhao.leetcode.tree.TreeNode(3);
        convertBinaST(root);

    }

    public static com.zhao.leetcode.tree.TreeNode convertBinaST(com.zhao.leetcode.tree.TreeNode root) {

        if(root == null) {
            return root;
        }
        Stack<com.zhao.leetcode.tree.TreeNode> stack = new Stack<>();
        int count = 0;
        com.zhao.leetcode.tree.TreeNode opeRoot = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                count += root.val;
                root.val = count;
                root = root.left;
            }
        }
        return opeRoot;
    }

    public static com.zhao.leetcode.tree.TreeNode convertBST(com.zhao.leetcode.tree.TreeNode root) {

        if(root == null) {
            return root;
        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        Stack<com.zhao.leetcode.tree.TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            com.zhao.leetcode.tree.TreeNode opeRoot = stack.pop();
            int num = treeMap.getOrDefault(opeRoot.val,0);
            treeMap.put(opeRoot.val,num+1);
            if(opeRoot.left != null) {
                stack.push(opeRoot.left);
            }
            if(opeRoot.right != null) {
                stack.push(opeRoot.right);
            }
        }
        int max = 0 ;
        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            max += key * value;
        }
        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            max -= key * value;
            treeMap.put(key,max + key);
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode opeRoot = stack.pop();
            opeRoot.val = treeMap.get(opeRoot.val);
            if(opeRoot.left != null) {
                stack.push(opeRoot.left);
            }
            if(opeRoot.right != null) {
                stack.push(opeRoot.right);
            }
        }
        return root;
    }

}
