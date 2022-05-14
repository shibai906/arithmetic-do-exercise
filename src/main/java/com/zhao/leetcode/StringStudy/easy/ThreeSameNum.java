package com.zhao.leetcode.StringStudy.easy;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-08 21:44
 * @description
 * 地址：https://leetcode-cn.com/problems/largest-3-same-digit-number-in-string/
 * 题目：字符串中最大的 3 位相同数字
 * 描述：给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 *
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 *
 * 注意：
 *  子字符串 是字符串中的一个连续字符序列。
 *  num 或优质整数中可能存在 前导零 。
 *
 **/
public class ThreeSameNum {

    public String largestGoodInteger(String num) {
        String max = "";
        int n = 1;
        for (int i = 1; i < num.length(); i ++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                n ++;
                if (n == 3) {
                    max = getMax(num.substring(i - 2, i + 1), max);
                    n = 1;
                }
            } else {
                n = 1;
            }
        }
        return max;
    }

    private String getMax(String substring, String max) {
        if (max.equals("")) {
            return  substring;
        }
        for (int i = 0; i < 3; i ++) {
            if (substring.charAt(i) > max.charAt(i)) {
                max = substring;
            } else if (substring.charAt(i) < max.charAt(i)) {
                break;
            }
        }
        return max;
    }

}
