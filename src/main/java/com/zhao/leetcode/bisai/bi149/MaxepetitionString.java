package com.zhao.leetcode.bisai.bi149;

/**
 * 1156. 单字符重复子串的最大长度
 *  如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 *
 * bbababaaaa
 * babbbbbbbbbbbbaababbaabaabaaaaaaaaabbbababba
 */
public class MaxepetitionString {

    public static void main(String[] args) {
        System.out.println(maxRepOpt1("bbababaaaa"));
    }

    public static int maxRepOpt1(String text) {
        int len = text.length();
        if(text == null || len == 0) {
            return 0;
        }
        int num = 1 ;
        int[] max = {1,text.charAt(0)};
        int flag = 0;
        for(int i = 1 ; i < len ; i ++) {
            if(flag < 2 && text.charAt(i) == text.charAt(i - 1)) {
                num ++ ;
                continue;
            }
            if(flag >= 2 && i < len - 1 && text.charAt(i + 1) == text.charAt(i)) {
                num ++;
                continue;
            }
            if( flag < 2 &&i < len - 1 && text.charAt(i + 1) == text.charAt(i - 1)) {
                num ++;
                flag += 2;
                continue;
            }
            if(flag >= 2) {
                flag -= 2;
            }
            if(flag == 1) {
                if(num > max[0]) {
                    max[0] = num;
                    max[1] = text.charAt(i - num);
                    flag = 0;
                }
            }
            if(flag == 0) {
                if(num > max[0]) {
                    max[0] = num;
                    max[1] = text.charAt(i - num);
                }else if(text.charAt(i) == max[1]) {
                    flag = 1;
                    max[0] ++;
                }
            }
            num = 1;
        }
        max[0] = max[0] > num ? max[0] : num;
        int[] you = new int[2];
        num = 1;
        for(int i = len - 2 ; i >= 0 ; i --) {
            if(flag < 2 && text.charAt(i) == text.charAt(i + 1)) {
                num ++ ;
                continue;
            }
            if(flag >= 2 && i > 0 && text.charAt(i - 1) == text.charAt(i)) {
                num ++;
                continue;
            }
            if( flag < 2 &&i > 0 && text.charAt(i + 1) == text.charAt(i - 1)) {
                num ++;
                flag += 2;
                continue;
            }
            if(flag >= 2) {
                flag -= 2;
            }
            if(flag == 1) {
                if(num > you[0]) {
                    you[0] = num;
                    you[1] = text.charAt(i + num);
                    flag = 0;
                }
            }
            if(flag == 0) {
                if(num > you[0]) {
                    you[0] = num;
                    you[1] = text.charAt(i + num);
                }else if(text.charAt(i) == you[1]) {
                    flag = 1;
                    you[0] ++;
                }
            }
            num = 1;
        }
        you[0] = you[0] > num ? you[0] : num;
        return max[0] > you[0] ? max[0] : you[0];
    }

}
