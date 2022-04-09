package com.zhao.leetcode.sliding.window.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-04-08 20:29
 * @description
 *
 * 地址：https://leetcode-cn.com/problems/minimum-window-substring/
 * 题目：最小覆盖子串
 * 描述：给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 **/
public class MinCoverSubstring {

    public static void main(String[] args) {
        MinCoverSubstring mc = new MinCoverSubstring();
        System.out.println(mc.minWindow("bba", "ba"));
    }

    /**
     * 滑动窗口，从两边往中间滑动
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();

        for (char c : s.toCharArray()) {
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hs.entrySet()) {
            if (entry.getValue() > ht.getOrDefault(entry.getKey(), 0)) {
                return "";
            }
        }
        int start = 0, end = s.length() - 1;
        for (; end > 0; end --) {
            char c = s.charAt(end);
            if (hs.get(c).equals(ht.getOrDefault(c, 0))) {
                break;
            }
            hs.put(c, hs.get(c) - 1);
        }
        for (; start < end; start ++) {
            char c = s.charAt(start);
            if (hs.get(c).equals(ht.getOrDefault(c, 0))) {
                break;
            }
            hs.put(c, hs.get(c) - 1);
        }
        return s.substring(start, end);

    }

    /**
     * 滑动窗口，从左往右滑动
     * @param s
     * @param t
     * @return
     */
    /*public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Set<Character> tSet = new HashSet<>();
        Map<Character, Integer> cunchu = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            tSet.add(c);
            cunchu.put(c, cunchu.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        while (end < s.length() && !tSet.isEmpty()) {
            char c = s.charAt(end ++);
            int num = tMap.getOrDefault(c, 0);
            if (tSet.contains(c)) {
                if (cunchu.get(c).equals(num + 1)) {
                    tSet.remove(c);
                }
            }
            tMap.put(c, num + 1);
        }
        if (end == s.length() && !tSet.isEmpty()) {
            return "";
        }

        for (; start < end; start ++) {
            char c = s.charAt(start);
            if (cunchu.getOrDefault(c, 0) > 0) {
                if (cunchu.get(c).equals(tMap.get(c))) {
                    break;
                }
                tMap.put(c, tMap.get(c) - 1);
            }
        }
        int minStart = start, minEnd = end;
        for (; end < s.length(); end ++) {
            char c = s.charAt(end);
            if (cunchu.keySet().contains(c)) {
                tMap.put(c, tMap.get(c) + 1);
                while (start < end) {
                    char sc = s.charAt(start);
                    if (cunchu.keySet().contains(sc)) {
                        int num = tMap.get(sc);
                        if (num == cunchu.get(sc)) {
                            if (end - start < minEnd - minStart) {
                                minEnd = end + 1;
                                minStart = start;
                            }
                            break;
                        }
                        tMap.put(sc, num - 1);
                    }
                    start ++;
                }

            }
        }
        return s.substring(minStart, minEnd);
    }*/

}
