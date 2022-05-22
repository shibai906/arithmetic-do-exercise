package com.zhao.leetcode.tree.medium;

import com.zhao.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-21 21:08
 * @description
 * 地址：https://leetcode.cn/problems/hPov7L/
 * 题目：二叉树每层的最大值
 * 描述：给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 **/
public class 二叉树每层的最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int num = 1, max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            max = Math.max(node.val, max);
            num --;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (num == 0) {
                result.add(max);
                max = Integer.MIN_VALUE;
                num = queue.size();
            }
        }
        return result;
    }

}
