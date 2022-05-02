package com.zhao.leetcode.StringStudy.hard;

import java.util.Arrays;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-05-02 11:27
 * @description
 * 地址：https://leetcode-cn.com/problems/total-appeal-of-a-string/
 * 题目：字符串的总引力
 **/
public class AllGravity {

    public static void main(String[] args) {
        AllGravity gravity = new AllGravity();
        gravity.appealSum("abc");
    }

    public long appealSum(String s) {
        long ans = 0;
        // sumG维护以s[i]结尾的子串的引力值之和
        long sumG = 0;
        int n = s.length();

        // idxArr存储每个字母上次出现时的索引
        int[] idxArr = new int[26];
        Arrays.fill(idxArr, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            sumG += i - idxArr[c];
            ans += sumG;
            idxArr[c] = i;
        }
        return ans;
    }

}
