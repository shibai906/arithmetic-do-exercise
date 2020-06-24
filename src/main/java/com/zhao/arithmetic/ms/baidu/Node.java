package com.zhao.arithmetic.ms.baidu;

import lombok.Data;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-05-27 20:52
 * @description
 **/
public class Node {

    public Node left ;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node right;
    public int value;

}
