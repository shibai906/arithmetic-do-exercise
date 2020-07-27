package com.zhao.leetcode.bisai.bi199;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-07-26 11:16
 * @description 地址：https://leetcode-cn.com/contest/weekly-contest-199/problems/number-of-good-leaf-nodes-pairs/
 * 题目：好叶子节点对的数量
 * 描述：给你二叉树的根节点 root 和一个整数 distance 。
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 * 返回树中 好叶子节点对的数量 。
 **/
// TODO: 2020/7/26 二叉树节点遍历问题
public class GoodLeafNodePair {

    public int countPairs(TreeNode root, int distance) {

        dfs(root, distance);
        return ans;
    }
    int ans = 0;
    public void handle(TreeNode root, int[] state, int d){
        int[] ret = dfs(root, d);
        for(int i = 0; i <= d; i++){
            for(int j = 0; j <= d; j++){
                if(i + j + 1 <= d){
                    ans += ret[i] * state[j];
                }
            }
        }
        for(int i = 0; i < d; i++){
            state[i + 1] += ret[i];
        }

    }
    public int[] dfs(TreeNode root, int d){
        int[] state = new int[d + 1];
        if(root.left == null && root.right == null){
            state[0] = 1;
            return state;
        }
        if(root.left != null){
            handle(root.left, state, d);
        }
        if(root.right != null){
            handle(root.right, state, d);
        }
        return state;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
