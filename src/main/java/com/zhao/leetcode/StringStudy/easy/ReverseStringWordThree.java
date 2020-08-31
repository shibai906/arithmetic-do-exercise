package com.zhao.leetcode.StringStudy.easy;


/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-08-30 16:49
 * @description
 * 题目：反转字符串中的单词 III
 * 地址：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 描述：给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 **/
public class ReverseStringWordThree {

    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        for(int i = 0 ; i < chars.length ; i ++) {
            if(chars[i] == ' ') {
                reverse(chars , start , i - 1);
                start = i + 1;
            }
        }
        reverse(chars,start,chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        for(int i = 0 ; i <= (end - start) / 2 ; i ++) {
            char temp = chars[start + i];
            chars[start + i] = chars[end - i];
            chars[end - i] = temp;
        }
    }


}
