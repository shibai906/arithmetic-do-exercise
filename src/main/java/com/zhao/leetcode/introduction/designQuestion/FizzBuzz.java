package com.zhao.leetcode.introduction.designQuestion;

import java.util.*;

/**
 * Fizz Buzz
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class FizzBuzz {

    public static void main(String[] args) {
        List list = fizzBuzz1(5);
    }

    public static List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; i ++) {
            if(i % 15 == 0) {
                list.add("FizzBuzz");
                continue;
            }
            if (i % 5 == 0) {
                list.add("Buzz");
                continue;
            }
            if (i % 3 == 0) {
                list.add("Fizz");
                continue;
            }
            list.add(String.valueOf(i));
        }
        return list;
    }

    public static List<String> fizzBuzz1(int n) {

        return new java.util.AbstractList<String>() {
            @Override
            public String get(int index) {
                index ++;
                if(index % 15 == 0) {
                    return "FizzBuzz";
                }
                if(index % 5 == 0) {
                    return "Buzz";
                }
                if(index % 3 == 0) {
                    return "Fizz";
                }
                return String.valueOf(index);
            }

            @Override
            public int size() {
                return n;
            }
        };
    }

}
