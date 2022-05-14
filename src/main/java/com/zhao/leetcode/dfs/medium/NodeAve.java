package com.zhao.leetcode.dfs.medium;

import com.zhao.leetcode.tree.TreeNode;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-08 21:40
 * @description
 * 地址：https://leetcode-cn.com/problems/count-nodes-equal-to-average-of-subtree/
 * 题目：统计值等于子树平均值的节点数
 * 描述：给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
 *
 * 注意：
 *  n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
 *  root 的 子树 由 root 和它的所有后代组成。
 *
 **/
public class NodeAve {

    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int sum = node.val + l[0] + r[0], nodeNums = l[1] + r[1] + 1, ave = sum / nodeNums;
        if (ave == node.val) {
            result ++;
        }
        return new int[]{sum, nodeNums};
    }

}
