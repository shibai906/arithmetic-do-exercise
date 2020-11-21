package com.zhao.leetcode.StringStudy.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-12 23:51
 * @description
 **/
public class CharFlowNotRepeat {

    public static void main(String[] args) {
        CharFlowNotRepeat cnr = new CharFlowNotRepeat();
        cnr.function();
    }

    public void function() {
        String name = "google";
        for(int i = 0 ; i < name.length() ; i ++) {
            insert(name.charAt(i));
        }
        System.out.println(firstAppearingOnce());

    }

    private int[] cnts = new int[128];
    private Queue<Character> queue = new LinkedList<>();

    public void insert(char ch) {
        if(++cnts[ch] < 2) {
            queue.add(ch);
        }
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }

    public char firstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

}
