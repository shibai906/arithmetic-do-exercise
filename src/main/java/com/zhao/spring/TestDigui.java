package com.zhao.spring;

/**
 * @program: arithmetic-do-exercise
 * @description
 * @author: zhaohuan
 * @create: 2020-03-03 16:12
 **/
public class TestDigui {

    static class Node{
        public int val;
        public Node left;
        public Node right;
    }

    private static int calculate(Node root){

        return calculate(root,0);
    }
    private static int calculate(Node node,int a){
        if(node==null){
            return a;
        }
        if(node.left==null&&node.right==null){
            return a*10+node.val;
        }
        return calculate(node.left,a*10+node.val)+calculate(node.right,a*10+node.val);
    }

    public static void main(String[] args){
        Node root=new Node();
        root.val=1;
        Node left=new Node();
        Node right=new Node();
        root.left=left;
        root.right=right;
        right.val=4;
        left.val=3;
        left.left=new Node();
        left.right=new Node();
        left.left.val=5;
        left.right.val=6;
        System.out.println(calculate(root));
    }
}

