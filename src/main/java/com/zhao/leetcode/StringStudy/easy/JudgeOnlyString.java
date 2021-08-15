package com.zhao.leetcode.StringStudy.easy;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-07-18 15:32
 * @description
 * 题目：面试题 01.01. 判定字符是否唯一
 * 内容：实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 地址：https://leetcode-cn.com/problems/is-unique-lcci/
 **/
public class JudgeOnlyString {
    public static void main(String[] args) {
        System.out.println(1 | 6);
    }

    public boolean isUnique(String astr) {
        long compare = 0;
        long cc = 1;
        if (astr == null || astr.length() == 0) {
            return true;
        }
        for (int i = 0 ; i < astr.length() ; i ++) {
            int offset = astr.charAt(i) - 'a';
            if ((compare & (cc << offset)) > 0) {
                return false;
            }
            compare |= cc << offset;
        }
        return true;

    }

}
