package com.zhao.leetcode.StringStudy;

/**
 * 最后一个单词的长度
 *  给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 */
public class LastWordLength {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World "));
    }

    public static int lengthOfLastWord(String s) {
        int num = 0;
        if(s == null) {
            return num;
        }

        for(int i = s.length() - 1 ; i >= 0 ; i --) {
            if(s.charAt(i) == ' ') {
                if(num == 0) {
                    continue;
                }
                return num;
            }
            num ++;
        }
        return num;
    }

}
