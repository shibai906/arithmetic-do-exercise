package com.zhao.leetcode.StringStudy.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-06 18:47
 * @description 地址： https://leetcode-cn.com/problems/distinct-subsequences/
 * 题目：不同的子序列
 * 描述： 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 **/
public class DifferentSubsequences {

    public static void main(String[] args) {
        DifferentSubsequences ds = new DifferentSubsequences();
        System.out.println(ds.numDistinct("babgbag", "bag"));
    }

    public int numDistinct(String s, String t) {

        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return 0;
        }
        int tLen = t.length(), sLen = s.length();
        List<Integer> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < tLen; i++) {

            if (i == 0) {
                for (int j = i; j < sLen; j++) {
                    if (t.charAt(i) == s.charAt(j) && tLen - i <= sLen - j) {
                        newList.add(j);
                    }
                }
            } else {
                if (list.size() == 0) {
                    return 0;
                }
                for (int listI : list) {
                    for (int j = listI + 1; j < sLen; j++) {
                        if (t.charAt(i) == s.charAt(j) && tLen - i <= sLen - j) {
                            newList.add(j);
                        }

                    }
                }

            }
            list = newList;
            newList = new ArrayList<>();
        }

        return list.size();


    }

}
