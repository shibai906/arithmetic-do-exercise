package com.zhao.leetcode.bisai.bi205;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2020-09-06 11:04
 * @description
 * 地址：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * 题目：替换所有的问号
 * 描述：给你一个仅包含小写英文字母和 '?' 字符的字符串 s<var> </var>，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * 注意：你 不能 修改非 '?' 字符。
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 **/
public class ModifyString {

    public String modifyString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i ++) {

            if(chars[i] == '?') {
                chars[i] = 'a';
                if((i > 0 && chars[i] == chars[i - 1]) || (i < chars.length - 1 && chars[i] == chars[i + 1] )) {
                    chars[i] = 'b';
                }
                if((i > 0 && chars[i] == chars[i - 1]) || (i < chars.length - 1 && chars[i] == chars[i + 1] )) {
                    chars[i] = 'c';
                }
            }
        }
        return new String(chars);

    }

}
