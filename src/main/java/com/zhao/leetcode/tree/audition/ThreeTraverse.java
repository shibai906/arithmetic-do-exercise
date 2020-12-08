package com.zhao.leetcode.tree.audition;

import com.zhao.leetcode.tree.TreeNode;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-23 12:02
 * @description
 * 树的三种遍历方式
 **/
public class ThreeTraverse {

    public static void main(String[] args) {
        ThreeTraverse tt = new ThreeTraverse();
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);

        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);

        left.left = leftLeft;
        left.right = leftRight;

        right.left = rightLeft;
        right.right = rightRight;
        tt.preOrderTraverse(root);
        System.out.println();
        tt.inOrderTraverse(root);
        System.out.println();
        tt.postOrderTraverse(root);

    }

    // 先序遍历 左中右
    private void preOrderTraverse(TreeNode node) {
        if(node == null)
            return;
        System.out.print(node.val +" ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    //中序遍历 中左右
    private void inOrderTraverse(TreeNode node) {
        if(node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }

    //后序遍历 中右左
    static void postOrderTraverse(TreeNode node) {
        if(node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val+" ");

    }


}
