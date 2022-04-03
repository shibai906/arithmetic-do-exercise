package com.zhao.leetcode.StringStudy.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-03 15:10
 * @description
 * 地址：https://leetcode-cn.com/problems/wtcaE1/
 * 题目：不含重复字符的最长子字符串
 * 描述：给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * 做法：滑动窗口
 **/
public class NoRepeatString {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(start ++));
            }
            set.add(c);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
