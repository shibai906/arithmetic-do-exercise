package com.zhao.leetcode.tree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 非递归遍历二叉树实现
 */
public class BinaryTree {


    public static void main(String[] args) {

    }


    // 非递归前序遍历
    public List<Integer> preorderTraversal(Node node) {
        List<Integer> res = new ArrayList<>();
        if(node == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.value);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    // 非递归中序遍历
    public List<Integer> inorderTraversal(Node node) {
        List<Integer> res = new ArrayList<>();

        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.value);
                node = node.right;
            }
        }
        return res;
    }

    // 非递归后序遍历
    public List<Integer> postorderTraversal(Node node) {

        List<Integer> res = new ArrayList<>();
        if(node == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();

        Node p = node;
        // 标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
        Node pre = p;

       /* while (p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if(p.right == null || p.right == pre) {
                    res.add(p.value);
                    pre = cur;
                    p = null;
                } else
            }
        }*/

       return res;
    }

    // 非递归层次遍历
    public List<Integer> levelTraversal(Node node) {

        List<Integer> res = new ArrayList<>();
        if(node == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            res.add(node.value);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }



}
