package com.zhao.leetcode.tree.easy;


import com.zhao.leetcode.tree.Node;
import com.zhao.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        int Ldeep = maxDepth(root.left);
        int Rdeep = maxDepth(root.right);

        return (Ldeep > Rdeep ? Ldeep : Rdeep) + 1;

        /*if(root == null) {
            return 0;
        }
        int depth = 0 ;
        List<TreeNode> head = new LinkedList<>();
        head.add(root);
        List<TreeNode> opeHead = new LinkedList<>();
        while (head.size() > 0) {
            root = head.remove(0);
            if(root.left != null) {
                opeHead.add(root.left);
            }
            if(root.right != null) {
                opeHead.add(root.right);
            }
            if(head.size() == 0) {
                head = opeHead;
                opeHead = new LinkedList<>();
                depth ++;
            }
        }
        return depth;*/

    }

}
