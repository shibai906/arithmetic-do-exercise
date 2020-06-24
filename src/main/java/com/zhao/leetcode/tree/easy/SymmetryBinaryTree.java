package com.zhao.leetcode.tree.easy;


/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-06-13 19:53
 * @description 题目： 101. 对称二叉树
 * 地址： https://leetcode-cn.com/problems/symmetric-tree/
 * 思路： 使用层序遍历，两边遍历的方式
 **/
public class SymmetryBinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode oneLeft = new TreeNode(2);
        treeNode.left = oneLeft;
        TreeNode oneRight = new TreeNode(2);
        treeNode.right = oneRight;
        oneLeft.left = new TreeNode(3);
        oneRight.left = new TreeNode(3);
        SymmetryBinaryTree binaryTree = new SymmetryBinaryTree();
        binaryTree.isSymmetric(treeNode);

    }

    public boolean isSymmetricByOfficial(TreeNode root) {

        if(root == null) {
            return true;
        }
        return check(root.left , root.right);

    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left , right.right) && check(left.right , right.left);
    }


    // 方法一：自己想的办法
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        java.util.List<TreeNode> head = new java.util.LinkedList<>();
        java.util.List<TreeNode> opeHead = new java.util.LinkedList<>();

        head.add(root);

        while (head.size() > 0) {
            TreeNode nodeLeft = head.remove(0);
            if (head.size() == 0) {
                if (!leftEqualRight(nodeLeft.left, nodeLeft.right)) {
                    return false;
                }
                if (!opeHeadAdd(opeHead, nodeLeft.left, nodeLeft.right)) {
                    return false;
                }
            } else {
                TreeNode nodeRight = head.remove(head.size() - 1);
                if (!leftEqualRight(nodeLeft, nodeRight)) {
                    return false;
                }
                if (!opeHeadAdd(opeHead, nodeLeft.left, nodeRight.right)) {
                    return false;
                }
                if (!opeHeadAdd(opeHead, nodeLeft.right, nodeRight.left)) {
                    return false;
                }
            }
            if (head.size() == 0) {
                head = opeHead;
                opeHead = new java.util.LinkedList<>();
            }
        }
        return true;
    }

    private boolean leftEqualRight(TreeNode left, TreeNode right) {
        if (!leftAndNAllNullOrAllNotNull(left, right)) {
            return false;
        }
        if (left != null) {
            if (left.val != right.val) {
                return false;
            }
        }
        return true;
    }

    private boolean leftAndNAllNullOrAllNotNull(TreeNode left, TreeNode right) {
        if ((left == null ^ right == null) == true) {
            return false;
        }
        return true;
    }

    private boolean opeHeadAdd(java.util.List<TreeNode> list, TreeNode left, TreeNode right) {
        if (!leftAndNAllNullOrAllNotNull(left, right)) {
            return false;
        }
        if (left != null) {
            list.add(0, left);
            list.add(right);
        }
        return true;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
