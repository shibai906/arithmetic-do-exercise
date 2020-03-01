package com.zhao.leetcode.tree.easy;

import com.zhao.leetcode.tree.TreeNode;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-01 18:24
 * 地址： https://leetcode-cn.com/problems/same-tree/submissions/
 * 题目： 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 **/
public class SameTree {


    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        SameTree sameTree = new SameTree();
        sameTree.isSameTree(p,q);
    }

    boolean flag = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q) {
            return true;
        }
        digui(p , q);
        return flag;
    }

    private void digui(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            flag = false;
            return;
        }
        if(p.val != q.val) {
            flag = false;
            return;
        }

        int pLeft = p.left == null ? 0 : 1 ;
        int pRight = p.right == null ? 0 : 1 ;
        int qLeft = q.left == null ? 0 : 1 ;
        int qRight = q.right == null ? 0 : 1 ;
        if((pLeft ^ qLeft) == 1 || (pRight ^ qRight) == 1)  {
            flag = false;
            return;
        }
        if(pLeft == 1) {
            digui(p.left,q.left);
        }
        if(pRight == 1) {
            digui(p.right,q.right);
        }

    }

}
