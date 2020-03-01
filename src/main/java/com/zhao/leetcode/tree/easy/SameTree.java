package com.zhao.leetcode.tree.easy;

import com.zhao.leetcode.tree.TreeNode;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-01 18:24
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
