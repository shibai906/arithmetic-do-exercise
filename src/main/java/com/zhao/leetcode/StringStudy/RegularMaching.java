package com.zhao.leetcode.StringStudy;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 正则表达式匹配
 *  给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *  '.' 匹配任意单个字符
 *  '*' 匹配零个或多个前面的那一个元素
 */
public class RegularMaching {

    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
    }

    public static boolean isMatch(String s, String p) {
        // 最简单的方式就是调用类库
        /*Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();*/
        int i = 0 , j = 0 , lenS = s.length() , lenP = p.length();
        while(i < lenS || j < lenP ) {


        }
        return true;

    }

}
