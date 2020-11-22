package com.zhao.leetcode.bisai.bi216;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-11-22 10:50
 * @description
 * 题目：检查两个字符串数组是否相等
 * 描述：给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *      数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * 地址：https://leetcode-cn.com/contest/weekly-contest-216/problems/check-if-two-string-arrays-are-equivalent/
 *
 **/
public class CheckStringEquals {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null && word2 == null) {
            return true;
        }
        if (word1 == null || word2 == null) {
            return false;
        }

        StringBuilder sb1 = new StringBuilder();
        for (String w1 : word1) {
            sb1.append(w1);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String w2 : word2) {
            sb2.append(w2);
        }
        if (sb1.length() != sb2.length()) {
            return false;
        }
        return checkString(sb1.toString(), sb2.toString());

    }

    private boolean checkString(String str1, String str2) {

        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;

    }

}
