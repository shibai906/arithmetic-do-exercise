package com.zhao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 无重复最长子串
 */
public class MaxSon {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("acvddaer",0));

    }

    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int max = 0;
        List<Character> list = new ArrayList<>();
        for(int i = 0 ; i < chars.length ; i ++) {
            for(int j = 0 ; j < list.size() ; j ++ ) {
                if(list.get(j) == chars[i]) {
                    i = i + j - list.size() + 1;
                    if(max < list.size()) {
                        max = list.size();
                    }
                    list.clear();
                }
            }

            list.add(chars[i]);
        }
        if(list.size() > max) {
            max = list.size();
        }
        return max;
    }


    // 优化滑动窗口
    public static int lengthOfLongestSubstring(String s ,int n) {

        n = s.length() ;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>(); // 新建map集合

        for(int j = 0 , i = 0 ; j < n; j ++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i); // 当什么什么来着
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j),j + 1);
        }
        return ans;


    }
}
