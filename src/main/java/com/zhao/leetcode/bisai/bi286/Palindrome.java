package com.zhao.leetcode.bisai.bi286;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-03-27 11:18
 * @description
 * 地址：https://leetcode-cn.com/contest/weekly-contest-286/problems/find-palindrome-with-fixed-length/
 * 题目：找到指定长度的回文数
 * 描述：给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。
 *
 * 回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
 **/
public class Palindrome {

    public static void main(String[] args) {
        // TODO: 2022/3/27  待熟悉，两周之后再来一次
        Palindrome pr = new Palindrome();
        pr.kthPalindrome(new int[]{90}, 1);
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        for (int i = 0 ; i < queries.length; i ++) {
            String s = (long)Math.pow(10, (intLength - 1) / 2) + queries[i] - 1 + "";
            if (s.length() > (intLength + 1) / 2) {
                result[i] = -1;
            } else {
                result[i] = Long.valueOf(s + new StringBuilder(s.substring(0, intLength - s.length())).reverse());
            }

        }
        return result;

    }



}
