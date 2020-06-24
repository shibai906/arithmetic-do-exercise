package com.zhao.arithmetic.ms.baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-05-27 20:51
 * @description
 **/
public class TestShuBianli {

    public static void main(String[] args) {

    }

    public static List<Integer> fund(Node head) {
        List<Integer> result = new ArrayList<>();
        if(head == null) {
            return null;
        }
        List<Node> shangCeng = new LinkedList<>();
        shangCeng.add(head);
        int ceng = 1 ;

        List<Node> xiaCent = new LinkedList<>();

        while (shangCeng.size() > 0) {
            if(ceng % 2 == 1) {
                Node node = shangCeng.remove(0);
                addLeft(node,xiaCent);
                addRight(node , xiaCent);
                result.add(node.value);
            } else {
                Node node = shangCeng.remove(shangCeng.size() - 1);
                addRight(node , xiaCent);
                addLeft(node,xiaCent);
                result.add(node.value);
            }
            if(shangCeng.size() == 0) {
                shangCeng = xiaCent;
                xiaCent = new LinkedList<>();
            }
            ceng ++ ;
        }
        return result;

    }

    private static void addLeft(Node node , List<Node> list) {
        if(node.left != null) {
            list.add(node.left);
        }
    }

    private static void addRight(Node node , List<Node> list) {
        if(node.right != null) {
            list.add(node.left);
        }

    }
}
