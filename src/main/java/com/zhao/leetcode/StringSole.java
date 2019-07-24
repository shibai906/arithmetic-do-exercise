package com.zhao.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class StringSole {

    public static void main(String[] args) {
        System.out.println(renjiaFirstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {

        if(s.length() == 0) {
            return -1;
        }
        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i < s.length() - 1 ; i ++) {
            if(set.contains(s.charAt(i))) {
                continue;
            }
            int num = set.size();
            for(int j = i + 1 ; j < s.length() ; j ++) {
                if(s.charAt(i) == s.charAt(j)) {
                    set.add(s.charAt(i));
                    break;
                }
            }
            if(num == set.size()) {
                return i;
            }
        }
        if(!set.contains(s.charAt(s.length() - 1))) {
            return s.length() - 1;
        }

        return -1;
    }

    public static int renjiaFirstUniqChar(String s) {
        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int startIndex = s.indexOf(ch);
            if (startIndex != -1 && startIndex == s.lastIndexOf(ch)) {
                index = (index == -1 || index > startIndex) ? startIndex : index;
            }
        }
        return index;
    }

}
