package com.zhao.leetcode.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *  给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Binomial {

    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if(numRows < 1) {
            return list;
        }
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        list.add(integers);
        for(int i = 1 ; i < numRows ; i ++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for(int j = 1 ; j < integers.size() ; j ++) {
                next.add(integers.get(j) + integers.get(j - 1));
            }
            next.add(1);
            list.add(next);
            integers = next;
        }
        return list;

    }

}
