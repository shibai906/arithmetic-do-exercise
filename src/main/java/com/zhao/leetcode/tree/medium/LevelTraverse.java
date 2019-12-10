package com.zhao.leetcode.tree.medium;

import com.zhao.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 地址： https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * 层次遍历
 *
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2019-12-01 13:18
 **/
public class LevelTraverse {

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
        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) {
            return list;
        }
        List<TreeNode> nodes = new LinkedList<TreeNode>();

        List<TreeNode> newNode = new LinkedList<TreeNode>();

        nodes.add(root);
        List<Integer> integers = new ArrayList<Integer>();
        while (nodes.size() > 0) {
            root = nodes.remove(0);
            integers.add(root.val);
            if(root.left != null) {
                newNode.add(root.left);
            }
            if(root.right != null) {
                newNode.add(root.right);
            }
            if(nodes.size() == 0) {
                list.add(integers);
                integers = new ArrayList<Integer>();
                nodes = newNode;
                newNode = new LinkedList<TreeNode>();
            }
        }
        return list;

    }

}
